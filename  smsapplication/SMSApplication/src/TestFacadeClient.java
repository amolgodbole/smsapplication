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
	public void callOperationMf() throws NumberFormatException, IOException{
		int choice = 0;
		Portfolio portfolio = new Portfolio(investor);
		MutualFund mf =new MutualFund();
		int i=0;
		//after input as investor.
		System.out.println("Enter the stocks you want to choose as a part of your portfolio:");
		System.out.println(Listing.getInstance().getAllStocks().get(0).stockname+":Select 1 for yes/2 for no");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice1=Integer.parseInt(br.readLine());
		int total_stocks=0;
		
		
		if (choice1==1)
		{
		System.out.println("Enter number of stocks of" +Listing.getInstance().getAllStocks().get(i).stockname+":");		
		mf.stocks.add(Listing.getInstance().getAllStocks().get(i));
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));	
		int number_apple=Integer.parseInt(br1.readLine());
		mf.stocks.get(i).numberOfStocks=number_apple;
		investor.amountInAccount=investor.amountInAccount - ((Listing.getInstance().getAllStocks().get(i).dStockPrice)*number_apple);
		i++;
		total_stocks=total_stocks+number_apple;
		}
		
		System.out.println("Enter the stocks you want to choose as a part of your portfolio:");
		System.out.println(Listing.getInstance().getAllStocks().get(1).stockname+":Select 1 for yes/2 for no");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		int choice2=Integer.parseInt(br2.readLine());
		
		if (choice2==1)
		{
		System.out.println("Enter number of stocks of"+Listing.getInstance().getAllStocks().get(1).stockname);		
		mf.stocks.add(Listing.getInstance().getAllStocks().get(i));
		BufferedReader br21 = new BufferedReader(new InputStreamReader(System.in));	
		int number_ms=Integer.parseInt(br21.readLine());
		mf.stocks.get(i).numberOfStocks=number_ms;
		investor.amountInAccount=investor.amountInAccount - ((Listing.getInstance().getAllStocks().get(i).dStockPrice)*number_ms);
		i++;
		
		total_stocks=total_stocks+number_ms;
		}
		
		System.out.println("Enter the stocks you want to choose as a part of your portfolio:");
		System.out.println(Listing.getInstance().getAllStocks().get(2).stockname+":Select 1 for yes/2 for no");
		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
		int choice3=Integer.parseInt(br3.readLine());
		
		if (choice3==1)
		{
		System.out.println("Enter number of stocks of :"+Listing.getInstance().getAllStocks().get(2).stockname);		
		mf.stocks.add(Listing.getInstance().getAllStocks().get(i));
		BufferedReader br31 = new BufferedReader(new InputStreamReader(System.in));	
		int number_yahoo=Integer.parseInt(br31.readLine());
		mf.stocks.get(i).numberOfStocks=number_yahoo;
		investor.amountInAccount=investor.amountInAccount - ((Listing.getInstance().getAllStocks().get(i).dStockPrice)*number_yahoo);
		i++;
		total_stocks=total_stocks+number_yahoo;
		}
			
		System.out.println("Enter the stocks you want to choose as a part of your portfolio:");
		System.out.println(Listing.getInstance().getAllStocks().get(3).stockname+":Select 1 for yes/2 for no");
		BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
		int choice4=Integer.parseInt(br4.readLine());
		
		if (choice4==1)
		{
		System.out.println("Enter number of stocks:"+Listing.getInstance().getAllStocks().get(3).stockname);		
		mf.stocks.add(Listing.getInstance().getAllStocks().get(i));
		BufferedReader br31 = new BufferedReader(new InputStreamReader(System.in));	
		int number_google=Integer.parseInt(br31.readLine());
		mf.stocks.get(i).numberOfStocks=number_google;
		investor.amountInAccount=investor.amountInAccount - ((Listing.getInstance().getAllStocks().get(i).dStockPrice)*number_google);
		i++;
		total_stocks=total_stocks+number_google;
		}
		
		mf.noofStocks=total_stocks;
		investor.mutualFunds.add(mf);	
		System.out.println(""+mf.noofStocks);
		System.out.println(""+investor.amountInAccount);	
		mf.setMutualFundID("MF001");	
		Listing.getInstance().getAllMutualFunds().add(mf);
		
		}
	public void callOperation(){
		int choice = 0;
		Portfolio portfolio = new Portfolio(investor);
		
			while(true) {
			
				System.out.println("-------------------------------------------------------------------");
				System.out.println("Main menu : ");
				System.out.println("-------------------------------------------------------------------");
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
		
		while(true){
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Securities Management System");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Enter your role : ");
		System.out.println("1. Investor");
		System.out.println("2. Company");
		System.out.println("3. Exit");
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
				System.out.println("-------------------------------------------------------------------");
				System.out.println("Listing menu");
				System.out.println("-------------------------------------------------------------------");
				
				System.out.println("Select : ");
				System.out.println("1. List stock");
				/*System.out.println("2. List mutual funds");*/
				System.out.println("2. Split stock");
				System.out.println("3. Exit");
				
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
					/*if(option1.equals("2")){
						Investor investor = new Investor();
						investor.setInvestorID("INV01STK01");
						investor.setStrFirstName("Akshay");
						investor.setStrLastName("Kumar");
						investor.setStrAddress("Colonade");
						investor.setStrState("CA");
						investor.setStrEmail("aks@gmail.com");	
						investor.setAmountInAccount(1000000);
						investor.setnPhone(4089899898L);
						
						TestFacadeClient tc = new TestFacadeClient(investor);
						tc.callOperationMf();
					}*/
					
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
						stockSplitOrder.display();
					}
					if(option1.equals("3")) break;
					}catch (IOException e) 
					{
						e.printStackTrace();
						
					}
				}
			}
			if(option.equals("3")) break;
		} catch (IOException e) 
		{
			e.printStackTrace();
			
		}
		}
		
		
		/*InvestorListing allinvestors = new InvestorListing();
		List<Investor> thisInvestor = allinvestors.getAllInvestors();
		thisInvestor.add(investor);*/
		
		//new InvestorListing().setAllInvestors(thisInvestor);
				
	}

}
