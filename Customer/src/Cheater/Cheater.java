package Cheater;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.Vector;

public class Cheater {

	boolean conex = true;
	Combination myTrich;
	Vector<String> platrecu = new Vector<>();
	
	Vector<String>  trajic = new Vector<>();

	DataInputStream canalLecture=null;
	PrintStream canalEcriture=null;
	
    public void lanceTricheur() {
    	
    	
    	String port1 = "2018";
    	int port = 2018;
    	String ip = "127.0.0.1";
    	Socket sok = null ;

    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Bienvenue sur le client tricheur ;) ");
    	System.out.println("Donner l'adresse IP de serveur ");
    	ip = sc.nextLine();
    	System.out.println("Donner le PORT de serveur ");
    	port1 = sc.nextLine();
    	port = Integer.parseInt(port1);
    	
    	try {
			sok = new Socket(ip, port);
		} catch (UnknownHostException e) { e.printStackTrace();
		} catch (IOException e) { e.printStackTrace(); }
    	
    	if(sok!=null) {
    		try {
				canalLecture = new DataInputStream(sok.getInputStream());
				canalEcriture = new PrintStream(sok.getOutputStream());
			} catch (IOException e) { e.printStackTrace(); }
    		
    		
    	}

    	trajic.add("A1");trajic.add("A2");trajic.add("A3");trajic.add("A4");
    	trajic.add("B1");trajic.add("B2");trajic.add("B3");trajic.add("B4");
    	trajic.add("C1");trajic.add("C2");trajic.add("C3");trajic.add("C4");
    	trajic.add("D1");trajic.add("D2");trajic.add("D3");trajic.add("D4");
    	
    	Driving com = new Driving(this, canalLecture, canalEcriture);
    	com.start();
    	canalEcriture.print("CONNEXION/Tricheur/\n");canalEcriture.flush();
    	
    	new SendingMessages(canalEcriture).start();
        
    }

//    a chaque recu de nouveux pla
public void receveLettres(String plateux) {
	if(!conex) {
		myTrich.stop();
	}
	
	conex = false;
	platrecu = new Vector<>();
	
	for (int i = 0; i < plateux.length(); i++) { platrecu.add(""+plateux.charAt(i)); }
	 
	myTrich = new Combination(canalEcriture, platrecu, trajic);
	myTrich.start();
 
}


}