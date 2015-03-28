import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import Client_and_Server_Package.*;

/**
 * @author Ches
 *Proofreading : Alex
 */
public class Create_GUI extends JFrame {
	static final String titleList[] = {"None","Mr", "Mrs", "Ms.", "Miss", "Dr."};
	static final String statusList[] = {"None", "Staff"};
	static  String unitsList[] = {"None", "1-C018","1-C012","1-C015","1-C020","1-C028","1-C058"};
	
	static final String staffgenderList[] = {"None", "Male", "Female"};
	static final String studentgenderList[] = {"None", "Male", "Female"};
	
	static final String yearList[] = {"None", "Year 1", "Year 2", "Year 3", "Masters", "Doctors (PHD)"};
	static String courseList[] = {"None","BCs Computer Security and Forensics","BCs Art","BCs Game Design","BCs Game Programming"};
	
	static AllClient allclient = new AllClient();
	
	Container con;
	
	JLabel lblWelcome = new JLabel ("Registration");
	
	JLabel lblStaff = new JLabel ("Staff Registration");
	JLabel lblStaff_Title = new JLabel ("<html>Title <font color='red'>*</font></html>");
	JLabel lblStaff_First_Name = new JLabel ("<html>First Name <font color='red'>*</font></html>");
	JLabel lblStaff_Surname = new JLabel ("<html>Surname <font color='red'>*</font></html>");
	JLabel lblStaff_DOB = new JLabel ("<html>Date of Birth <font color='red'>*</font></html>");
	JLabel lblStaff_Gender = new JLabel ("<html>Gender <font color='red'>*</font></html>");
	JLabel lblStaff_Address = new JLabel ("<html>Address <font color='red'>*</font></html>");
	JLabel lblStaff_Postcode = new JLabel ("<html>Post Code <font color='red'>*</font></html>");
	JLabel lblStaff_Tele = new JLabel ("<html>Telephone Num. <font color='red'>*</font></html>");
	JLabel lblStaff_Email = new JLabel ("<html>E-mail Address <font color='red'>*</font></html>");
	JLabel lblStaff_Status = new JLabel ("<html>Status <font color='red'>*</font></html>");
	JLabel lblStaff_Unit_ID = new JLabel ("<html>Unit ID <font color='red'>*</font></html>");
	JLabel lblStaff_Bank_Name = new JLabel("<html>Bank Name <font color='red'>*</font></html>");
	JLabel lblStaff_Bank_Acc = new JLabel("<html>Bank Account <font color='red'>*</font></html>");
	JLabel lblStaff_Password = new JLabel ("<html>Password <font color='red'>*</font></html>");
	
	JComboBox<String> combStaff_Title = new JComboBox<String>(titleList);
	JTextField txtStaff_First_Name = new JTextField (5);
	JTextField txtStaff_Surname = new JTextField (5);
	JTextField txtStaff_DOB = new JTextField (5);
	JComboBox<String> combStaff_Gender = new JComboBox<String>(staffgenderList);
	JTextField txtStaff_Address = new JTextField (5);
	JTextField txtStaff_Postcode = new JTextField (5);
	JTextField txtStaff_Tele = new JTextField (5);
	JTextField txtStaff_Email = new JTextField (5);
	JComboBox<String> combStaff_Status = new JComboBox<String>(statusList);
	JComboBox<String> combStaff_Unit_ID = new JComboBox<String>(unitsList);
	JTextField txtStaff_Bank_Name = new JTextField(5);
	JTextField txtStaff_Bank_Acc = new JTextField(5);
	JTextField txtStaff_Password = new JTextField (5);
	
	
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
	JComboBox<String> combStudent_Gender = new JComboBox<String>(studentgenderList);
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
	JRadioButton rbtnStaff = new JRadioButton ("Staff");
	
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

	public Create_GUI(){
		super ("Registration");
		
		lblWelcome.setFont(new Font("Arial", Font.BOLD,24));
		lblStaff.setFont(new Font("Arial", Font.BOLD,14));
		lblStudent.setFont(new Font("Arial", Font.BOLD,14));
		txtStudent_Unit1.setEditable(false);
		txtStudent_Unit2.setEditable(false);
		txtStudent_Unit3.setEditable(false);
		txtStudent_Unit4.setEditable(false);
		
		con = getContentPane();
		con.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.ipadx = 1;
		c.gridy = 0;
		c.ipady = 1;
		c.anchor = GridBagConstraints.PAGE_START;
		con.add(lblWelcome, c);
		
		JPanel rButtons = new JPanel();
		rButtons.setLayout(new GridLayout(0,2));
		rButtons.add(rbtnStaff); rButtons.add(rbtnStudent);
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnStaff); group.add(rbtnStudent);
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.ipadx = 1;
		c.gridy = 1;
		c.ipady = 1;
		c.anchor = GridBagConstraints.PAGE_START;
		con.add(rButtons, c);
		
		final JPanel uStaff = new JPanel();
		uStaff.setLayout(new GridLayout(0,2));
		uStaff.add(lblStaff); uStaff.add(new JLabel(""));
		uStaff.add(lblStaff_Title); uStaff.add(combStaff_Title);
		uStaff.add(lblStaff_First_Name); uStaff.add(txtStaff_First_Name);
		uStaff.add(lblStaff_Surname); uStaff.add(txtStaff_Surname);
		uStaff.add(lblStaff_DOB); uStaff.add(txtStaff_DOB);
		uStaff.add(lblStaff_Gender); uStaff.add(combStaff_Gender);
		uStaff.add(lblStaff_Address); uStaff.add(txtStaff_Address);
		uStaff.add(lblStaff_Postcode); uStaff.add(txtStaff_Postcode);
		uStaff.add(lblStaff_Tele); uStaff.add(txtStaff_Tele);
		uStaff.add(lblStaff_Email); uStaff.add(txtStaff_Email);
		uStaff.add(lblStaff_Status); uStaff.add(combStaff_Status);
		uStaff.add(lblStaff_Unit_ID); uStaff.add(combStaff_Unit_ID);
		uStaff.add(lblStaff_Bank_Name); uStaff.add(txtStaff_Bank_Name);
		uStaff.add(lblStaff_Bank_Acc); uStaff.add(txtStaff_Bank_Acc);
		uStaff.add(lblStaff_Password); uStaff.add(txtStaff_Password);
		uStaff.add(new JLabel("")); uStaff.add(btnStaff);
		
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
		con_Panel.setLayout(new GridLayout(0,2));
		con_Panel.add(uStaff); con_Panel.add(uStudent);
		c.fill=GridBagConstraints.BOTH;
		c.gridx = 1;
		c.ipadx = 1;
		c.gridy = 2;
		c.ipady = 1;
		c.anchor = GridBagConstraints.LINE_START;
		con.add(con_Panel, c);
		
		c.fill=GridBagConstraints.BOTH;
		c.gridx = 3;
		c.ipadx = 1;
		c.gridy = 3;
		c.ipady = 1;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		con.add(btnBack, c);
		
    	uStaff.setVisible(false);
    	uStudent.setVisible(false);
		
        rbtnStaff.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){

            	AllClient.message = "";
            	
            	AllClient.sendData("StaffList,2");
            	try {
            		AllClient.message = ( String ) AllClient.input.readObject(); 
               		}//end of try
     	     	 catch (IOException | ClassNotFoundException classNotFoundException)  
     	     	 {    
     	     		 System.out.println( "\n?Cant pre-load the units for staff" ); 
     	     	 }

            	String[] splitMessage = AllClient.message.split(","); 
            	combStaff_Unit_ID.removeAllItems();
            	 int x=0;
            	 combStaff_Unit_ID.addItem("None");
            	 while (x<splitMessage.length)
            	 {
            		 System.out.println(splitMessage[x]+" element");
            		 combStaff_Unit_ID.addItem(splitMessage[x]);
            		 x++;
            	  } 
            	
            	 uStaff.setVisible(true);
            	 
            	combStaff_Title.setSelectedIndex(0); combStaff_Gender.setSelectedIndex(0); 
            	combStaff_Status.setSelectedIndex(0); combStaff_Unit_ID.setSelectedIndex(0);
            	txtStaff_First_Name.setText(""); txtStaff_Surname.setText(""); 
            	txtStaff_DOB.setText(""); txtStaff_Address.setText(""); 
            	txtStaff_Postcode.setText(""); txtStaff_Tele.setText(""); 
            	txtStaff_Email.setText(""); txtStaff_Password.setText("");
            	
            	uStudent.setVisible(false);
            	
            }
           
        });
		
        rbtnStudent.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	
            	AllClient.sendData("StudentListCourses-onload,2");
            	
            	try  
            	{
               		AllClient.message = ( String ) AllClient.input.readObject(); 		
                }//end of try
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
                	 System.out.println("Something went wrong-can't pre load the course list :( ");
                 }
            	 
            	uStaff.setVisible(false);
            	
            	combStaff_Gender.setSelectedIndex(0); combStudent_CourseID.setSelectedIndex(0);
            	combStudent_Year_Study.setSelectedIndex(0);
            	txtStudent_First_Name.setText(""); txtStudent_Surname.setText(""); 
            	txtStudent_DOB.setText(""); txtStudent_Address.setText(""); 
            	txtStudent_Postcode.setText(""); txtStudent_Tele.setText("");
            	txtStudent_Email.setText(""); txtStudent_Bank_Acc.setText("");
            	txtStudent_Bank_Name.setText(""); txtStudent_Password.setText("");
            	
            	uStudent.setVisible(true);
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
				
				//no telephone- nedd to be course
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
	    	            			+ "Your Username is your First Name\n"
	    	            			+ "and you Password is your Password\n"
	    	            			+ "Have a Nice Day :)",
	    	            			"Important Message!",
	    	            			JOptionPane.INFORMATION_MESSAGE);
	               			//how to get the username and password?
	               			setVisible(false);
	               			Admin_GUI admin=new Admin_GUI(); 
	               			admin.setVisible(true);
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
        	     	 catch (   IOException | ClassNotFoundException classNotFoundException   )  
        	     	 {    
        	     		 System.out.println( "\n?" ); 
        	     	 } 
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
        
        btnStaff.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	int int_staff_name = txtStaff_First_Name.getText().length();
            	int int_staff_surname = txtStaff_Surname.getText().length();
            	int int_staff_dob = txtStaff_DOB.getText().length();
            	int int_staff_address = txtStaff_Address.getText().length();
            	int int_staff_postcode = txtStaff_Postcode.getText().length();
            	int int_staff_tele = txtStaff_Tele.getText().length();
            	int int_staff_email = txtStaff_Email.getText().length();
            	int int_staff_bank_name = txtStaff_Bank_Name.getText().length();
            	int int_staff_bank_acc = txtStaff_Bank_Acc.getText().length();
            	int int_staff_password = txtStaff_Password.getText().length();
            	
				if(combStaff_Title.getSelectedIndex() == 0 || int_staff_name <= 0 
					|| int_staff_surname <= 0 || int_staff_dob <= 0
					|| combStaff_Gender.getSelectedIndex()==0 || int_staff_address <= 0
					|| int_staff_postcode <= 0 || int_staff_tele <= 0 || int_staff_email <= 0
					|| combStaff_Status.getSelectedIndex()==0 || combStaff_Unit_ID.getSelectedIndex()==0
					|| int_staff_bank_name <= 0 || int_staff_bank_acc <= 0
					|| int_staff_password <= 0){
	            	//custom title, error icon
	            	JOptionPane.showMessageDialog(con,
	            			"Please fill in all the text fields with RED STAR symbol\n"
	            			+ "Thank You",
	            			"Warning",
	            			JOptionPane.WARNING_MESSAGE);
	            	//if (txtStaff_First_Name.getText()==NULL   )
				}
				else
				{
					String staff_account_holder= txtStaff_First_Name.getText()+" "+txtStaff_Surname.getText();
					AllClient.sendData("StaffRegister,2,"+combStaff_Title.getSelectedItem()+","
										+txtStaff_First_Name.getText()+","+txtStaff_Surname.getText()+","
										+txtStaff_DOB.getText()+","+combStaff_Gender.getSelectedItem()+","+txtStaff_Address.getText()+","
										+txtStaff_Postcode.getText()+","+txtStaff_Tele.getText()+","+txtStaff_Email.getText()+","
										+txtStaff_Bank_Acc.getText() +","+ combStaff_Status.getSelectedItem()+","+combStaff_Unit_ID.getSelectedItem()+","
										+txtStaff_Password.getText()+","+txtStaff_Bank_Name.getText()+","+staff_account_holder);//add staff not student bank fields!
	            	//bank is 14 [15]
					//pass is 13 :)
					try 
					{                                                                      
						AllClient.message = ( String ) AllClient.input.readObject(); 	
	               	//	splitsMessage[11]+"','"+splitsMessage[15]+"','"+splitsMessage[16]+"');");//all string [11] it is 12 element
	               		//put answer into new course list
	            	}catch(IOException | ClassNotFoundException classNotFoundException)  
	            	{    
	            		System.out.println( "\n?" ); 
	            	} 
	
	               		if (AllClient.message.equals("Done"))
	               		{  
	               			JOptionPane.showMessageDialog(con,
	    	            			"Thank you for Registration.\n"
	    	            			+ "Your Username is your First Name\n"
	    	            			+ "and you Password is your Password\n"
	    	            			+ "Have a Nice Day :)",
	    	            			"Important Message!",
	    	            			JOptionPane.INFORMATION_MESSAGE);
	               			//how to get the user-name and password?
	               		
	    	        		setVisible(false);
	    	        		Admin_GUI admin=new Admin_GUI(); 
	    	        		admin.setVisible(true);
	               		}
				}
            }
        });
        
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
        		setVisible(false);
        		Admin_GUI admin=new Admin_GUI(); 
        		admin.setVisible(true);
            }
        });
		
		pack();
		setSize(1050,525);
		setLocation(125,100);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
