
import java.sql.Time;
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
	/* MutualFundOrder mutualfundlist=new MutualFundOrder();
	 
	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   Date date = new Date();
	   //System.out.println(dateFormat.format(date));
	   GregorianCalendar cal1;*/
	   
	  /* int year = cal1.get(Calendar.YEAR); 
	   int week = cal1.get(Calendar.WEEK_OF_YEAR);
	   int dayOfMonth = cal1.get(Calendar.DAY_OF_MONTH);
	   static int time=4;
	   List<MutualFund> mutualfundlist1=new ArrayList<MutualFund>();
	   

	   //get current date time with Calendar()
	   Calendar cal = Calendar.getInstance();
	   //System.out.println(dateFormat.format(cal.getTime()));
*/	
	public ClockInstance1() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * IF CLOCK TIME IS VALID then CALL the FUNCTION:
	 * 
	 * processChangeStateAtValidTime(true)
	 */
	
	public boolean checkTimevalidity()
	{
		/*if (time==9)
		return false;
		else if(time==4)
			for (int i=0;i<mutualfundlist1.size();i++)
			{
				MutualFund mf=mutualfundlist1.get(i);
				mutualfundlist.calculate_NAV(mf);
				 
			}*/
		
		 Calendar now = Calendar.getInstance();
	       int hrs = now.get(Calendar.HOUR_OF_DAY);
	       int min = now.get(Calendar.MINUTE);
	       int sec = now.get(Calendar.SECOND);
	       
	       System.out.println("" +hrs);
	       if((hrs>8 && min>00 ) && (hrs<23 && min <60)){
	    	   return true;
	       }else if(hrs==4 && min==00){
	    	   
	    	   return false;
	       }
	   	   else{
	    	   return false;
	       }
		//return validity;
		
		//LOGIC 
		//am currently hard coding but thread will be monitoring the time
		
	}
	boolean validity = true;
	
	//InitializedState initializedState = new InitializedState();


public boolean checkTimevalidityMutualFunds()
{
	 Calendar now = Calendar.getInstance();
       int hrs = now.get(Calendar.HOUR_OF_DAY);
       int min = now.get(Calendar.MINUTE);
       int sec = now.get(Calendar.SECOND);
       
       //this timing should be 4.00pm
     if((hrs>8 && min>00 ) && (hrs<23 && min <60)){
    	   
    	   return true;
       }
   	   else{
    	   return false;
       }

}
}
