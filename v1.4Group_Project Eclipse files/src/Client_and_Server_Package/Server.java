/** Alexander Drabek
 * 
 * *-Verification of client+SSL communication-maybe IPSEC
 * Creating nested sql statements, use of relations!-I can obtain name of the unit querying only table with unit
 * APPLY more sophisticated things to query like : LIMIT, limit char-set also!
 *  * WE CAN : determine the table name in variable TO: view table (or other  universal queries) which differs only with table name
 * 
 * 
 * 
 * ,retrieve message from client- done
 * create communication with database-done
 * and SQL statements-In progress
 * server can send a message to client!-done
 * control SQL statement through giving server fields and data! -In progress
 * 
 * 
 * TO DO:
 *     -develop solution to store results from database
 * 
 * each action communicate with Database and sends response to the  client
 * 
*To Think:
 *-in which type(object/String) the message will be passed to client/ how client will extract it!
*In future :

*-some prevention for reversing engineering
*-More things will be displayed on console
*
*/

package Client_and_Server_Package;

import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Server{ 

   private ObjectOutputStream output; 
   private ObjectInputStream input; 

   private ServerSocket server; // our server socket
   private Socket connection;  // our client socket
   private int counter = 0; 
   
   static final String DRIVER = "com.mysql.jdbc.Driver"; // JDBC driver
     
  	private Connection con;
  	private ResultSet   rs;
  	private Statement stmt;
  	private ResultSetMetaData rsmd;
   
     /*
      * DEFAULT 'local' Database and Host
      */
    String DATABASE = "test";
    String HOST = "127.0.0.1";
    String USERNAME = "";
    String PASSWORD = "";
     
    String DATABASE_URL = "jdbc:mysql://" + HOST + "/" + DATABASE;
    String sent="";
    
    
    
   public Server(){
	   
      counter++;
   } 
    
   public static void main(String [] args){
	   Server ser = new Server();
	   ser.runServer();
   }
   
   public void runServer()
   {
      try 
      {
          // a new server on port 12346
         server = new ServerSocket( 12346 ); 

         while ( true ) 
         {
            try 
            {
               waitForConnection(); 
               getStreams(); 
               processConnection(); 
            } 
            catch ( EOFException eofException ) 
            	{
            	System.out.println( "\nServer terminated connection" );
            	} 
            finally 
              {
               closeConnection(); 
               counter++;
              } 
         } 
      }
      catch ( IOException ioException ) 
      			{
         ioException.printStackTrace();
      			} 
   } 

   private void waitForConnection() throws IOException
   {
	   System.out.println( "Waiting for connection12\n" );
      connection = server.accept();             
      System.out.println( "Connection " + counter + " received from: " +
         connection.getInetAddress().getHostName() );
   } 

   private void getStreams() throws IOException
   {
      output = new ObjectOutputStream( connection.getOutputStream() );
      output.flush(); 
      input = new ObjectInputStream( connection.getInputStream() );
      System.out.println( "\nGot I/O streams\n" );
   } 

   private void processConnection() throws IOException
   {
	   String message = "Connection successful123";
	      sendData( message ); 
	      do 
	      { 
	         try 
	         {
	        	 
	        	 
	      
	            message = ( String ) input.readObject(); //Update,Name,Alex he is a student,he want to update smth, he want to update NAME field, he gave name
	            
	         
	             
	                      
	            //[ ] ,[1],[message] 
	            //reason : fits to the number of field in My_SQL + in any case!
	             //  splitsMessage[0] it doesn't mean anything
	              // splitsMessage[1] it means (number of switch option ) 1 or 2.....
	             //splitsMessage[2] it means actual data !
	          //example : "" ,1,data,data
	           //switch// if 1-5it means admin -legend :TO UPDATE!!!!!
	                     //if 6-9 //it means users 
	                     //if 9-12 // it means staff  
	                    
	         
	         String[] splitsMessage = message.split(",");    //delimiter is a comma 
	         System.out.println("I receive the data!!"+splitsMessage[0]);
	         int messageInt=Integer.parseInt(splitsMessage[1]);
	         Connection con = null;
	        
	            try{
	            Class.forName(DRIVER);//db url,username,password
	            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	               }
	         catch (Exception e){
	            e.printStackTrace();
	        }
	        // [meaningful!],1,data,data
	            switch (messageInt) {
	            case 1:  
	            	PreparedStatement pst;
	            	ResultSet   result;
	            	String user,pass;
	            	Statement st;
	            	
	             //LOGIN!!!!
	                        try{
	                        	  st = con.createStatement();
	                //student

	                       //    ResultSet result =st.executeQuery(sql);//
	                       	pst = con.prepareStatement("SELECT StudentID , Password FROM students WHERE StudentID=? AND Password=?");
	                    	pst.setString(1, splitsMessage[2]); pst.setString(2,splitsMessage[3]);
	                    	result=pst.executeQuery();
	                           if (result == null || !result.first()) {}
	                           else {
	                        		 user=result.getString("StudentID");
	                                 pass=result.getString("Password");
	                                 System.out.println("hurray");
	                              	   sendData("Student");//status
	                              	   break;
	                              	   }
	               //staff      
	                              
	                            result=null;
	                        	pst = con.prepareStatement("SELECT StaffID , Password FROM staff WHERE Status=? AND StaffID=? AND Password=?");
	                        	pst.setString(1,"Staff");pst.setString(2, splitsMessage[2]); pst.setString(3,splitsMessage[3]);
	                        	result=pst.executeQuery();
	                         if ( !result.first()||result == null) {System.out.println("sad face staff");}       
	                         else{
	                                 user=result.getString("StaffID");
	                                 pass=result.getString("Password"); 
	                                 sendData("Staff");//status 
	                                 break;
	                              }
	                         	result=null;
	                         	pst = con.prepareStatement("SELECT StaffID, Password  FROM staff WHERE Status=? AND StaffID=? AND Password=?");
	                        	pst.setString(1,"Admin");pst.setString(2, splitsMessage[2]); pst.setString(3,splitsMessage[3]);
	                        	result=pst.executeQuery(); 
	                 //Admin                                   	        	 
	                           if (!result.first() ||result == null )
	                           { System.out.println("sad face admin"); } 
	                           else{
	                               user=result.getString("StaffID");
	                               pass=result.getString("Password"); 
	                               sendData("Admin");//status
	                               break;
	                           		}
	                       }//try block
	                        catch ( Exception e){
	                        	//SQLException s -exception
	                        	System.out.println("SQL statement is not executed!/Or no data from them");
	                        	sendData("Wrong");//status
	                            e.printStackTrace();
	                            }
	                                 break;
	              case 2: 
	   //registration in main
	                	   //splitsMessage[0]- SPECIAL MEANING = which type of person(student/admin/staff)
	                	   //[1]-case//[2-13] reserved by table student //or [2-14] by staff
	                	   //[11]+[15-16] reserved by the Bank table-staff
	                	   //+++pass empty field for 14th ins student!  
	                //sending to client b4 creating
	                	       // 1. available courses-students
	                	      //2.correspondent units-all
	                	    // + pass Units to client
	                   	//SELECT `Unit_ID`, `UnitName` FROM `units` WHERE .....identify which is corresponding to course 	
	                        try{
	                        	  st = con.createStatement();
	          //student on load              	  
	                        	  if (splitsMessage[0].equals("StudentListCourses-on-load"))
	                        	  		{
	                        		  //list of course
	                        		  message="ListCourse,";
	                        		  		result =st.executeQuery("SELECT `Course_Name` FROM `courses` ");//
	                                   		 while(result.next()==true)
	                                		 	{
	                                			 message=message+result.getString("Course_Name") +",";
	                          		         	
	                                		 	}
	                                   		//System.out.println(message+"\n"); 
	                                   		String removedCommaMessage = message.substring(0, message.length() - 1);
	                                   		System.out.println(removedCommaMessage);
	                                   	    sendData(removedCommaMessage);
	                                      break;//finish the case
	                        	  		}
	           //staff on load             	  
	                        	  else if (splitsMessage[0].equals("StaffList"))//all units list
	                        	  		{	
	                        		  message="";
	                        		  				//it display the second result ?!		
	                        		  		result =st.executeQuery("SELECT `Unit_ID`, `UnitName` FROM `units`");// 
	                        		  		result.first();
	                        		  		message=result.getString("Unit_ID")+",";
	                            		    	while(result.next()==true )
	                            		  	     {
	                            		  		
	                            		  					message=message+result.getString("Unit_ID")+","; //it is creating to many elements because of comma.
	                            		  				//	System.out.println(message);           			  		
	                        			  	     }
	                            		    	String removedCommaMessage = message.substring(0, message.length() - 1);
	                            		sendData(removedCommaMessage);// WHOLE MEESSAGE-unit list!		delimiter comma		
	                    			  System.out.println("I have printed+send all the units(?)"); 
	                    			      break;
	                        	  		}
	                  // String sent;
	                        	  //corresponding units - after changing status of the list ?
	                        	  else if (splitsMessage[0].equals("CorrespondUnitsList"))
	                        	  		{  
	                        		  ///there is no link between XD
	                               			pst = con.prepareStatement(" SELECT UnitID_1 , UnitID_2 , UnitID_3 , UnitID_4  FROM courses WHERE COURSE_Name=?");
	                               			//System.out.println(splitsMessage[2]+"got this");
	                               			pst.setString(1,splitsMessage[2]);
	                               			result=pst.executeQuery();
	                               			result.first();
	                                		message=result.getString("UnitID_1")+","+result.getString("UnitID_2")+","+result.getString("UnitID_3")+","+result.getString("UnitID_4");//+","+result.getString("UnitName")
	                               			System.out.println(message+"this is it!");
	                                  		sendData(message);	
	                            	        // WHOLE MEESSAGE-unit list!		delimiter comma
	                            	     break;
	                        	  		}
	  //should be correct/                           
	                        		 
	                        	  
	   //        	  ######################WORKING################################################
	              	//System.out.println("Hello, you reached me before executing the StudentRegister");	  
	                        	  else if (splitsMessage[0].equals("StudentRegister")){
	                                        
	                                               		  st = con.createStatement();
	                                                         //student
	                                               		  		System.out.println("Hello, you reached me just next the to statements used to execute the StudentRegister");
	                                                                //   ResultSet result =st.executeQuery(sql);//
	                                                               pst = con.prepareStatement("INSERT INTO students (First_Name , Surname , Date_of_Birth , Gender , Address , Postcode , CourseID , Telephone_Number, E_mail, Bank_Account_Number , Year_of_Study , Password) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
	                                                               pst.setString(1,splitsMessage[2]); 
	                                                             	pst.setString(2,splitsMessage[3]);
	                                                             	pst.setString(3,splitsMessage[4]); 
	                                                             	pst.setString(4,splitsMessage[5]); 
	                                                             	pst.setString(5,splitsMessage[6]); 
	                                                             	pst.setString(6,splitsMessage[7]); 
	                                                             	pst.setString(7,splitsMessage[8]); 
	                                                             	pst.setString(8,splitsMessage[9]); 
	                                                             	pst.setString(9,splitsMessage[10]); 
	                                                             	pst.setString(10,splitsMessage[11]); 
	                                                             	pst.setString(11,splitsMessage[12]);
	                                                             	pst.setString(12,splitsMessage[13]);
	                                                             	
	                                                             	pst.executeUpdate();
	                                                                    
	                                                             	System.out.println("Hello, you reached me after executing the StudentRegister");
	                                                               sendData("Students_Done");//status
	                                                                                   	   
	                                               	}
	                                               	else if (splitsMessage[0].equals("StaffRegister")){
	                                                       
	                                                       // int val = st.executeUpdate("INSERT INTO `Students`( `First_Name`, `Surname`, `Date_of_Birth`, `Gender`, `Address`, `Postcode`, `CourseID`, `Telephone_Number`, `E-mail`, `Bank_Account_Number`, `Year_of_Study`, `Password`) VALUES ('"+splitsMessage[2]+"','"+splitsMessage[3]+"','"+splitsMessage[4]+"','"+splitsMessage[5]+"','"+splitsMessage[6]+"','"+splitsMessage[7]+"',"+splitsMessage[8]+",'"+splitsMessage[9]+"','"+splitsMessage[10]+"',"+splitsMessage[11]+","+splitsMessage[12]+",'"+splitsMessage[13]+"');"); 
	                                                      // String  bank= result.getString("StaffID");
	                                                    		  st = con.createStatement();
	                                                              //student
	                                                    		  		System.out.println("Hello, you reached me just next the to statements used to execute the StaffRegister");
	                                                                     //   ResultSet result =st.executeQuery(sql);//
	                                                                   pst = con.prepareStatement("INSERT INTO staff (Title , First_Name ,Surname, Date_Of_Birth , Gender , Address , Postcode  , Telephone_Number, E_mail, Bank_Account_Number , Status , UnitID, password) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
	                                                                   pst.setString(1,splitsMessage[2]); 
	                                                                  	pst.setString(2,splitsMessage[3]);
	                                                                  	pst.setString(3,splitsMessage[4]); 
	                                                                  	pst.setString(4,splitsMessage[5]); 
	                                                                  	pst.setString(5,splitsMessage[6]); 
	                                                                  	pst.setString(6,splitsMessage[7]); 
	                                                                  	pst.setString(7,splitsMessage[8]); 
	                                                                  	pst.setString(8,splitsMessage[9]); 
	                                                                  	pst.setString(9,splitsMessage[10]); 
	                                                                  	pst.setString(10,splitsMessage[11]); 
	                                                                  	pst.setString(11,splitsMessage[12]);
	                                                                  	pst.setString(12,splitsMessage[13]);
	                                                                  	pst.setString(13,splitsMessage[14]);
	                                                                  	
	                                                                  	pst.executeUpdate();
	                                                                         
	                                                                  	System.out.println("Hello, you reached me after executing the StudentRegister");
	                                                                    sendData("Done");//status
	                                                                    
	                                                                            	   
	                                                    	}
	                                                  

	                        	  
	                        	  //splitsMessage[11]- bank number in student and staff - local db   
	                        	//Insert General Bank details.
	                        	 if(splitsMessage[0].equals("StaffRegister")||splitsMessage[0].equals("StudentRegister"))
	                        		 //wrong 15,16 XD
	                        		 st = con.createStatement();
	                        	//st.executeUpdate(" VALUES ("+splitsMessage[11]+"','"+splitsMessage[15]+"','"+splitsMessage[16]+"');");//all strings-yes
	                        	  pst = con.prepareStatement("INSERT INTO `bank_details`(`Bank_Account_Number`, `Bank_Name`, `Account_Holders_Name`) VALUES (?,?,?)");
	                              pst.setString(1,splitsMessage[11]); 
	                             	pst.setString(2,splitsMessage[15]);
	                             	pst.setString(3,splitsMessage[16]); 	
	                             	pst.executeUpdate();
	                        	 
	                        	 break;
	                        }
	                        catch (Exception e){
	                            System.out.println("SQL statement is not executed!");
	                            e.printStackTrace();
	                        }
	                       
	                    break;
	                  
	              case 10: 
	                    //set unit data! -
	            	break;

	     default: //show error or something!//or...;
	                                 break;
	                    				}  //end of cases  
	                        
	                  } 
	                  catch ( ClassNotFoundException classNotFoundException ) 
	                  {    System.out.println( "\nUnknown object type received" ); } 

	                  } while ( !message.equals( "CLIENT>>> TERMINATE" ) );
	               }

    

   
   private void closeConnection() 
   {
      System.out.println( "\nTerminating connection-server\n" ); 

      try 
      {
         output.close(); 
         input.close(); 
         connection.close(); 
      } 
      catch ( IOException ioException ) 
      {
         ioException.printStackTrace();
      } 
   } 

   
   private void sendData( String message )
   {
      try 
      {
         output.writeObject(message);
         output.flush(); 
     
      } 
      catch ( IOException ioException ) 
      {
         System.out.println( "\nError writing object" );
      } 
   }
   
   /**
    * 
    * Admin Methods
    * 
    */
   
   /*
    * get Staff information form the Staff Table
    */
   public String [] [] getAStaff() throws SQLException
   {
	   String [] [] v; 
	   	
   		ResultSetMetaData rsmd;

	   try {
   		
           Class.forName(DRIVER);
           try {
               con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
               stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
               rs = stmt.executeQuery("SELECT * from staff");

           } catch (SQLException e) {
               String msg = "MyModel(): Error Connecting to Database:\n"
                       + e.getMessage();
               System.out.println(msg);
           }
       }catch (ClassNotFoundException e) {
           String msg = "The com.mysql.jdbc.Driver is missing\n"
                   + "install and rerun the application";
           System.out.println(msg);
           //System.exit(1);
       } finally {
       	
       }
	   
	   try
	   {
		   int rCount = 0;

		   while(rs.next())
		   {	
			   rCount++;			 
		   }
		   
		   stmt = null;
		   rs = null;
		   stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
	       rs = stmt.executeQuery("SELECT * from staff");
		   rsmd = rs.getMetaData();
			  
		   int noOfCols = rsmd.getColumnCount();	  
			  
		   v = new String[rCount][noOfCols];
		   
		   int counter = 0;
		   while(rs.next())
			  {
			   System.out.println(rs.getRow());
				 
					   for(int i = 0; i < noOfCols; i++)
					   {
						   v[counter][i] = (rs.getString(i+1));
						   System.out.print(v[counter][i] + "\t" );
					   }
					   System.out.println();
				counter++;
			  }
				  return v;
			  
		   }
	   catch (SQLException e) {
           String msg = "MyModel(): Error Connecting to Database:\n"
                   + e.getMessage();
           System.out.println(msg);
       }
	   return null;
   }
   
   /*
    * Admin method get Student information form the Student Table
    */
   public String [] [] getAStudent() throws SQLException
   {
	   String [] [] v; 
	 
	   ResultSetMetaData rsmd;
	   
	   try {
   		
           Class.forName(DRIVER);
           try {
               con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
               stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
               rs = stmt.executeQuery("SELECT * from students");

           } catch (SQLException e) {
               String msg = "MyModel(): Error Connecting to Database:\n"
                       + e.getMessage();
               System.out.println(msg);
           }
       }catch (ClassNotFoundException e) {
           String msg = "The com.mysql.jdbc.Driver is missing\n"
                   + "install and rerun the application";
           System.out.println(msg);
           
       } finally {
    	   
       }
	   
	   try
	   {
		   int rCount = 0;

		   while(rs.next())
		   {	
			   rCount++;			 
		   }
		   
		   stmt = null;
		   rs = null;
		   stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
	       rs = stmt.executeQuery("SELECT * from students");
		   rsmd = rs.getMetaData();
			  
		   int noOfCols = rsmd.getColumnCount();	  
			  
		   v = new String[rCount][noOfCols];
		   
		   int counter = 0;
		   while(rs.next())
			  {
			   System.out.println(rs.getRow());
				 
					   for(int i = 0; i < noOfCols; i++)
					   {
						   v[counter][i] = (rs.getString(i+1));
						   System.out.print(v[counter][i] + "\t" );
					   }
					   System.out.println();
				counter++;
			  }
				  return v;
			  
		   }
	   catch (SQLException e) {
           String msg = "MyModel(): Error Connecting to Database:\n"
                   + e.getMessage();
           System.out.println(msg);
       }
	   return null;
   }
   /**
    * 
    * End of Admin Methods
    * 
    */
   
   /**
    * 
    * Staff Methods
    * 
    */
   
   /*
    * Staff method get Student information form the Student Table
    */
   public String [] [] getStaffGrades() throws SQLException
   {
	   String [] [] v; 
	   
	   
	   ResultSetMetaData rsmd;

	   try {
   		
           Class.forName(DRIVER);
           try {
               con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
               stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
               rs = stmt.executeQuery("SELECT * from results_table");

           } catch (SQLException e) {
               String msg = "MyModel(): Error Connecting to Database:\n"
                       + e.getMessage();
               System.out.println(msg);
           }
       }catch (ClassNotFoundException e) {
           String msg = "The com.mysql.jdbc.Driver is missing\n"
                   + "install and rerun the application";
           System.out.println(msg);
           
       } finally {
       	
       }
	   
	   try
	   {
		   int rCount = 0;

		   while(rs.next())
		   {	
			   rCount++;			 
		   }
		   
		   stmt = null;
		   rs = null;
		   stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
	       rs = stmt.executeQuery("SELECT * from results_table");
		   rsmd = rs.getMetaData();
			  
		   int noOfCols = rsmd.getColumnCount();	  
			  
		   v = new String[rCount][noOfCols];
		   
		   int counter = 0;
		   while(rs.next())
			  {
			   System.out.println(rs.getRow());
				 
					   for(int i = 0; i < noOfCols; i++)
					   {
						   v[counter][i] = (rs.getString(i+1));
						   System.out.print(v[counter][i] + "\t" );
					   }
					   System.out.println();
				counter++;
			  }
				  return v;
			  
		   }
	   catch (SQLException e) {
           String msg = "MyModel(): Error Connecting to Database:\n"
                   + e.getMessage();
           System.out.println(msg);
       }
	   return null;
   }
   
   /*
    * Staff method: get Staff_Student get information from the Student table
    */
   public String [] [] getStaffStudent() throws SQLException
   {
	   String [] [] v; 
	   
	   
	   ResultSetMetaData rsmd;

	   try {
   		
           Class.forName(DRIVER);
           try {
               con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
               stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
               rs = stmt.executeQuery("SELECT * from students");

           } catch (SQLException e) {
               String msg = "MyModel(): Error Connecting to Database:\n"
                       + e.getMessage();
               System.out.println(msg);
           }
       }catch (ClassNotFoundException e) {
           String msg = "The com.mysql.jdbc.Driver is missing\n"
                   + "install and rerun the application";
           System.out.println(msg);
           
       } finally {
    	   
       }
	   
	   try
	   {
		   int rCount = 0;

		   while(rs.next())
		   {	
			   rCount++;			 
		   }
		   
		   stmt = null;
		   rs = null;
		   stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
	       rs = stmt.executeQuery("SELECT * from students");
		   rsmd = rs.getMetaData();
			  
		   int noOfCols = rsmd.getColumnCount();	  
			  
		   v = new String[rCount][noOfCols];
		   
		   int counter = 0;
		   while(rs.next())
			  {
			   System.out.println(rs.getRow());
				 
					   for(int i = 0; i < noOfCols; i++)
					   {
						   v[counter][i] = (rs.getString(i+1));
						   System.out.print(v[counter][i] + "\t" );
					   }
					   System.out.println();
				counter++;
			  }
				  return v;
			  
		   }
	   catch (SQLException e) {
           String msg = "MyModel(): Error Connecting to Database:\n"
                   + e.getMessage();
           System.out.println(msg);
       }
	   return null;
   }

   /**
    * 
    * End of Staff Methods
    * 
    */
   
   /**
    * 
    * Student Methods
 * @param name 
    * 
    */
   public String [] [] getStudentGrades(String name) throws SQLException
   {
	   String [] [] v; 
	   
	   
	   ResultSetMetaData rsmd;

	   try {
   		
           Class.forName(DRIVER);
           try {
               con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
               stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
               rs = stmt.executeQuery("SELECT * from results_table WHERE StudentID =" + name);

           } catch (SQLException e) {
               String msg = "MyModel(): Error Connecting to Database:\n"
                       + e.getMessage();
               System.out.println(msg);
           }
       }catch (ClassNotFoundException e) {
           String msg = "The com.mysql.jdbc.Driver is missing\n"
                   + "install and rerun the application";
           System.out.println(msg);
           
       } finally {
    	   
       }
	   
	   try
	   {
		   int rCount = 0;

		   while(rs.next())
		   {	
			   rCount++;			 
		   }
		   
		   stmt = null;
		   rs = null;
		   stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
	       rs = stmt.executeQuery("SELECT * from results_table WHERE StudentID =" + name);
		   rsmd = rs.getMetaData();
			  
		   int noOfCols = rsmd.getColumnCount();	  
			  
		   v = new String[rCount][noOfCols];
		   
		   int counter = 0;
		   while(rs.next())
			  {
			   System.out.println(rs.getRow());
				 
					   for(int i = 0; i < noOfCols; i++)
					   {
						   v[counter][i] = (rs.getString(i+1));
						   System.out.print(v[counter][i] + "\t" );
					   }
					   System.out.println();
				counter++;
			  }
				  return v;
			  
		   }
	   catch (SQLException e) {
           String msg = "MyModel(): Error Connecting to Database:\n"
                   + e.getMessage();
           System.out.println(msg);
       }
	   return null;
   }
   
   public String [] [] getStudentCourse() throws SQLException
   {
	   String [] [] v; 
	   
	   
	   ResultSetMetaData rsmd;

	   try {
   		
           Class.forName(DRIVER);
           try {
               con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
               stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
               rs = stmt.executeQuery("SELECT * from courses");

           } catch (SQLException e) {
               String msg = "MyModel(): Error Connecting to Database:\n"
                       + e.getMessage();
               System.out.println(msg);
           }
       }catch (ClassNotFoundException e) {
           String msg = "The com.mysql.jdbc.Driver is missing\n"
                   + "install and rerun the application";
           System.out.println(msg);
           //System.exit(1);
       } finally {
       	
       }
	   
	   try
	   {
		   int rCount = 0;

		   while(rs.next())
		   {	
			   rCount++;			 
		   }
		   
		   stmt = null;
		   rs = null;
		   stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
	       rs = stmt.executeQuery("SELECT * from courses");
		   rsmd = rs.getMetaData();
			  
		   int noOfCols = rsmd.getColumnCount();	  
			  
		   v = new String[rCount][noOfCols];
		   
		   int counter = 0;
		   while(rs.next())
			  {
			   System.out.println(rs.getRow());
				 
					   for(int i = 0; i < noOfCols; i++)
					   {
						   v[counter][i] = (rs.getString(i+1));
						   System.out.print(v[counter][i] + "\t" );
					   }
					   System.out.println();
				counter++;
			  }
				  return v;
			  
		   }
	   catch (SQLException e) {
           String msg = "MyModel(): Error Connecting to Database:\n"
                   + e.getMessage();
           System.out.println(msg);
       }
	   return null;
   }
   
   /**
    * 
    * End of Student Methods
    * 
    */
   
   /**
    *
    * Updating data from JTable in to the Database 
    *
    */
   public void updateTable(String tName, String [] [] updateData)
   {
	   String statement,clause = "";
	   int tRow = 0;
	   boolean bool = true;

		   try {
			   Class.forName(DRIVER);
			   try
			   {						   
					con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);								
					   rs = null;
				       rs = stmt.executeQuery("SELECT * from " + tName);
					   rsmd = rs.getMetaData();
					   while(rs.next())
					   {
						   clause = " WHERE " + rsmd.getColumnName(1) + "= '"+rs.getString(1)+"'";
							   
						   statement = "UPDATE " + tName + " SET ";
						   
						   for(int i = 0; i < rsmd.getColumnCount(); i++)
						   {
							   statement += rsmd.getColumnName(i+1) + " = '" + updateData[tRow][i]+"'";
							   
							   if(!(i == (rsmd.getColumnCount() -1)))
							   {
								   statement+= ",";
							   }
						   }
						   
						   statement += clause; 
						   tRow++;
						   stmt = null;
						   stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);						
						   System.out.println("Statement: " + statement);
						   stmt.executeUpdate(statement);	
						  	
					   }			  
			   }
			   catch (SQLException e)
			   {
		           String msg = "MyModel(): Error Connecting to Database:\n"
		                   + e.getMessage();
		           System.out.println(msg);
		       }
			} 
		   catch (ClassNotFoundException e)
		   {
				// TODO Auto-generated catch block
				e.printStackTrace();
		   }
	   }
   /**
    * 
    * 
    * 
    */
	
} 