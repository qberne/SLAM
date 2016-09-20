package com.example.quent.myapplication;

import junit.framework.TestCase;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by quent on 20/09/2016.
 */

public class ParticipantTest extends TestCase {
    public ParticipantTest(String testMethodName) {
        super(testMethodName);
    }

    public Participant testInstanciation() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return new Participant("de Robien", "Frédérique", sdf.parse("01/01/2001"), (byte) 49);
    }

    public void testNom() throws Exception {
        Participant p = testInstanciation();
        String n = p.getNom();
        assertEquals("Erreur dans les accesseurs de nom", n, "de Robien");
    }

    public void testPrenom() throws Exception {
        Participant p = testInstanciation();
        String n = p.getPrenom();
        assertEquals("Erreur dans les accesseurs de prenom", n, "Frédérique");
    }

    public void testDateDeNaissance() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Participant p = testInstanciation();
        Date d = p.getDateDeNaissance();
        assertEquals("Erreur dans les accesseurs de dateDeNaissance", d, sdf.parse("01/01/2001"));
    }

    public void testNumDepartement() throws Exception {
        Participant p = testInstanciation();
        byte b = p.getNumDepartement();
        assertEquals(49, b);
        p.setNumDepartement((byte) 55);
        b = p.getNumDepartement();
        assertEquals("Erreur dans les accesseurs de NumDepartement", b, (byte) 55);
    }

    public void testToString() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Participant p = testInstanciation();
        String n = p.toString();
        assertEquals("Erreur dans la methode toString()", n, "Participant\nde Robien\nFrédérique\n" + sdf.parse("01/01/2001") + "\n49");
    }
}
