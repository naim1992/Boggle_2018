package Cheater;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Driving extends Thread{

	private Cheater tr=null;
	private DataInputStream canalLecture=null;
	private PrintStream canalEcriture=null;
	private String commande = "";
	private String[] cmd;
	
	public Driving(Cheater t, DataInputStream l, PrintStream e) {
		this.tr = t;
		this.canalLecture = l;
		this.canalEcriture = e;
	}
	
	@Override
	public void run() {
		while(!this.isInterrupted()) {

			try {
				this.commande = this.canalLecture.readLine();
			} catch (IOException e) { this.interrupt(); e.printStackTrace(); }
			
			if(this.commande!=null && !this.commande.equals("")) {  
 
				 this.cmd = this.commande.split("/");
		            
		            
					switch (this.cmd[0]) {
					

					case "BIENVENUE": 
						this.tr.receveLettres(this.cmd[1]);
						break;

					case "TOUR":
						this.tr.receveLettres(this.cmd[1]);
						break;
						
					default:
						break;
						
					}
				
			}
		}
	}
}
