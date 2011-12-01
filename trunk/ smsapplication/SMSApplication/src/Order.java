import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Order
{
	String investerId;
	Investor investor = new Investor();
	
	public Order(){
		
	}
	
	public Order(Investor investor){
		this.investor=investor;
	}
	
	OrderBean order = new OrderBean();
		
		public void createOrder(){
		
		order.setStrOrderID("ORD-01-STK");
		order.setOrderType("STOCK");
		order.setPartialOrderFlag(true);
		order.setOrderProcessType("Buy_Orders");
		order.setBidAmount(450.22);
		order.setInvestorID(this.investor.getInvestorID());
		
		investor.orderList.add(order);
		System.out.println("*************" +investor.getInvestorID());
		System.out.println("Order places is : " +order.getStrOrderID());
		System.out.println("Checking order type");
		if(order.getOrderType().equalsIgnoreCase("STOCK")){
			
			StockOrder stockOrder = new StockOrder();
			stockOrder.implementOrder(order);
		}else{
			StockOrder stockOrder = new StockOrder();
			stockOrder.implementOrder(order);
		}
		}
		
	
	
		public void updateOrder(){
			
		}
		
		public void deleteOrder(Investor investor){
			DeleteContext dc = new DeleteContext();
			dc.delete(investor, order.getStrOrderID(), "investor_delete");
		}
		
		public void viewOrders(List<OrderBean> orderList) {
			Iterator<OrderBean> itr = orderList.iterator();
			
			while(itr.hasNext()) {
				OrderBean orderBean = (OrderBean) itr.next();
				System.out.println("Investor id: "+orderBean.getInvestorID());
				System.out.println("Order id: "+orderBean.getStrOrderID());
				System.out.println("Order Type: "+orderBean.getOrderType());
			}
		}
		
		
	void orderOperation(){
		while(true) {
			
				System.out.println("Enter your choice : ");
				System.out.println("1. Create Order");
				System.out.println("2. Update Order");
				System.out.println("3. Delete Order");
				System.out.println("4. View Orders");
				System.out.println("5. Exit");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				try {
					String option = br.readLine();
					if(option.equals("1")){
						createOrder();
					}
					if(option.equals("2")) updateOrder();
					if(option.equals("3")) deleteOrder(investor);
					//if(option.equals("4")) order.viewOrders(investor.orderList);
					if(option.equals("4")) viewOrders(investor.orderList);
					if(option.equals("5")) break;
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
	}
}
