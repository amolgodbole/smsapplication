

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @author   Amol Godbole
 *
 */
public class CalendarUtility
{
	/**
     * accepts the date in string format and converts it into a Calendar
     * object and returns it
     * @param args: String Date
     * @return: Calendar Object
     * @throws ParseException
     */

    public static Calendar getCalendarFromString(String date) throws Exception  {

          /* Instantiated simple date format object and specified the pattern */

          SimpleDateFormat simpleDate=new SimpleDateFormat("dd-MMM-yyyy");
          Date dateReference=null;

          /* parse method returns the Java.Util.Date object corresponding to
           * the String date */

          dateReference = simpleDate.parse(date);

          /* Calendar object instantiated and setTime method sets the calendar
           * time with the date passed */

          Calendar calendar=Calendar.getInstance();
          calendar.setTime(dateReference);

          /* the set calendar object is returned */

          return calendar;
    }

    /**
     * accepts the Calendar object and return the date in String
     * format
     * @param args: Calendar calendar- calendar object that needs to returned in string format
     * @return: String- date in string format
     */
    public String getStringFromCalendar(Calendar calendar) throws Exception
    {

          /* Declaration of variables   */

          Date date=null;
          SimpleDateFormat simpleDate=new SimpleDateFormat("dd-MMM-yyyy");

          /* Getting Date from the calendar object and using format method for retrieval of
           * date in text format */

          date=calendar.getTime();
          
          
          String textDate=simpleDate.format(date);


          /* the string date is returned */

          return textDate;
    }


/*<<<<<<< .mine
     To check the module 
    public static void main(String args[]){
          CalendarUtility calendarUtility=new CalendarUtility();
          Calendar calendar = null;
          try {
        	  String date1="15-May-2009";
                calendar = calendarUtility.getCalendarFromString(date1);
                String date=calendarUtility.getStringFromCalendar(calendar);
                System.out.println(date);
                
                Time tm = new Time(System.currentTimeMillis());
    			tm.getTime();
    			System.out.println(""+tm.getHours());
    			
          }
=======
>>>>>>> .r60*/

}


