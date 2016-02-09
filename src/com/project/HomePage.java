package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePage {

	JFrame homePage = new JFrame("Students Assist Homepage");
	JButton stuLog = new JButton("Student Login");	
	JButton adminLog = new JButton("Admin Login");
	HomePage()
	{
			
		JPanel pan = new JPanel();
		JLabel note = new JLabel("NOTE: This application provides the information regarding the courses and inplant training/internships given by our alumni");
				
		JLabel title = new JLabel("Students Assist");
		JLabel imge = new JLabel(new ImageIcon("C:/Users/Karthik Baskaran/Pictures/Best Backgrounds/02.jpg"));
		
		title.setFont( new Font("Comic Sans MS", Font.BOLD, 54));
		title.setForeground(Color.BLUE);
		note.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		stuLog.setFont(new Font("Comic Sans MS",Font.CENTER_BASELINE,15));
		adminLog.setFont(new Font("Comic Sans MS",Font.CENTER_BASELINE,15));

		pan.setLayout(null);
		homePage.add(pan);
		pan.setBackground(Color.WHITE);
		
		imge.setBounds(0, 0, 100, 100);
		title.setBounds(450,20,900,50);
		stuLog.setBounds(400,300,150,40);
		adminLog.setBounds(800,300,150,40);
		note.setBounds(100,100,2000,900);

		pan.add(title);
		pan.add(stuLog);
		pan.add(adminLog);
		pan.add(note);
		
		homePage.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		homePage.setSize(2070,768);
		homePage.setVisible(true);
		homePage.setLayout(null);
		
		stuLog.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new LoginPage();
				homePage.dispose();
			}			
		});
		adminLog.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				new AdminLogin();
				homePage.dispose();
			}
		});
	}
	public static void main(String[] args) {
		new HomePage();
	}

}
