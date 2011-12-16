import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;


public class CustomerDelete implements DeleteStrategy{

	int customerDeleteID=0;
	boolean customerDeleteType=false;
	private Investor investor;
	String strOrderID ="";
	
	
	public CustomerDelete(Investor investor, String orderID) 
	{
		this.investor =  investor;
		this.strOrderID = orderID;
	}
	public CustomerDelete() 
	{
		
	}
	
	void deleteStrategyMethod() {};
	void displayCustomerDeleteDetails() {}
	
	
	
	@Override
	public String deleteOrder(Investor investor, String orderID) 
	
	{
		
		List<OrderBean> orders = investor.getOrderList();
		Iterator<OrderBean> orderIterator = orders.iterator();
		while(!orders.isEmpty())
		{
			while(orderIterator.hasNext())
			{
				OrderBean order = orderIterator.next();
				strOrderID = order.getStrOrderID();
				
				if(strOrderID.equalsIgnoreCase(orderID))
				{
					OrderBean foundOrder = order;
					Double amount = foundOrder.getBidAmount();
					System.out.println("In customer delete class !!");
					System.out.println("Deleting Customer Delete order");
					orders.remove(orderID);
					
					/*Listing stockListing = Listing.getInstance();
					List<Stock> allListedStocks = stockListing.getAllStocks();
					Iterator<Stock> stockIterator = allListedStocks.iterator();
					
					while(stockIterator.hasNext())
					{
						// this is to iterate over all the stocks
						Stock _stock = stockIterator.next();
						if(_stock.getStockid().equals(order.getStockID()))
						{
							SortedMap<Double, OrderBean> buyQueue = _stock.getBuyQueue();
							SortedMap<Double, OrderBean> sellQueue = _stock.getSellQueue();
							SortedMap<Double, OrderBean> removeOrder = new TreeMap<Double, OrderBean>();
							removeOrder.put(amount, foundOrder);
							
							if(buyQueue.containsValue(foundOrder));
							{
								_stock.buyQueue.remove(buyQueue.get(amount));
							}
							
							if(sellQueue.containsValue(foundOrder))
							{
								_stock.sellQueue.remove(foundOrder);
							}
						}
					}*/
					
					
					
					
					System.out.println("Deleted");
					return "deleted";
				}
			}
		}
		return "deleted";
	}
	

}
