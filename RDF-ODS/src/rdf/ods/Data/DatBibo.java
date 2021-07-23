/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rdf.ods.Data;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rdf.ods.Data.DATConexion;

/**
 *
 * @author Isra
 */
public class DatBibo {
    DATConexion con = new DATConexion();
    DATConexion con2 = new DATConexion();
    ResultSet rs;

    PreparedStatement ps = null; 

    public ResultSet ConsultarDocument() throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM document ";
        rs = st.executeQuery(sentencia);
        return rs;
    }
    
    
    public ResultSet ConsultarPerson() throws ClassNotFoundException, SQLException {
       Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM autor ";
        rs = st.executeQuery(sentencia);
       
        return rs;
    }
    
    
 
    public ResultSet ConsultarBooks() throws ClassNotFoundException, SQLException {
       Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM book ";
        rs = st.executeQuery(sentencia);
       
        return rs;
    }

    public ResultSet ConsultarArticle() throws ClassNotFoundException, SQLException {
       Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM article ";
        rs = st.executeQuery(sentencia);
       
        return rs;
    }

    public ResultSet ConsultarChapter() throws ClassNotFoundException, SQLException {
       Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM chapter ";
        rs = st.executeQuery(sentencia);
       
        return rs;
    }

    public ResultSet ConsultarConference() throws ClassNotFoundException, SQLException {
       Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM conference ";
        rs = st.executeQuery(sentencia);
       
        return rs;
    }

    public ResultSet ConsultarGlobalC() throws ClassNotFoundException, SQLException {
       Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM gobalcitationcount ";
        rs = st.executeQuery(sentencia);
       
        return rs;
    }

    public ResultSet ConsultarOrganization() throws ClassNotFoundException, SQLException {
       Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM organizacion ";
        rs = st.executeQuery(sentencia);
       
        return rs;
    }

    public ResultSet ConsultarJournal() throws ClassNotFoundException, SQLException {
       Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM journal ";
        rs = st.executeQuery(sentencia);
       
        return rs;
    }


    public ResultSet ConsultarConcept()  throws ClassNotFoundException, SQLException {
       Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM concept ";
        rs = st.executeQuery(sentencia);
       
        return rs;
    }

    public ResultSet ConsultarPlace() throws ClassNotFoundException, SQLException {
       Statement st = con.AbrirConexion().createStatement();
        String sentencia = "SELECT * FROM place ";
        rs = st.executeQuery(sentencia);
       
        return rs;
    }
 
}
