package com.example.quent.myapplication;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by quent on 27/09/2016.
 */
public class Saison {
    private ArrayList<Cours> lesCours;

    public ArrayList<Cours> getLesCours() {
        return lesCours;
    }

    public Saison(){
        lesCours = new ArrayList<Cours>();
    }

    public void ajouterCours(Cours unCours) {
        getLesCours().add(unCours);
    }

    public void supprimerCours(Cours unCours) {
        getLesCours().remove(unCours);
    }

    public Cours trouverCours(Date uneDate){
        Cours c = null;
        for (Cours C : lesCours) if (C.getDateCours().compareTo(uneDate) == 0) c = C;
        return c;
    }

    public Cours trouverCours(String unIntitule){
        Cours c = null;
        for (Cours C : lesCours) if (C.getIntituleCours() == unIntitule) c = C;
        return c;
    }
}
