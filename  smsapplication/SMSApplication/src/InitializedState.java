import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class InitializedState implements OrderStateInterface
{
	private StockOrderInterface stockOrderInterface;
	List<OrderBean> initializedOrders = new ArrayList<OrderBean>();
	ClockInstance1 clock=new ClockInstance1();
	 InitializedState(StockOrderInterface stockOrder)
	{
		stockOrderInterface = stockOrder;
	}
		
		/*public String processOrder(OrderBean order) {
			// TODO Auto-generated method stub
			System.out.println("Order Initialized !!");
			stockOrderInterface.setState(stockOrderInterface.getActiveState());
			//st.setState(st.getActiveState());
			System.out.println("Process Order ");
			return "Order Initialized";
		}*/
	
	
		public InitializedState() {
		// TODO Auto-generated constructor stub
	}

		public void updateResult() {
			// TODO Auto-generated method stub
			stockOrderInterface.setState(stockOrderInterface.getCompletedState());	
		}

		@Override
		public String  processInitializedOrder(OrderBean order) 
		{

			System.out.println("Order Initialized !!");
			
			if(clock.checkTimevalidity())
			{
			stockOrderInterface.setState(stockOrderInterface.getActiveState());
			//st.setState(st.getActiveState());
			System.out.println("Changed State Call method InitializedOrder to ActiveOrder !");
			return "true: Changed State Call method InitializedOrder to ActiveOrder ";
			}
			else
			{
				initializedOrders.add(order);
				return "true: Order Initialized and is waiting for time to be valid";
			}
			
			
		}
		
		public void processChangeStateAtValidTime(boolean validity)
		{
			while(validity)
			{
				Iterator<OrderBean> orderIterator = initializedOrders.iterator();

				while(orderIterator.hasNext())
				{
					OrderBean order = orderIterator.next();
					processInitializedOrder(order);
				}
			}
		}

		@Override
		public String processActiveOrder(OrderBean order) {
			return "false: Incorrect process in Active Order! Will enter Active State at valid Time";
			// TODO Auto-generated method stub
			
		}

		@Override
		public String processDeletedOrder(OrderBean order) {
			return "false: Incorrect process in Deleted Order! Will enter Deleted State after Order Complete";
			// TODO Auto-generated method stub
			
		}

		@Override
		public String processCompletedOrder(OrderBean order) {
			return "false: Incorrect process in Complete Order! Order Needs to be completed first";
			// TODO Auto-generated method stub
			
		};

	
}
