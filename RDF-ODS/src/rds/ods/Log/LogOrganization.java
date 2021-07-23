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
import rds.ods.Clases.BiboChapter;
import rds.ods.Clases.FoafOrganization;
import static rds.ods.Log.LogChapter.objDatBibo;

/**
 *
 * @author Isra
 */
public class LogOrganization {
static DatBibo objDatBibo = new DatBibo();
FoafOrganization objOrg = new FoafOrganization();
DATConexion objcon = new DATConexion();

    public ArrayList<FoafOrganization> LeerOrg(ArrayList<FoafOrganization> arrayOrganization) throws ClassNotFoundException, SQLException {
    ResultSet rs = objDatBibo.ConsultarOrganization();
    ResultSetMetaData rm = rs.getMetaData();
    int columnCount = rm.getColumnCount();
    ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        while (rs.next()) {  
            FoafOrganization objOrg = new FoafOrganization();
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("idDocument"))
                    objOrg.setIdDocument(Integer.parseInt(value));
                if (columnName.equals("name"))
                    objOrg.setName(value);
                if (columnName.equals("homePage"))
                    objOrg.setHomePage(columnName);
            }
           arrayOrganization.add(objOrg);
           
        }
        rs.close();
        return arrayOrganization;
    }
    
}
