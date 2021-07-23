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
import static rds.ods.Log.LogBook.objDatBibo;

/**
 *
 * @author Isra
 */
public class LogChapter {
static DatBibo objDatBibo = new DatBibo();
BiboChapter objChapter = new BiboChapter();
DATConexion objcon = new DATConexion();

    public ArrayList<BiboChapter>LeerChapter(ArrayList<BiboChapter> arrayChapter) throws ClassNotFoundException, SQLException {
    ResultSet rs = objDatBibo.ConsultarChapter();
    ResultSetMetaData rm = rs.getMetaData();
    int columnCount = rm.getColumnCount();
    ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        while (rs.next()) {  
            BiboChapter objChapter = new BiboChapter();
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("idDocument"))
                    objChapter.setIdDocumentCh(Integer.parseInt(value));
                if (columnName.equals("chapter"))
                     objChapter.setChapter(value);
                
            }
           arrayChapter.add(objChapter);
           
        }
        rs.close();
        return arrayChapter;
    }
}
