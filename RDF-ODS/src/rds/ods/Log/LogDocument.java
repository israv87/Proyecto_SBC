/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rds.ods.Log;

import com.mysql.jdbc.Connection;
import rdf.ods.Data.DatBibo;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import rdf.ods.Data.DATConexion;
import rds.ods.Clases.BiboDocument;

/**
 *
 * @author Isra
 */
public class LogDocument {
static DatBibo objDatBibo = new DatBibo();
BiboDocument objBiboDocument = new BiboDocument();
DATConexion objcon = new DATConexion();


public  ArrayList<BiboDocument> LeerBiboDocument(ArrayList<BiboDocument> ArrayDocument) throws ClassNotFoundException, SQLException{

    ResultSet rs = objDatBibo.ConsultarDocument();
    ResultSetMetaData rm = rs.getMetaData();

    int columnCount = rm.getColumnCount();
    ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        while (rs.next()) {
            BiboDocument objBiboDocument= new BiboDocument();
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("idDocument"))
                    objBiboDocument.setId(Integer.parseInt(value));
                if (columnName.equals("titulo"))
                    objBiboDocument.setTitulo(value);
                if (columnName.equals("abstrac"))
                    objBiboDocument.setAbstrct(value);
                if (columnName.equals("url"))
                    objBiboDocument.setUri(value);
                if (columnName.equals("anio"))
                    objBiboDocument.setAnio(value);
                if (columnName.equals("numPages"))
                    objBiboDocument.setNumPages(Integer.parseInt(value));
                if (columnName.equals("language"))
                    objBiboDocument.setLenguaje(value);
                if (columnName.equals("doi"))
                    objBiboDocument.setDoi(value);
                if (columnName.equals("volume"))
                    objBiboDocument.setVolumen(Integer.parseInt(value));
                if (columnName.equals("pstart"))
                    objBiboDocument.setStart(Integer.parseInt(value));
                if (columnName.equals("pend"))
                    objBiboDocument.setEnd(Integer.parseInt(value));
                if (columnName.equals("isopen"))
                    objBiboDocument.setOpen(value);
                if (columnName.equals("biboDocument"))
                    objBiboDocument.setBiboDocument(value);   
                if (columnName.equals("type"))
                    objBiboDocument.setType(value); 
            }
           ArrayDocument.add(objBiboDocument);
        }
       
 
    
        return ArrayDocument;
    }
}
