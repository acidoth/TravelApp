package main;

/**
 * Created with IntelliJ IDEA.
 * User: chaamini
 * Date: 8/14/13
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Customer {

    protected String name ;
    protected String destinationFrom;
    protected String destinationTo;
    protected String date;
    protected String hotelName ;
    protected String stayInHotel ;

    public Customer(String name, String destinationFrom,String destinationTo, String date, String hotelName, String  stayInHotel) {
       this.name = name;
       this.destinationFrom = destinationFrom ;
       this.destinationTo = destinationTo;
       this.date = date;
       this.hotelName = hotelName;
       this.stayInHotel = stayInHotel;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDestinationFrom(String destinationFrom){
        this.destinationFrom = destinationFrom;

    }

    public void setDestinationTo(String destinationTo){
        this.destinationTo= destinationTo;
    }

    public void setDate(String date){
        this.date=date;
    }

    public void setHotelName (String hotelName){
        this.hotelName=hotelName;
    }

    public void setStayInHotel(String stayInHotel){
        this.stayInHotel = stayInHotel;
    }


   public String getName(){
       return name;
   }

   public String getDestinationFrom(){
       return destinationFrom;
   }

   public String getDestinationTo(){
       return  destinationTo;
   }

   public String getDate(){
        return date;
   }

   public String getHotelName(){
       return hotelName;
   }

   public String getStayInHotel(){
       return stayInHotel;
   }
}
