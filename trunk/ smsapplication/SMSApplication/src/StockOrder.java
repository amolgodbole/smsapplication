import java.sql.Time;


public class StockOrder extends OrderTMAAbstractClass implements StockOrderInterface{

	int orderID=0;
	String stockID="";
	double stockPrice=0;
	private DeleteStrategy ds;
	//ClockInstance1 clock=new ClockInstance1();

	OrderStateInterface initialized;
	OrderStateInterface active;
	OrderStateInterface deleted;
	OrderStateInterface completed;
	OrderStateInterface orderStateInterface;

	public StockOrder()
	{
		initialized 	= 	new InitializedState(this);
		active 			= 	new ActiveState(this);
		deleted 		= 	new DeletedState(this);
		completed 		= 	new CompletedState(this);
		orderStateInterface = initialized;
	}




	public void updateResult()
	{
		System.out.println("Update Result");
	}

	public OrderStateInterface getActiveState()
	{
		return active;
	}

	public OrderStateInterface getDeletedState()
	{
		return deleted;
	}


	public OrderStateInterface getCompletedState()
	{
		return completed;
	}
	public OrderStateInterface getInitializedState()
	{
		return initialized;
	}
	String type="";





	private DeleteStrategy setDeleteStrategy() {
		// TODO Auto-generated method stub
		//implementation of different delete strategy methods
		//based on the logic we implement.

		if (type=="customerdelete")
		{}//goto (CustomerDelete);
		if(type=="expired")
			//goto (Expired);
		{}
		if(type=="ordercompleted")
			//goto (OrderCompletionDelete);
		{}


		return ds;

	}

	@Override
	public void setState(OrderStateInterface state)
	{
		orderStateInterface = state;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String processOrder(OrderBean order)
	{
		String strReturn="false";
		/*Time time = new Time(System.currentTimeMillis());
time.getHours();*/
		//NEED TO IMPLEMENT DYNAMIC TIME USING FORMAT


		/*
		 * DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//get current date time with Date()
Date date = new Date();
System.out.println(dateFormat.format(date));
=======
		@SuppressWarnings("deprecation")
		@Override
		public String processOrder(OrderBean order) 
		{
			System.out.println("In stock order");
			String strReturn="false";


			if(ClockInstance1.checkTimevalidity())
			{
				System.out.println("Checking time validity of order");
				orderStateInterface = active;
				orderStateInterface.processActiveOrder(order);

			}

			else if(! ClockInstance1.checkTimevalidity())
			{
				strReturn = orderStateInterface.processInitializedOrder(order);
			}
			return stockID;



		}
>>>>>>> .r68

//get current date time with Calendar()
Calendar cal = Calendar.getInstance();
System.out.println(dateFormat.format(cal.getTime()));
		 */


			strReturn = orderStateInterface.processInitializedOrder(order);
		
		return stockID;



	}




	@Override
	public void processActiveOrder(OrderBean order) {
		orderStateInterface.processActiveOrder(order);
		
	}








	//void processOrder(orderID);



} 
