package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class CorrecteurTest {

	@Test // test 1 dans le dico 1 pas dedans
	public void testCorriger1() {
		String[] t1 = { "toiture", "hhh" };
		String[] d1 = { "toiture" };
		boolean[] ct = Main.corriger(t1, d1);
		assertTrue(ct[0]);
		assertFalse(ct[1]);
	}

	@Test // test Maj
	public void testCorriger2() {
		String[] t1 = { "Toiture" };
		String[] d1 = { "toiture" };
		boolean[] ct = Main.corriger(t1, d1);
		assertTrue(ct[0]);
	}

	@Test // test Espace
	public void testCorriger3() {
		String[] t1 = { " " };
		String[] d1 = { " " };
		boolean[] ct = Main.corriger(t1, d1);
		assertTrue(ct[0]);
	}

	@Test // test vide
	public void testCorriger4() {
		String[] t1 = {};
		String[] d1 = {};
		boolean[] ct = Main.corriger(t1, d1);
		assertEquals(ct.length, 0);
	}

	@Test // test avec d1 long
	public void testCorriger5() {
		String[] t1 = { "huitre", "chien", "baleine" };
		String[] d1 = { "huitre", "baleine" };
		boolean[] ct = Main.corriger(t1, d1);
		assertTrue(ct[0]);
	}

	@Test // 1 taille 4
	public void testRechercheDico1() {
		String[] t = { "arbre", "babouin", "compact", "débrouille" };
		// 1er terme
		assertEquals(0, Main.rechercheDicho("arbre", t));
		// dernier terme
		assertEquals(3, Main.rechercheDicho("débrouille", t));
		// terme au milieu
		assertEquals(1, Main.rechercheDicho("babouin", t));
		// terme en dehors du tableau
		assertEquals(-1, Main.rechercheDicho("proust", t));
	}

	@Test // 2 taille 0
	public void testRechercheDico2() {
		String[] t = {};
		assertEquals(-1, Main.rechercheDicho("arbre", t));
	}

	@Test // 3 taille 1
	public void testRechercheDico3() {
		String[] t = { "arbre" };
		assertEquals(0, Main.rechercheDicho("arbre", t));
	}

	@Test // cherche mot avec accent
	public void testRechercheDico4() {
		String[] t = { "arbre", "éléphant", "proust" };
		assertEquals(1, Main.rechercheDicho("éléphant", t));
	}

	@Test
	public void testTriTrié() {
		String[] t1 = { "arbre", "babouche", "clafoutie" };
		String[] t1trie = { "arbre", "babouche", "clafoutie" };

		Main.triSelection(t1);
		assertArrayEquals(t1trie, t1);
	}

	@Test
	public void testTriNonTrié() {
		String[] t1 = { "babouche", "clafoutie", "arbre" };
		String[] t1trie = { "arbre", "babouche", "clafoutie" };

		Main.triSelection(t1);
		assertArrayEquals(t1trie, t1);
	}

	@Test
	public void testTri1mot() {
		String[] t1 = { "babouche" };
		String[] t1trie = { "babouche" };

		Main.triSelection(t1);
		assertArrayEquals(t1trie, t1);
	}

	@Test
	public void testTriMajusculeMiniscule() {
		String[] t1 = { "arbre", "Babouche", "clafoutie" };
		String[] t1trie = { "Babouche", "arbre", "clafoutie" };

		Main.triSelection(t1);
		assertArrayEquals(t1trie, t1);
	}

	@Test // La 1ere, derniere et milieu lettre qui est pas la même
	public void testCalculerDifference1() {
		String s1 = ("arbre");
		String s2 = ("zrbre");
		String s3 = ("arbrz");
		String s4 = ("arzre");
		Main.calculerDifference(s1, s2);
		Main.calculerDifference(s1, s3);
		Main.calculerDifference(s1, s4);
	}

	@Test // mot pas de même longueur
	public void testCalculerDifference2() {
		String s1 = ("arbre");
		String s2 = ("arbree");
		Main.calculerDifference(s1, s2);
	}

	// A compléter par VOS tests sur TOUTES les fonctions y compris les fonctions
	// intermédiaires!!

}
