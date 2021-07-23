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
import rds.ods.Clases.BiboConference;
import static rds.ods.Log.LogChapter.objDatBibo;

/**
 *
 * @author Isra
 */
public class LogConference {
static DatBibo objDatBibo = new DatBibo();
BiboConference objConference = new BiboConference();
DATConexion objcon = new DATConexion();

    public ArrayList<BiboConference> LeerConference(ArrayList<BiboConference> arrayConference) throws ClassNotFoundException, SQLException {
    ResultSet rs = objDatBibo.ConsultarConference();
    ResultSetMetaData rm = rs.getMetaData();
    int columnCount = rm.getColumnCount();
    ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        while (rs.next()) {
            BiboConference objConference = new BiboConference();
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("idDocument"))
                    objConference.setIdDocumentConf(Integer.parseInt(value));
                if (columnName.equals("tituloC"))
                     objConference.setTituloC(value);
                if (columnName.equals("urlC"))
                     objConference.setUrl(value);
                if (columnName.equals("contacInfo"))
                     objConference.setContacInfo(value);
                if (columnName.equals("descriptionC"))
                     objConference.setDescriptionC(value);
                if (columnName.equals("place"))
                     objConference.setPlace(value);
                if (columnName.equals("nombre"))
                     objConference.setName(value);
            }
           arrayConference.add(objConference);
           
        }
        rs.close();
        return arrayConference;
    }
}
