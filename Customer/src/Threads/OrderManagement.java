package Threads;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import Graphic.Games;

public class OrderManagement extends Thread{

	private Games jeux = null;
	private Socket socket = null;
	private DataInputStream canalLecture = null;
	private PrintStream canalEcriture = null;
	private String commande = "";
	private String[] cmd;
	
	public OrderManagement(Games j) {
		this.jeux = j;
		this.socket = this.jeux.getSocket();
        try {
        	this.canalEcriture = new PrintStream(this.socket.getOutputStream());
        	this.canalLecture = new DataInputStream(this.socket.getInputStream());
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
	}
	
	@Override
	public void run() {
		while(!this.isInterrupted()) {
			
			try {
				this.commande = this.canalLecture.readLine();
			} catch (IOException e) { this.interrupt(); e.printStackTrace(); }
			
			if(this.commande!=null || !this.commande.equals("")) {  
 
				
            this.cmd = this.commande.split("/");
            
            
			switch (this.cmd[0]) {
			
			case "BIENVENUE": 
				this.jeux.NewGrille(this.cmd[1]);
				this.jeux.NewResults(this.cmd[2]);
				break;
				
			case "CONNECTE":
				this.jeux.AddUser(this.cmd[1]);
				new ErrorDisplay(this.jeux.I_out_message, "New connection of "+this.cmd[1]).start();
				break;

			case "DECONNEXION": 
				this.jeux.RemoveUser(this.cmd[1]);
				new ErrorDisplay(this.jeux.I_out_message, this.cmd[1]+" is offline ").start();
				break;

			case "SESSION": 
				new ErrorDisplay(this.jeux.I_out_message, "New Session").start();
				this.jeux.NewSession();
				break;

			case "VAINQUEUR": 
				new ErrorDisplay(this.jeux.I_out_message, "End of Session").start();
				String bilan = this.cmd[1]; 
				this.jeux.NewResults(bilan);
				break;

			case "TOUR":
				this.jeux.NewGrille(this.cmd[1]);
				break;
				
			case "MVALIDE": 
				this.jeux.ValidationMot(this.cmd[1]);
				break;
				
			case "MINVALIDE": 
				new ErrorDisplay(this.jeux.I_out_message, this.cmd[1]).start();
				this.jeux.InValidationMot();
				break;
				
			case "RFIN": 
				new ErrorDisplay(this.jeux.I_out_message, "Expiry of the time limit for reflection.").start();
				break;
				
			case "BILANMOTS": 
				this.jeux.NewResultsBil(this.cmd[1], this.cmd[2]);
				break;
				
			case "RECEPTION": 
				this.jeux.AddMessage("Public", this.cmd[1]);
				break;
				
			case "PRECEPTION": 
				this.jeux.AddMessage(this.cmd[2], this.cmd[1]);
				break;

			case "USERS": 
				this.jeux.AddUSERS(this.cmd[1]);
				break;

			case "TIME": 
				int tmp = Integer.parseInt(this.cmd[1]);
				new TimeManagement(this.jeux.I_in_time, tmp).start();
				break;
				
			case "ERREUR": 
				switch (this.cmd[1]) {
				case "userExist":
					new ErrorDisplay(this.jeux.I_out_message, "User existe.").start();
					this.jeux.closeF();
					break;

				default:
					System.out.println("autre ERREUR");
					break;
				}
				
				break;
				
				

			default:
				break;
			}
			}
		}
	}
}
