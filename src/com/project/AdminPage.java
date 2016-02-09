package com.project;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AdminPage {

	JFrame frame = new JFrame("Admin Page");
	JButton update = new JButton("Update");
	JButton view = new JButton("View");
	JButton logout = new JButton("Logout");
	JLabel title = new JLabel("Welcome Admin");
	AdminPage()
	{
		JPanel pan = new JPanel();
		pan.setLayout(null);
		
		title.setFont(new Font("Comic Sans MS", Font.PLAIN,50));
		title.setForeground(Color.BLUE);
		update.setFont(new Font("Comic Sans MS", Font.CENTER_BASELINE,20));
		view.setFont(new Font("Comic Sans MS", Font.CENTER_BASELINE,20));
		logout.setFont(new Font("Comic Sans MS", Font.CENTER_BASELINE,20));
		
		title.setBounds(420, 0, 500, 90);
		view.setBounds(300, 300, 150, 25);
		update.setBounds(800, 300, 150, 25);
		logout.setBounds(0, 0, 200, 50);
		
		pan.add(logout);
		pan.add(title);
		pan.add(update);
		pan.add(view);
		frame.add(pan);
		
		update.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				new AdminPost();
			}
		});
		
		view.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new AdminView();
				
			}
		});
		
		logout.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				new HomePage();
				frame.dispose();
			}
		});
		
		pan.setBackground(Color.WHITE);
		frame.setSize(2070,768);
		frame.setVisible(true);
		frame.setLayout(null);
		
		
	}
	

}
