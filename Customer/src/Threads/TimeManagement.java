package Threads;

public class TimeManagement extends Thread{
	
	private int time = 0 ;
	private javax.swing.JLabel LabTime;
	
	public TimeManagement(javax.swing.JLabel L, int t) {
		this.LabTime = L;
		this.time = t;
	}
	
	@Override
	public void run() {
		while (this.time!=0) {
			
			if(this.time<=10) {
				this.LabTime.setForeground(new java.awt.Color(253,22,7));	
			}else {
				this.LabTime.setForeground(new java.awt.Color(13,2,1));
			}
			
			this.LabTime.setText(""+this.time);
			try { sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
			this.time--;
		}
	}
}
