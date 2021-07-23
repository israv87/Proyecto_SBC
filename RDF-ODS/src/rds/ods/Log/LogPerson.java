/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rds.ods.Log;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import rdf.ods.Data.DATConexion;
import rdf.ods.Data.DatBibo;
import rds.ods.Clases.FoafPerson;
import static rds.ods.Log.LogChapter.objDatBibo;

/**
 *
 * @author Isra
 */
public class LogPerson {

static DatBibo objDatBibo = new DatBibo();   
FoafPerson objPerson = new FoafPerson();
DATConexion objcon = new DATConexion();

    public ArrayList<FoafPerson> LeerPerson(ArrayList<FoafPerson> arrayPerson) throws ClassNotFoundException, SQLException {
    
    ResultSet rs = objDatBibo.ConsultarPerson();
    ResultSetMetaData rm = rs.getMetaData();
    
    int columnCount = rm.getColumnCount();
    ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        while (rs.next()) {  
            FoafPerson objPerson = new FoafPerson();
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("idDocument"))
                    objPerson.setIdDocumentPerson(Integer.parseInt(value));
                if (columnName.equals("nombre"))
                     objPerson.setName(value);
                if (columnName.equals("apellidoP"))
                     objPerson.setApellidoP(value);
                if (columnName.equals("apellidoM"))
                     objPerson.setApellidoM(value);
                if (columnName.equals("pNombre"))
                     objPerson.setPnombre(value);
                if (columnName.equals("sNombre"))
                     objPerson.setSnombre(value);
                if (columnName.equals("vivo_url"))
                     objPerson.setUrl(value);
                if (columnName.equals("vivo_rank"))
                     objPerson.setRank(value);
            }
           arrayPerson.add(objPerson);
           
        }

        return arrayPerson;
    }
}
