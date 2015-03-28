import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.Desktop;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class ochastreingSimpleWay here.
 * HolidaySimpleWay
 * @Alexander Drabek
 * @version (a version number or a date)
 */
public class ochastreingSimpleWayTwoObjectsGUI  extends JFrame
{
//declaring labels and fields.
//declaring other parameters(place and price) labels +fields
JTextField  place;//declaring text field for place of holiday,rest in the same way
JLabel placeLabel;//declaring Label for place of holiday,rest in the same way
JTextField  price;
JLabel priceLabel;
//start dates and labels
JTextField  startDay;
JLabel startDayLabel;
JTextField  startMonth;
JLabel startMonthLabel;
JTextField startYear;
JLabel startYearLabel;
//ending dates and labels
JTextField  endDay;
JLabel endDayLabel;
JTextField  endMonth;
JLabel endMonthLabel;
JTextField  endYear;
JLabel endYearLabel;
//declaring objects
HolidaySimpleWay object1,object2;

    public ochastreingSimpleWayTwoObjectsGUI()
    {
        super();
        // get the container object
        Container containerOne = getContentPane();
        // set the layout of the container object
       containerOne.setLayout(new GridLayout(10,2));
        // initializing  labels and text fields
      place= new JTextField();
      placeLabel= new JLabel("Type place of your holiday");
      price= new JTextField();
      priceLabel= new JLabel("Type price of your holiday");
      startDay= new JTextField();
      startDayLabel= new JLabel(" Start day of your holiday");
      startMonth= new JTextField();
      startMonthLabel= new JLabel("Start month of your holiday");
      startYear= new JTextField();
      startYearLabel= new JLabel("Start year of your holiday");
      endDay= new JTextField();
      endDayLabel= new JLabel("Finishing day of your holiday");
      endMonth= new JTextField();
      endMonthLabel= new JLabel("Finishing  month of your holiday");
      endYear= new JTextField();
      endYearLabel= new JLabel("Finishing year of your holiday");

      JButton creation1=new JButton("Create 1st Object.");
      JButton creation2=new JButton("Create 2nd Object.");
      JButton comparision=new JButton("Compare Objects.");
     //Adding to GUI Label + text field for each attribute of object
         containerOne.add(startDayLabel);
          containerOne.add(startDay);
         containerOne.add(startMonthLabel);
          containerOne.add(startMonth);
          containerOne.add(startYearLabel);
          containerOne.add(startYear);
           containerOne.add(endDayLabel);
          containerOne.add(endDay);
          containerOne.add(endMonthLabel);
          containerOne.add(endMonth);
           containerOne.add(endYearLabel);
          containerOne.add(endYear);
          containerOne.add(placeLabel);
          containerOne.add(place);
          containerOne.add(priceLabel);
          containerOne.add(price);
   
          //Adding to GUI buttons      
          containerOne.add(creation1);
          containerOne.add(creation2);
          containerOne.add(comparision);
    //actions for buttons
    
    //action for Button which compare two objects
      comparision.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
               
try {
     String url = "http://www.google.com";
     java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
} catch (java.io.IOException ex) {
     System.out.println(ex.getMessage());
}
                if(object1.equals(object2)){
                  System.out.println("Objects are equal");
                                   }
                   else
                    System.out.println("Objects are different");
            }
        });
        
       //actions for button which create first object
      creation1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                
                
                            //Declaring objects.
                object1= new HolidaySimpleWay();
                 //HolidaySimpleWay object2= new HolidaySimpleWay();
                 //object1 parameters
                object1.setPlace(place.getText());
                object1.setPrice(price.getText());
                object1.setStartYear(startYear.getText());
                object1.setStartMonth(startMonth.getText());
                object1.setStartDay(startDay.getText());
                object1.setEndYear(endYear.getText());
                object1.setEndMonth(endMonth.getText());
                object1.setEndDay(endDay.getText());
                    System.out.println(object1.showAllData());
            }
        });
        //actions for button which create second object
        creation2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
                  //Declaring objects.
                   object2= new HolidaySimpleWay();         
                 //setting object2 parameters
                object2.setPlace(place.getText());
                object2.setPrice(price.getText());
                object2.setStartYear(startYear.getText());
                object2.setStartMonth(startMonth.getText());
                object2.setStartDay(startDay.getText());
                object2.setEndYear(endYear.getText());
                object2.setEndMonth(endMonth.getText());
                object2.setEndDay(endDay.getText());
                    System.out.println(object2.showAllData());//show data of object

            }
      }); 
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        // Causes this Window to be sized to fit the preferred size
        // and layouts of its subcomponents
        setBackground(Color.black);
        pack();
      setVisible(true);// shows the window
    }

    public static void main(String [] args)
    {
      System.out.println("If you want to have different values in second Object ,change actual fields.");     
      JWebPane browser = new JWebPane();
new JFrame("Browser").add(browser);
browser.load(someURL);
      ochastreingSimpleWayTwoObjectsGUI  ochastreing1 = new  ochastreingSimpleWayTwoObjectsGUI();//create a GUI
    }
}
