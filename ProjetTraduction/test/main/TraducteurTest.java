package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TraducteurTest {
	@Before
	public void init() {
		// Si des initialisations sont nécessaires avant de réaliser les tests
		// les lancer ici
	}

	@Test
	public void test1() {
		String[] t1 = { "je", "chercher" };
		String[] t1Attendu = { "I", "look for" };

		String[] t1Traduit = Main.traduire(t1);
		assertArrayEquals(t1Attendu, t1Traduit);
	}

	@Test
	public void testIndiceCle() {

		String[] cles = { "arbre", "babouin", "compact", "débrouille" };
		String[] valeur = { "arbre", "babouin", "compact", "débrouille" };
		int nbAssoc = 4;
		TabAssoc tab = new TabAssoc();
		tab.cles = cles;
		tab.valeurs = valeur;
		tab.nbAssoc = nbAssoc;
		// 1er terme
		assertEquals(0, Main.indiceCle("arbre", tab));
		// dernier terme
		assertEquals(3, Main.rechercheDicho("débrouille", tab));
		// terme au milieu
		assertEquals(1, Main.rechercheDicho("babouin", tab));
		// terme en dehors du tableau
		assertEquals(-1, Main.rechercheDicho("proust", tab));
	}

	@Test // 1 taille 4
	public void testRechercheDico1() {
		String[] cle = { "arbre", "babouin", "compact", "débrouille" };
		String[] valeur = { "arbre", "babouin", "compact", "débrouille" };
		int nbAssoc = 4;
		TabAssoc tab = new TabAssoc();
		tab.cles = cle;
		tab.valeurs = valeur;
		tab.nbAssoc = nbAssoc;

		// 1er terme
		assertEquals(0, Main.rechercheDicho("arbre", tab));
		// dernier terme
		assertEquals(3, Main.rechercheDicho("débrouille", tab));
		// terme au milieu
		assertEquals(1, Main.rechercheDicho("babouin", tab));
		// terme en dehors du tableau
		assertEquals(-1, Main.rechercheDicho("proust", tab));
	}

	// TODO Auto-generated method stub

	@Test // 2 taille 0
	public void testRechercheDico2() {
		String[] cle = {};
		String[] valeur = {};
		int nbAssoc = 0;
		TabAssoc tab = new TabAssoc();
		tab.cles = cle;
		tab.valeurs = valeur;
		tab.nbAssoc = nbAssoc;
		assertEquals(-1, Main.rechercheDicho("arbre", tab));
	}

	@Test // 3 taille 1
	public void testRechercheDico3() {
		String[] cle = { "arbre" };
		String[] valeur = { "arbre" };
		int nbAssoc = 1;
		TabAssoc tab = new TabAssoc();
		tab.cles = cle;
		tab.valeurs = valeur;
		tab.nbAssoc = nbAssoc;
		assertEquals(0, Main.rechercheDicho("arbre", tab));
	}

	@Test // trie taille 4
	public void testTri1() {
		String[] cle = { "arbre", "babouin", "compact", "débrouille" };
		String[] valeur = { "arbre", "babouin", "compact", "débrouille" };
		int nbAssoc = 4;
		TabAssoc tab = new TabAssoc();
		tab.cles = cle;
		tab.valeurs = valeur;
		tab.nbAssoc = nbAssoc;
		Main.tri(tab);
	}

	@Test // trie taille vide
	public void testTri2() {
		String[] cle = {};
		String[] valeur = {};
		int nbAssoc = 0;
		TabAssoc tab = new TabAssoc();
		tab.cles = cle;
		tab.valeurs = valeur;
		tab.nbAssoc = nbAssoc;
		Main.tri(tab);
	}

	@Test // trie taille 1
	public void testTri3() {
		String[] cle = { "arbre" };
		String[] valeur = { "arbre" };
		int nbAssoc = 1;
		TabAssoc tab = new TabAssoc();
		tab.cles = cle;
		tab.valeurs = valeur;
		tab.nbAssoc = nbAssoc;
		Main.tri(tab);
	}

	// A compléter par VOS tests sur TOUTES les fonctions y compris les fonctions
	// intermédiaires!!

}
