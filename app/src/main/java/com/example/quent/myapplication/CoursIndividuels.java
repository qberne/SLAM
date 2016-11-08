package com.example.quent.myapplication;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by quent on 27/09/2016.
 */
public class CoursIndividuels extends Cours {

    protected Personne moniteur;

    public CoursIndividuels(String intituleCours, Date dateCours, Personne moniteur){
        super(intituleCours, dateCours);
        this.moniteur = moniteur;
    }

    public Personne getMoniteur() { return moniteur; }

    public void setMoniteur(Personne moniteur){
        this.moniteur = moniteur;
    }

    public Personne getLeParticipant() {
        if (listPersonnes.size() == 0) return null;
        else return listPersonnes.get(0);
    }

    public boolean ajouterParticipant(Personne unP){
        if (listPersonnes.size() == 0) //Si il reste de la place
        {
            listPersonnes.add(unP);
            return true;
        }
        else return false;
    }

    public void supprimerParticipant(Personne unP) throws Exception{
        if (listPersonnes.size() != 0 && listPersonnes.get(0) == unP){
            listPersonnes.remove(unP);
        }
    }

    public String listeDesParticipants(){
        if (listPersonnes.size() == 0) return "aucun participant affecté à ce cours";
        return listPersonnes.get(0).toString();
    }

    public ArrayList<Personne> trouverParticipants(String unNomFamille){
        ArrayList<Personne> list = new ArrayList<Personne>();
        for (Personne P : listPersonnes) if (P.getNom() == unNomFamille) list.add(P);
        return list;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Cours\n");
        sb.append(getIntituleCours()).append("\n");
        sb.append(getDateCours().toString()).append("\n");
        sb.append(getMoniteur()).append("\n");
        sb.append(listeDesParticipants());
        return sb.toString(); /*retour de la chaîne*/
    }
        
}
