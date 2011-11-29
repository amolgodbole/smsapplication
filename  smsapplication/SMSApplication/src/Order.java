import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	
	void orderOperation(){
		
		System.out.println("Enter your choice : ");
		System.out.println("1. Create Order");
		System.out.println("2. Update Order");
		System.out.println("3. Delete Order");
		System.out.println("4. View Orders");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String option = br.readLine();
			if(option.equals("1")){
				order.setStrOrderID("ORD-01-STK");
				order.setOrderType("STOCK");
				order.setPartialOrderFlag(true);
				order.setInvestorID(this.investor.getInvestorID());
				
				investor.orderList.add(order);
				System.out.println("*************" +investor.getInvestorID());
				
				System.out.println("Order places is : " +order.getStrOrderID());
			}
			if(option.equals("2")) order.updateOrder();
			if(option.equals("3")) order.deleteOrder();
			if(option.equals("4")) order.viewOrders(investor.orderList);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
