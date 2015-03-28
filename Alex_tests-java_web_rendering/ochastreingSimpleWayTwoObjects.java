
/**
 * Write a description of class ochastreingSimpleWay here.
 * HolidaySimpleWay
 * @author Alexander Drabek
 * @version 0.1
 * 
 * 
 * 
 * 
 */
public class ochastreingSimpleWayTwoObjects 
{


    public ochastreingSimpleWayTwoObjects()
    {
      //empty  
      
    }

    public static void main(String [] args)
    
    {
        System.out.println("Hello in week14...");//Sometimes i like to just print some text when starting.
        //It helps with "where is my program" problem which i can not even classify as an error. 
        
    //Declaring objects.
      HolidaySimpleWay object1= new HolidaySimpleWay();
      HolidaySimpleWay object2= new HolidaySimpleWay();
    //object1 parameters
      object1.setPlace("Katowice");
      object1.setPrice("1000");
      object1.setStartYear("2012");
      object1.setStartMonth("1");
      object1.setStartDay("20");
      object1.setEndYear("2012");
      object1.setEndMonth("2");
      object1.setEndDay("20");
      
    //object2 parameters
     object2.setPlace("Sirilanka");
      object2.setPrice("9999000");
      object2.setStartYear("2012");
      object2.setStartMonth("4");
      object2.setStartDay("20");
      object2.setEndYear("2012");
      object2.setEndMonth("6");
      object2.setEndDay("19");
        System.out.println("object1");
    System.out.println(object1.showAllData());
      System.out.println("object2");
      System.out.println(object2.showAllData());
     System.out.println(object1.equals(object2));//comparing data 
    System.out.println("I am making objects equal");
     object1=object2;//making objects to show true as they should be equal
      System.out.println("Now I am running a test to see if they are equal");
     System.out.println(object1.equals(object2));
    }
}
