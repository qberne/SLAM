package com.example.quent.myapplication;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by quent on 27/09/2016.
 */
public class CoursCollectifs extends Cours {
    private int nbMaxCours;

    public CoursCollectifs(String intituleCours, Date dateCours, int nbMaxCours){
        super(intituleCours, dateCours);
        this.nbMaxCours = nbMaxCours;
    }

    public int getNbMaxCours() {
        return nbMaxCours;
    }

    public void setNbMaxCours(int nbMaxCours) {
        if (this.nbMaxCours < nbMaxCours) this.nbMaxCours = nbMaxCours;
    }

    public boolean ajouterParticipant(Personne unP){
        if (listPersonnes.size() < nbMaxCours) //Si il reste de la place
        {
            listPersonnes.add(unP);
            return true;
        }
        else return false;
    }
    
    public void supprimerParticipant(Personne unP) throws Exception{
        if (listPersonnes.contains(unP)){
            listPersonnes.remove(unP);
        }
        else throw new Exception("Personne introuvable");
    }

    public String listeDesParticipants(){
        if (listPersonnes.size() == 0) return "";
        String s = "";
        for (Personne P : listPersonnes) s += "--\n" + P.toString() + "\n\n";
        return s;
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
        sb.append(getNbMaxCours()).append("\n");
        sb.append(listeDesParticipants());
        return sb.toString(); /*retour de la chaîne*/
    }
}
