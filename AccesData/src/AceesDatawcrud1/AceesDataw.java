package AceesDatawcrud1;

import java.awt.*;

import javax.sql.*;
import javax.swing.*;

import java.awt.TextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import  java.lang.*;
public class AceesDataw {

	private JFrame frame;
	private JTable table;
	
 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AceesDataw window = new AceesDataw();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AceesDataw() {
		initialize(); 
		
	    remplirtab();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 728, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(203, 23, 469, 386);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "prenom", "nom", "date de mort "
			}
		));
		scrollPane.setViewportView(table);
	}
	 
	
	public void  remplirtab()
	{
		

		   
		   
	    	
	    	
	    	
			

		   try {
			   
			   
			 
		         String  url = "jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";; 
			     String  login = "root";
			      String  password="root";
			      
				DefaultTableModel d1 = ( DefaultTableModel ) table.getModel();
				
				   Class.forName("com.mysql.jdbc.Driver");
				   System.out.println("Drive OK ");
		         String requete=  " SELECT * FROM actor ; ";
				   Connection con  = DriverManager.getConnection(url,login,password);
					Statement stmt =  con.createStatement();
					ResultSet result   = stmt.executeQuery(requete);
				
			   while(result.next())
			   {
				   
				   String id = result.getString(1);
				   String nom = result .getString(2);
				   String prenom = result .getString(3);
				   String date = result.getString(4);
					
				    Object[] rowData = {id ,nom ,prenom ,date}; 
				  	d1.addRow(rowData);
				  	System.out.println(rowData);
				  	
				   
			   }
		         
			
		   }catch(Exception e)
		   {   System.out.println("test " + e.getMessage());
			   e.getStackTrace();
		   }
		
		   
	}
	 
  
	
 
	
}
