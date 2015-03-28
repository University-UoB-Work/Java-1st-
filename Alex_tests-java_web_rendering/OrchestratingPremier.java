
/**
 * Write a description of class OrchestratingPremier here.
 * 
 * @Alexander Drabek) 
 * @version 1.0
 */
public class OrchestratingPremier
{

    public OrchestratingPremier()
    {
    }

   public static void main(String [] args)
    
    {
        /*
         * I will create two objects with hard-coded different data.
         * In the bottom I am assessing that object1 is the same as object 2 and compare .
         * So the program must admit that objects are equal if the method equal is well written.
         */
        
        System.out.println("Hello in Orchestrating Class");//just to open terminal before operations.
        
      Premier object1= new Premier();//1st object of class premier
      object1.setPlace("Katowice");
      object1.setPrice("1000");
      object1.setStartYear("2012");
      object1.setStartMonth("1");
      object1.setStartDay("20");
      object1.setEndYear("2012");
      object1.setEndMonth("2");
      object1.setEndDay("20");
      
      object1.setHotelName("Alex's Hotel");
      object1.setHotelGrade("5");
      object1.setResortName("Alex Resort");
      System.out.println("Object1 of a class Premier");
      System.out.println(object1.showAllData());
      
          Premier object2= new Premier();
      object2.setPlace("Luton");
      object2.setPrice("50");
      object2.setStartYear("2013");
      object2.setStartMonth("3");
      object2.setStartDay("20");
      object2.setEndYear("2013");
      object2.setEndMonth("4");
      object2.setEndDay("20");
      
      object2.setHotelName("Easy Hotel");
      object2.setHotelGrade("2");
      object2.setResortName("Bedfordshire");
      System.out.println("Object2 of a class Premier");//with following line which show all data of objects it is like a label.
      System.out.println(object2.showAllData());
        System.out.println("Comparing....");
        
        if(object1.equals(object2)){
                  System.out.println("Objects are equal");
                                   }
                   else
                    System.out.println("Objects are different");
        System.out.println("Ok lets try  with two the same objects but now they contain the same data");             
      object1=object2;//making object the same

      
      if(object1.equals(object2)){
                  System.out.println("Objects are equal");
                                   }
                   else
                    System.out.println("Objects are different");
      
    }
}
