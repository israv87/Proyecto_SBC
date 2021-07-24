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
public class BiboJournal {
    String tituloJ; 
    String shortTitleJ; 
    String urlJ;
    int idArticle;
    int idJournal;

    public BiboJournal() {
    }

    public BiboJournal(String tituloJ, String shortTitleJ, String urlJ, int idArticle, int idJournal) {
        this.tituloJ = tituloJ;
        this.shortTitleJ = shortTitleJ;
        this.urlJ = urlJ;
        this.idArticle = idArticle;
        this.idJournal = idJournal;
    }

    public String getTituloJ() {
        return tituloJ;
    }

    public void setTituloJ(String tituloJ) {
        this.tituloJ = tituloJ;
    }

    public String getShortTitleJ() {
        return shortTitleJ;
    }

    public void setShortTitleJ(String shortTitleJ) {
        this.shortTitleJ = shortTitleJ;
    }

    public String getUrlJ() {
        return urlJ;
    }

    public void setUrlJ(String urlJ) {
        this.urlJ = urlJ;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getIdJournal() {
        return idJournal;
    }

    public void setIdJournal(int idJournal) {
        this.idJournal = idJournal;
    }

    @Override
    public String toString() {
        return "BiboJournal{" + "tituloJ=" + tituloJ + ", shortTitleJ=" + shortTitleJ + ", urlJ=" + urlJ + ", idArticle=" + idArticle + ", idJournal=" + idJournal + '}';
    }
    

    
    
}
