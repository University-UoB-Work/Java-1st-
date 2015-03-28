/**
 * Write a description of class Premier here.
 * 
 * @Alexander Drabek
 * @version 1.0
 */
public class Premier extends HolidaySimpleWay//subclass of HolidaySimpleWay
{
    // instance variables
    private String hotelName;
    private String hotelGrade;
    private String resortName;
    public Premier()
    {
        super();
        hotelName="";//we don't know  the value yet so ""
        hotelGrade="";//we don't know the value yet so ""
        resortName="";//we don't know the value yet so ""
    }
    public void setHotelName( String hotelName)
         {
             this.hotelName= hotelName;
             //i am aware that this.hotelName it is not the same variable as hotelName
             //for me it is more clear in this way .
            }
            
    public void setHotelGrade( String hotelGrade)
            {
             this.hotelGrade= hotelGrade;
            }
    public void setResortName( String resortName)
            {
             this.resortName= resortName;
            }
    public String getHotelName(){
        return hotelName;
             }
    public String getHotelGrade(){
             return hotelGrade;
             }
    public String getResortName(){
            return resortName;
             }    
    public boolean equals(HolidaySimpleWay obj)// parameter will be an object of HolidaySimpleWay
    {
        //I will compare all things to assure that object is the same
        //I used && which means short evaluating circuit so long code doesn't matter.
        boolean theSame = false;//variable which return 
        if (this.getClass() == obj.getClass())//
        {
           //if whole start date match ->proceed to asses the end date if it also match-> proceed to asses the place and the price 
            Premier innerObject = (Premier) obj;
            if ((innerObject.getStartDay()).equals(this.getStartDay()) && (innerObject.getStartMonth()).equals(this.getStartMonth()) && (innerObject.getStartYear()).equals(this.getStartYear()))
               if ( (innerObject.getEndDay()).equals(this.getEndDay()) && (innerObject.getEndMonth()).equals(this.getEndMonth()) && (innerObject.getEndYear()).equals(this.getEndYear()))
               if ((innerObject.getPlace()).equals(this.getPlace())   && (innerObject.getPrice()).equals(this.getPrice()) )
               if((innerObject.getHotelName()).equals(this.getHotelName())   && (innerObject.getHotelGrade()).equals(this.getHotelGrade())  && (innerObject.getResortName()).equals(this.getResortName())  )
            {
               theSame = true;//finally I can admit that this objects are equal.
            }
        }
        return theSame;//returning state -false mean objects are not the same.
    }
            //i had showAllDataPremier and showAllDataHoliday() but now i changed to the same name and let overriding working.
            public String showAllData(){
                    return (super.showAllData()+".\n The hotel name is "+getHotelName()+" and it grade is "+getHotelGrade()+" .The hotel is placed in  "+ getResortName());
            }
}
