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
public class SkosConcept {
    String prefLabel;
    String altLabel;
    int idDocumentConcept;
    String namec;

    public SkosConcept() {
    }

    public SkosConcept(String prefLabel, String altLabel, int idDocumentConcept, String namec) {
        this.prefLabel = prefLabel;
        this.altLabel = altLabel;
        this.idDocumentConcept = idDocumentConcept;
        this.namec = namec;
    }

    public String getPrefLabel() {
        return prefLabel;
    }

    public void setPrefLabel(String prefLabel) {
        this.prefLabel = prefLabel;
    }

    public String getAltLabel() {
        return altLabel;
    }

    public void setAltLabel(String altLabel) {
        this.altLabel = altLabel;
    }

    public int getIdDocumentConcept() {
        return idDocumentConcept;
    }

    public void setIdDocumentConcept(int idDocumentConcept) {
        this.idDocumentConcept = idDocumentConcept;
    }

    public String getNamec() {
        return namec;
    }

    public void setNamec(String namec) {
        this.namec = namec;
    }

    
}
