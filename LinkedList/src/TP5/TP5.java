package TP5;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.LinkedList;
import main.LinkedListInterface;
import main.MyList;
import main.MyListInterface;
import main.Operator;

public class TP5 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Linked list, methode build avec operateur union
	 */
	@Test
	public void test1() throws IOException {
		LinkedListInterface list = new LinkedList();
		MyListInterface resultatListe;
		ArrayList<Object> arr1 = new ArrayList<Object>();
		ArrayList<Object> arr2 = new ArrayList<Object>();
		arr1.add(1);
		arr2.add(4);
		resultatListe = list.build(Operator.UNION, arr1, arr2);
		int tailleListe = resultatListe.getSize();
		assertEquals("La liste resultante devrait avoir une longueur de 3.", 3, resultatListe.getSize());
		assertEquals("L'union devrait avoir créer un tableau de deux éléments.", 2, resultatListe.getAt(tailleListe-1).size());
		assertEquals("L'union devrait avoir créer un tableau avec l'élément 1.", 1, resultatListe.getAt(tailleListe-1).get(0));
		assertEquals("L'union devrait avoir créer un tableau avec l'élément 4.", 4, resultatListe.getAt(tailleListe-1).get(1));
	}
	
	/**
	 * Linked list, methode build avec operateur intersection
	 */
	@Test
	public void test2() throws IOException {
		LinkedListInterface list = new LinkedList();
		MyListInterface resultatListe;
		ArrayList<Object> arr1 = new ArrayList<Object>();
		ArrayList<Object> arr2 = new ArrayList<Object>();
		arr1.add(1);
		arr2.add(4);
		resultatListe = list.build(Operator.INTERSECTION, arr1, arr2);
		int tailleListe = resultatListe.getSize();
		assertEquals("La liste resultante devrait avoir une longueur de 3.", 3, resultatListe.getSize());
		assertEquals("L'intersection devrait avoir créer un tableau de 0 élément.", 0, resultatListe.getAt(tailleListe-1).size());
	}

	/**
	 * Linked list, methode build avec operateur difference
	 */
	@Test
	public void test3() throws IOException {
		LinkedListInterface list = new LinkedList();
		MyListInterface resultatListe;
		ArrayList<Object> arr1 = new ArrayList<Object>();
		ArrayList<Object> arr2 = new ArrayList<Object>();
		arr1.add(1);
		arr2.add(4);
		resultatListe = list.build(Operator.DIFFERENCE, arr1, arr2);
		int tailleListe = resultatListe.getSize();
		assertEquals("La liste resultante devrait avoir une longueur de 3.", 3, resultatListe.getSize());
		assertEquals("La différence devrait avoir créer un tableau de 1 élément.", 1, resultatListe.getAt(tailleListe - 1).size());
		assertEquals("La différence devrait avoir créer un tableau avec l'élément 1.", 1, resultatListe.getAt(tailleListe-1).get(0));
	}
	
	/**
	 * Linked list, methode build avec operateur symetrique difference
	 */
	@Test
	public void test4() throws IOException {
		LinkedListInterface list = new LinkedList();
		MyListInterface resultatListe;
		ArrayList<Object> arr1 = new ArrayList<Object>();
		ArrayList<Object> arr2 = new ArrayList<Object>();
		arr1.add(1);
		arr2.add(4);
		resultatListe = list.build(Operator.SYMMETRIC_DIFFERENCE, arr1, arr2);
		int tailleListe = resultatListe.getSize();
		assertEquals("La liste resultante devrait avoir une longueur de 3.", 3, resultatListe.getSize());
		assertEquals("La différence symetrique devrait avoir créer un tableau de 2 éléments.", 2, resultatListe.getAt(tailleListe - 1).size());
		assertEquals("La différence symetrique devrait avoir créer un tableau avec l'élément 1.", 1, resultatListe.getAt(tailleListe-1).get(0));
		assertEquals("La différence symetrique devrait avoir créer un tableau avec l'élément 4.", 4, resultatListe.getAt(tailleListe-1).get(1));
	}
	
	/**
	 * Linked list, methode build avec operateur is_subset
	 */
	@Test
	public void test5() throws IOException {
		LinkedListInterface list = new LinkedList();
		MyListInterface resultatListe;
		ArrayList<Object> arr1 = new ArrayList<Object>();
		ArrayList<Object> arr2 = new ArrayList<Object>();
		arr1.add(1);
		arr2.add(4);
		resultatListe = list.build(Operator.IS_SUBSET, arr1, arr2);
		int tailleListe = resultatListe.getSize();
		assertEquals("La liste resultante devrait avoir une longueur de 3.", 3, resultatListe.getSize());
		assertEquals("Le is_subset devrait avoir créer un tableau de 1 élément.", 1, resultatListe.getAt(tailleListe - 1).size());
		assertEquals("Le is_subset devrait avoir créer un tableau avec l'élément FALSE.", "false", resultatListe.getAt(tailleListe-1).get(0));
	}
	
	/**
	 * Linked list, methode build avec operateur is_superset
	 */
	@Test
	public void test6() throws IOException {
		LinkedListInterface list = new LinkedList();
		MyListInterface resultatListe;
		ArrayList<Object> arr1 = new ArrayList<Object>();
		ArrayList<Object> arr2 = new ArrayList<Object>();
		arr1.add(1);
		arr2.add(4);
		resultatListe = list.build(Operator.IS_SUPERSET, arr1, arr2);
		int tailleListe = resultatListe.getSize();
		assertEquals("La liste resultante devrait avoir une longueur de 3.", 3, resultatListe.getSize());
		assertEquals("Le is_superset devrait avoir créer un tableau de 1 élément.", 1, resultatListe.getAt(tailleListe - 1).size());
		assertEquals("Le is_superset devrait avoir créer un tableau avec l'élément FALSE.", "false", resultatListe.getAt(tailleListe-1).get(0));
	}
	
	/**
	 * MyList, methodes add, getSize, getAt, setAt
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void test7() throws IOException {
		ArrayList<Object> unArray = new ArrayList<Object>();
		unArray.add(0);
		unArray.add(1);
		unArray.add(2);
		
		ArrayList<Object> unArray2 = new ArrayList<Object>();
		unArray2.add(3);
		unArray2.add(4);
		
		MyList uneListe = new MyList();
		uneListe.add(unArray);
		
		assertEquals("La liste MyList devrait avoir une taille de 1.", 1, uneListe.getSize());
		assertEquals("La liste devrait contenir une liste de 3 éléments.", 3, uneListe.getAt(0).size());
		
		uneListe.setAt(unArray2, 0);
		assertEquals("La liste MyList devrait avoir une taille de 1.", 1, uneListe.getSize());
		assertEquals("La liste devrait contenir une liste de 2 éléments.", 2, uneListe.getAt(0).size());
		
		uneListe.getAt(uneListe.getSize() + 1); // Erreur
	}
	
	
}
