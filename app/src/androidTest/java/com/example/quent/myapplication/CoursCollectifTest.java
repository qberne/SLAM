package com.example.quent.myapplication;

import junit.framework.TestCase;

import java.text.SimpleDateFormat;

/**
 * Created by quent on 27/09/2016.
 */
public class CoursCollectifTest extends TestCase {

    protected Personne P1, P2, P3;
    protected Cours C1;

    public CoursCollectifTest(String testMethodName) {
        super(testMethodName);
    }

    protected void setUp() throws Exception {
        super.setUp();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        P1 = new Personne("TAURAND", "Test", sdf1.parse("01/01/2001"), (byte)49);
        P2 = new Personne("DE ROBIEN", "Test", sdf1.parse("01/01/2001"), (byte)49);
        P3 = new Personne("TAURAND", "Test2", sdf1.parse("01/01/2005"), (byte)49);

        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        C1 = new CoursCollectifs("Ski Débutant", sdf2.parse("15/12/2015 13:00"), 10);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        P1 = null;
        P2 = null;
        P3 = null;
        C1 = null;
    }

    public void testAjoutParticipant() throws Exception {
        C1.ajouterParticipant(P1);

        assertEquals("Insertion non effectuee",C1.getLesParticipantsInscrits().get(0).getNom(),"TAURAND");

        for (int i = 1; i <= 10; i++) C1.ajouterParticipant(P1); //Ajout de 10 participants

        assertEquals("Test participants max non fonctionnel", C1.getLesParticipantsInscrits().size(), 10);
    }

    public void testSupprimerParticipant() throws Exception {

            C1.ajouterParticipant(P1);

            assertEquals("Personne non present",C1.getLesParticipantsInscrits().size(),1);

            C1.supprimerParticipant(P1);

            assertEquals("Supression non fonctionnel", C1.getLesParticipantsInscrits().size(), 0);


    }

    public void testTrouverParticipants() throws Exception {
        C1.ajouterParticipant(P1);
        C1.ajouterParticipant(P2);
        C1.ajouterParticipant(P3);

        assertEquals("Personne non trouver", C1.trouverParticipants("DE ROBIEN").get(0).getNom(),"DE ROBIEN");

        assertEquals("Fraterie non fonctionnel", C1.trouverParticipants("TAURAND").size(), 2);
    }
}
