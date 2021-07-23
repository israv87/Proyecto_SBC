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


/**
 *
 * @author Isra
 */
public class LogArticle {
static DatBibo objDatBibo = new DatBibo();
BiboArticle objArticle = new BiboArticle();
DATConexion objcon = new DATConexion();

    public ArrayList<BiboArticle> LeerArticulos(ArrayList<BiboArticle> arrayArticle) throws ClassNotFoundException, SQLException {
     ResultSet rs = objDatBibo.ConsultarArticle();
    ResultSetMetaData rm = rs.getMetaData();
    int columnCount = rm.getColumnCount();
    ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        while (rs.next()) {
           BiboArticle objArticle = new BiboArticle();
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                 if (columnName.equals("idArticle"))
                    objArticle.setIdArticle(Integer.parseInt(value));
                if (columnName.equals("idDocument"))
                    objArticle.setIdDocumentArt(Integer.parseInt(value));
                if (columnName.equals("identifier"))
                     objArticle.setIdentifier(value);
                if (columnName.equals("influencialCC"))
                    objArticle.setInfluencialCC(value);
                if (columnName.equals("issue"))
                    objArticle.setIssue(value);
            }
           arrayArticle.add(objArticle);
        }
        return arrayArticle;
    }

}
