package Graphic;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import Threads.ErrorDisplay;

/**
 *
 * @author ghersa
 */
public class Connection extends javax.swing.JFrame {

 
    public Connection() {
        initComponents();
    }
                         
    private void initComponents() {

        panel_connexion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inp_ip = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inp_port = new javax.swing.JTextField();
        I_Cancel = new javax.swing.JButton();
        I_Login = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        inp_username = new javax.swing.JTextField();
        I_erreur = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Please enter the IP address and Port");

        inp_ip.setText("127.0.0.1");

        jLabel2.setText("IP address");

        jLabel3.setText("Port");

        inp_port.setText("2018");

        I_Cancel.setText("Cancel");
        I_Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                I_CancelFunc_cancel(evt);
            }
        });

        I_Login.setText("LogIn");
        I_Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                I_LoginFunc_login(evt);
            }
        });

        jLabel5.setText("Username ");

        inp_username.setText("Your UserName");

        I_erreur.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout panel_connexionLayout = new javax.swing.GroupLayout(panel_connexion);
        panel_connexion.setLayout(panel_connexionLayout);
        panel_connexionLayout.setHorizontalGroup(
            panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_connexionLayout.createSequentialGroup()
                .addGroup(panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(I_erreur, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_connexionLayout.createSequentialGroup()
                            .addGap(435, 435, 435)
                            .addGroup(panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_connexionLayout.createSequentialGroup()
                                    .addComponent(I_Cancel)
                                    .addGap(264, 264, 264)
                                    .addComponent(I_Login))
                                .addGroup(panel_connexionLayout.createSequentialGroup()
                                    .addGroup(panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(55, 55, 55)
                                    .addGroup(panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inp_ip, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                        .addComponent(inp_port, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                        .addComponent(inp_username)))))
                        .addGroup(panel_connexionLayout.createSequentialGroup()
                            .addGap(496, 496, 496)
                            .addComponent(jLabel1))))
                .addContainerGap(429, Short.MAX_VALUE))
        );
        panel_connexionLayout.setVerticalGroup(
            panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_connexionLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_connexionLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inp_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addComponent(jLabel3))
                    .addComponent(inp_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inp_username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103)
                .addGroup(panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(I_Cancel)
                    .addComponent(I_Login))
                .addGap(47, 47, 47)
                .addComponent(I_erreur, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1236, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 691, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }                       

    private void I_CancelFunc_cancel(java.awt.event.MouseEvent evt) {                                     
        this.inp_ip.setText("127.0.0.1");
        this.inp_port.setText("2018");
        this.inp_username.setText("Your UserName");
         
    }                                    

    private void I_LoginFunc_login(java.awt.event.MouseEvent evt) {    

		int tmp_port = Integer.parseInt(this.inp_port.getText());
		String tmp_ip = this.inp_ip.getText();
		String tmp_user = this.inp_username.getText();
		
    	if(tmp_ip.equals("") | this.inp_port.getText().equals("") | tmp_user.equals("") ) {
    		new ErrorDisplay(this.I_erreur, "The IP address And Port And UserName must not be empty").start();
    	}else { 
    		
    		try {
				s = new Socket( tmp_ip, tmp_port ); 
			} catch (IOException e) {
				new ErrorDisplay(this.I_erreur, "Connection error").start();
			}
    
    		if(s!=null) {
    			DataInputStream canalLecture=null;
    			String tmp="";
    			String[] cmd;
    			// while(tmp.equals("")) {
    				
    			 try {
    				 canalLecture = new DataInputStream(this.s.getInputStream());
    				// tmp = canalLecture.readLine();
    				 System.out.println(tmp);
    		  		} catch (IOException e) {
    		  			e.printStackTrace();
    		  		}
    			// }
    			 cmd = tmp.split("/");
    			 if(cmd[0].equals("ERREUR")) {
    				 new ErrorDisplay(this.I_erreur, "User Exists").start();
    			 }else {
       	          Games j = new Games( tmp_user, s);
       	          j.setVisible(true);
       	          this.setVisible(false); 
    			 }
    			
    		}else {
    			new ErrorDisplay(this.I_erreur, "Connection error").start();
    		}

		}
    	

        
        
    }                                  
 
    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Connection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Connection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Connection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Connection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Connection().setVisible(true);
            }
        });
    }
                     
    private javax.swing.JButton I_Cancel;
    private javax.swing.JButton I_Login;
    private javax.swing.JLabel I_erreur;
    private javax.swing.JTextField inp_ip;
    private javax.swing.JTextField inp_port;
    private javax.swing.JTextField inp_username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panel_connexion;
    
    private  Socket s = null;
 
}
