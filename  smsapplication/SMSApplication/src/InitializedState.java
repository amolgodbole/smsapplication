import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class InitializedState implements OrderStateInterface
{
	private StockOrderInterface stockOrderInterface;
	
	List<OrderBean> initializedOrders = new ArrayList<OrderBean>();
	List<Stock> allStocks = new Listing().getAllStocks();
	Stock stock = null;
	
	ClockInstance1 clock=new ClockInstance1();
	
	 InitializedState(StockOrderInterface stockOrderInterface)
	{
		this.stockOrderInterface = stockOrderInterface;
	}
		

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
			if(order.equals(null))
			{
				System.out.println("Order is Null");
			}
			if(clock.checkTimevalidity())
			{
				
				OrderBean orderInInitializedState = order;
				String stockIdInOrder = orderInInitializedState.getStockID();
				Iterator<Stock> allStockIterator = allStocks.iterator();
				
				 while(allStockIterator.hasNext())
				 {
					 Stock stockInIter = allStockIterator.next();
					if( stockInIter.getStockid().equals(stockIdInOrder))
					{
						this.stock = stockInIter;
					}
				 }
				
				if(order.getOrderProcessType().equalsIgnoreCase("Buy_Orders"))
				{
					
					Double bidAmount = (Double) order.getBidAmount();
					System.out.println("Bid Amount: "+bidAmount);
					this.stock.buyQueue.put(bidAmount, order); 
					System.out.println("order placed in Buy Queue of Stock with Stock id: "+ this.stock.getStockid());
					stockOrderInterface.processOrder(order);
					//activeOrderStateInterface.setStates(waiting);
					//activeOrderStateInterface.getWaiting()
					//stockOrderInterface.setState(stockOrderInterface.getActiveState());
				}
				else if(order.getOrderProcessType().equalsIgnoreCase("Sell_Orders"))
				{
					Double askAmount = (Double) order.getAskAmount();
					this.stock.sellQueue.put(askAmount, order);
					System.out.println("order placed in Sell Queue of Stock with Stock id: "+ this.stock.getStockid());
					stockOrderInterface.processOrder(order);
				}
			
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

		
		/*public String processOrder(OrderBean order) {
		// TODO Auto-generated method stub
		System.out.println("Order Initialized !!");
		stockOrderInterface.setState(stockOrderInterface.getActiveState());
		//st.setState(st.getActiveState());
		System.out.println("Process Order ");
		return "Order Initialized";
	}*/
	
}
