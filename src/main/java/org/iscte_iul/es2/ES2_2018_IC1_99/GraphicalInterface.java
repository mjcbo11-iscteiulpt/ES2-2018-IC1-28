package org.iscte_iul.es2.ES2_2018_IC1_99;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;


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
	

	
	

	
	public GraphicalInterface() {
		CreateInterface();
		
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
		
	
	}
	private void CreateButtons() {
		
	}

	private void CreateLabels() {
		

	}

	
	private void addStuff() {
		
		
		LeftPanel.add(TimeAndVariablesPanel);
		
		
		LeftPanel.add(XMLPanel);
		
		frame.add(LeftPanel);
	}
	private void setVisible() {
		frame.setSize(800,1400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setVisible(true);
		
	}
	
	
		
	
}
