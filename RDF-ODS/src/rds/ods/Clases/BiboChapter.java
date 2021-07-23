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
public class BiboChapter {
    String chapter;
    int idDocumentCh;

    public BiboChapter() {
    }

    public BiboChapter(String chapter, int idDocumentCh) {
        this.chapter = chapter;
        this.idDocumentCh = idDocumentCh;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public int getIdDocumentCh() {
        return idDocumentCh;
    }

    public void setIdDocumentCh(int idDocumentCh) {
        this.idDocumentCh = idDocumentCh;
    }

    @Override
    public String toString() {
        return "BiboChapter{" + "chapter=" + chapter + ", idDocumentCh=" + idDocumentCh + '}';
    }
    
    
}
