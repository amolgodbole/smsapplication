import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


public class TestFacadeClient {

	/**
	 * @param args
	 * @throws IOException 
	 */
	Investor investor = new Investor();
	public TestFacadeClient(Investor investor)
	{
		this.investor = investor;
	}
	public TestFacadeClient()
	{
		
	}
	
	public void callOperation(){
		int choice = 0;
		Portfolio portfolio = new Portfolio(investor);
		
			while(true) {
				System.out.println("Enter your choice : ");
				System.out.println("1. Create Profile");
				System.out.println("2. Access Account");
				System.out.println("3. Manage Order");
				System.out.println("4. Exit");
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String option;
				
				try {
					option = br.readLine();
					if(option.equals("1")){
						choice=1;
						portfolio.processRequestType(choice);
						
					}
					if(option.equals("2")){
						choice=2;
						portfolio.processRequestType(choice);
					}
					if(option.equals("3")){
						choice=3;
						portfolio.processRequestType(choice);
					}
					if(option.equals("4")) break;
				} catch (IOException e) 
				{
					e.printStackTrace();
					
				}
				
				
			}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Portfolio portfolio = new Portfolio();
		  
		
		
		OrderBean order = new OrderBean();
		order.setStrOrderID("O0000002");
		order.setPartialOrderFlag(true);
		order.setOrderType("STOCK");
		order.setInvestorID("");
		order.setOrderProcessType("Sell_Orders");
		order.setAskAmount(450.22);
		order.setNoOfStocks(10);
		order.setStockID("C01");
		
		Stock stock = new Stock();
		stock.setdStockPrice(400);
		stock.setNumberOfStocks(10);
		stock.setStockid("C01");
		stock.setStockname("Apple");
		
		order.setStock(stock);

		new Stock().sellQueue.put(450.22, order);
		
		TestFacadeClient tc = new TestFacadeClient();
		tc.callOperation();
		
		/*InvestorListing allinvestors = new InvestorListing();
		List<Investor> thisInvestor = allinvestors.getAllInvestors();
		thisInvestor.add(investor);*/
		
		//new InvestorListing().setAllInvestors(thisInvestor);
				
	}

}
