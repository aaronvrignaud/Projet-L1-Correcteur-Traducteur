package main;

import javax.swing.text.TabableView;

import util.ACX;

public class Main2 {
    public static String[] dico = ACX.lectureDico("lib/frenchEnglish.txt");

    public static TabAssoc init() {
        TabAssoc t = new TabAssoc();
        t.nbAssoc = 0;
        t.cles = new String[10000];
        t.valeurs = new String[10000];
        return t;
    }

    public static void ajouteAssoc(String fr, String en, TabAssoc t) {
        t.cles[t.nbAssoc] = fr;
        t.valeurs[t.nbAssoc] = en;
        t.nbAssoc++;
    }

    public static TabAssoc enBien(TabAssoc tab, String[] dico) {
        for (int i = 0; i < dico.length; i = i + 2) {
            tab.cles[tab.nbAssoc] = dico[i];
            tab.valeurs[tab.nbAssoc] = dico[i + 1];
            tab.nbAssoc++;
        }
        return tab;
    }

}
