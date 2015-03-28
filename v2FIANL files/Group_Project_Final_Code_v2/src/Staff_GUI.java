import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.sql.*;

import Client_and_Server_Package.*;

public class Staff_GUI extends JFrame {
	
	Container con;
	
	public String getGrades [][];
	public String getStaffStudents [][];
	public String[] [] updateTable;

	JLabel lblWelcome = new JLabel("Welcome Staff");
	
	JButton btnView = new JButton("View");
	JButton btnUpdate = new JButton("Update");
	JButton btnLogout = new JButton("Logout");
	
	JTextField txtstatus = new JTextField(30);
	
	final JTable table;
	
	Object message1;
	
	Object[] possibilities = {"None", "Grades", "Students Info"};
	
	static int viewRow;
	static int modelRow;
	public String tableName = "";
     
    static AllClient allclient = new AllClient();
    
	int row;
	int col;
    
	public Staff_GUI() throws Exception{
		super ("Staff");
		
		lblWelcome.setFont(new Font("Arial", Font.BOLD,24));
			
		con = getContentPane();
		con.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JPanel top = new JPanel();
		top.add(lblWelcome); top.add(new JLabel("                                                                                                                                                                                                        ")); top.add(btnView); top.add(btnUpdate); top.add(btnLogout);
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
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {
                        
                    	viewRow = table.getSelectedRow();
                    	
                    	this.setSelectedRow(viewRow);
                    	
                        if (viewRow < 0) {
                            //Selection got filtered away.
                            txtstatus.setText("");
                        } else {
                        	
                            modelRow = table.convertRowIndexToModel(viewRow);
                            
                            this.setModelRow(modelRow);
                            txtstatus.setText(
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
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.enable(false);
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(table);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        textPanel.add(scroll, BorderLayout.CENTER);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.ipadx = 800;
		c.gridy = 1;
		c.ipady = 460;
		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
		con.add(textPanel, c);
		
		JPanel bottom = new JPanel();
		bottom.add(new JLabel("Status"), BorderLayout.WEST); bottom.add(txtstatus);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.ipadx = 5;
		c.gridy = 2;
		c.ipady = 5;
		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
		con.add(bottom, c);
		
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
					// Option 1: View Grades
					else if (options == possibilities[1]){
						try{
							getGrades = allclient.getStaffGrades();							
							
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
						table.setModel(new DefaultTableModel(getGrades,gradeHeader));
						tableName = "results_table";
						table.enable(true);
					}
					// Option 2: View Student Info
					else if (options == possibilities[2]){
						try{
							getStaffStudents = allclient.getStaffStudent();

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
						table.setModel(new DefaultTableModel(getStaffStudents,studentHeader));
						tableName = "students";
					}
				}catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Couldn't get list data");
					e1.printStackTrace();
				}		
			}
        });
        
        btnUpdate.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	
            	col= table.getColumnCount();            			 
    			row=table.getRowCount(); 
    			
    			updateTable = new String [row][col];
    			
            	for(int i = 0; i < row; i++)
            	{
            		for(int x = 0; x < col; x++)
            		{
            			updateTable[i][x] = (String) table.getValueAt(i, x);
            		}
            	}
            	allclient.sendUpdateData(tableName,updateTable);

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
		setSize(1025,600);
		setLocation(125,150);
		setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

