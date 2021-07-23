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
public class BiboBook {
 String isbn;
 String edition;
 int idDocumentBook; 

    public BiboBook() {
    }

    public BiboBook(String isbn, String edition, int idDocumentBook) {
        this.isbn = isbn;
        this.edition = edition;
        this.idDocumentBook = idDocumentBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getIdDocumentBook() {
        return idDocumentBook;
    }

    public void setIdDocumentBook(int idDocumentBook) {
        this.idDocumentBook = idDocumentBook;
    }

    @Override
    public String toString() {
        return "BiboBook{" + "isbn=" + isbn + ", edition=" + edition + ", idDocumentBook=" + idDocumentBook + '}';
    }

   
}
