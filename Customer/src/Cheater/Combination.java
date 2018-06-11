package Cheater;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Vector;

public class Combination extends Thread{

	private PrintStream canalEcriture=null;
	private Vector<String> mots;
	private Vector<String> trajectoir;
	
	private Vector<String> Platmots;
	private Vector<String> trajectoirPlat;
	
	public Combination(PrintStream c, Vector<String> m, Vector<String> t) {
		 this.canalEcriture = c;
		 this.mots = new Vector<>();
		 this.trajectoir = new Vector<>();
		 this.Platmots = m;
		 this.trajectoirPlat = t;
	}
	
	@Override
	public void run() {
		
		ensembleMots(this.Platmots,  this.trajectoirPlat);
		
	}
	

//	trouver l'ensemble des mots de taille 2 a la taille 15 en appelle la methode combinaisons
public void ensembleMots(Vector<String> p, Vector<String> t) {
	Vector<String> tmpL = new Vector<>();
	Vector<String> tmpT = new Vector<>();
	
	Vector<String> reverseP = new Vector<>();
	Vector<String> reverseT = new Vector<>();
	for (int i = 15; i >= 0 ; i--) {
		reverseP.add(p.elementAt(i));
		reverseT.add(t.elementAt(i));
	}

	for (int i = 2; i < 15; i++) {
		combinaisons(tmpL, tmpT, p, t, i);
		combinaisons(tmpL, tmpT, reverseP, reverseT, i);
		
	}

}

//	methode utilise la programmation dynamique pour trouver tout les combainison 
public void combinaisons(Vector<String> ListLettres,Vector<String> ListTirag, Vector<String> Grille,Vector<String> OrderTirage, int nbLet) {
	if(nbLet==0) { 
		AddNewMotTrouve(ListLettres, ListTirag);
	}else {
		
		Vector<String> GrilleRest;
		Vector<String> GrilleRestTirag;
		Vector<String> ListLettresPlus;
		Vector<String> ListTiragPlus;
		
		for (int i = 0; i < Grille.size(); i++) {
			 
			GrilleRest = new Vector<>();
			for (int j = i; j < Grille.size(); j++) {
				 
				GrilleRest.add(Grille.get(j));
			}
			
			GrilleRestTirag = new Vector<>();
			for (int j = i; j < OrderTirage.size(); j++) {
				 
				GrilleRestTirag.add(OrderTirage.get(j));
			}
			
			ListLettresPlus = new Vector<>();
			ListLettresPlus = (Vector<String>) ListLettres.clone();  ListLettresPlus.addElement(Grille.get(i));
			
			ListTiragPlus = new Vector<>();
			ListTiragPlus = (Vector<String>) ListTirag.clone();  ListTiragPlus.addElement(OrderTirage.get(i));
			
			combinaisons(ListLettresPlus, ListTiragPlus, GrilleRest, GrilleRestTirag, nbLet-1);
			
		}
	}
}

// pour chaque mot de la combainison si il existe dans le dic on l'envoi au serveur
public void AddNewMotTrouve(Vector<String> mot, Vector<String> taj) {
	String motcom = "";
	String trajcom = "";
	
	for (int i = 0; i < mot.size(); i++) {
		 
		motcom += mot.elementAt(i);
		trajcom += taj.elementAt(i);
	}
	if(is_exist_word(motcom)) {
		 
		mots.addElement(motcom);
		trajectoir.addElement(trajcom);
		canalEcriture.print("TROUVE/"+motcom+"/"+trajcom+"/\n");canalEcriture.flush();
	}

}	

// tester si un mot existe dans un dictionnaire 
public static boolean is_exist_word(String word){
    word = word.toUpperCase();
	boolean rps = false;
		File dataFile = new File("src/Cheater/Dictionnaire/"+word.charAt(0)+"_dico.txt");
		   	try {
		   	InputStream ips = new FileInputStream(dataFile);
		   	InputStreamReader ipsr = new InputStreamReader(ips);
		   	BufferedReader br = new BufferedReader(ipsr);
		   	String ligne;
		   	while ((ligne = br.readLine()) != null) {
		   		 
		   		if (word.equals(ligne)) {
					rps = true;
				}
		   	}
		   	
		   	br.close();
		   	} catch (Exception e) { System.out.println(e.toString()); }
return rps;
}
}
