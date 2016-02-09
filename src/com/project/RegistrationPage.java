package com.project;

import javax.swing.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*;
import java.awt.event.*;

public class RegistrationPage 

{
	JFrame frame = new JFrame("Registration page");
	
	JPanel pan = new JPanel();
	JLabel title = new JLabel("Please register in our server");
	JLabel name = new JLabel("Name : ");
	JLabel DOB = new JLabel("Date of birth : ");
	JLabel registrationNo = new JLabel("Registration No. :");
	JLabel password = new JLabel("Password : ");
	JLabel confirmPass = new JLabel("Confirm Password : ");
	JLabel dobFormat = new JLabel("(dd/MM/yyyy)");
	
	JTextField nameField = new JTextField();
	JTextField DOBField = new JTextField();
	JTextField regField = new JTextField();
	
	JPasswordField passField = new JPasswordField();
	JPasswordField confirmPassField = new JPasswordField();
	
	JButton submit = new JButton("Submit");
	JButton reset = new JButton("Reset");
	JButton back= new JButton("Back");
	
	String userName;
	String confirmPassword;
	String pass;
	String rno;
	String dobname;
	
	
	RegistrationPage()
	{
		
		title.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		title.setForeground(Color.BLUE);
		name.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		DOB.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		registrationNo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		password.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		confirmPass.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		dobFormat.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		reset.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		submit.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		back.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		pan.setLayout(null);
		frame.add(pan);
		title.setBounds(350, 0, 700, 100);
		name.setBounds(100,110,250,20);
		DOB.setBounds(100,200,250,20);
		registrationNo.setBounds(100,300,250,20);
		password.setBounds(100,400,250,20);
		confirmPass.setBounds(100,500,250,20);
		nameField.setBounds(400, 110, 500, 20);
		DOBField.setBounds(400, 200, 500, 20);
		dobFormat.setBounds(910,200,250,20);
		regField.setBounds(400, 300, 500, 20);
		passField.setBounds(400, 400, 500, 20);
		confirmPassField.setBounds(400, 500, 500, 20);
		submit.setBounds(500,550,100,25);
		reset.setBounds(700,550,100,25);
		back.setBounds(600,600,100,25);
		
		pan.add(title);
		pan.add(name); 
		pan.add(nameField);
		pan.add(dobFormat);
		
		pan.add(DOB);
		pan.add(DOBField);
		
		pan.add(registrationNo);
		pan.add(regField);
		
		pan.add(password);
		pan.add(passField);
		
		pan.add(confirmPass);
		pan.add(confirmPassField);
		
		pan.add(submit);
		pan.add(reset);
		pan.add(back);
		
		
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				nameField.setText(null);
				DOBField.setText(null);
				regField.setText(null);
				passField.setText(null);
				confirmPassField.setText(null);
				
			}			
		});	
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				new LoginPage();
				frame.dispose();
			}
		});
		
		submit.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) 
			{
			
				boolean okay=validate();
				
				if(okay)
				{
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "");
						PreparedStatement ps=con.prepareStatement("insert into registration(name, rno, password, dob) values (?,?,?,?)");
						
						ps.setString(1,userName);
						ps.setString(2,rno);
						ps.setString(3,pass);
						ps.setString(4,dobname);
						ps.executeUpdate();
						}
					catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					
					frame.dispose();
					new LoginPage();
				 }
							
			}});
		
		pan.setBackground(Color.WHITE);
		frame.setSize(2070,768);
		frame.setVisible(true);
		frame.setLayout(null);
	}
	public static boolean isValid(String text) {
	    if (text == null || !text.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
	        return false;
	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    df.setLenient(false);
	    try {
	        df.parse(text);
	        return true;
	    } catch (ParseException ex) {
	        return false;
	    }
	
	}
	@SuppressWarnings("deprecation")
	public boolean validate()
	{
		  userName = nameField.getText();
		  dobname = DOBField.getText();
		  pass = passField.getText();
		  confirmPassword = confirmPassField.getText();
		  rno = regField.getText();	
		  boolean valid = true;
		  if(!userName.equals("") && !dobname.equals("") && !pass.equals("") && !confirmPassword.equals("") && !rno.equals(""))
		  {
          if (pass.length() > 15 || pass.length() < 4)
          {
                  JOptionPane.showMessageDialog(frame,"Password should be less than 15 and more than 8 characters in length.","Dialog",JOptionPane.ERROR_MESSAGE);
                  valid = false;
          }
          if (pass.indexOf(userName) > -1)
          {
                  JOptionPane.showMessageDialog(frame,"Password Should not be same as user name","Dialog",JOptionPane.ERROR_MESSAGE);
                  valid = false;
          }
          String lowerCaseChars = "(.*[a-z].*)";
          if (!pass.matches(lowerCaseChars ))
          {
                  JOptionPane.showMessageDialog(frame,"Password should contain atleast one lower case alphabet","Dialog",JOptionPane.ERROR_MESSAGE);
                  valid = false;
          }
          String regx = "^[A-Za-z]+$";
          Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
          Matcher matcher = pattern.matcher(userName);
        
          if(!matcher.find())
          
				{
        				JOptionPane.showMessageDialog(frame, "Enter the name correctly","Dialog",JOptionPane.ERROR_MESSAGE);
        				valid = false;
    			}
          else
          {
              if(valid)
              {
            	  valid = isValid(dobname);
            	  if(pass.equals(confirmPassword))
            	  {
            		  if(valid)
            		  {
            			  if (rno.matches("[0-9]+") && rno.length() == 12)
            			  {
            				  try{
          						Class.forName("com.mysql.jdbc.Driver");
          						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "");
          						Statement s=con.createStatement();
          						ResultSet rs=s.executeQuery("select * from registration");

          						while(rs.next())
          						{
          						if(rs.getString(2).equals(rno))
          						{
          							valid = false;
               
          						}
          						else
          						{
          							valid = true;
          						}
          						}
          						}
          					catch(Exception e1){}
          					if(!valid)
          					{
          						JOptionPane.showMessageDialog(frame, "The Register number is already registered!","ERROR",JOptionPane.ERROR_MESSAGE);
                    			valid = false;  
          					}
          					else
          					{
          						JOptionPane.showMessageDialog(frame, "You have been successfully registered");
                    			  
          					}
            				  
            			  }
            			  else
            			  {
            				  JOptionPane.showMessageDialog(frame, "Enter the Register number in correct format!","ERROR",JOptionPane.ERROR_MESSAGE);
                			  valid = false;
            			  }
            			  
            		  }
            		  else
            		  {

                		  JOptionPane.showMessageDialog(frame, "Enter the Date of Birth in correct format!","ERROR",JOptionPane.ERROR_MESSAGE);
            			  valid = false;
            		  }
            	  }
            	  else
            	  {
            		  JOptionPane.showMessageDialog(frame, "Password and confirm password are not same","ERROR",JOptionPane.ERROR_MESSAGE);
        			  valid = false;	  
            	  }
            	  
          }
		  }
		  }
		  else
		  {
			  JOptionPane.showMessageDialog(frame, "Enter the details first","Dialog",JOptionPane.ERROR_MESSAGE);
			  valid = false;
		  }
          return valid;
	}
}
