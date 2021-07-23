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
import rds.ods.Clases.BiboJournal;
import static rds.ods.Log.LogChapter.objDatBibo;

/**
 *
 * @author Isra
 */
public class LogJournal {
    static DatBibo objDatBibo = new DatBibo();
    BiboJournal objJournal = new BiboJournal();
    DATConexion objcon = new DATConexion();
    
    public ArrayList<BiboJournal> LeerJournal(ArrayList<BiboJournal> arrayJournal) throws SQLException, ClassNotFoundException {
    ResultSet rs = objDatBibo.ConsultarJournal();
    ResultSetMetaData rm = rs.getMetaData();
    int columnCount = rm.getColumnCount();
    ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        while (rs.next()) {  
            BiboJournal objJournal = new BiboJournal();
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("idArticle"))
                    objJournal.setIdArticle(Integer.parseInt(value));
                if (columnName.equals("tituloJ"))
                     objJournal.setTituloJ(value);
                if (columnName.equals("shortTitleJ"))
                     objJournal.setShortTitleJ(value);
                if (columnName.equals("urlJ"))
                     objJournal.setUrlJ(value);
            }
           arrayJournal.add(objJournal);
           
        }
        rs.close();
        return arrayJournal;
    }
}
