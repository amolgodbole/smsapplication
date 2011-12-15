import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;



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
	MutualFund mf = new MutualFund();
		
	public void createOrder() throws IOException{
		
			Stock stock = new Stock();
			stock.setdStockPrice(400);
			stock.setNumberOfStocks(10);
			stock.setStockid("C01");
			stock.setStockname("Apple");
			
			
		Random random=new Random(9);
		int orderid=random.nextInt();
		String orderstring="O000000"+orderid;
		order.setStrOrderID(orderstring);
		order.setPartialOrderFlag(true);
		order.setInvestorID(this.investor.getInvestorID());
		
		System.out.println("Choose order type: 1===STOCK  AND  2===MUTUALFUND");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		int i=Integer.parseInt(input);
		
		if (i==1)
		{	order.setOrderType("STOCK");
			System.out.println("Select the stock to buy: 1==APPLE 2==MICROSOFT 3==YAHOO  4==GOOGLE");
			BufferedReader brstock=new BufferedReader(new InputStreamReader(System.in));
			if (Integer.parseInt(brstock.readLine())==1)
			order.setStockID("C01");
			else if (Integer.parseInt(brstock.readLine())==2)
				order.setStockID("C02");
			else if (Integer.parseInt(brstock.readLine())==3)
				order.setStockID("C03");
			else 
				order.setStockID("C04");
			System.out.println("Enter if order is a buy or sell order: 1===BUY  and 2===SELL");
			BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
			int j=Integer.parseInt(br1.readLine());
			
			if (j==1)
				order.setOrderProcessType("Buy_Orders");	
				else order.setOrderType("Sell_Orders");
				
			if (order.getOrderProcessType()=="Buy_Orders")
			{
			System.out.println("Enter bid amount:");
			BufferedReader br0=new BufferedReader(new InputStreamReader(System.in));
			double bidamount=Double.parseDouble(br0.readLine());
			order.setBidAmount(bidamount);
			}
			else
			{
				System.out.println("Enter ask amount:");
				BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
				double askamount=Double.parseDouble(br2.readLine());
				order.setAskAmount(askamount);

			}
			
			System.out.println("Select the number of stocks:");
			BufferedReader br3=new BufferedReader(new InputStreamReader(System.in));
			int stocks=Integer.parseInt(br3.readLine());
			order.setNoOfStocks(stocks);
			
			order.setStock(stock);
			
			/*stock.setdStockPrice(400);
			stock.setNumberOfStocks(10);
			stock.setStockid("C01");
			stock.setStockname("Apple");
			*/
			
			investor.orderList.add(order);
			
			
		System.out.println("Checking order type");
				
				StockOrder stockOrder = new StockOrder();
				stockOrder.implementOrder(order);
			
			
		}
		
		else 
		{
			mf.setInvestorID(order.getInvestorID());
			mf.setMutualFundID("MF000001");
		
			System.out.println("List of units in mutual fund:");
			
			System.out.println("Enter no of units :");
			BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
			
			mf.setNoofStocks(Integer.parseInt(br1.readLine()));	
			
			
			double price=Listing.getInstance().getAllMutualFunds().get(0).mutualFundPrice;
			mf.setMutualFundPrice(price);
			System.out.println("Details of Mutual fund order are ");
			System.out.println("Mutual fund price : "+mf.getMutualFundPrice());
			System.out.println("No of stocks in Mutual fund : "+mf.getNoofStocks());
			
			
			investor.mutualFunds.add(mf);
			System.out.println("Balance in investor account:"+investor.getAmountInAccount());
	        MutualFundOrder mfOrder=new MutualFundOrder();
	        if(new ClockInstance1().checkTimevalidityMutualFunds()){
	        	mfOrder.processMutualFundOrder(mf,investor);
	        }
	        else{
	        	System.out.println("Mutual fund order is placed... and will be served after 4pm");       	
	        	mfOrder.processMutualFundOrder(mf, investor);
	        }
	      
	        
			
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
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Order menu : ");
			System.out.println("-------------------------------------------------------------------");
			
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
					if(option.equals("4")) viewOrders(investor.orderList);
					if(option.equals("5")) break;
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
	}
}
