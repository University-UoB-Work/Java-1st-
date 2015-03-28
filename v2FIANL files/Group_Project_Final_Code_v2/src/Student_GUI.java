import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

import Client_and_Server_Package.AllClient;

public class Student_GUI extends JFrame {
	Container con;
	
	public String getStudentGrades [][];
	public String getStudentCourse [][];
	public String[] [] updateTable;
	
	JLabel lblWelcome = new JLabel("Welcome Student");
	
	JButton btnView = new JButton("View");
	JButton btnLogout = new JButton("Logout");
	
	JTable table;
	
	Object[] possibilities = {"None", "View Grades", "View Courses"};
	
	static AllClient allclient = new AllClient();
	
	static int viewRow;
	static int modelRow;
	public String studentName = "";
	
	public Student_GUI(){
		super ("Student");
			
		lblWelcome.setFont(new Font("Arial", Font.BOLD,24));
			
		con = getContentPane();
		con.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JPanel top = new JPanel();
		top.add(lblWelcome); top.add(new JLabel("                                                                                                                                                                                                                             ")); top.add(btnView); top.add(btnLogout);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.ipadx = 0;
		c.gridy = 0;
		c.ipady = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
		con.add(top, c);
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(0,1));
		table = new JTable();
	    table.setPreferredScrollableViewportSize(new Dimension(500, 70));
	    table.setFillsViewportHeight(true);
	    table.setAutoCreateRowSorter(true);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table.enable(false);
	    JScrollPane scroll = new JScrollPane();
	    scroll.setViewportView(table);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	    textPanel.add(scroll, BorderLayout.CENTER);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.ipadx = 1000;
		c.gridy = 1;
		c.ipady = 500;
		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
		con.add(textPanel, c);
		
		btnView.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){

					System.out.println("Connection was successful");					
			try {
						
					String options = (String)JOptionPane.showInputDialog(
							con,
		                    "What you want to View?",
		                    "View",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    possibilities,
		                    "None");
					if(options == possibilities[0]){
						JOptionPane.showMessageDialog(con,
							    "You selected " + possibilities[0]
							    + "\nNo actions will be taken",
							    "Message",
							    JOptionPane.WARNING_MESSAGE);
					}
					//Option 1: View View Grades
					else if (options == possibilities[1]){
						String name = JOptionPane.showInputDialog(con,
								"Enter your Student ID down below",
								"Message",
								JOptionPane.DEFAULT_OPTION);
						studentName = name;
						
						try{
							getStudentGrades = allclient.getStudentGrades(studentName);

							}catch (SQLException e1) {
								// TODO Auto-generated catch block
								System.out.println("Couldn't get list data");
								e1.printStackTrace();
							}
						String [] gradeHeader = new String[5];
						gradeHeader[0] = ("ID");
						gradeHeader[1] = ("Student ID");
						gradeHeader[2] = ("Course ID");
						gradeHeader[3] = ("Unit ID");
						gradeHeader[4] = ("Grade");
						table.setModel(new DefaultTableModel(getStudentGrades,gradeHeader));
					}
					// Option 2: View Courses
					else if (options == possibilities[2]){
						try{
							getStudentCourse = allclient.getStudentCourse();

							}catch (SQLException e1) {
								// TODO Auto-generated catch block
								System.out.println("Couldn't get list data");
								e1.printStackTrace();
							}
						String [] gradeHeader = new String[10];
						gradeHeader[0] = ("Course ID");
						gradeHeader[1] = ("Course Name");
						gradeHeader[2] = ("Num. of Units");
						gradeHeader[3] = ("Start Data");
						gradeHeader[4] = ("End Date");
						gradeHeader[5] = ("Course Type");
						gradeHeader[6] = ("Unit 1");
						gradeHeader[7] = ("Unit 2");
						gradeHeader[8] = ("Unit 3");
						gradeHeader[9] = ("Unit 4");
						table.setModel(new DefaultTableModel(getStudentCourse,gradeHeader));
					}
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("Couldn't get list data");
				e1.printStackTrace();
			}		
		}			
       });
		
        btnLogout.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
        		setVisible(false);
        		Login_GUI log=new Login_GUI(); 
        		log.setVisible(true);
            }
        });
		
		pack();
		setSize(1040,630);
		setLocation(125,150);
		setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
