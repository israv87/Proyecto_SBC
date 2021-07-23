/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rdf.ods.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DATConexion {

    //Conectarse a la BDD
    public Connection con;


    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String driver = "org.gjt.mm.mysql.Driver";
        String url = "jdbc:mysql://localhost:3306/rdf_ods";
        Class.forName(driver);
        return DriverManager.getConnection(url, "root","");
    }
    

    public Connection AbrirConexion() throws ClassNotFoundException, SQLException {
        con = getConnection();
        return con;
    }

    public void CerrarConexion() throws SQLException {
        con.close();
    }


 
    

    

  
}
