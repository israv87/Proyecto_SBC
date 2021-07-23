package rds.ods.Clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Isra
 */
public class FoafPerson {
    String name;
    String pnombre;
    String snombre;
    String apellidoP;
    String apellidoM;
    String url;
    String rank;
    int idDocumentPerson;

    public FoafPerson() {
    }

    public FoafPerson(String name, String pnombre, String snombre, String apellidoP, String apellidoM, String url, String rank, int idDocumentPerson) {
        this.name = name;
        this.pnombre = pnombre;
        this.snombre = snombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.url = url;
        this.rank = rank;
        this.idDocumentPerson = idDocumentPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPnombre() {
        return pnombre;
    }

    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getIdDocumentPerson() {
        return idDocumentPerson;
    }

    public void setIdDocumentPerson(int idDocumentPerson) {
        this.idDocumentPerson = idDocumentPerson;
    }

    @Override
    public String toString() {
        return "BiboPerson{" + "name=" + name + ", pnombre=" + pnombre + ", snombre=" + snombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", url=" + url + ", rank=" + rank + ", idDocumentPerson=" + idDocumentPerson + '}';
    }

    
            
    
}
