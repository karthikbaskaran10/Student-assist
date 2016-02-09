package com.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;

public class Post{
	JFrame frame = new JFrame("Post Information");
	JPanel pan = new JPanel();
	JLabel c = new JLabel("Course : ");
	JLabel cp = new JLabel("Institute : ");
	JLabel cf = new JLabel("Course Fee : ");
	JLabel com = new JLabel("Comments : ");
	JLabel field = new JLabel("Field : ");
	
	JTextField courseField = new JTextField();
	JTextField coursePlaceField = new JTextField();
	JTextField courseFeeField = new JTextField();
	JTextField commentsField = new JTextField();
	
	JButton submit = new JButton("Submit");
	JButton reset = new JButton("Reset");
	
	JRadioButton option1 = new JRadioButton("Courses");
    JRadioButton option2 = new JRadioButton("IPT/Internships");
    JRadioButton selected;
    
       
	String course;
	String coursePlace;
	String courseFee;
	String comments;
	String dept;
	
	ButtonGroup group = new ButtonGroup();
	
		//@SuppressWarnings("deprecation")
		Post(){
		
		submit.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		reset.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		option1.setActionCommand("Courses");
		option1.setSelected(true);
		option2.setActionCommand("IPT");
		
		group.add(option1);
	    group.add(option2);
	    
		pan.setBackground(Color.WHITE);
	    pan.setLayout(null);
		frame.add(pan);
		
		c.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		cp.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		cf.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		com.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		field.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
		option1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		option2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		option1.setBackground(Color.WHITE);
		option2.setBackground(Color.WHITE);
		
		c.setBounds(100,100,250,20);
		cp.setBounds(100,200,250,20);
		cf.setBounds(100,300,250,20);
		com.setBounds(100,400,250,20);
		field.setBounds(100,500,250,20);
		
		courseField.setBounds(400, 100, 500, 20);
		coursePlaceField.setBounds(400, 200, 500, 20);
		courseFeeField.setBounds(400, 300, 500, 20);
		commentsField.setBounds(400, 400, 500, 20);
	
		option1.setBounds(400, 500, 100, 20);
		option2.setBounds(550, 500, 250, 20);
	
		submit.setBounds(350,580,100,20);
		reset.setBounds(600,580,100,20);
		
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				courseField.setText(null);
				coursePlaceField.setText(null);
				courseFeeField.setText(null);
				commentsField.setText(null);
			}			
		});
		
		submit.addActionListener(new ActionListener()  {
			
			public void actionPerformed(ActionEvent arg0){
			
				String driver="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/mydb";
				String username="root";
				String pwd="";
				
				try
				{
					course = courseField.getText();
					coursePlace = coursePlaceField.getText();
					courseFee = courseFeeField.getText();
					comments = commentsField.getText();
					dept = group.getSelection().getActionCommand();
				Class.forName(driver);
				Connection con=DriverManager.getConnection(url,username,pwd);
				if(course.equals("") || coursePlace.equals("") || courseFee.equals("") || comments.equals(""))
				{
					JOptionPane.showMessageDialog(frame, "Enter the details first","Error",JOptionPane.ERROR_MESSAGE);
					
				}
				else
				{
					PreparedStatement ps=con.prepareStatement("insert into post (course, place, fee, remarks, department) values (?,?,?,?,?)");
					ps.setString(1, course );
					ps.setString(2, coursePlace);
					ps.setString(3, courseFee);
					ps.setString(4, comments);
					ps.setString(5, dept);
					
					ps.executeUpdate();
					JOptionPane.showMessageDialog(frame,"The post is successful. Thank you for the information.");
					frame.dispose();
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		
		
		pan.add(c);
		pan.add(cp);
		pan.add(cf);
		pan.add(com);
		pan.add(field);
		
		pan.add(courseField);
		pan.add(coursePlaceField);
		pan.add(courseFeeField);
		pan.add(commentsField);
		
		pan.add(option1);
		pan.add(option2);

		pan.add(submit);
		pan.add(reset);
	
		frame.setSize(2070,768);
		frame.setVisible(true);
		frame.setLayout(null);
		
	}
}
