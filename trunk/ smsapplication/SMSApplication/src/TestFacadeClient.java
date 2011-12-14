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
import java.util.Random;
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
		
		System.out.println("Enter as a : ");
		System.out.println("1. Investor");
		System.out.println("2. Company");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String option;
		
		try {
			option = br.readLine();
			if(option.equals("1")){
				
				TestFacadeClient tc = new TestFacadeClient();
				tc.callOperation();
			}
			
			if(option.equals("2")){
			while(true){
				System.out.println("Select : ");
				System.out.println("1. List stock");
				System.out.println("2. Split stock");
				BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
				String option1 = null;
				try {
					option1 = br1.readLine();
					if(option1.equals("1")){
						// List stock functionality
						Stock stockNew = new Stock();
						stockNew.setStockid("C05");
						stockNew.setStockname("Stk-01");
						System.out.println("Enter Company name : ");
						BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
						stockNew.setStrCompanyName(br2.readLine());
						System.out.println("Enter Initial stock price : ");
						BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
						stockNew.setdStockPrice(Double.parseDouble(br3.readLine()));
						System.out.println("Enter total number of stocks : ");
						BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
						stockNew.setNumberOfStocks(Integer.parseInt(br4.readLine()));
						Listing listing = Listing.getInstance();
						listing.getAllStocks().add(stockNew);
						System.out.println("Stock added to listing...");
						
							
					}
					if(option1.equals("2")){
						// Split stock functionality
						Stock stockNew = new Stock();
						System.out.println("Enter stock id : ");
						BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
						String stockId = br2.readLine();
						List<Stock> allStocks = Listing.getInstance().getAllStocks();
						Iterator<Stock> allStockIterator = allStocks.iterator();
						while(allStockIterator.hasNext())
						{
							Stock stockInIter = allStockIterator.next();
							if( stockInIter.getStockid().equals(stockId))
							{
								stockNew = stockInIter;
								System.out.println("Stock is : "+stockNew.getStockname());
							}
						}
						StockSplit stockSplitOrder = new StockSplit(stockNew);
						stockSplitOrder.processSplitStock(stockNew);
						
					}
					if(option1.equals("3")) break;
					}catch (IOException e) 
					{
						e.printStackTrace();
						
					}
				}
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
			
		}
		
		
		
		/*InvestorListing allinvestors = new InvestorListing();
		List<Investor> thisInvestor = allinvestors.getAllInvestors();
		thisInvestor.add(investor);*/
		
		//new InvestorListing().setAllInvestors(thisInvestor);
				
	}

}
