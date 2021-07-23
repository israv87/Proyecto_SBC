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
import rds.ods.Clases.BiboArticle;
import rds.ods.Clases.BiboBook;


/**
 *
 * @author Isra
 */
public class LogBook {
static DatBibo objDatBibo = new DatBibo();
BiboBook objBook = new BiboBook(); 
DATConexion objcon = new DATConexion();

    public ArrayList<BiboBook> LeerBooks(ArrayList<BiboBook> arrayBook) throws ClassNotFoundException, SQLException {
    ResultSet rs = objDatBibo.ConsultarBooks();
    ResultSetMetaData rm = rs.getMetaData();
    int columnCount = rm.getColumnCount();
    ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        while (rs.next()) {  
            BiboBook objBook = new BiboBook(); 
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("idDocument"))
                    objBook.setIdDocumentBook(Integer.parseInt(value));
                if (columnName.equals("isbn"))
                     objBook.setIsbn(value);
                if (columnName.equals("edition"))
                    objBook.setEdition(value);
            }
           arrayBook.add(objBook);
           
        }
        rs.close();
        return arrayBook;
    }
}
