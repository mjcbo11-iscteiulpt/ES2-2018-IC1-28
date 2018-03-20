package org.iscte_iul.es2.ES2_2018_IC1_99;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.util.Properties;





public class GraphicalInterface {
	
	protected JFrame frame ;
	protected JPanel LeftPanel ;
	protected JPanel RightPanel ;
	protected JPanel TimeAndVariablesPanel;	
	protected JPanel XMLPanel;	
	
	protected JLabel ProblemTitleLabel ;
	protected JTextField ProblemTitle ;
	
	protected JLabel ProblemDescriptionLabel ;
	protected JTextField ProblemDescription ;	
	
	protected JLabel UserEmailLabel;
	protected JTextField UserEmail ;
	protected JLabel UserPassLabel;
	protected JTextField UserPass ;
	
	protected JButton SendEmail ;
	
	
	

	

	
	//Mail criado para fins de teste
	protected String adminMail="usertestees@gmail.com";
	protected String adminPassword="passwordteste";
	protected String userMail="usertestees2@gmail.com";
	protected String userPassword="passwordteste";
	
	

	
	public GraphicalInterface() {
		CreateInterface();
		OpenListeners();
		
	}



	private void CreateInterface() {
		CreateFrame();
		CreatePanels();
		CreateTextFields();
		CreateButtons();
		CreateLabels();
		addStuff();
		setVisible();
	}

	private void CreateFrame() {
		frame = new JFrame("ProblemSolverAndDecisionHelper");		
	}
	
	private void CreatePanels() {
		LeftPanel =new JPanel() ;
		RightPanel =new JPanel() ;
		TimeAndVariablesPanel=new JPanel() ;	
		XMLPanel=new JPanel() ;					
		CreateLayouts();		
	}
	private void CreateLayouts() {
		frame.setLayout(new BorderLayout());
		LeftPanel.setLayout(new GridLayout(15,1));
		//RightPanel.setLayout();
		TimeAndVariablesPanel.setLayout(new GridLayout(2,2));
		XMLPanel.setLayout(new FlowLayout());			
	}


	private void CreateTextFields() {
		ProblemTitle = new JTextField();
		ProblemDescription = new JTextField();
		UserEmail = new JTextField();
		UserPass=new JTextField();
	
	}
	private void CreateButtons() {
		SendEmail = new JButton("Send Email");		
		
	}

	private void CreateLabels() {
		ProblemTitleLabel = new JLabel("Problem Title", SwingConstants.CENTER);
		ProblemDescriptionLabel = new JLabel("Problem Description", SwingConstants.CENTER);
		UserEmailLabel = new JLabel("User Email", SwingConstants.CENTER);
		UserPassLabel = new JLabel("User Password", SwingConstants.CENTER);
		

	}

	
	private void addStuff() {
		LeftPanel.add(ProblemTitleLabel);
		LeftPanel.add(ProblemTitle);
		
		LeftPanel.add(ProblemDescriptionLabel);
		LeftPanel.add(ProblemDescription);
		
		LeftPanel.add(UserEmailLabel);
		LeftPanel.add(UserEmail);
		LeftPanel.add(UserPassLabel);
		LeftPanel.add(UserPass);
		
		LeftPanel.add(SendEmail);
		
		
		LeftPanel.add(TimeAndVariablesPanel);
		
		
		LeftPanel.add(XMLPanel);
		
		frame.add(LeftPanel);
	}
	private void setVisible() {
		frame.setSize(800,1400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setVisible(true);
		
	}
	
	public void SendEmailListener() {
		SendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(UserEmail.toString().trim().length() <=4 ||!UserEmail.getText().contains("@")||UserEmail.getText().equals("usertestees@gmail.com")) {
					JOptionPane.showMessageDialog(frame, "Email inválido");
				}else {
					Properties props = new Properties();
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");

					Session session = Session.getInstance(props,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(UserEmail.getText(), UserPass.getText());
						}
					  });

					try {

						Message message = new MimeMessage(session);
						message.setFrom(new InternetAddress(UserEmail.getText()));
						message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(adminMail));
						message.setSubject("Testing Subject");
						message.setText("Dear Mail Crawler,"
							+ "\n\n No spam to my email, please!");

						Transport.send(message);

						System.out.println("Done");

					} catch (MessagingException e1) {
						throw new RuntimeException(e1);
					}
					  

				   }
				}
				
			
		});	
	}
		private void OpenListeners() {
			SendEmailListener();
		}
	
}
