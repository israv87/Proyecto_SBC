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
public class C4OGlobalCount {
    String hasGobalCountDate;  
    int hasGobalCountValue; 
    int idDocument;

    public C4OGlobalCount() {
    }

    public C4OGlobalCount(String hasGobalCountDate, int hasGobalCountValue, int idDocument) {
        this.hasGobalCountDate = hasGobalCountDate;
        this.hasGobalCountValue = hasGobalCountValue;
        this.idDocument = idDocument;
    }

    public String getHasGobalCountDate() {
        return hasGobalCountDate;
    }

    public void setHasGobalCountDate(String hasGobalCountDate) {
        this.hasGobalCountDate = hasGobalCountDate;
    }

    public int getHasGobalCountValue() {
        return hasGobalCountValue;
    }

    public void setHasGobalCountValue(int hasGobalCountValue) {
        this.hasGobalCountValue = hasGobalCountValue;
    }

    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    @Override
    public String toString() {
        return "BiboGlobalCount{" + "hasGobalCountDate=" + hasGobalCountDate + ", hasGobalCountValue=" + hasGobalCountValue + ", idDocument=" + idDocument + '}';
    }
    
    
}
