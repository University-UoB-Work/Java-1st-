/**
 * I understand "this" and I am using it properly.
 * It is not the same variable!
 * 
 * 
 * 
 * 
 */

public class HolidaySimpleWay {
    private String startYear;
    private String startMonth;
    private String startDay;
    private String endYear;
    private String endMonth;
    private String endDay;//date will be presented dd-mm-yyyy or similar-(collection of variable)
    private String price;//prefer to declare as int and create a second variable to carry currency.
    private String place;
     

    public HolidaySimpleWay() 
    
    {
       //private String startYear;
       //default data, not so important
      startMonth="1";
      startDay="1";
      startYear="2013";//should be set to current year.
      endYear="2013";
      endMonth="12";
      endDay="28";//because of February, normally i would put 30/31
      price="0";
      place="Home";
    
    }
       
    public void setPlace(String place) {
        this.place = place; //this method is for setting a place where user2 want to spend holidays
    }
     public String getPlace() {
       return place;
    }
    
     public void setPrice(String price) {
        this.price = price;
    }
     public String getPrice() {
       return price;
    }
    
    public void setStartYear(String startYear ) {
        this.startYear = startYear;
    }
    public String getStartYear() {
       return startYear;
    }
    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;

     }
     public String getStartMonth() {
      return startMonth;
    }
  
    public void setStartDay(String startDay) {
        this.startDay = startDay;
        }
        
    public String getStartDay() {
       return startDay;
    }
      
     public void setEndYear(String endYear ) {
        this.endYear = endYear; 
    }
    public String getEndYear() {
       return endYear;
     }
  
    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
        }    
     public String getEndMonth() {
       return endMonth;
    }
  
    public void setEndDay(String endDay) {
         this.endDay = endDay;    
         }
    public String getEndDay() {
       return endDay;
     }
     
    public boolean equals(HolidaySimpleWay obj)// parameter will be an object of HolidaySimpleWay
    {
        //I will compare all things to assure that object is the same
        //I used && which means short evaluating circuit so long code doesn't matter.
        boolean theSame = false;//variable which return 
        if (this.getClass() == obj.getClass())//
        {
           //if whole start date match ->proceed to asses the end date if it also match-> proceed to asses the place and the price 
            HolidaySimpleWay innerObject = (HolidaySimpleWay) obj;
            if ((innerObject.getStartDay()).equals(this.getStartDay()) && (innerObject.getStartMonth()).equals(this.getStartMonth()) && (innerObject.getStartYear()).equals(this.getStartYear()))
               if ( (innerObject.getEndDay()).equals(this.getEndDay()) && (innerObject.getEndMonth()).equals(this.getEndMonth()) && (innerObject.getEndYear()).equals(this.getEndYear()))
               if ((innerObject.getPlace()).equals(this.getPlace())   && (innerObject.getPrice()).equals(this.getPrice()) )
            {
               theSame = true;//finally I can admit that this objects are equal.
            }
        }
        return theSame;//returning state -false mean objects are not the same.
    }


    public String showAllData()
    {
    return ("Holiday will start on : "+ getStartDay()+"-"+getStartMonth()+"-"+getStartYear()+" and end on : "+ getEndDay()+"-"+ getEndMonth()+"-"+getEndYear()+"\n The holiday will took place at "+ getPlace()+" whole cost will be "+getPrice() );
    }
}