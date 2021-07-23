/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rdf.ods.Data;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Isra
 */
public class DatArticle {
    public Connection con;
    ResultSet rs;
    PreparedStatement ps = null; 
    
    public Connection getCon() throws ClassNotFoundException, SQLException {
        String driver = "org.gjt.mm.mysql.Driver";
        String url = "jdbc:mysql://localhost:3306/rdf_ods";
        Class.forName(driver);
        return DriverManager.getConnection(url, "root","");
    }
    
    public Connection AbrirCon() throws ClassNotFoundException, SQLException {
        con = getCon();
        return con;
    }
     public void CerrarCon() throws SQLException {
        con.close();
    }
    
      public ResultSet ConsultarArticle() throws ClassNotFoundException, SQLException {
       Statement st = AbrirCon().createStatement();
        String sentencia = "SELECT * FROM article ";
        rs = st.executeQuery(sentencia);
        return rs;
    }
}
