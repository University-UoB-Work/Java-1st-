import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;

import static javax.swing.GroupLayout.Alignment.*;

import Client_and_Server_Package.*;

public class Login_GUI extends JFrame{

	Container con;
	JLabel lblWelcome;
	JLabel lblUsername;
	JLabel lblPassword;
	
	JTextField txtUsername;
	JPasswordField txtPassword;
	
	JButton btnEnter;
	JButton btnRegister;
	JButton btnExit;

	public static void setupEnterActionForAllButtons() {
        InputMap im = (InputMap) UIManager.getDefaults().get("Button.focusInputMap");
        Object pressedAction = im.get(KeyStroke.getKeyStroke("pressed SPACE"));
        Object releasedAction = im.get(KeyStroke.getKeyStroke("released SPACE"));

        im.put(KeyStroke.getKeyStroke("pressed ENTER"), pressedAction);
        im.put(KeyStroke.getKeyStroke("released ENTER"), releasedAction);
    }
	
	public Login_GUI(){
		super("Login");
		
		con = getContentPane();
		
		
		GroupLayout layout = new GroupLayout(con);
		con.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		lblWelcome = new JLabel("         Welcome");
		lblWelcome.setFont(new Font("Arial", Font.BOLD,24));
		lblUsername = new JLabel("Username:");
		lblPassword = new JLabel("Password:");
		
		txtUsername = new JTextField();
		txtPassword = new JPasswordField();
		
		btnEnter = new JButton("Enter");
		btnRegister = new JButton("Register");
		btnExit = new JButton("Exit");
		
        layout.setHorizontalGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(LEADING)
        					.addComponent(lblWelcome)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(LEADING)
        							.addComponent(lblUsername)
        							.addComponent(lblPassword)
        							.addComponent(btnEnter))
        						.addGroup(layout.createParallelGroup(LEADING)
        							.addComponent(btnRegister)
        							.addComponent(txtPassword)
        							.addComponent(txtUsername)
        							.addGap(75))))
        				.addGroup(layout.createParallelGroup(LEADING)
        						.addComponent(btnExit))
            );
            
            layout.linkSize(SwingConstants.HORIZONTAL, btnEnter, btnExit);
     
            layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(BASELINE)
                    .addComponent(lblWelcome))
                .addGroup(layout.createParallelGroup(LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(BASELINE)
                            .addComponent(lblUsername)
                            .addComponent(txtUsername))
                        .addGroup(layout.createParallelGroup(BASELINE)
                            .addComponent(lblPassword)
                            .addComponent(txtPassword))))
               .addGroup(layout.createParallelGroup(LEADING)
                    .addComponent(btnEnter)
                    .addComponent(btnRegister)
                    .addComponent(btnExit))
            );
            
            btnEnter.addActionListener(new ActionListener(){
                public void actionPerformed (ActionEvent e){
                	
                	String user = txtUsername.getText();
    	            String passwor = txtPassword.getText();
    	           
    	            AllClient.sendData( ",1,"+user+","+passwor );
	          //  AllClient.sendData( ",1,1219460,test1" );// sample data 
	          
    	          
    	            try {
    	           
    	            	AllClient.message = ( String ) AllClient.input.readObject(); 
 
   				   if (AllClient.message.equals("Admin")){
   	            	setVisible(false);
   	            	dispose();
   	            	Admin_GUI admin = new Admin_GUI();
   	            	admin.setVisible(true);
   	            }
   	            //Open a Student GUI
   	            else if(AllClient.message.equals("Student")){
   	            	setVisible(false);
   	            	dispose();
   	            	Student_GUI student = new Student_GUI();
   	            	student.setVisible(true);
   	            }
   	            //Open a Staff GUI
   	            else if(AllClient.message.equals("Staff")){
   	            	setVisible(false);
   	            	dispose();
   	            	Staff_GUI staff = new Staff_GUI();
   	            	staff.setVisible(true);
   	            }
   	            else
   	            {
   	            	System.out.println("test   "+AllClient.message+" test-client  ");
   	            	JOptionPane.showMessageDialog(con,
   	            			"Wrong Username or Password.",
   	            			"Login Error",
   	            			JOptionPane.ERROR_MESSAGE);
   	            }
  	            	
	            	txtUsername.setText("ID");
	            	txtPassword.setText("");
   				    
     	           		}
    	            
    	           
     	     	 catch (   IOException | ClassNotFoundException classNotFoundException   ) 
  			      {    
     	     		 System.out.println( "\nUnknown object type received");
  			      			JOptionPane.showMessageDialog(con,
	            			"Wrong Username or Password.",
	            			"Login Error",
	            			JOptionPane.ERROR_MESSAGE);
  			      } catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
              }
            });
            
            btnRegister.addActionListener(new ActionListener(){
                public void actionPerformed (ActionEvent e){
                		setVisible(false);
                		Register_GUI reg=new Register_GUI(); 
                		reg.setVisible(true);
                		reg.enable(true);
				}
            });
            
            btnExit.addActionListener(new ActionListener(){
                public void actionPerformed (ActionEvent e){
                	AllClient.closeConnection();
                    System.exit(0);
                }
            });
            
		pack();
		setSize(255,160);
		setLocation(500,350);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String [] args){
		setupEnterActionForAllButtons();
		Login_GUI login_gui = new Login_GUI();
		
		AllClient client = new AllClient();
		client.runClient();
    }
}