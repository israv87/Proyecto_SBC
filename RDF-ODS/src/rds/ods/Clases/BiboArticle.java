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
public class BiboArticle {
    int idArticle;
   String identifier;
   String influencialCC;
   String issue;
   int idDocumentArt;

    public BiboArticle() {
    }

    public BiboArticle(int idArticle, String identifier, String influencialCC, String issue, int idDocumentArt) {
        this.idArticle = idArticle;
        this.identifier = identifier;
        this.influencialCC = influencialCC;
        this.issue = issue;
        this.idDocumentArt = idDocumentArt;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getInfluencialCC() {
        return influencialCC;
    }

    public void setInfluencialCC(String influencialCC) {
        this.influencialCC = influencialCC;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public int getIdDocumentArt() {
        return idDocumentArt;
    }

    public void setIdDocumentArt(int idDocumentArt) {
        this.idDocumentArt = idDocumentArt;
    }

    @Override
    public String toString() {
        return "BiboArticle{" + "idArticle=" + idArticle + ", identifier=" + identifier + ", influencialCC=" + influencialCC + ", issue=" + issue + ", idDocumentArt=" + idDocumentArt + '}';
    }

  
   
}
