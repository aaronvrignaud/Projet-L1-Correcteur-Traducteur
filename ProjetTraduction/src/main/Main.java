package main;

import util.ACX;

public class Main {

	// niveau 1
	public static TabAssoc init() {
		String[] t = ACX.lectureDico("lib/frenchEnglish.txt");
		TabAssoc tab = new TabAssoc();
		int nMax = t.length / 2;
		tab.nbAssoc = 0;
		tab.cles = new String[nMax];
		tab.valeurs = new String[nMax];
		for (int i = 0; i < t.length; i = i + 2) {
			tab.cles[tab.nbAssoc] = t[i];
			tab.valeurs[tab.nbAssoc] = t[i + 1];
			tab.nbAssoc++;
		}

		return tab;
	}

	public static int indiceCle(String cle, TabAssoc tab) {

		for (int i = 0; i < tab.nbAssoc; i++) {
			if (cle.toLowerCase().equals(tab.cles[i].toLowerCase())) {
				return i;
			}

		}
		return -1;
	}

	public static String valeurParIndiceCle(String cle, TabAssoc tab) {
		int indiceCle = indiceCle(cle, tab);
		if (indiceCle != -1) {
			return tab.valeurs[indiceCle];
		}
		return cle;
	}

	public static String[] traduireIntermediaire(String[] texte, TabAssoc tab) {
		String[] texteTraduit = new String[texte.length];
		for (int i = 0; i < texteTraduit.length; i++) {
			texteTraduit[i] = valeurParIndiceCle(texte[i], tab);
		}
		return texteTraduit;
	}

	public static String[] traduire(String[] texte) {
		TabAssoc tab = init();
		return traduireIntermediaire(texte, tab);
	}

	// niveau 2

	public static TabRac initRacine() {
		String[] t = ACX.lectureDico("lib/racines.txt");
		TabRac tab = new TabRac();
		int nMax = t.length;
		tab.nAssoc = 0;
		tab.mot = new String[nMax];
		tab.racines = new String[nMax];
		for (int i = 0; i < t.length; i++) {
			// separe les mots espaces
			String[] temp = ACX.mots(t[i]);
			tab.mot[tab.nAssoc] = temp[1];
			tab.racines[tab.nAssoc] = temp[2];
			tab.nAssoc++;

		}

		return tab;
	}

	public static String valeurParIndiceCleRacines(String cle, TabAssoc tab, TabRac rac) {
		int indiceCle = indiceCle(cle, tab);
		if (indiceCle != -1) {
			return tab.valeurs[indiceCle];
		} else if (indiceRacine(cle, rac) != -1) {
			return valeurParIndiceCle(rac.racines[indiceRacine(cle, rac)], tab);
		}
		return cle;
	}

	public static int indiceRacine(String cle, TabRac tab) {

		for (int i = 0; i < tab.nAssoc; i++) {
			if (cle.equals(tab.mot[i])) {
				return i;
			}

		}
		return -1;
	}

	public static String[] traduireIntermediaireRac(String[] texte, TabAssoc tab, TabRac rac) {

		String[] texteTraduit = new String[texte.length];
		for (int i = 0; i < texteTraduit.length; i++) {
			texteTraduit[i] = valeurParIndiceCleRacines(texte[i], tab, rac);
		}
		return texteTraduit;
	}

	public static String[] traduireRac(String[] texte) {
		TabAssoc tab = init();
		TabRac rac = initRacine();
		return traduireIntermediaireRac(texte, tab, rac);
	}

	// niveau 3

	public static TabAssoc exchange(TabAssoc tab, int a, int b) {
		String temp1 = tab.cles[a];
		String temp2 = tab.valeurs[a];
		tab.cles[a] = tab.cles[b];
		tab.valeurs[a] = tab.valeurs[b];
		tab.cles[b] = temp1;
		tab.valeurs[b] = temp2;
		return tab;
	}

	public static void tri(TabAssoc tab) {
		int imin = 0;
		for (int i = 0; i < tab.cles.length; i++) {
			// afficheTableau(t);
			imin = i;
			for (int j = i; j < tab.cles.length; j++) {
				if (tab.cles[imin].compareTo(tab.cles[j]) > 0) {
					imin = j;
				}
			}
			exchange(tab, i, imin);
		}
	}

	public static int rechercheDicho(String cherche, TabAssoc tab) {
		int debut = 0;
		int fin = tab.cles.length - 1;
		boolean trouve = false;
		int milieu = (debut + fin) / 2;
		while (!trouve && debut <= fin) {
			milieu = (debut + fin) / 2;
			if (tab.cles[milieu].compareTo(cherche) == 0)
				trouve = true;
			else if (tab.cles[milieu].compareTo(cherche) > 0) {
				fin = milieu - 1;
			} else
				debut = milieu + 1;
		}
		if (trouve)
			return milieu;
		else
			return -1;
	}

	public static String valeurParIndiceCleTri(String cle, TabAssoc tab, TabRac rac) {
		tri(tab);
		int indiceCle = rechercheDicho(cle, tab);
		if (indiceCle != -1) {
			return tab.valeurs[indiceCle];
		} else if (indiceRacine(cle, rac) != -1) {
			return valeurParIndiceCle(rac.racines[indiceRacine(cle, rac)], tab);
		}
		return cle;
	}

	public static String[] traduireIntermediaireTri(String[] texte, TabAssoc tab, TabRac rac) {

		String[] texteTraduit = new String[texte.length];
		for (int i = 0; i < texteTraduit.length; i++) {
			texteTraduit[i] = valeurParIndiceCleRacines(texte[i], tab, rac);
		}
		return texteTraduit;
	}

	public static String[] traduireTri(String[] texte) {
		TabAssoc tab = init();
		TabRac rac = initRacine();
		return traduireIntermediaireRac(texte, tab, rac);
	}

	public static void main(String[] args) {
		// ACX.interfaceTraduction("traduire");
		ACX.interfaceTraduction("traduireRac");
		// ACX.interfaceTraduction("traduireTri");
	}
}