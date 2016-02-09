package com.project;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AdminLogin {

	JFrame loginPage;
	JButton reset;
	JTextField userText;
	JPasswordField passwordText;
	String enteredName;
	String enteredPass;
	boolean valid = false;
	public AdminLogin()
	{
		JLabel title = new JLabel("Welcome to Students Assist");
		JLabel title1 = new JLabel("Admin Login");
		loginPage = new JFrame("Student's Assist Admin Login");
		JPanel panel = new JPanel();
		JLabel name = new JLabel("Name : ");
		JLabel password = new JLabel("Password : ");
		userText = new JTextField();
		passwordText = new JPasswordField();
		JButton okay = new JButton("LOGIN");
		reset = new JButton("RESET");
		JButton forgotPassword = new JButton("Forgot Password?");
		JButton home = new JButton("Home");
		
		panel.setBackground(Color.WHITE);
		title.setFont( new Font("Comic Sans MS", Font.BOLD, 54));
		title.setForeground(Color.BLUE);
		title1.setFont( new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30));
		title1.setForeground(Color.BLUE);
		name.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		password.setFont(new Font("Comic Sans MS",Font.ITALIC,20));
		okay.setFont(new Font("Comic Sans MS",Font.CENTER_BASELINE,15));
		reset.setFont(new Font("Comic Sans MS", Font.CENTER_BASELINE, 15));
		forgotPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		home.setFont(new Font("Comic Sans MS", Font.CENTER_BASELINE, 15));
			
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
						if(enteredName.equals("admin") && enteredPass.equals("admin123"))
						{
							valid = true;
						}
				
					if(valid){
						enteredName = null;
						enteredPass = null;
						loginPage.dispose();
						new AdminPage();
					}
					else
					{
						
						String message = "Incorrect Login ID or Password";
						JOptionPane.showMessageDialog(loginPage, message, "Dialog",
						JOptionPane.ERROR_MESSAGE);
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
		
		forgotPassword.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				enteredName = userText.getText();
				String result = "";
				if(enteredName.equals(""))
				{
					JOptionPane.showMessageDialog(loginPage, "Please enter the user name and then proceed!","Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				if(enteredName.equals("admin"))
				{
				result = JOptionPane.showInputDialog(loginPage,"What is your date of birth? (dd/mm/yyyy)");
				if(result.equals("19/05/1996"))
				{
					JOptionPane.showMessageDialog(loginPage, "Your password is admin123");
				}
				else
				{
					JOptionPane.showMessageDialog(loginPage, "Your date of birth is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
				}
				}
				else
				{
					JOptionPane.showMessageDialog(loginPage, "Please enter the user name correctly", "Error", JOptionPane.ERROR_MESSAGE);
				}
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
		okay.setBounds(500, 300, 90,20);
		reset.setBounds(670,300,90,20);
		forgotPassword.setBounds(425,350,490,30);
		home.setBounds(585,400,90,20);
		
		panel.add(title);
		panel.add(title1);
		panel.add(home);
		panel.add(name);
		panel.add(password);	
		panel.add(userText);
		panel.add(passwordText);
		panel.add(okay);
		panel.add(forgotPassword);
		panel.add(reset);
		
		loginPage.setSize(2070,768);
		loginPage.setVisible(true);
		loginPage.setLayout(null);
		
	}
}
