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
import rds.ods.Clases.SkosConcept;
import static rds.ods.Log.LogArticle.objDatBibo;

/**
 *
 * @author Isra
 */
public class LogConcept {
static DatBibo objDatBibo = new DatBibo();
SkosConcept objConcept = new SkosConcept();
DATConexion objcon = new DATConexion();

    public ArrayList<SkosConcept> LeerConcept(ArrayList<SkosConcept> arrayConcept) throws ClassNotFoundException, SQLException {
     ResultSet rs = objDatBibo.ConsultarConcept();
    ResultSetMetaData rm = rs.getMetaData();
    int columnCount = rm.getColumnCount();
    ArrayList<String> columnas = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columnas.add(columnName);
        }
        while (rs.next()) {
           SkosConcept objConcept = new SkosConcept();
            for (String columnName : columnas) {
                String value = rs.getString(columnName);
                if (columnName.equals("idDocument"))
                    objConcept.setIdDocumentConcept(Integer.parseInt(value));
                if (columnName.equals("prefLabel"))
                    objConcept.setPrefLabel(value);
                if (columnName.equals("altLabel"))
                    objConcept.setAltLabel(value);
            }
           arrayConcept.add(objConcept);
        }
        return arrayConcept;
    }
}
