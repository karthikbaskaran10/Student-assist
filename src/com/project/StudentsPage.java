package com.project;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StudentsPage {

	JFrame frame = new JFrame("Students Page");
	
	JButton courses;
	JButton ipt;
	JButton post;
	JButton logout;
	
	public StudentsPage(){
		
		
		JPanel pan = new JPanel();
		JLabel title = new JLabel("Welcome Student");
		
		pan.setBackground(Color.WHITE);
		pan.setLayout(null);
		
		courses = new JButton("Courses");
		ipt = new JButton("IPT/Internships");
		logout = new JButton("Logout");
		post = new JButton("Post");
		
		title.setFont(new Font("Comic Sans MS", Font.PLAIN,50));
		title.setForeground(Color.BLUE);
		courses.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		ipt.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		post.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		logout.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		frame.add(pan);
		title.setBounds(450, 0, 1000, 50);
		courses.setBounds(200, 200, 200, 30);
		ipt.setBounds(800, 200, 200, 30);
		post.setBounds(500,500,200,30);
		logout.setBounds(0, 0, 100, 30);
		
		logout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new HomePage();
				frame.dispose();
			}
		});
		courses.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				new Courses();	
			}
		});
		
		ipt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new IPT();
			}
		});
		
		post.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				new Post();
			}
		});
		
		
		pan.add(title);
		pan.add(courses);
		pan.add(ipt);
		//pan.add(interview);
		pan.add(post);
		pan.add(logout);
	
		frame.setSize(2070,768);
		frame.setVisible(true);
		frame.setLayout(null);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
