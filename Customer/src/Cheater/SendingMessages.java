package Cheater;

import java.io.PrintStream;
import java.util.Vector;

public class SendingMessages extends Thread{
	private Vector<String> messages = new Vector<>();
	private PrintStream canalEcriture=null;

	public SendingMessages( PrintStream e) {
		this.canalEcriture = e;
	}
	
	@Override
	public void run() {
		mymessages();
		
		while(true) {
			int ind = (int) (Math.random() * ( this.messages.size() - 0 ));
			
			this.canalEcriture.print("ENVOI/"+this.messages.get(ind)+"/\n");
			this.canalEcriture.flush();
			
			try { sleep(4000); } catch (InterruptedException e) { this.interrupt();}
		}
	}

	public void mymessages() {
		this.messages.addElement("Salut les amis.");
		this.messages.addElement("moi je suis de paris et vous.");
		this.messages.addElement("chez nous il fais beux ;))");
		this.messages.addElement("qui veux rester en contact avec moi ?");
		this.messages.addElement("je suis votre CHEF ;) ");
		this.messages.addElement("qui veux suivre des cours avec moi ? ");
		this.messages.addElement("Hy Hyyy");
	}
	
}
