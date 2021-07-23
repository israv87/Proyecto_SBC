/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rds.ods.Clases;

/**
 *
 * @author Isra
 */
public class FoafOrganization {
   String name; 
   String homePage; 
   int idDocument;

    public FoafOrganization() {
    }

    public FoafOrganization(String name, String homePage, int idDocument) {
        this.name = name;
        this.homePage = homePage;
        this.idDocument = idDocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    @Override
    public String toString() {
        return "FoafOrganization{" + "name=" + name + ", homePage=" + homePage + ", idDocument=" + idDocument + '}';
    }
   
   
}
