package Client_and_Server_Package;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.SQLException;

import javax.swing.*;
	
	//this is a general parent class for all Clients
	//each client will be using the methods and connection details in order to  do a request and retrieve server response
	
public class AllClient extends JFrame {

		   public static ObjectOutputStream output; 
		   public static ObjectInputStream input; 
		   
		   public static String message = ""; 
		   public String client1; 
		   public static Socket client; 
		   public static Server sObj = new Server();

	
		public AllClient(){
			super("CLient");
			
			try{
				InetAddress ownIP=InetAddress.getLocalHost();
				
				client1 = ownIP.getHostAddress();
				}catch (Exception e){
					System.out.println("Exception caught = "+e.getMessage());
				}
			
		   }
		
		   public void runClient() //it execute while running client test-need to have in constructor
		   {
		      try 
		      {
		         connectToServer(); 
		         getStreams(); 
		         processConnection(); 
		      } 
		      catch ( EOFException eofException ) 
		      {
		         System.out.println( "\nClient terminated connection" );
		      } 
		      catch ( IOException ioException ) 
		      {
		         ioException.printStackTrace();
		      } 
		      finally 
		      {
		       
		      } 
		   } 

		   
		   public void connectToServer() throws IOException
		   {      
		      System.out.println( "Attempting connection\n" );

		      
		      client = new Socket( InetAddress.getByName( client1 ), 12346 );

		      
		      System.out.println( "Connected to: " + 
		         client.getInetAddress().getHostName() );
		   } 

		   
		   public void getStreams() throws IOException
		   {
		      
		      output = new ObjectOutputStream( client.getOutputStream() );      
		      output.flush(); 

		      
		      input = new ObjectInputStream( client.getInputStream() );

		      System.out.println( "\nGot I/O streams\n" );
		   } 

		   
		   public static String processConnection() throws IOException
		   {
		    
		      do 
		      { 
		         try 
		         {
		            message = ( String ) input.readObject(); 
		            System.out.println( "\n" + message+"Client" );
		            return message;
		         } 
		         catch ( ClassNotFoundException classNotFoundException ) 
		         {
		            System.out.println( "\nUnknown object type received" );
		         } 

		      } while ( !message.equals( "SERVER>>> TERMINATE" ) );
			return message;
		   } 

		   
		   public static void closeConnection() 
		   {
		      System.out.println( "\nClosing connection" );
		      

		      try 
		      {
		         // close streams first, then socket
		         output.close(); 
		         input.close(); 
		         client.close(); 
		      } 
		      catch ( IOException ioException ) 
		      {
		         ioException.printStackTrace();
		      } 
		   } 

		  
		   public static void sendData( String message )
		   {
		      try 
		      {
		         output.writeObject( message );
		         output.flush(); 
		       
		      } 
		      catch ( IOException ioException )
		      {
		    	  System.out.println("Something went wrong with output steam");
		      } 
		   } 

		   /*
		    * Update method for all tables
		    */
		   public void sendUpdateData(String table, String [] [] data)
		   {
			  sObj.updateTable(table,data);
		   }
		   
		   
		   /**
		    * 
		    * Start of Admin get Methods
		    * 
		    */
		   public String [] [] getAStaff() throws SQLException
		   {
			   return sObj.getAStaff();			   
		   }
		   
		   public String [] [] getAStudent() throws SQLException
		   {
			   return sObj.getAStudent();			   
		   }
		   /**
		    * 
		    * End of Admin get Methods
		    * 
		    */
		   
		   /**
		    * 
		    * Staff get Methods
		    * 
		    */
		   public String [] [] getStaffGrades() throws SQLException
		   {
			   return sObj.getStaffGrades();			   
		   }
		   
		   public String [] [] getStaffStudent() throws SQLException
		   {
			   return sObj.getStaffStudent();			   
		   }
		   /**
		    * 
		    * End of Staff get Methods
		    * 
		    */
		   
		   /**
		    * 
		    * Student get Methods
		    * 
		    */
		   public String [] [] getStudentGrades(String name) throws SQLException
		   {
			   return sObj.getStudentGrades(name);			   
		   }
		   
		   public String [] [] getStudentCourse() throws SQLException
		   {	
			   return sObj.getStudentCourse();			   
		   }
		   /**
		    * 
		    * End of Student get Methods
		    * 
		    */
		   
}
	
