package com.example.quent.myapplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by quent on 27/09/2016.
 */
public class Cours {
    private String intituleCours;
    private Date dateCours;
    private int nbMaxCours;
    private ArrayList<Participant> lesParticipantsInscrits;

    public Cours(String intituleCours, Date dateCours, int nbMaxCours){
        this.intituleCours = intituleCours;
        this.dateCours = dateCours;
        this.nbMaxCours = nbMaxCours;
        this.lesParticipantsInscrits = new ArrayList<Participant>();
    }

    public String getIntituleCours() {
        return intituleCours;
    }

    public Date getDateCours() {
        return dateCours;
    }

    public int getNbMaxCours() {
        return nbMaxCours;
    }

    public ArrayList<Participant> getLesParticipantsInscrits(){
        return lesParticipantsInscrits;
    }

    public void setDateCours(Date dateCours) {
        this.dateCours = dateCours;
    }

    public void setNbMaxCours(int nbMaxCours) {
        if (this.nbMaxCours < nbMaxCours) this.nbMaxCours = nbMaxCours;
    }

    public boolean ajouterParticipant(Participant unP){
        if (lesParticipantsInscrits.size() < nbMaxCours) //Si il reste de la place
        {
            lesParticipantsInscrits.add(unP);
            return true;
        }
        else return false;
    }
    
    public void supprimerParticipant(Participant unP) throws Exception{
        if (lesParticipantsInscrits.contains(unP)){
            lesParticipantsInscrits.remove(unP);
        }
        else throw new Exception("Participant introuvable");
    }

    public String listeDesParticipants(){
        if (lesParticipantsInscrits.size() == 0) return "";
        String s = "";
        for (Participant P : lesParticipantsInscrits) s += "--\n" + P.toString() + "\n\n";
        return s;
    }

    public ArrayList<Participant> trouverParticipants(String unNomFamille){
        ArrayList<Participant> list = new ArrayList<Participant>();
        for (Participant P : lesParticipantsInscrits) if (P.getNom() == unNomFamille) list.add(P);
        return list;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder("Cours\n");
        sb.append(getIntituleCours()).append("\n");
        sb.append(getDateCours().toString()).append("\n");
        sb.append(getNbMaxCours()).append("\n");
        sb.append(listeDesParticipants());
        return sb.toString(); /*retour de la chaîne*/
    }
        
}
