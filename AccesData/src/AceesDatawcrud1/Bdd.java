package AceesDatawcrud1;
import  java.lang.*;
 

import   java.sql.*;

import javax.swing.table.DefaultTableModel;

 class Bdd {   
	
	protected  String  url ; 
	protected String  login;
	protected String  password;
	
	 
	    
	    
	     
	    
	    private void retour(String str )
	    {
	    	System.out.println(str);
	    }
	    
	    
	    
	    public void Connexion( String url,String login ,String password)  throws Exception
	    {
	    	   try {
	    		   
	    		   Class.forName("com.mysql.jdbc.Driver");
	    		   System.out.println("Drive OK ");
	    	   }catch(  Exception e ){
	    		   
	    		    System.out.print("errueur de driver " + e.getMessage()); 
	    		  
	    	   }
	    	   
	    	   
	    	   try {
	    		   
	    		    
	    		   
	    		   this.conx =DriverManager.getConnection( url,login,password);
	    		   System.out.println("Connexion  OK ");
	    		   
	    	   }catch(SQLException ex)
	    	   {
	    		   System.out.println("probleme avec la connexion  "+ ex.getMessage());
	    	   }
	    	   
	    	   
	    }
	    // test ok 
	    public  ResultSet ReqSel1( )  throws Exception
	    {   
	    	
	    	ResultSet resultn = null;
	    	try {
	    		Statement stmt =  this.conx.createStatement();
	    		result = stmt.executeQuery(requete);
	
	    		 //On récupère les MetaData
	    	      ResultSetMetaData resultMeta = result.getMetaData();
	    	      System.out.println("\n**********************************");
	    	      //On affiche le nom des colonnes
	    	      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	    	        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
	    	         
	    	      System.out.println("\n**********************************");
	    	         
	    	      while(result.next()){         
	    	        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	    	          System.out.print("\t" + result.getObject(i).toString() + "\t |");
	    	            
	    	        System.out.println("\n---------------------------------");
                    
	    	      }
                  
	    	      	    	      
	    	       resultn =  result;
	    	       result.close();
	    	      stmt.close();
	    	     
	    	     return resultn;
	    		
	    	}catch(SQLException e) {
	    	   retour("errueur requete   : "+e.getMessage());
	    	   e.printStackTrace();
	    	   throw new Exception(e.getMessage());
	    	   
	    	}
	    }
	    
	    
	   public static void  main(String [] args)
	   {
		
		   
		   

			

				
		   
		  
	   }
	

}
