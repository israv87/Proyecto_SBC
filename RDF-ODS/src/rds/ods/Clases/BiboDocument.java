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
public class BiboDocument {
        int id;
        String titulo;
        String abstrct;
        String uri;
        String anio;
        int numPages;
        String doi;
        String lenguaje;
        int volumen;
        int start;
        int end;
        String cites;
        String open;
        String biboDocument;
        String type;
        String place;
        String plc;

    public BiboDocument() {
    }

    public BiboDocument(int id, String titulo, String abstrct, String uri, String anio, int numPages, String doi, String lenguaje, int volumen, int start, int end, String cites, String open, String biboDocument, String type, String place, String plc) {
        this.id = id;
        this.titulo = titulo;
        this.abstrct = abstrct;
        this.uri = uri;
        this.anio = anio;
        this.numPages = numPages;
        this.doi = doi;
        this.lenguaje = lenguaje;
        this.volumen = volumen;
        this.start = start;
        this.end = end;
        this.cites = cites;
        this.open = open;
        this.biboDocument = biboDocument;
        this.type = type;
        this.place = place;
        this.plc = plc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAbstrct() {
        return abstrct;
    }

    public void setAbstrct(String abstrct) {
        this.abstrct = abstrct;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getCites() {
        return cites;
    }

    public void setCites(String cites) {
        this.cites = cites;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getBiboDocument() {
        return biboDocument;
    }

    public void setBiboDocument(String biboDocument) {
        this.biboDocument = biboDocument;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlc() {
        return plc;
    }

    public void setPlc(String plc) {
        this.plc = plc;
    }

    @Override
    public String toString() {
        return "BiboDocument{" + "id=" + id + ", titulo=" + titulo + ", abstrct=" + abstrct + ", uri=" + uri + ", anio=" + anio + ", numPages=" + numPages + ", doi=" + doi + ", lenguaje=" + lenguaje + ", volumen=" + volumen + ", start=" + start + ", end=" + end + ", cites=" + cites + ", open=" + open + ", biboDocument=" + biboDocument + ", type=" + type + ", place=" + place + ", plc=" + plc + '}';
    }
        
        
 
   
        
}
