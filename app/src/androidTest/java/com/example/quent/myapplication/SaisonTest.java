package com.example.quent.myapplication;

import junit.framework.TestCase;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by quent on 27/09/2016.
 */
public class SaisonTest extends TestCase {
    public SaisonTest(String testMethodName) {
        super(testMethodName);
    }

    public void testAjouterSupprimerCours() throws Exception {
        Saison S1 = new Saison();

        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Cours C1 = new CoursCollectifs("Ski Débutant", sdf2.parse("15/12/2015 13:00"), 10);

        S1.ajouterCours(C1);

        assertEquals("Ajout non fonctionnel", S1.getLesCours().get(0), C1);

        S1.supprimerCours(C1);

        assertEquals("Supression non fonctionnel", S1.getLesCours().size(), 0);
    }

    public void testTrouverCours() throws Exception {
        Saison S1 = new Saison();

        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Cours C1 = new CoursCollectifs("Ski Débutant", sdf2.parse("15/12/2015 13:00"), 10);

        S1.ajouterCours(C1);

        assertEquals("trouver cours date non fonctionnel", S1.trouverCours(sdf2.parse("15/12/2015 13:00")), C1);

        assertEquals("trouver cours intitule non fonctionnel", S1.trouverCours("Ski Débutant"), C1);
    }
}
