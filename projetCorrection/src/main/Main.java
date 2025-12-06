package main;

import util.ACX;

public class Main {

	public static String[] dico = ACX.lectureDico("lib/dico.txt");
	public static String[] dicotrie = ACX.lectureDico("lib/dicotrie.txt");

	public static int recherche(String cherche, String[] dico) {
		// A FAIRE!
		for (int x = 0; x < dico.length; x++) {
			if (dico[x].equals(cherche)) {
				return x;
			}
		}
		return -1;
	}

	// A faire!
	public static boolean[] corriger(String[] texte, String[] dico) {
		boolean[] presence = new boolean[texte.length];
		for (int i = 0; i < texte.length; i++) {
			if (recherche(texte[i].toLowerCase(), dico) >= 0) {
				presence[i] = true;
			} else {
				presence[i] = false;
			}
		}
		return presence;
	}

	public static boolean[] corrigerDico(String[] texte) {
		boolean[] resultat = corriger(texte, dico);
		return resultat;
	}

	public static void exchange(String[] t, int i, int j) {
		String temp = t[i];
		t[i] = t[j];
		t[j] = temp;
	}

	public static void triSelection(String[] dico) {
		int imin = 0;
		for (int i = 0; i < dico.length; i++) {
			// afficheTableau(t);
			imin = i;
			for (int j = i; j < dico.length; j++) {
				if (dico[imin].compareTo(dico[j]) > 0) {
					imin = j;
				}
			}
			exchange(dico, i, imin);
		}
	}

	public static int rechercheDicho(String cherche, String[] dico) {
		int debut = 0;
		int fin = dico.length - 1;
		boolean trouve = false;
		int milieu = (debut + fin) / 2;
		while (!trouve && debut <= fin) {
			milieu = (debut + fin) / 2;
			if (dico[milieu].compareTo(cherche) == 0)
				trouve = true;
			else if (dico[milieu].compareTo(cherche) > 0) {
				fin = milieu - 1;
			} else
				debut = milieu + 1;
		}
		if (trouve)
			return milieu;
		else
			return -1;
	}

	public static boolean[] corrigerRapide(String[] texte, String[] dico) {
		boolean[] presence = new boolean[texte.length];
		for (int i = 0; i < texte.length; i++) {
			if (rechercheDicho(texte[i].toLowerCase(), dico) >= 0) {
				presence[i] = true;
			} else {
				presence[i] = false;
			}
		}
		return presence;
	}

	public static boolean[] corrigerDicoRapide(String[] texte) {
		boolean[] resultat = corrigerRapide(texte, dicotrie);
		return resultat;

	}

	public static boolean calculerDifference(String s1, String s2) {
		int count = 0;
		if (s1.length() != s2.length()) {
			return false;
		} else {
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					count++;
					if (count > 1) {
						return false;
					}
				}
			}
		}
		return count == 1;
	}

	public static String[] proposerCorrection(String mot) {
		String[] tableauMotSimilaire = dicotrie;
		int a = 0;
		for (String mot2 : tableauMotSimilaire) {
			if (mot.length() == mot2.length() && calculerDifference(mot, mot2)) {
				a++;
			}
		}

		String[] MotsSimilaire = new String[a];
		int emplacement = 0;

		for (String mot2 : tableauMotSimilaire) {
			if (mot.length() == mot2.length() && calculerDifference(mot, mot2)) {
				MotsSimilaire[emplacement++] = mot2;
			}
		}
		return MotsSimilaire;
	}

	public static void main(String[] args) {
		/*
		 * ACX.interfaceCorrection("corrigerDico");
		 * String [] t1= {"toiture","hhh"};
		 * String [] d1= {"toiture"};
		 * boolean[] ct= Main.corriger(t1,d1);
		 */
		// String [] t1= {"Toiture"};
		// String [] d1= {"toiture"};
		// boolean[] ct= Main.corrigerRapide(t1,d1);
		ACX.interfaceCorrection("corrigerDicoRapide", "proposerCorrection");
		// tri(dico);
		// ACX.ecritureFichierString(dico, "lib/dicotrie.txt");

	}
}
