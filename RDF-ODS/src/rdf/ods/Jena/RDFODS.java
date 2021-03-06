/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rdf.ods.Jena;

import com.mysql.jdbc.Connection;
import rds.ods.Log.LogConcept;
import rds.ods.Log.LogJournal;
import rds.ods.Log.LogOrganization;
import rds.ods.Log.LogConference;
import rds.ods.Log.LogChapter;
import rds.ods.Log.LogBook;
import rds.ods.Log.LogGlobalCount;
import rds.ods.Log.LogPerson;
import rds.ods.Log.LogArticle;
import rds.ods.Clases.BiboDocument;
import rds.ods.Log.LogDocument;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.VCARD;
import org.apache.jena.sparql.vocabulary.FOAF;
//import org.apache.jena.rdf.model.RDFWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.apache.jena.riot.*;

import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.SKOS;
import rdf.ods.Data.DATConexion;
import rds.ods.Clases.BiboArticle;
import rds.ods.Clases.BiboBook;
import rds.ods.Clases.BiboChapter;
import rds.ods.Clases.BiboConference;
import rds.ods.Clases.BiboJournal;
import rds.ods.Clases.C4OGlobalCount;
import rds.ods.Clases.FoafOrganization;
import rds.ods.Clases.FoafPerson;
import rds.ods.Clases.SkosConcept;

/**
 *
 * @author Isra
 */
public class RDFODS {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) throws ClassNotFoundException, SQLException {

                ArrayList<BiboDocument> arrayDocument = new ArrayList<BiboDocument>();
                ArrayList<BiboArticle> arrayArticle = new ArrayList<BiboArticle>();
                ArrayList<BiboBook> arrayBook = new ArrayList<BiboBook>();
                ArrayList<BiboChapter> arrayChapter = new ArrayList<BiboChapter>();
                ArrayList<BiboConference> arrayConference = new ArrayList<BiboConference>();
                ArrayList<C4OGlobalCount> arrayGlobalCount = new ArrayList<C4OGlobalCount>();
                ArrayList<FoafPerson> arrayPerson = new ArrayList<FoafPerson>();
                ArrayList<FoafOrganization> arrayOrganization = new ArrayList<FoafOrganization>();
                ArrayList<SkosConcept> arrayConcept = new ArrayList<SkosConcept>();
                ArrayList<BiboJournal> arrayJournal = new ArrayList<BiboJournal>();

                LogDocument objLogDocument = new LogDocument();
                LogArticle objLogArticle = new LogArticle();
                LogBook objLogBook = new LogBook();
                LogChapter objLogChapter = new LogChapter();
                LogConference objLogConference = new LogConference();
                LogGlobalCount objLogGlobal = new LogGlobalCount();
                LogJournal objLogJournal = new LogJournal();
                LogOrganization objLogOrganization = new LogOrganization();
                LogPerson objLogPerson = new LogPerson();
                LogConcept objLogConcept = new LogConcept();

                DATConexion objDat = new DATConexion();
                Model model = ModelFactory.createDefaultModel();
                String dataPrefix = "http://utpl.edu.ec/ods/";
                model.setNsPrefix("Data", dataPrefix);

                // Fijar prefijos de vocabularios incorporados en Jena
                String foaf = "http://xmlns.com/foaf/0.1/";
                model.setNsPrefix("foaf", foaf);
                String vcard = "http://www.w3.org/2006/vcard/ns#";
                model.setNsPrefix("foaf", vcard);
                String dct = "http://purl.org/dc/terms/";
                model.setNsPrefix("dct", dct);
                String projmol = "http://utpl.edu.ec/ods/projmol/#";
                model.setNsPrefix("projmol", projmol);

                // Fijar Prefijo para otros vocabularios como DBPedia que no est??n directamente
                // incorporados en Jena
                String schema = "http://schema.org/";
                model.setNsPrefix("schema", schema);

                String bibo = "http://purl.org/ontology/bibo/";
                model.setNsPrefix("bibo", bibo);
                String vivo = "http://vivoweb.org/ontology/core";
                model.setNsPrefix("vivo", vivo);
                String c4o = "http://purl.org/spar/c4o/";
                model.setNsPrefix("c4o", c4o);
                String event = "http://purl.org/NET/c4dm/event.owl#";
                model.setNsPrefix("event", event);

                String dbo = "http://dbpedia.org/ontology";
                model.setNsPrefix("dbo", dbo);

                Model dboModel = ModelFactory.createDefaultModel(); // modelo de la ontolog??a
                objLogDocument.LeerBiboDocument(arrayDocument);
                objLogBook.LeerBooks(arrayBook);
                objLogArticle.LeerArticulos(arrayArticle);
                objLogChapter.LeerChapter(arrayChapter);
                objLogJournal.LeerJournal(arrayJournal);
                objLogGlobal.LeerGlobalC(arrayGlobalCount);
                objLogOrganization.LeerOrg(arrayOrganization);
                objLogPerson.LeerPerson(arrayPerson);
                objLogConference.LeerConference(arrayConference);
                objLogConcept.LeerConcept(arrayConcept);

                for (BiboDocument objDoc : arrayDocument) {
                        
                        String ProcedingsURI = dataPrefix + ("PROC" + objDoc.getAnio()+ objDoc.getPlc()+ objDoc.getId());
                        Resource procedings = model.createResource(ProcedingsURI)
                            .addProperty(RDF.type, dboModel.getResource(bibo + "Proceedings"));
                        
                        String CONFPAPERURI = dataPrefix + ("CONF" + objDoc.getAnio()+ objDoc.getPlc()+ objDoc.getId());
                        Resource conferencePaper = model.createResource(CONFPAPERURI)
                            .addProperty(RDF.type,dboModel.getResource(vivo + "ConferencePaper"))
                            .addProperty(dboModel.getProperty(bibo, "reproducedIn"), ProcedingsURI);

                        String PlaceURI = dataPrefix + ("PLC" + objDoc.getPlc()+objDoc.getId());
                        Resource place = model.createResource(PlaceURI)
                            .addProperty(RDF.type, dboModel.getResource(vivo + "Place"))
                            .addProperty(FOAF.name, String.valueOf(objDoc.getPlace()));
                        
                            String PublisherURI = dataPrefix+ ("PUB" + objDoc.getAnio()+ objDoc.getPlc()+ objDoc.getId());
                        Resource publisher = model.createResource(PublisherURI)
                            .addProperty(RDF.type,dboModel.getResource(vivo + "Publisher"))
                            .addProperty(dboModel.getProperty(dbo, "place"), PlaceURI);

                        String DocumentURI = dataPrefix + objDoc.getDoi();
                        
                        Resource Document = model.createResource(DocumentURI)
                                        // .addProperty(RDF.type,FOAF.Document )
                                        .addProperty(RDF.type, dboModel.getResource(bibo + "Document"))
                                        .addProperty(DCTerms.title, objDoc.getTitulo())
                                        .addProperty(dboModel.getProperty(bibo, "abstract"), objDoc.getAbstrct())
                                        .addProperty(dboModel.getProperty(bibo, "cites"), DocumentURI)
                                        .addProperty(dboModel.getProperty(bibo, "date"), objDoc.getAnio())
                                        .addProperty(dboModel.getProperty(bibo, "uri"), objDoc.getUri())
                                        .addProperty(dboModel.getProperty(vivo, "numPages"),
                                                        String.valueOf(objDoc.getNumPages()))
                                        .addProperty(DCTerms.language, objDoc.getLenguaje())
                                        .addProperty(dboModel.getProperty(bibo, "doi"), objDoc.getDoi())
                                        .addProperty(dboModel.getProperty(bibo, "volume"),
                                                        String.valueOf(objDoc.getVolumen()))
                                        .addProperty(dboModel.getProperty(bibo, "pageStart"),
                                                        String.valueOf(objDoc.getStart()))
                                        .addProperty(dboModel.getProperty(bibo, "pageEnd"),
                                                        String.valueOf(objDoc.getEnd()));
                        place.addProperty(dboModel.getProperty(dbo, "place"), DocumentURI);

                        String TESISURI = dataPrefix + ("THS" + objDoc.getAnio()+ objDoc.getPlc()+ objDoc.getId());
                        Resource tesis = model.createResource(TESISURI)
                                        .addProperty(RDF.type, dboModel.getResource(bibo + "Thesis"))
                                        .addProperty(RDFS.subClassOf, DocumentURI);

                        for (FoafPerson objPerson : arrayPerson) {
                                if (objPerson.getIdDocumentPerson() == objDoc.getId()) {
                                        String PersonURI = dataPrefix + (objPerson.getUrl() + 
                                                        + objPerson.getIdDocumentPerson());
                                        Resource person = model.createResource(PersonURI)
                                                        .addProperty(RDF.type, FOAF.Person)
                                                        .addProperty(FOAF.name, objPerson.getName())
                                                        .addProperty(FOAF.lastName, objPerson.getApellidoP())
                                                        .addProperty(FOAF.firstName, objPerson.getPnombre())
                                                        .addProperty(dboModel.getProperty(vivo, "url"),projmol+objPerson.getUrl())
                                                        .addProperty(dboModel.getProperty(vivo, "rank"),objPerson.getRank());
                                        Document.addProperty(dboModel.getProperty(dct, "creator"),
                                                dboModel.getResource(PersonURI));
                                }
                        }

                        for (C4OGlobalCount objGlobal : arrayGlobalCount) {
                                if (objGlobal.getIdDocument() == objDoc.getId()) {

                                        String GLOBALURI = dataPrefix + (objGlobal.getHasGobalCountDate()+
                                                        objGlobal.getHasGobalCountDate() + "-"
                                                        + objGlobal.getIdDocument());
                                        Resource global = model.createResource(GLOBALURI)
                                                        .addProperty(RDF.type,dboModel.getResource(c4o + "GlobalCitationCount"))
                                                        .addProperty(dboModel.getProperty(dct, "hasGlobalCountDate"),
                                                                        objGlobal.getHasGobalCountDate())
                                                        .addProperty(dboModel.getProperty(dct, "hasGlobalCountValue"),
                                                                        String.valueOf(objGlobal.getHasGobalCountValue()));
                                        Document.addProperty(dboModel.getProperty(c4o,"hasGlobalCitationFrequency"),
                                                dboModel.getResource(GLOBALURI));
                               }  
                        }

                        for (SkosConcept objSkos : arrayConcept) {
                                if (objSkos.getIdDocumentConcept() == objDoc.getId()) {

                                        String ConceptURI = dataPrefix + ("SKOS" + objSkos.getNamec() + objSkos.getIdDocumentConcept());
                                        Resource SkosConcept = model.createResource(ConceptURI)
                                                        .addProperty(RDF.type, SKOS.Concept)
                                                        .addProperty(SKOS.prefLabel, objSkos.getPrefLabel())
                                                        .addProperty(SKOS.altLabel, objSkos.getAltLabel())
                                                        .addProperty(SKOS.broader, ConceptURI);
                                        Document.addProperty(dboModel.getProperty(dct, "subject"),dboModel.getResource(ConceptURI));
                                }
                        }
                        // Consultamos los libros y si el documento actual es un libro o no
                        for (BiboBook objBook : arrayBook) {
                                if (objBook.getIdDocumentBook() == objDoc.getId()) {
                                        String BookURI = dataPrefix + (objBook.getIsbn());
                                        Resource book = model.createResource(BookURI)
                                                        .addProperty(RDF.type, dboModel.getResource(bibo + "Book"))
                                                        .addProperty(RDFS.subClassOf, dboModel.getResource(DocumentURI))
                                                        .addProperty(dboModel.getProperty(bibo, "isbn"),objBook.getIsbn())
                                                        .addProperty(dboModel.getProperty(bibo, "edition"),objBook.getEdition());
                                        procedings.addProperty(RDFS.subClassOf, BookURI);
                                }
                        }

                        for (BiboArticle objArt : arrayArticle) {
                                if (objArt.getIdDocumentArt() == objDoc.getId()) {
                                        String ArticleURI = dataPrefix + (objArt.getIdentifier());
                                        
                                        Resource article = model.createResource(ArticleURI)
                                                        .addProperty(RDF.type, dboModel.getResource(bibo + "Article"))
                                                        .addProperty(RDFS.subClassOf, dboModel.getResource(DocumentURI))
                                                        .addProperty(dboModel.getProperty(bibo, "identifier"),objArt.getIdentifier())
                                                        .addProperty(dboModel.getProperty(projmol, "influentialCC"), objArt.getInfluencialCC())
                                                        .addProperty(dboModel.getProperty(vivo, "issue"),objArt.getIssue());
                                        conferencePaper.addProperty(RDFS.subClassOf, dboModel.getResource(ArticleURI))
                                                        .addProperty(dboModel.getProperty(bibo, "reproducedIn"), ProcedingsURI);
                                
                                        for (BiboJournal objJournal : arrayJournal) {
                                                if (objJournal.getIdArticle() == objArt.getIdArticle()) {
                                                        String JOURNALURI = dataPrefix + (objJournal.getIdArticle()+objJournal.getIdJournal());
                                                        Resource journal = model.createResource(JOURNALURI)
                                                                        .addProperty(RDF.type,dboModel.getResource(bibo+ "Journal"))
                                                                        .addProperty(dboModel.getProperty(dct, "title"),objJournal.getTituloJ())
                                                                        .addProperty(dboModel.getProperty(vcard, "uri"),projmol+objJournal.getUrlJ())
                                                                        .addProperty(dboModel.getProperty(bibo,"shortTitle"),objJournal.getShortTitleJ())
                                                                        .addProperty(dboModel.getProperty(vivo, "Publisher"), PublisherURI);
                                                        article.addProperty(dboModel.getProperty(dct,"isPartOf"),dboModel.getResource(JOURNALURI));

                                                }
                                        }
                                }
                        }

                        for (BiboChapter objChapter : arrayChapter) {
                                if (objChapter.getIdDocumentCh() == objDoc.getId()) {

                                        String DocumentPartURI = dataPrefix
                                                        + ("DCP" +  objChapter.getChapter()+objChapter.getIdDocumentCh());
                                        Resource documentPart = model.createResource(DocumentPartURI)
                                                        .addProperty(RDF.type,dboModel.getResource(bibo + "DocumentPart"))
                                                        .addProperty(RDFS.subClassOf, DocumentURI);

                                        String ChapterURI = dataPrefix + ("CH" + objChapter.getChapter());
                                        Resource chapter = model.createResource(ChapterURI)
                                                        .addProperty(dboModel.getProperty(bibo, "chapter"), objChapter.getChapter())
                                                        .addProperty(RDFS.subClassOf, DocumentPartURI);
                                }
                        }

                        for (BiboConference objConf : arrayConference) {
                                if (objConf.getIdDocumentConf() == objDoc.getId()) {

                                        String ConferenceURI = dataPrefix + ("CONF" + objConf.getName() + "_"+ objConf.getPlace()
                                                + "_"+ objConf.getCidConference());
                                        Resource conference = model.createResource(ConferenceURI)
                                                .addProperty(RDF.type, dboModel.getResource(bibo + "Conference"))
                                                .addProperty(dboModel.getProperty(dct,"title"),objConf.getTituloC())
                                                .addProperty(dboModel.getProperty(vivo,"url"),projmol+objConf.getUrl())
                                                .addProperty(dboModel.getProperty(vivo,"contactInformation"),objConf.getContacInfo())
                                                .addProperty(dboModel.getProperty(vivo,"description"),objConf.getDescriptionC())
                                                .addProperty(dboModel.getProperty(vivo,"hasProceedings"),ProcedingsURI)
                                                .addProperty(dboModel.getProperty(vivo,"publisher"),PublisherURI)
                                                .addProperty(dboModel.getProperty(event,"place"),PlaceURI)
                                                ;
                                        conferencePaper.addProperty(dboModel.getProperty(bibo,"presentedAt"),ConferenceURI);
                                }

                        }

                        for (FoafOrganization objOrg : arrayOrganization) {
                                if (objOrg.getIdDocument() == objDoc.getId()) {
                                    
                               
                                        String ORGANIZATIONURI = dataPrefix + ("ORG"+ objDoc.getAnio()+ objDoc.getPlc()+ objDoc.getId());
                                        Resource organization = model.createResource(ORGANIZATIONURI)
                                                        .addProperty(RDF.type, FOAF.Organization)
                                                        .addProperty(dboModel.getProperty(dbo, "place"), PlaceURI)
                                                        .addProperty(FOAF.name, objOrg.getName())
                                                        .addProperty(FOAF.homepage, objOrg.getHomePage());
                                        tesis.addProperty(dboModel.getProperty(bibo, "issuer"), ORGANIZATIONURI);
                                        publisher.addProperty(RDFS.subClassOf, ORGANIZATIONURI);
                                        
                                                                                
                                        String ConferenceURI2 = dataPrefix + ("Conf2" +objOrg.getIdDocument()+"ORG");
                                        Resource conference2 = model.createResource(ConferenceURI2)
                                                .addProperty(dboModel.getProperty(bibo,"organizer"),ORGANIZATIONURI);
                                }
                         }
                }

                StmtIterator iter = model.listStatements();
                // print out the predicate, subject and object of each statement
                while (iter.hasNext()) {
                        Statement stmt = iter.nextStatement(); // get next statement
                        Resource subject = stmt.getSubject(); // get the subject
                        Property predicate = stmt.getPredicate(); // get the predicate
                        RDFNode object = stmt.getObject(); // get the object

                        // System.out.print(subject.toString());
                        // System.out.print(" " + predicate.toString() + " ");
                        if (object instanceof Resource) {
                                // System.out.print(object.toString());
                        } else {
                                // object is a literal
                                // System.out.print(" \"" + object.toString() + "\"");
                        }

                        // System.out.println(" .");
                }

                // now write the model in XML form to a file
                System.out.println("MODELO RDF------");
                // model.write(System.out, "RDF/");

                // Save to a file
                // RDFWriter writer = model.getWriter("RDF/XML");
                // writer.write(model,os, "");
                RDFDataMgr.write(System.out, model, Lang.TURTLE);
                // Close models
                dboModel.close();
                model.close();

        }

}
