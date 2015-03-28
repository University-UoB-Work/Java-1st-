import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import Client_and_Server_Package.*;
/**
 * @author Ches
 * Proofreading Alex
 */
public class Register_GUI extends JFrame {
	
	static final String gender[] = {"None", "Male", "Female"};
	
	static final String yearList[] = {"None", "Year 1", "Year 2", "Year 3", "Masters", "Doctors (PHD)"};
	static String courseList[] = {"None","BCs Computer Security and Forensics","BCs Art","BCs Game Design","BCs Game Programming"};
	
	static AllClient allclient = new AllClient();
	
	Container con;
	
	JLabel lblWelcome = new JLabel ("Registration");
	
	JLabel lblStudent  = new JLabel ("Student Registration");
	JLabel lblStudent_First_Name = new JLabel ("<html>First Name <font color='red'>*</font></html>");
	JLabel lblStudent_Surname = new JLabel ("<html>Surname <font color='red'>*</font></html>");
	JLabel lblStudent_DOB = new JLabel ("<html>Date of Birth <font color='red'>*</font></html>");
	JLabel lblStudent_Gender = new JLabel ("<html>Gender <font color='red'>*</font></html>");
	JLabel lblStudent_Address = new JLabel ("<html>Address <font color='red'>*</font></html>");
	JLabel lblStudent_Postcode = new JLabel ("<html>Post Code <font color='red'>*</font></html>");
	JLabel lblStudent_CourseID = new JLabel ("<html>Course ID <font color='red'>*</font></html>");
	JLabel lblStudent_Course_Units = new JLabel("Course Units");
	JLabel lblStudent_Tele = new JLabel ("<html>Telephone Num. <font color='red'>*</font></html>");
	JLabel lblStudent_Email = new JLabel ("<html>E-mail Address <font color='red'>*</font></html>");
	JLabel lblStudent_Bank_Acc = new JLabel ("<html>Bank Account Num. <font color='red'>*</font></html>");
	JLabel lblStudent_Bank_Name = new JLabel ("<html>Bank Name <font color='red'>*</font></html>");
	JLabel lblStudent_Year_Study = new JLabel ("<html>Year of Study <font color='red'>*</font></html>");
	JLabel lblStudent_Password = new JLabel ("<html>Password <font color='red'>*</font></html>");
	
	JTextField txtStudent_First_Name = new JTextField (5);
	JTextField txtStudent_Surname = new JTextField (5);
	JTextField txtStudent_DOB = new JTextField (5);
	JComboBox<String> combStudent_Gender = new JComboBox<String>(gender);
	JTextField txtStudent_Address = new JTextField (5);
	JTextField txtStudent_Postcode = new JTextField (5);
	JComboBox<String> combStudent_CourseID = new JComboBox<String>(courseList);
	JTextField txtStudent_Unit1 = new JTextField(5);
	JTextField txtStudent_Unit2 = new JTextField(5);
	JTextField txtStudent_Unit3 = new JTextField(5);
	JTextField txtStudent_Unit4 = new JTextField(5);
	JTextField txtStudent_Tele = new JTextField (5);
	JTextField txtStudent_Email = new JTextField (5);
	JTextField txtStudent_Bank_Acc = new JTextField (5);
	JTextField txtStudent_Bank_Name = new JTextField (5);
	JComboBox<String> combStudent_Year_Study = new JComboBox<String>(yearList);
	JTextField txtStudent_Password = new JTextField (5);
	
	JRadioButton rbtnStudent = new JRadioButton ("Student");
	JRadioButton rbtnNone = new JRadioButton ("None");
	
	JButton btnStudent = new JButton("Create");
	JButton btnStaff = new JButton("Create");
	JButton btnBack = new JButton("Back");
	JButton btnView = new JButton("View");
	
	private static void setupEnterActionForAllButtons() {
        InputMap im = (InputMap) UIManager.getDefaults().get("Button.focusInputMap");
        Object pressedAction = im.get(KeyStroke.getKeyStroke("pressed SPACE"));
        Object releasedAction = im.get(KeyStroke.getKeyStroke("released SPACE"));

        im.put(KeyStroke.getKeyStroke("pressed ENTER"), pressedAction);
        im.put(KeyStroke.getKeyStroke("released ENTER"), releasedAction);
    }
		
	public Register_GUI(){
		super ("Registration");
		
		lblWelcome.setFont(new Font("Arial", Font.BOLD,24));
		lblStudent.setFont(new Font("Arial", Font.BOLD,14));
		txtStudent_Unit1.setEditable(false);
		txtStudent_Unit2.setEditable(false);
		txtStudent_Unit3.setEditable(false);
		txtStudent_Unit4.setEditable(false);
		
		con = getContentPane();
		con.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JPanel topPanel = new JPanel();
		topPanel.add(lblWelcome); topPanel.add(new JLabel("                                                                                     ")); topPanel.add(btnBack);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.ipadx = 1;
		c.gridy = 0;
		c.ipady = 1;
		c.anchor = GridBagConstraints.PAGE_START;
		con.add(topPanel, c);
		
		JPanel rButtons = new JPanel();
		rButtons.setLayout(new GridLayout(0,2));
		rButtons.add(rbtnNone); rButtons.add(rbtnStudent);
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnNone); group.add(rbtnStudent);
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.ipadx = 1;
		c.gridy = 1;
		c.ipady = 1;
		c.anchor = GridBagConstraints.PAGE_START;
		con.add(rButtons, c);
		
		final JPanel unitsPanel = new JPanel();
		unitsPanel.setLayout(new GridLayout(0,4));
		unitsPanel.add(txtStudent_Unit1);
		unitsPanel.add(txtStudent_Unit2);
		unitsPanel.add(txtStudent_Unit3);
		unitsPanel.add(txtStudent_Unit4);
		
		final JPanel lbl_btn_Panel = new JPanel();
		lbl_btn_Panel.setLayout(new GridLayout(0,2));
		lbl_btn_Panel.add(lblStudent_Course_Units); lbl_btn_Panel.add(btnView);
		
		final JPanel uStudent= new JPanel();
		uStudent.setLayout(new GridLayout(0,2));
		uStudent.add(lblStudent); uStudent.add(new JLabel(""));
		uStudent.add(lblStudent_First_Name); uStudent.add(txtStudent_First_Name);
		uStudent.add(lblStudent_Surname); uStudent.add(txtStudent_Surname);
		uStudent.add(lblStudent_DOB); uStudent.add(txtStudent_DOB);
		uStudent.add(lblStudent_Gender); uStudent.add(combStudent_Gender);
		uStudent.add(lblStudent_Address); uStudent.add(txtStudent_Address);
		uStudent.add(lblStudent_Postcode); uStudent.add(txtStudent_Postcode);
		uStudent.add(lblStudent_CourseID); uStudent.add(combStudent_CourseID);
		uStudent.add(lbl_btn_Panel); uStudent.add(unitsPanel);
		uStudent.add(lblStudent_Tele); uStudent.add(txtStudent_Tele);
		uStudent.add(lblStudent_Email); uStudent.add(txtStudent_Email);
		uStudent.add(lblStudent_Bank_Acc); uStudent.add(txtStudent_Bank_Acc);
		uStudent.add(lblStudent_Bank_Name); uStudent.add(txtStudent_Bank_Name);
		uStudent.add(lblStudent_Year_Study); uStudent.add(combStudent_Year_Study);
		uStudent.add(lblStudent_Password); uStudent.add(txtStudent_Password);
		uStudent.add(new JLabel("")); uStudent.add(btnStudent);
		
		JPanel con_Panel = new JPanel();
		con_Panel.setLayout(new GridLayout(0,1));
		con_Panel.add(uStudent);
		c.fill=GridBagConstraints.BOTH;
		c.gridx = 1;
		c.ipadx = 1;
		c.gridy = 2;
		c.ipady = 1;
		c.anchor = GridBagConstraints.LINE_START;
		con.add(con_Panel, c);
		
    	uStudent.setVisible(false);
		
        rbtnStudent.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	AllClient.sendData("StudentListCourses-onload,2");
            	
            	try  
            	{
               		AllClient.message = ( String ) AllClient.input.readObject(); 		
                }
            	catch (IOException | ClassNotFoundException classNotFoundException) 
     	     	{    
            		System.out.println( "\n?" ); 
     	     	} 
            	System.out.println("i have received course list on load!-client");
            	 String[] splitMessage = AllClient.message.split(","); 
            	 System.out.println(splitMessage[0]+"to to ");
            	 if(splitMessage[0].equals("ListCourse"))  
            	 {	
                 	combStudent_CourseID.removeAllItems();
                 	combStudent_CourseID.addItem("None");
                 	//received in 0
                 	 int x=1;
                 	 while (x<splitMessage.length)
                 	 {
                 	   System.out.println(splitMessage[x]+" element");
                 	   combStudent_CourseID.addItem(splitMessage[x]);
                 	   x++;
                 	 } 
                 }
                 else 
                 {
                	 System.out.println("Something went wrong-can't pre-load the course list :( ");
                 }
            	
            	combStudent_Gender.setSelectedIndex(0); combStudent_CourseID.setSelectedIndex(0);
            	combStudent_Year_Study.setSelectedIndex(0);
            	txtStudent_First_Name.setText(""); txtStudent_Surname.setText(""); 
            	txtStudent_DOB.setText(""); txtStudent_Address.setText(""); 
            	txtStudent_Postcode.setText(""); txtStudent_Tele.setText("");
            	txtStudent_Email.setText(""); txtStudent_Bank_Acc.setText("");
            	txtStudent_Bank_Name.setText(""); txtStudent_Password.setText("");
            	
            	uStudent.setVisible(true);
            }
           //}
        });
        
        rbtnNone.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	
            	uStudent.setVisible(false);
            	
            	combStudent_Gender.setSelectedIndex(0); combStudent_CourseID.setSelectedIndex(0);
            	combStudent_Year_Study.setSelectedIndex(0);
            	txtStudent_First_Name.setText(""); txtStudent_Surname.setText(""); 
            	txtStudent_DOB.setText(""); txtStudent_Address.setText(""); 
            	txtStudent_Postcode.setText(""); txtStudent_Tele.setText("");
            	txtStudent_Email.setText(""); txtStudent_Bank_Acc.setText("");
            	txtStudent_Bank_Name.setText(""); txtStudent_Password.setText("");
           }
        });
        
        btnStudent.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	int int_student_name = txtStudent_First_Name.getText().length();
            	int int_student_surname = txtStudent_Surname.getText().length();
            	int int_student_dob = txtStudent_DOB.getText().length();
            	int int_student_address = txtStudent_Address.getText().length();
            	int int_student_postcode = txtStudent_Postcode.getText().length();
            	int int_student_tele = txtStudent_Tele.getText().length();
            	int int_student_email = txtStudent_Email.getText().length();
            	int int_student_bankacc = txtStudent_Bank_Acc.getText().length();
            	int int_student_bankname = txtStudent_Bank_Name.getText().length();
            	int int_student_password = txtStudent_Password.getText().length();
            	
				if(int_student_name <= 0 || int_student_surname <= 0 || int_student_dob <= 0
					|| combStudent_Gender.getSelectedIndex()==0 || int_student_address <= 0
					|| combStudent_CourseID.getSelectedIndex()==0
					|| int_student_postcode <= 0 || int_student_tele <= 0 
					|| int_student_email <= 0 || int_student_bankacc <= 0 
					|| int_student_bankname <= 0 || combStudent_Year_Study.getSelectedIndex()==0
					|| int_student_password <= 0){
	            	JOptionPane.showMessageDialog(con,
	            			"Please fill in all the text fields with RED STAR symbol\n"
	            			+ "Thank You",
	            			"Warning",
	            			JOptionPane.WARNING_MESSAGE);
	            	//if (txtStaff_First_Name.getText()==NULL   )
				}
				
				//no telephone- need to be course
				else{
					
					String studnt_account_holder= txtStudent_First_Name.getText()+" "+txtStudent_Surname.getText();
					AllClient.sendData("StudentRegister,2,"+txtStudent_First_Name.getText()+","+txtStudent_Surname.getText()+","
										+txtStudent_DOB.getText()+","+combStudent_Gender.getSelectedItem()+","+txtStudent_Address.getText()+","
										+txtStudent_Postcode.getText()+","+combStudent_CourseID.getSelectedIndex()+","+txtStudent_Tele.getText()+","+txtStudent_Email.getText()+","
										+ txtStudent_Bank_Acc.getText()+","+combStudent_Year_Study.getSelectedItem()+","+txtStudent_Password.getText()+",,"+txtStudent_Bank_Name.getText()+","
										+studnt_account_holder);
	            	
					try 
	            	{
						AllClient.message = ( String ) AllClient.input.readObject(); 	
	               		//put answer into new course list
	            	}
	            	 catch (IOException | ClassNotFoundException classNotFoundException)  
	            	 {    
	            		 System.out.println( "\n?here?" ); 
	            	 } 
					
	               		if (AllClient.message.equals("Students_Done"))
	               		{  
	               			JOptionPane.showMessageDialog(con,
	    	            			"Thank you for Registration.\n"
	    	            			+ "Your User-name is your First Name\n"
	    	            			+ "and you Password is your Password\n"
	    	            			+ "Have a Nice Day :)",
	    	            			"Important Message!",
	    	            			JOptionPane.INFORMATION_MESSAGE);
	               			//how to get the user-name and password?
	               			setVisible(false);
	    	        		Login_GUI log=new Login_GUI(); 
	    	        		log.setVisible(true);
	               		}
	        		
				}
            }
        });
        
        btnView.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	System.out.println(combStudent_CourseID.getSelectedIndex()+"My index is :P");
            	if(combStudent_CourseID.getSelectedIndex()!=0)  {
                 	  AllClient.sendData("CorrespondUnitsList,2,"+ combStudent_CourseID.getSelectedItem());//sending to server selected course
                 
               	try {
               		AllClient.message = ( String ) AllClient.input.readObject(); 	      		
                  		}//end of try
        	     	 catch (   IOException | ClassNotFoundException classNotFoundException   )  {    System.out.println( "\n?" ); } 
               	//,txtStudent_Unit2,txtStudent_Unit3,txtStudent_Unit4
                 
               	 String[] splitMessage2 = AllClient.message.split(",");    //delimiter is a comma 
                   txtStudent_Unit1.setText(splitMessage2[0]);
                   txtStudent_Unit2.setText(splitMessage2[1]);
                   txtStudent_Unit3.setText(splitMessage2[2]);
                   txtStudent_Unit4.setText(splitMessage2[3]);
                
                 }
            	else
            	{
            		 txtStudent_Unit1.setText("");
                     txtStudent_Unit2.setText("");
                     txtStudent_Unit3.setText("");
                     txtStudent_Unit4.setText("");
            		
            	}
            }
        });

        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
        		setVisible(false);
        		Login_GUI log=new Login_GUI(); 
        		log.setVisible(true);
            }
        });
		
		pack();
		setSize(500,550);
		setLocation(125,100);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
