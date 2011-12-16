import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class InitializedState implements OrderStateInterface
{
	private StockOrderInterface stockOrderInterface;

	List<OrderBean> initializedOrders = new ArrayList<OrderBean>();
	List<Stock> allStocks = Listing.getInstance().getAllStocks();
	Stock stock = null;

	ClockInstance1 clock=new ClockInstance1();

	InitializedState(StockOrderInterface stockOrderInterface)
	{
		this.stockOrderInterface = stockOrderInterface;
	}


	public InitializedState() {
		
	}

	

	public void processChangeStateAtValidTime(boolean validity) 
	{
		while(validity)
		{
			Iterator<OrderBean> orderIterator = initializedOrders.iterator();

			while(orderIterator.hasNext())
			{
				OrderBean order = orderIterator.next();
				stockOrderInterface.setState(stockOrderInterface.getInitializedState());
				stockOrderInterface.processOrder(order);
			}
		}
	}




	@SuppressWarnings("deprecation")
	@Override
	public String processOrder(OrderBean order) {
		
		//System.out.println("In process order of Initialized state");



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
					System.out.println("Stock is : "+this.stock.getStockname());
				}
			}
	
		 if(! order.isMarketOrderFlag())
			{
				if(order.getOrderProcessType().equalsIgnoreCase("Buy_Orders"))
				{

					Double bidAmount = (Double) order.getBidAmount();
					System.out.println("Bid Amount: "+bidAmount);
					//System.out.println("Order Id: " +order.getStrOrderID());


					ActiveState as = ActiveState.getInstance();
					as.setThreadChanger("true");
					//System.out.println("Before Insert!"+System.currentTimeMillis());
					this.stock.buyQueue.put(bidAmount, order);
					//System.out.println("After Insert!"+System.currentTimeMillis());
					as.setThreadChanger("false");


					Double d = this.stock.buyQueue.lastKey();
					//System.out.println("Buy Queue last Key: "+d);
					System.out.println("order placed in Buy Queue of Stock with Stock id: "+ this.stock.getStockid());

				}
				else if(order.getOrderProcessType().equalsIgnoreCase("Sell_Orders"))
				{
					Double askAmount = (Double) order.getAskAmount();

					this.stock.sellQueue.put(askAmount, order);
					System.out.println("order placed in Sell Queue of Stock with Stock id: "+ this.stock.getStockid());
					//stockOrderInterface.processOrder(order);
				}
				
			}

			

			stockOrderInterface.setState(stockOrderInterface.getActiveState());
			System.out.println("Changed State Call method InitializedOrder to ActiveOrder !");
			stockOrderInterface.processOrder(order);
			//st.setState(st.getActiveState());
			//System.out.println("Changed State Call method InitializedOrder to ActiveOrder !");
			return "true: Changed State Call method InitializedOrder to ActiveOrder ";
		}
		else
		{
			initializedOrders.add(order);
			return "true: Order Initialized and is waiting for time to be valid";
		}


	}

}
