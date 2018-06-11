package Graphic;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;

import Threads.OrderManagement;

/**
 *
 * @author ghersa
 */
public class Games extends javax.swing.JFrame {

	public Games(String usnam, Socket s) {
		initComponents();
		username.setText(usnam);
		this.socket = s;
		this.usersCon.add("Every");
		this.I_select_user.setModel(new javax.swing.DefaultComboBoxModel<>(this.usersCon));

		try {
			canalEcriture = new PrintStream(this.socket.getOutputStream());
			canalLecture = new DataInputStream(this.socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		canalEcriture.println("CONNEXION/" + this.username.getText() + "/");
		canalEcriture.flush();
		GC = new OrderManagement(this);
		GC.start();

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				canalEcriture.close();
				try {
					canalLecture.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				GC.interrupt();

				canalEcriture.println("SORT/" + username.getText() + "/\n");
				canalEcriture.flush();
				super.windowClosing(e);
			}
		});
	}

	// Initialisation des composants
	private void initComponents() {

		panel_jeux = new javax.swing.JPanel();
		jPanel_grille = new javax.swing.JPanel();
		I_in_time = new javax.swing.JLabel();
		A1 = new javax.swing.JButton();
		A3 = new javax.swing.JButton();
		A2 = new javax.swing.JButton();
		A4 = new javax.swing.JButton();
		B4 = new javax.swing.JButton();
		B3 = new javax.swing.JButton();
		B2 = new javax.swing.JButton();
		B1 = new javax.swing.JButton();
		C4 = new javax.swing.JButton();
		C3 = new javax.swing.JButton();
		C2 = new javax.swing.JButton();
		C1 = new javax.swing.JButton();
		D4 = new javax.swing.JButton();
		D3 = new javax.swing.JButton();
		D2 = new javax.swing.JButton();
		D1 = new javax.swing.JButton();
		I_out_mot = new javax.swing.JTextField();
		I_check_mot = new javax.swing.JButton();
		I_reset_mot = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		I_mots = new javax.swing.JList<>();
		jLabel6 = new javax.swing.JLabel();
		I_in_score = new javax.swing.JLabel();
		I_select_trajectory = new javax.swing.JComboBox<>();
		I_out_message = new javax.swing.JLabel();
		I_desin_trajectory = new javax.swing.JButton();
		username = new javax.swing.JLabel();
		jPanel_chat = new javax.swing.JPanel();
		I_select_user = new javax.swing.JComboBox<>();
		I_text_chat = new javax.swing.JTextField();
		I_send_chat = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		I_chat = new javax.swing.JList<>();
		jScrollPane3 = new javax.swing.JScrollPane();
		I_Result = new javax.swing.JList<>();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		panel_jeux.setBackground(new java.awt.Color(224, 187, 0));
		panel_jeux.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createTitledBorder("Boggle By Sofiane GHERSA __ Naim CHOULLIT "), "",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Dialog", 3, 14))); // NOI18N

		jPanel_grille.setBackground(new java.awt.Color(252, 145, 14));

		I_in_time.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
		I_in_time.setText("80:20");

		A1.setBackground(new java.awt.Color(80, 84, 212));
		A1.setText("A");
		A1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_A1(evt);
			}
		});

		A3.setBackground(new java.awt.Color(80, 84, 212));
		A3.setText("A");
		A3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_A3(evt);
			}
		});

		A2.setBackground(new java.awt.Color(80, 84, 212));
		A2.setText("A");
		A2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_A2(evt);
			}
		});

		A4.setBackground(new java.awt.Color(80, 84, 212));
		A4.setText("A");
		A4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_A4(evt);
			}
		});

		B4.setBackground(new java.awt.Color(80, 84, 212));
		B4.setText("A");
		B4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_B4(evt);
			}
		});

		B3.setBackground(new java.awt.Color(80, 84, 212));
		B3.setText("A");
		B3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_B3(evt);
			}
		});

		B2.setBackground(new java.awt.Color(80, 84, 212));
		B2.setText("A");
		B2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_B2(evt);
			}
		});

		B1.setBackground(new java.awt.Color(80, 84, 212));
		B1.setText("A");
		B1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_B1(evt);
			}
		});

		C4.setBackground(new java.awt.Color(80, 84, 212));
		C4.setText("A");
		C4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_C4(evt);
			}
		});

		C3.setBackground(new java.awt.Color(80, 84, 212));
		C3.setText("A");
		C3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_C3(evt);
			}
		});

		C2.setBackground(new java.awt.Color(80, 84, 212));
		C2.setText("A");
		C2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_C2(evt);
			}
		});

		C1.setBackground(new java.awt.Color(80, 84, 212));
		C1.setText("A");
		C1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_C1(evt);
			}
		});

		D4.setBackground(new java.awt.Color(80, 84, 212));
		D4.setText("A");
		D4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_D4(evt);
			}
		});

		D3.setBackground(new java.awt.Color(80, 84, 212));
		D3.setText("A");
		D3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_D3(evt);
			}
		});

		D2.setBackground(new java.awt.Color(80, 84, 212));
		D2.setText("A");
		D2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_D2(evt);
			}
		});

		D1.setBackground(new java.awt.Color(80, 84, 212));
		D1.setText("A");
		D1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				click_case_D1(evt);
			}
		});

		I_out_mot.setEditable(false);

		I_check_mot.setBackground(new java.awt.Color(80, 84, 212));
		I_check_mot.setText("Check");
		I_check_mot.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				I_check_motf_check_mot(evt);
			}
		});

		I_reset_mot.setText("<");
		I_reset_mot.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				I_reset_motf_reset_mot(evt);
			}
		});

		jScrollPane1.setViewportView(I_mots);

		jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
		jLabel6.setText("Score ");

		I_in_score.setFont(new java.awt.Font("Ubuntu", 3, 24)); // NOI18N
		I_in_score.setText("00");

		I_out_message.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
		I_out_message.setForeground(new java.awt.Color(248, 32, 9));

		I_desin_trajectory.setText("Designer");
		I_desin_trajectory.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				I_desin_trajectoryf_designer(evt);
			}
		});

		javax.swing.GroupLayout jPanel_grilleLayout = new javax.swing.GroupLayout(jPanel_grille);
		jPanel_grille.setLayout(jPanel_grilleLayout);
		jPanel_grilleLayout.setHorizontalGroup(
				jPanel_grilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel_grilleLayout
										.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(
												I_out_message, javax.swing.GroupLayout.PREFERRED_SIZE, 538,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(59, 59, 59))
						.addGroup(jPanel_grilleLayout.createSequentialGroup().addGroup(jPanel_grilleLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel_grilleLayout.createSequentialGroup().addGap(74, 74, 74).addGroup(
										jPanel_grilleLayout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(
														jPanel_grilleLayout.createSequentialGroup().addComponent(B1,
																javax.swing.GroupLayout.PREFERRED_SIZE, 46,
																javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18,
																		18)
																.addComponent(B2,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 46,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18, 18).addComponent(B3,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 46,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18, 18).addComponent(B4,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 46,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel_grilleLayout.createSequentialGroup().addComponent(C1,
														javax.swing.GroupLayout.PREFERRED_SIZE, 46,
														javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
														.addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(C3, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18).addComponent(C4,
																javax.swing.GroupLayout.PREFERRED_SIZE, 46,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel_grilleLayout.createSequentialGroup().addComponent(D1,
														javax.swing.GroupLayout.PREFERRED_SIZE, 46,
														javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
														.addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18).addComponent(D4,
																javax.swing.GroupLayout.PREFERRED_SIZE, 46,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(I_out_mot)
												.addGroup(jPanel_grilleLayout.createSequentialGroup()
														.addGroup(jPanel_grilleLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(I_in_time)
																.addGroup(jPanel_grilleLayout.createSequentialGroup()
																		.addComponent(A1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				46,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18, 18, 18)
																		.addComponent(A2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				46,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18, 18, 18).addComponent(A3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				46,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGap(18, 18, 18).addComponent(A4,
																javax.swing.GroupLayout.PREFERRED_SIZE, 46,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(3, 3, 3)
										.addComponent(I_reset_mot, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												I_check_mot, javax.swing.GroupLayout.PREFERRED_SIZE, 91,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel_grilleLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(I_select_trajectory, 0,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jScrollPane1)
												.addGroup(jPanel_grilleLayout.createSequentialGroup()
														.addComponent(jLabel6)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(I_in_score,
																javax.swing.GroupLayout.PREFERRED_SIZE, 62,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(I_desin_trajectory))
								.addGroup(jPanel_grilleLayout.createSequentialGroup().addContainerGap().addComponent(
										username, javax.swing.GroupLayout.PREFERRED_SIZE, 141,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel_grilleLayout.setVerticalGroup(jPanel_grilleLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel_grilleLayout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel_grilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel_grilleLayout.createSequentialGroup().addComponent(username)
										.addGap(26, 26, 26).addComponent(I_in_time).addGap(18, 18, 18)
										.addGroup(jPanel_grilleLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(A3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(jPanel_grilleLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(jPanel_grilleLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(jPanel_grilleLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(D4, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(78, 78, 78)
										.addGroup(jPanel_grilleLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(jPanel_grilleLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(I_reset_mot, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(I_check_mot,
																javax.swing.GroupLayout.PREFERRED_SIZE, 40,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(I_out_mot)))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel_grilleLayout.createSequentialGroup()
												.addGroup(jPanel_grilleLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel6).addComponent(I_in_score,
																javax.swing.GroupLayout.PREFERRED_SIZE, 21,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(18, 18, 18).addComponent(jScrollPane1,
														javax.swing.GroupLayout.PREFERRED_SIZE, 346,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
						.addGroup(jPanel_grilleLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(I_desin_trajectory, javax.swing.GroupLayout.DEFAULT_SIZE, 39,
										Short.MAX_VALUE)
								.addComponent(I_select_trajectory))
						.addGap(47, 47, 47).addComponent(I_out_message, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		I_send_chat.setText("Send");
		I_send_chat.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				I_send_chatf_send_message(evt);
			}
		});

		jScrollPane2.setViewportView(I_chat);

		javax.swing.GroupLayout jPanel_chatLayout = new javax.swing.GroupLayout(jPanel_chat);
		jPanel_chat.setLayout(jPanel_chatLayout);
		jPanel_chatLayout.setHorizontalGroup(jPanel_chatLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel_chatLayout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane2)
								.addGroup(jPanel_chatLayout.createSequentialGroup()
										.addComponent(I_select_user, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(I_text_chat, javax.swing.GroupLayout.PREFERRED_SIZE, 242,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(I_send_chat).addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap()));
		jPanel_chatLayout.setVerticalGroup(jPanel_chatLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel_chatLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addGroup(jPanel_chatLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel_chatLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(I_select_user, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(I_text_chat, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(I_send_chat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addContainerGap()));

		I_Result.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane3.setViewportView(I_Result);

		I_mots.setModel(new javax.swing.AbstractListModel<String>() {
			Vector<String> strings = new Vector<>();

			public int getSize() {
				return strings.size();
			}

			public String getElementAt(int i) {
				return strings.get(i);
			}

			public void addElement(String s) {
				strings.addElement(s);
			}
		});
		jScrollPane1.setViewportView(I_mots);

		javax.swing.GroupLayout panel_jeuxLayout = new javax.swing.GroupLayout(panel_jeux);
		panel_jeux.setLayout(panel_jeuxLayout);
		panel_jeuxLayout.setHorizontalGroup(panel_jeuxLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panel_jeuxLayout.createSequentialGroup().addGap(9, 9, 9)
						.addComponent(jPanel_grille, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panel_jeuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel_chat, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane3))
						.addContainerGap()));

		panel_jeuxLayout.setVerticalGroup(panel_jeuxLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panel_jeuxLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(panel_jeuxLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(jPanel_grille, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(panel_jeuxLayout.createSequentialGroup()
								.addComponent(jPanel_chat, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jScrollPane3)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1327, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addContainerGap()
										.addComponent(panel_jeux, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap())));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 698, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addContainerGap()
										.addComponent(panel_jeux, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap())));

		pack();
	}

	private void click_case_A1(java.awt.event.MouseEvent evt) {
		if (!this.Traj_But.contains(A1)) {

			this.A1.setEnabled(false);

			this.Traj_But.add(A1);
			this.Traj_Mot += this.A1.getText();
			this.Traj_Traj += "A1";

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	private void click_case_A2(java.awt.event.MouseEvent evt) {
		if (!this.Traj_But.contains(A2)) {

			this.A2.setEnabled(false);

			this.Traj_But.add(A2);
			this.Traj_Mot += this.A2.getText();
			this.Traj_Traj += "A2";

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	private void click_case_A3(java.awt.event.MouseEvent evt) {
		if (!this.Traj_But.contains(A3)) {

			this.A3.setEnabled(false);

			this.Traj_But.add(A3);
			this.Traj_Mot += this.A3.getText();
			this.Traj_Traj += "A3";

			this.I_out_mot.setText(this.Traj_Mot);
		}

	}

	private void click_case_A4(java.awt.event.MouseEvent evt) {
		if (!this.Traj_But.contains(A4)) {

			this.A4.setEnabled(false);

			this.Traj_But.add(A4);
			this.Traj_Mot += this.A4.getText();
			this.Traj_Traj += "A4";

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	private void click_case_B4(java.awt.event.MouseEvent evt) {
		if (!this.Traj_But.contains(B4)) {

			this.B4.setEnabled(false);

			this.Traj_But.add(B4);
			this.Traj_Mot += this.B4.getText();
			this.Traj_Traj += "B4";

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	private void click_case_B3(java.awt.event.MouseEvent evt) {
		if (!this.Traj_But.contains(B3)) {

			this.B3.setEnabled(false);

			this.Traj_But.add(B3);
			this.Traj_Mot += this.B3.getText();
			this.Traj_Traj += "B3";

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	private void click_case_B2(java.awt.event.MouseEvent evt) {
		if (!this.Traj_But.contains(B2)) {

			this.B2.setEnabled(false);

			this.Traj_But.add(B2);
			this.Traj_Mot += this.B2.getText();
			this.Traj_Traj += "B2";

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	private void click_case_B1(java.awt.event.MouseEvent evt) {
		if (!this.Traj_But.contains(B1)) {

			this.B1.setEnabled(false);

			this.Traj_But.add(B1);
			this.Traj_Mot += this.B1.getText();
			this.Traj_Traj += "B1";

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	private void click_case_C1(java.awt.event.MouseEvent evt) {
		if (!this.Traj_But.contains(C1)) {

			this.C1.setEnabled(false);

			this.Traj_But.add(C1);
			this.Traj_Mot += this.C1.getText();
			this.Traj_Traj += "C1";

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	private void click_case_C2(java.awt.event.MouseEvent evt) {
		if (!this.Traj_But.contains(C2)) {

			this.C2.setEnabled(false);

			this.Traj_But.add(C2);
			this.Traj_Mot += this.C2.getText();
			this.Traj_Traj += "C2";

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	private void click_case_C3(java.awt.event.MouseEvent evt) {
		if (!this.Traj_But.contains(C3)) {

			this.C3.setEnabled(false);

			this.Traj_But.add(C3);
			this.Traj_Mot += this.C3.getText();
			this.Traj_Traj += "C3";

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	private void click_case_C4(java.awt.event.MouseEvent evt) {
		if (!this.Traj_But.contains(C4)) {

			this.C4.setEnabled(false);

			this.Traj_But.add(C4);
			this.Traj_Mot += this.C4.getText();
			this.Traj_Traj += "C4";

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	private void click_case_D1(java.awt.event.MouseEvent evt) {
		if (!this.Traj_But.contains(D1)) {

			this.D1.setEnabled(false);

			this.Traj_But.add(D1);
			this.Traj_Mot += this.D1.getText();
			this.Traj_Traj += "D1";

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	private void click_case_D2(java.awt.event.MouseEvent evt) {
		if (!this.Traj_But.contains(D2)) {

			this.D2.setEnabled(false);

			this.Traj_But.add(D2);
			this.Traj_Mot += this.D2.getText();
			this.Traj_Traj += "D2";

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	private void click_case_D3(java.awt.event.MouseEvent evt) {

		if (!this.Traj_But.contains(D3)) {

			this.D3.setEnabled(false);

			this.Traj_But.add(D3);
			this.Traj_Mot += this.D3.getText();
			this.Traj_Traj += "D3";

			this.I_out_mot.setText(this.Traj_Mot);
		}

	}

	private void click_case_D4(java.awt.event.MouseEvent evt) {

		if (!this.Traj_But.contains(D4)) {

			this.D4.setEnabled(false);

			this.Traj_But.add(D4);
			this.Traj_Mot += this.D4.getText();
			this.Traj_Traj += "D4";

			this.I_out_mot.setText(this.Traj_Mot);
		}

	}

	// Split
	public Vector<String> mysplit(String chan, char sep) {
		Vector<String> res = new Vector<>();
		String tmp = "";

		for (int i = 0; i < chan.length(); i++) {
			if (chan.charAt(i) == sep) {
				res.add(tmp);
				tmp = "";
			} else {
				tmp += chan.charAt(i);
			}
		}
		return res;
	}

	// nouvelle session
	public void NewSession() {
		MetreAZero();
		this.I_mots.setModel(new javax.swing.AbstractListModel<String>() {
			Vector<String> strings = new Vector<>();

			public int getSize() {
				return strings.size();
			}

			public String getElementAt(int i) {
				return strings.get(i);
			}
		});

	}

	// renisialiser les tab
	public void MetreAZero() {
		if (this.Traj_But.size() != 0) {

			int taille = this.Traj_But.size() - 1;
			for (int i = 0; i <= taille; i++) {
				this.Traj_But.get(i).setEnabled(true);
			}

			this.Traj_But.removeAllElements();

			this.Traj_Mot = "";
			this.Traj_Traj = "";

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	// recuperer la socket
	public Socket getSocket() {
		return this.socket;
	}

	// fermer la fenetre en cas de user existe
	public void closeF() {
		this.jScrollPane3.setVisible(false);
		this.jPanel_chat.setVisible(false);
		this.jPanel_grille.setVisible(false);
	}

	// mettre a jour la grille
	public void NewGrille(String g) {
		this.A1.setText("" + g.charAt(0));
		this.A2.setText("" + g.charAt(1));
		this.A3.setText("" + g.charAt(2));
		this.A4.setText("" + g.charAt(3));
		this.B1.setText("" + g.charAt(4));
		this.B2.setText("" + g.charAt(5));
		this.B3.setText("" + g.charAt(6));
		this.B4.setText("" + g.charAt(7));
		this.C1.setText("" + g.charAt(8));
		this.C2.setText("" + g.charAt(9));
		this.C3.setText("" + g.charAt(10));
		this.C4.setText("" + g.charAt(11));
		this.D1.setText("" + g.charAt(12));
		this.D2.setText("" + g.charAt(13));
		this.D3.setText("" + g.charAt(14));
		this.D4.setText("" + g.charAt(15));

		MetreAZero();
	}

	// mettre a jour les resultats
	public void NewResults(String par) {
		Vector<String> res = mysplit(par, '*');

		Vector<String> strings = new Vector<>();
		strings.add("Number of turns is " + res.get(0));
		strings.add("");
		strings.add("User | Score | Words");
		strings.add("");

		for (int i = 1; i < res.size(); i += 2) {
			strings.add(res.get(i) + " | " + res.get(i + 1));
			if (res.get(i).equals(this.username.getText())) {
				this.I_in_score.setText(res.get(i + 1));
			}
		}

		this.I_Result.setModel(new javax.swing.AbstractListModel<String>() {

			public int getSize() {
				return strings.size();
			}

			public String getElementAt(int i) {
				return strings.get(i);
			}
		});

		MetreAZero();
	}

	// mettre a jour les resultats
	public void NewResultsBil(String mots, String par) {
		Vector<String> res = mysplit(par, '*');
		String[] motsj = mots.split(";");

		Vector<String> strings = new Vector<>();
		strings.add("Number of turns is " + res.get(0));
		strings.add("");
		strings.add("User | Score | Words");
		strings.add("");

		for (int i = 1, j = 0; i < res.size(); i += 2, j++) {
			String[] tmp2 = motsj[j].split(":");
			String aff = "";
			if (tmp2.length == 2)
				aff = tmp2[1];

			strings.add(res.get(i) + " | " + res.get(i + 1) + " | " + aff);

			if (res.get(i).equals(this.username.getText())) {
				this.I_in_score.setText(res.get(i + 1));
			}
		}

		this.I_Result.setModel(new javax.swing.AbstractListModel<String>() {

			public int getSize() {
				return strings.size();
			}

			public String getElementAt(int i) {
				return strings.get(i);
			}
		});

		MetreAZero();
	}

	// validation de mot par le serveur
	public void ValidationMot(String m) {

		this.I_select_trajectory.setModel(new javax.swing.DefaultComboBoxModel<>(this.myMots));

		this.myMots.addElement(m);
		this.CordLane.put(m, (Vector<JButton>) Traj_But.clone());

		this.I_mots.setModel(new javax.swing.AbstractListModel<String>() {
			Vector<String> strings = myMots;

			public int getSize() {
				return strings.size();
			}

			public String getElementAt(int i) {
				return strings.get(i);
			}
		});

		MetreAZero();
	}

	// invalidation de mot par le serveur
	public void InValidationMot() {
		MetreAZero();
	}

	// Ajouter un message
	public void AddMessage(String user, String msg) {
		recevmessages.add(user + " : " + msg);
		this.I_chat.setModel(new javax.swing.AbstractListModel<String>() {
			Vector<String> strings = recevmessages;

			public int getSize() {
				return strings.size();
			}

			public String getElementAt(int i) {
				return strings.get(i);
			}
		});
	}

	// Envoi de mot
	private void I_check_motf_check_mot(java.awt.event.MouseEvent evt) {

		if (this.Traj_But.size() != 0) {

			this.canalEcriture.print("TROUVE/" + this.Traj_Mot + "/" + this.Traj_Traj + "/\n");
			this.canalEcriture.flush();

			int taille = this.Traj_But.size() - 1;
			for (int i = 0; i <= taille; i++) {

				this.Traj_But.get(i).setEnabled(true);
			}

			this.Traj_Mot = "";
			this.Traj_Traj = "";

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	// Supprimer une lettre
	private void I_reset_motf_reset_mot(java.awt.event.MouseEvent evt) {

		if (this.Traj_But.size() != 0) {
			int taille = this.Traj_But.size() - 1;
			this.Traj_But.get(taille).setEnabled(true);

			this.Traj_But.remove(taille);
			this.Traj_Mot = this.Traj_Mot.substring(0, this.Traj_Mot.length() - 1);
			this.Traj_Traj = this.Traj_Traj.substring(0, this.Traj_Traj.length() - 2);

			this.I_out_mot.setText(this.Traj_Mot);
		}
	}

	// Add user
	public void AddUser(String user) {
		this.usersCon.addElement(user);
		this.I_select_user.setModel(new javax.swing.DefaultComboBoxModel<>(this.usersCon));
	}

	// Remove user
	public void RemoveUser(String user) {
		this.usersCon.remove(user);
		this.I_select_user.setModel(new javax.swing.DefaultComboBoxModel<>(this.usersCon));
	}

	// Send message
	private void I_send_chatf_send_message(java.awt.event.MouseEvent evt) {

		String msg = this.I_text_chat.getText();
		String user = this.I_select_user.getSelectedItem().toString();
		if (user.equals("Every")) {
			this.canalEcriture.print("ENVOI/" + msg + "/\n");
			this.canalEcriture.flush();
		} else {
			this.canalEcriture.print("PENVOI/" + user + "/" + msg + "/\n");
			this.canalEcriture.flush();
		}

	}

	// ajout des users
	public void AddUSERS(String par) {
		Vector<String> us = mysplit(par, '*');
		for (String user1 : us) {
			AddUser(user1);
		}
	}

	// recuperer les coordonier des lettres
	public int[] getCordLane(javax.swing.JButton btn) {
		int[] res = new int[2];
		res[0] = 0;
		res[1] = 0;

		if (btn.equals(A1)) {
			res[0] = 150;
			res[1] = 200;
		}
		if (btn.equals(A2)) {
			res[0] = 200;
			res[1] = 200;
		}
		if (btn.equals(A3)) {
			res[0] = 250;
			res[1] = 200;
		}
		if (btn.equals(A4)) {
			res[0] = 300;
			res[1] = 200;
		}

		if (btn.equals(B1)) {
			res[0] = 150;
			res[1] = 250;
		}
		if (btn.equals(B2)) {
			res[0] = 200;
			res[1] = 250;
		}
		if (btn.equals(B3)) {
			res[0] = 250;
			res[1] = 250;
		}
		if (btn.equals(B4)) {
			res[0] = 300;
			res[1] = 250;
		}

		if (btn.equals(C1)) {
			res[0] = 150;
			res[1] = 300;
		}
		if (btn.equals(C2)) {
			res[0] = 200;
			res[1] = 300;
		}
		if (btn.equals(C3)) {
			res[0] = 250;
			res[1] = 300;
		}
		if (btn.equals(C4)) {
			res[0] = 300;
			res[1] = 300;
		}

		if (btn.equals(D1)) {
			res[0] = 150;
			res[1] = 350;
		}
		if (btn.equals(D2)) {
			res[0] = 200;
			res[1] = 350;
		}
		if (btn.equals(D3)) {
			res[0] = 250;
			res[1] = 350;
		}
		if (btn.equals(D4)) {
			res[0] = 300;
			res[1] = 350;
		}

		return res;

	}

	// disign de Tajectoire
	private void I_desin_trajectoryf_designer(java.awt.event.MouseEvent evt) {

		String mot = this.I_select_trajectory.getSelectedItem().toString();
		Vector<javax.swing.JButton> Tra = this.CordLane.get(mot);

		for (int i = 0; i < Tra.size() - 1; i++) {
			int[] tmp1 = getCordLane(Tra.get(i));
			int[] tmp2 = getCordLane(Tra.get(i + 1));

			this.getGraphics().drawLine(tmp1[0], tmp1[1], tmp2[0], tmp2[1]);
		}

	}

	private javax.swing.JButton A1;
	private javax.swing.JButton A2;
	private javax.swing.JButton A3;
	private javax.swing.JButton A4;
	private javax.swing.JButton B1;
	private javax.swing.JButton B2;
	private javax.swing.JButton B3;
	private javax.swing.JButton B4;
	private javax.swing.JButton C1;
	private javax.swing.JButton C2;
	private javax.swing.JButton C3;
	private javax.swing.JButton C4;
	private javax.swing.JButton D1;
	private javax.swing.JButton D2;
	private javax.swing.JButton D3;
	private javax.swing.JButton D4;
	private javax.swing.JList<String> I_chat;
	private javax.swing.JButton I_check_mot;
	private javax.swing.JButton I_desin_trajectory;
	private javax.swing.JLabel I_in_score;
	public static javax.swing.JLabel I_in_time;
	public javax.swing.JList<String> I_mots;
	public javax.swing.JLabel I_out_message;
	private javax.swing.JTextField I_out_mot;
	private javax.swing.JLabel I_reset_mot;
	private javax.swing.JComboBox<String> I_select_trajectory;
	private javax.swing.JComboBox<String> I_select_user;
	private javax.swing.JButton I_send_chat;
	private javax.swing.JTextField I_text_chat;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel_chat;
	private javax.swing.JPanel jPanel_grille;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JPanel panel_jeux;
	private javax.swing.JLabel username;
	public javax.swing.JScrollPane jScrollPane3;
	public javax.swing.JList<String> I_Result;

	private Socket socket = null;
	private DataInputStream canalLecture = null;
	public PrintStream canalEcriture = null;

	public Vector<javax.swing.JButton> Traj_But = new Vector<>();
	public String Traj_Traj = "";
	public String Traj_Mot = "";
	public Vector<String> myMots = new Vector<>();
	public int myScor = 0;

	public Thread GC;
	private Vector<String> recevmessages = new Vector<>();
	private Vector<String> usersCon = new Vector<>();

	private Map<String, Vector<javax.swing.JButton>> CordLane = new HashMap<>();

}
