package com.example.quent.myapplication;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by quent on 13/09/2016.
 */
public class Participant {
    private String nom, prenom;
    private Date dateDeNaissance;
    private byte numDepartement;

    public Participant() {
    }

    public Participant(String nom, String prenom, Date dateDeNaissance, byte numDepartement) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.numDepartement = numDepartement;
    }

    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public Date getDateDeNaissance(){
        return this.dateDeNaissance;
    }

    public byte getNumDepartement(){
        return this.numDepartement;
    }

    public void setNumDepartement(byte numDepartement)
    {
        this.numDepartement = numDepartement;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Participant\n");
        sb.append(getNom()).append("\n");
        sb.append(getPrenom()).append("\n");
        sb.append(getDateDeNaissance()).append("\n");
        sb.append(getNumDepartement());
        return sb.toString(); /*retour de la chaîne*/
    }
}
