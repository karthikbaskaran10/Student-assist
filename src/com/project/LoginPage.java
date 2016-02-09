package com.project;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage{
	JFrame loginPage;
	JButton reset;
	
	JTextField userText;
	JPasswordField passwordText;
	String enteredName;
	String enteredPass;
	String result;
	boolean valid = false;
	public LoginPage()
	{
		JLabel title = new JLabel("Welcome to Students Assist");
		JLabel title1 = new JLabel("Students login");
		loginPage = new JFrame("Student's Assist Student Login");
		JPanel panel = new JPanel();
		JLabel name = new JLabel("Register Number: ");
		JLabel password = new JLabel("Password: ");
		userText = new JTextField();
		passwordText = new JPasswordField();
		JButton okay = new JButton("LOGIN");
		JButton signUp = new JButton("SIGN UP");
		JButton forgotPassword = new JButton("Forgot Password?");
		reset = new JButton("RESET");
		JButton home = new JButton("Home");
		
		panel.setBackground(Color.WHITE);
		title.setFont( new Font("Comic Sans MS", Font.BOLD, 54));
		title.setForeground(Color.BLUE);
		title1.setFont( new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30));
		title1.setForeground(Color.BLUE);
		name.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		password.setFont(new Font("Comic Sans MS",Font.ITALIC,20));
		okay.setFont(new Font("Comic Sans MS",Font.CENTER_BASELINE,15));
		signUp.setFont(new Font("Comic Sans MS",Font.CENTER_BASELINE,15));
		reset.setFont(new Font("Comic Sans MS", Font.CENTER_BASELINE, 15));
		home.setFont(new Font("Comic Sans MS", Font.CENTER_BASELINE, 15));
		forgotPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new HomePage();
				loginPage.dispose();	
			}
		});
		okay.addActionListener(new ActionListener(){
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				enteredName = userText.getText();
				enteredPass = passwordText.getText();
				if(!enteredName.equals("") && !enteredPass.equals(""))
				{
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "");
					Statement s=con.createStatement();
					ResultSet rs=s.executeQuery("select * from registration");
					while(rs.next())
					{
						if(enteredName.equals(rs.getString(2)) && enteredPass.equals(rs.getString(3)))
						{
							valid = true;
							break;
						}
					}
					if(valid){
						enteredName = null;
						enteredPass = null;
						loginPage.dispose();
						new StudentsPage();
					}
					else
					{
						
						String message = "Incorrect Login ID or Password";
						JOptionPane.showMessageDialog(loginPage, message, "Dialog",
						JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			    }
			
			else
			{
				String message = "Please enter the details first";
				JOptionPane.showMessageDialog(loginPage, message, "Dialog",
						JOptionPane.ERROR_MESSAGE);
			}
					
			}});	
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				userText.setText(null);
				passwordText.setText(null);		
			}			
		});	
		signUp.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				loginPage.dispose();
				new RegistrationPage();
				
			}
		});
		
		forgotPassword.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				enteredName = userText.getText();
				boolean val = false;
				if(!enteredName.equals(""))
				{
					if(true)
					{
						try{
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "");
							Statement s=con.createStatement();
							ResultSet rs=s.executeQuery("select * from registration");
							while(rs.next())
							{
								if(enteredName.equals(rs.getString(2)))
								{
									val = true;
									break;
								}
							}
							if(val){
								result = JOptionPane.showInputDialog(loginPage, "Enter your date of birth in correct format (dd/mm/yyyy) ");
								rs=s.executeQuery("select * from registration");
								while(rs.next()){
									if(result.equals(rs.getString(4)))
									{
										String mess = "Your Password is "+rs.getString(3);
										JOptionPane.showMessageDialog(loginPage, mess);
									}
								}
							}
							else
							{
								
								String message = "User is not registered";
								JOptionPane.showMessageDialog(loginPage, message, "Dialog",
								JOptionPane.ERROR_MESSAGE);
							}
						
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				}
				else
				{
					JOptionPane.showMessageDialog(loginPage, "Please enter the Registration Number and then proceed!","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			
			}
		});
		
		panel.setLayout(null);
		loginPage.add(panel);

		title.setBounds(270,15,900,90);
		title1.setBounds(570,100,750,90);
		name.setBounds(350,200,350,20);
		password.setBounds(350,250,350,20);
		userText.setBounds(550, 200, 350, 20);
		passwordText.setBounds(550, 250, 350, 20);
		okay.setBounds(400, 300, 90,20);
		reset.setBounds(570,300,90,20);
		signUp.setBounds(750,300,100,20);
		forgotPassword.setBounds(380,350,490,30);
		home.setBounds(570,400,100,20);
		
		panel.add(title);
		panel.add(title1);
		panel.add(home);
		panel.add(name);
		panel.add(password);	
		panel.add(userText);
		panel.add(passwordText);
		panel.add(okay);
		panel.add(reset);
		panel.add(signUp);
		panel.add(forgotPassword);
		
		loginPage.getRootPane().setDefaultButton(okay);
		loginPage.setSize(2070,768);
		loginPage.setVisible(true);
		loginPage.setLayout(null);
		
	}
	

}
