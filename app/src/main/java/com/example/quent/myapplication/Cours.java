package com.example.quent.myapplication;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by quent on 27/09/2016.
 */
public abstract class Cours {

    protected String intituleCours;
    protected Date dateCours;
    protected Double tarifHoraire;
    protected ArrayList<Personne> listPersonnes;

    public Cours(String intituleCours, Date dateCours){
        this.intituleCours = intituleCours;
        this.dateCours = dateCours;
        this.listPersonnes = new ArrayList<Personne>();
    }

    public String getIntituleCours() { return intituleCours;};

    public Date getDateCours() { return dateCours; };

    public ArrayList<Personne> getLesParticipantsInscrits() { return listPersonnes;};

    public void setDateCours(Date dateCours) { this.dateCours = dateCours; };

    public abstract boolean ajouterParticipant(Personne unP);
    
    public abstract void supprimerParticipant(Personne unP)throws Exception;

    public abstract String listeDesParticipants();

    public abstract ArrayList<Personne> trouverParticipants(String unNomFamille);
    
    public abstract String toString();
        
}
