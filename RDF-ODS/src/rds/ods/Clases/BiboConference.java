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
public class BiboConference {
    String CidConference; 
    String tituloC; 
    String url;  
    String contacInfo; 
    String descriptionC;
    int idDocumentConf;
    String place;
    String name;

    public BiboConference() {
    }

    public BiboConference(String CidConference, String tituloC, String url, String contacInfo, String descriptionC, int idDocumentConf, String place, String name) {
        this.CidConference = CidConference;
        this.tituloC = tituloC;
        this.url = url;
        this.contacInfo = contacInfo;
        this.descriptionC = descriptionC;
        this.idDocumentConf = idDocumentConf;
        this.place = place;
        this.name = name;
    }

    public String getCidConference() {
        return CidConference;
    }

    public void setCidConference(String CidConference) {
        this.CidConference = CidConference;
    }

    public String getTituloC() {
        return tituloC;
    }

    public void setTituloC(String tituloC) {
        this.tituloC = tituloC;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContacInfo() {
        return contacInfo;
    }

    public void setContacInfo(String contacInfo) {
        this.contacInfo = contacInfo;
    }

    public String getDescriptionC() {
        return descriptionC;
    }

    public void setDescriptionC(String descriptionC) {
        this.descriptionC = descriptionC;
    }

    public int getIdDocumentConf() {
        return idDocumentConf;
    }

    public void setIdDocumentConf(int idDocumentConf) {
        this.idDocumentConf = idDocumentConf;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BiboConference{" + "CidConference=" + CidConference + ", tituloC=" + tituloC + ", url=" + url + ", contacInfo=" + contacInfo + ", descriptionC=" + descriptionC + ", idDocumentConf=" + idDocumentConf + ", place=" + place + ", name=" + name + '}';
    }

    
    
    
}
