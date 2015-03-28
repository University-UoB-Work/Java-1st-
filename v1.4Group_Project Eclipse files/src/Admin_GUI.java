import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.net.*;
import java.sql.*;

import Client_and_Server_Package.AllClient;

public class Admin_GUI extends JFrame{
	Container con;
	
	public String getAStaff [][];
	public String getAStudent [][];
	public String[] [] updateTable;
	
	JLabel lblWelcome = new JLabel("Welcome Administrator");
	JLabel lblSpace = new JLabel(" ");
	
	JTextField txtStaffstatus = new JTextField(30);
	JTextField txtStudentstatus = new JTextField(30);
	
	JRadioButton rbtnStaff = new JRadioButton("View Staff Database");
	JRadioButton rbtnStudent = new JRadioButton("View Student Database");
	
	JButton btnStaff_View = new JButton("View");			
	JButton btnStaff_Update = new JButton("Update");
	
	JButton btnStudent_View = new JButton("View");
	JButton btnStudent_Update = new JButton("Update");
	
	JButton btnPHPAdmin = new JButton("PHPMyAdmin");
	JButton btnNew = new JButton("New");
	JButton btnLogout = new JButton("Logout");
	
	final static String STAFFPANEL = "STAFF";
	final static String STUDENTPANEL = "STUDENT";
	
	static AllClient allclient = new AllClient();
	
	String[] staffOptions = {"None","Add Row","Add Column"};
	String[] studentOptions = {"None","Add Row", "Add Column"};
	
	JTable staffTable;
	JTable studentTable;
	
	static int viewRow;
	static int modelRow;
	int row;
	int col;
	
	public String tableName = "";
	
	public Admin_GUI(){
		
		super("Admin");
		
		lblWelcome.setFont(new Font("Arial", Font.BOLD,24));
		
		con = getContentPane();
		con.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JPanel top = new JPanel();
		top.add(lblWelcome); top.add(new JLabel("                                                                                                                                                           ")); top.add(btnNew); top.add(btnPHPAdmin); top.add(btnLogout);
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
		
		
		JTabbedPane tabbedPane = new JTabbedPane();
		 
        //Create the "cards".
        JPanel cardStaff = new JPanel();
        cardStaff.setLayout(new BorderLayout());
        JPanel staff_buttons = new JPanel();
        staff_buttons.add(btnStaff_View);
        staff_buttons.add(btnStaff_Update);
        staff_buttons.add(new JLabel("Status")); 
        staff_buttons.add(txtStaffstatus); 
        cardStaff.add(staff_buttons, BorderLayout.PAGE_START);
        JPanel staffPanel = new JPanel();
        staffPanel.setLayout(new GridLayout(0,1));
        staffTable = new JTable();
        staffTable.setModel(new DefaultTableModel(0,0));
        staffTable.setPreferredScrollableViewportSize(new Dimension(400, 250));
        staffTable.setFillsViewportHeight(true);
        staffTable.setAutoCreateRowSorter(true);
        staffTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        staffTable.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {
                        
                    	viewRow = staffTable.getSelectedRow();
                    	
                    	this.setSelectedRow(viewRow);
                    	
                        if (viewRow < 0) {
                            //Selection got filtered away.
                            txtStaffstatus.setText("");
                        } else {
                        	
                            modelRow = staffTable.convertRowIndexToModel(viewRow);
                            
                            this.setModelRow(modelRow);
                            txtStaffstatus.setText(
                                String.format("Selected Row in view: %d. " +
                                    "Selected Row in model: %d.", 
                                    viewRow, modelRow));
                        }
                    }
                    public void setSelectedRow(int i)
                	{
                		viewRow = i; 
                	}
                	
                	public void setModelRow(int i)
                	{
                		modelRow = i; 
                	}
						
					}
                
        );
        staffTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane staffScroll = new JScrollPane();
        staffScroll.setViewportView(staffTable);
        staffScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        staffScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        staffPanel.add(staffScroll, BorderLayout.CENTER);
        cardStaff.add(staffPanel, BorderLayout.CENTER);
        
        
        JPanel cardStudent = new JPanel();
        cardStudent.setLayout(new BorderLayout());
        JPanel student_buttons = new JPanel();
        student_buttons.add(btnStudent_View);
        student_buttons.add(btnStudent_Update);
        student_buttons.add(new JLabel("Status")); 
        student_buttons.add(txtStudentstatus); 
        cardStudent.add(student_buttons, BorderLayout.PAGE_START);
        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new GridLayout(0,1));
        studentTable = new JTable();
        studentTable.setModel(new DefaultTableModel(0,0));
        studentTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        studentTable.setFillsViewportHeight(true);
        studentTable.setAutoCreateRowSorter(true);
        studentTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        studentTable.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {
                        
                    	viewRow = studentTable.getSelectedRow();
                    	
                    	this.setSelectedRow(viewRow);
                    	
                        if (viewRow < 0) {
                            //Selection got filtered away.
                        	txtStudentstatus.setText("");
                        } else {
                        	
                            modelRow = studentTable.convertRowIndexToModel(viewRow);
                            
                            this.setModelRow(modelRow);
                            txtStudentstatus.setText(
                                String.format("Selected Row in view: %d. " +
                                    "Selected Row in model: %d.", 
                                    viewRow, modelRow));
                        }
                    }
                    public void setSelectedRow(int i)
                	{
                		viewRow = i; 
                	}
                	
                	public void setModelRow(int i)
                	{
                		modelRow = i; 
                	}
						
					}
                
        );
        studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane studentScroll = new JScrollPane();
        studentScroll.setViewportView(studentTable);
        studentScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        studentScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        studentPanel.add(studentScroll, BorderLayout.CENTER);
        cardStudent.add(studentPanel, BorderLayout.CENTER);
        
        tabbedPane.addTab(STAFFPANEL, cardStaff);
        tabbedPane.addTab(STUDENTPANEL, cardStudent);
        
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.ipadx = 630;
        c.gridy = 5;
        c.ipady = 455;
        c.anchor = GridBagConstraints.LINE_START;
        con.add(tabbedPane, c);
		
        /**
         * STAFF BUTTONS
         */
		btnStaff_View.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){

					System.out.println("Connection was successful");					
					try {
						getAStaff = allclient.getAStaff();
						
						}catch (SQLException e1) {
							// TODO Auto-generated catch block
							System.out.println("Couldn't get list data");
							e1.printStackTrace();
						}
						String [] staffHeader = new String[14];
						staffHeader[0] = ("Staff ID");
						staffHeader[1] = ("Title");
						staffHeader[2] = ("First Name");
						staffHeader[3] = ("Surname");
						staffHeader[4] = ("Date of Birth");
						staffHeader[5] = ("Gender");
						staffHeader[6] = ("Address");
						staffHeader[7] = ("Postcode");
						staffHeader[8] = ("Tele. Num.");
						staffHeader[9] = ("E-mail");
						staffHeader[10] = ("Bank Acc.");
						staffHeader[11] = ("Status");
						staffHeader[12] = ("Unit ID");
						staffHeader[13] = ("Password");
						staffTable.setModel(new DefaultTableModel(getAStaff,staffHeader));
						tableName = "staff";
					}

        });

        btnStaff_Update.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	col= staffTable.getColumnCount();            			 
    			row=staffTable.getRowCount(); 
    			
    			updateTable = new String [row][col];
    			
            	for(int i = 0; i < row; i++)
            	{
            		for(int x = 0; x < col; x++)
            		{
            			updateTable[i][x] = (String) staffTable.getValueAt(i, x);
            		}
            	}
            	allclient.sendUpdateData(tableName,updateTable);
            }
        });
          
        /**
         * STUDENT BUTTONS
         */
		btnStudent_View.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	
					System.out.println("Connection was successful");					
					try {
						getAStudent = allclient.getAStudent();

						}catch (SQLException e1) {
							// TODO Auto-generated catch block
							System.out.println("Couldn't get list data");
							e1.printStackTrace();
						}
						String [] studentHeader = new String[13];
						studentHeader[0] = ("Student ID");
						studentHeader[1] = ("First Name");
						studentHeader[2] = ("Surname");
						studentHeader[3] = ("DOB");
						studentHeader[4] = ("Gender");
						studentHeader[5] = ("Address");
						studentHeader[6] = ("Postcode");
						studentHeader[7] = ("Course ID");
						studentHeader[8] = ("Tele. Num.");
						studentHeader[9] = ("E-mail");
						studentHeader[10] = ("Bank Acc.");
						studentHeader[11] = ("Year of Study");
						studentHeader[12] = ("Password");
						studentTable.setModel(new DefaultTableModel(getAStudent,studentHeader));
						tableName = "students";
					}
        });

        btnStudent_Update.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	col= studentTable.getColumnCount();            			 
    			row=studentTable.getRowCount(); 
    			
    			updateTable = new String [row][col];
    			
            	for(int i = 0; i < row; i++)
            	{
            		for(int x = 0; x < col; x++)
            		{
            			updateTable[i][x] = (String) studentTable.getValueAt(i, x);
            		}
            	}
            	allclient.sendUpdateData(tableName,updateTable);
            }
        });
        
        btnPHPAdmin.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            try {
            	String url1 = "https://10.1.63.200/webconfig/phpMyAdmin/index.php?db=test&table=Students&target=sql.php&token=f127e71e64b054660598fa3383bdda84";
   	         	Desktop.getDesktop().browse(URI.create(url1));
   	       		}
   	       catch (java.io.IOException e1) 
   	       {
   	           System.out.println(e1.getMessage());
   	       }
          }   
        });	      
        
        btnNew.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	setVisible(false);
            	Create_GUI create_gui = new Create_GUI();
            	create_gui.setVisible(true);
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
		setSize(1030,650);
		setLocation(125,150);
		setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
