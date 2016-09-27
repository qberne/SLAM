package com.example.quent.myapplication;

import junit.framework.TestCase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by quent on 27/09/2016.
 */
public class CoursTest extends TestCase {

    public CoursTest(String testMethodName) {
        super(testMethodName);
    }

    public void testAjoutParticipant() throws Exception {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Participant P1 = new Participant("TAURAND", "Test", sdf1.parse("01/01/2001"), (byte)49);

        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Cours C1 = new Cours("Ski Débutant", sdf2.parse("15/12/2015 13:00"), 10);

        C1.ajouterParticipant(P1);

        assertEquals("Insertion non effectuee",C1.getLesParticipantsInscrits().get(0).getNom(),"TAURAND");

        for (int i = 1; i <= 10; i++) C1.ajouterParticipant(P1); //Ajout de 10 participants

        assertEquals("Test participants max non fonctionnel", C1.getLesParticipantsInscrits().size(), 10);
    }

    public void testSupprimerParticipant() throws Exception {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Participant P1 = new Participant("TAURAND", "Test", sdf1.parse("01/01/2001"), (byte)49);

        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Cours C1 = new Cours("Ski Débutant", sdf2.parse("15/12/2015 13:00"), 10);

        C1.ajouterParticipant(P1);

        assertEquals("Participant non present",C1.getLesParticipantsInscrits().size(),1);

        C1.supprimerParticipant(P1);

        assertEquals("Supression non fonctionnel", C1.getLesParticipantsInscrits().size(), 0);
    }

    public void testTrouverParticipants() throws Exception {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Participant P1 = new Participant("DE ROBIEN", "Test", sdf1.parse("01/01/2001"), (byte)49);
        Participant P2 = new Participant("TAURAND", "Test", sdf1.parse("01/01/2001"), (byte)49);
        Participant P3 = new Participant("TAURAND", "Test2", sdf1.parse("01/01/2005"), (byte)49);

        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Cours C1 = new Cours("Ski Débutant", sdf2.parse("15/12/2015 13:00"), 10);

        C1.ajouterParticipant(P1);
        C1.ajouterParticipant(P2);
        C1.ajouterParticipant(P3);

        assertEquals("Participant non trouver", C1.trouverParticipants("DE ROBIEN").get(0).getNom(),"DE ROBIEN");

        assertEquals("Fraterie non fonctionnel", C1.trouverParticipants("TAURAND").size(), 2);
    }
}
