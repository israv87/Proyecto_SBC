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
import rds.ods.Clases.C4OGlobalCount;
import static rds.ods.Log.LogChapter.objDatBibo;

/**
 *
 * @author Isra
 */
public class LogGlobalCount {
    static DatBibo objDatBibo = new DatBibo();
    C4OGlobalCount objGlobal = new C4OGlobalCount();
    DATConexion objcon = new DATConexion();

    public ArrayList<C4OGlobalCount> LeerGlobalC(ArrayList<C4OGlobalCount> arrayGlobalCount) throws ClassNotFoundException, SQLException {
       ResultSet rs = objDatBibo.ConsultarGlobalC();
    ResultSetMetaData rm = rs.getMetaData();
    int columnCount = rm.getColumnCount();
    ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        while (rs.next()) {  
                C4OGlobalCount objGlobal = new C4OGlobalCount();
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("idDocument"))
                    objGlobal.setIdDocument(Integer.parseInt(value));
                if (columnName.equals("hasGobalCountDate"))
                     objGlobal.setHasGobalCountDate(value);
                if (columnName.equals("hasGobalCountValue"))
                     objGlobal.setHasGobalCountValue(Integer.parseInt(value));
            }
           arrayGlobalCount.add(objGlobal);
           
        }
        rs.close();
        return arrayGlobalCount;
    }
}
