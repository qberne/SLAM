package com.example.quent.myapplication;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by quent on 18/10/2016.
 */
public class PlanningSaison {

    private Date DateDebut, DateFin;
    private ArrayList<Cours> listCours;

    public void ajouterUnCours(Cours c) {
        if (c.getDateCours().after(DateDebut) && c.getDateCours().before(DateFin))
        {
            listCours.add(c);
        }
    }
    public void supprimerUnCours(Cours c) {

        c.getLesParticipantsInscrits().clear();
        listCours.remove(c);
    }
    public ArrayList<CoursCollectifs> listeDesCoursCollectifs() {
        ArrayList<CoursCollectifs> cc = new ArrayList<CoursCollectifs>();
        for (Cours c : listCours)
        {
            if (c instanceof CoursCollectifs) cc.add((CoursCollectifs) c);
        }
        return cc;
    }
    public ArrayList<CoursIndividuels> listeDesCoursIndividuels() {
        ArrayList<CoursIndividuels> ci = new ArrayList<CoursIndividuels>();
        for (Cours c : listCours)
        {
            if (c instanceof CoursIndividuels) ci.add((CoursIndividuels)c);
        }
        return ci;
    }
    public ArrayList<Cours> listeDesCours() {
        ArrayList<Cours> c = new ArrayList<Cours>();
        c.addAll(listeDesCoursCollectifs());
        c.addAll(listeDesCoursIndividuels());
        return c;
    }

}
