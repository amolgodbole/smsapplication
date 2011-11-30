
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;


public class ClockInstance1 

{
	
	/*Time time = new Time(System.currentTimeMillis());
	 CalendarUtility calUtil = new CalendarUtility();
	 Calendar cal = Calendar.getInstance();
	 DateFormat dateFromat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 Date date = new Date();
	 dateFormat.
	 System.out.println(.f);*/
	 
	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   Date date = new Date();
	   //System.out.println(dateFormat.format(date));
	   GregorianCalendar cal1;
	   
	   int year = cal1.get(Calendar.YEAR); 
	   int week = cal1.get(Calendar.WEEK_OF_YEAR);
	   int dayOfMonth = cal1.get(Calendar.DAY_OF_MONTH);
	   
	   

	   //get current date time with Calendar()
	   Calendar cal = Calendar.getInstance();
	   //System.out.println(dateFormat.format(cal.getTime()));
	
	public ClockInstance1() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * IF CLOCK TIME IS VALID then CALL the FUNCTION:
	 * 
	 * processChangeStateAtValidTime(true)
	 */
	
	public static boolean checkTimevalidity()
	{
		return true;
		//LOGIC
		
	}
	boolean validity = true;
	
	InitializedState initializedState = new InitializedState();
	//initializedState.processChangeStateAtValidTime(validity);
	

}
