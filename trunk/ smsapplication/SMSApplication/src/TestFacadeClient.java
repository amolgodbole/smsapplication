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
		investor.setInvestorID("INV000009");
		//after input as investor.
		System.out.println("Enter the stocks you want to choose as a part of your portfolio:");
		System.out.println("Apple:Select 1 for yes/2 for no");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice1=Integer.parseInt(br.readLine());
		int total_stocks=0;
		
		
		if (choice1==1)
		{
		System.out.println("Enter number of stocks of Apple:");		
		mf.stocks.add(Listing.getInstance().getAllStocks().get(i));
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));	
		int number_apple=Integer.parseInt(br1.readLine());
		mf.stocks.get(i).setStockname("Apple");
		mf.stocks.get(i).setNumberOfStocks(number_apple);
		investor.amountInAccount=investor.amountInAccount - ((Listing.getInstance().getAllStocks().get(i).dStockPrice)*number_apple);
		i++;
		total_stocks=total_stocks+number_apple;
		}
		
		System.out.println("Enter the stocks you want to choose as a part of your portfolio:");
		System.out.println("Microsoft:Select 1 for yes/2 for no");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		int choice2=Integer.parseInt(br2.readLine());
		
		if (choice2==1)
		{
			mf.stocks.add(Listing.getInstance().getAllStocks().get(i));
			System.out.println("Enter number of stocks of Microsoft");		
		
		BufferedReader br21 = new BufferedReader(new InputStreamReader(System.in));	
		int number_ms=Integer.parseInt(br21.readLine());
		mf.stocks.get(i).setNumberOfStocks(number_ms);
		
		investor.amountInAccount=investor.amountInAccount - ((Listing.getInstance().getAllStocks().get(i).dStockPrice)*number_ms);
		i++;
		
		total_stocks=total_stocks+number_ms;
		}
		
		System.out.println("Enter the stocks you want to choose as a part of your portfolio:");
		System.out.println("Yahoo:Select 1 for yes/2 for no");
		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
		int choice3=Integer.parseInt(br3.readLine());
		
		if (choice3==1)
		{
			mf.stocks.add(Listing.getInstance().getAllStocks().get(i));
			System.out.println("Enter number of stocks of :Yahoo");		
		BufferedReader br31=new BufferedReader(new InputStreamReader(System.in));
		int num_yahoo=Integer.parseInt(br31.readLine());
		mf.stocks.get(i).setNumberOfStocks(num_yahoo);
		
		
		investor.amountInAccount=investor.amountInAccount - ((Listing.getInstance().getAllStocks().get(i).dStockPrice)*num_yahoo);
		i++;
		total_stocks=total_stocks+num_yahoo;
		}
			
		System.out.println("Enter the stocks you want to choose as a part of your portfolio:");
		System.out.println("Google:Select 1 for yes/2 for no");
		BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
		int choice4=Integer.parseInt(br4.readLine());
		
		if (choice4==1)
		{
			mf.stocks.add(Listing.getInstance().getAllStocks().get(i));
		System.out.println("Enter number of stocks:Google");		

		BufferedReader br41 = new BufferedReader(new InputStreamReader(System.in));	
		int number_google=Integer.parseInt(br41.readLine());
		mf.stocks.get(i).setNumberOfStocks(number_google);
		
		investor.amountInAccount=investor.amountInAccount - ((Listing.getInstance().getAllStocks().get(i).dStockPrice)*number_google);
		i++;
		total_stocks=total_stocks+number_google;
		}
		MutualFundOrder mforder=new MutualFundOrder();
		double price=mforder.calculate_NAV(mf);
		System.out.println("Portfolio summary");
		System.out.println("MFID:"+mf.mutualFundID);
		/*
		if (choice1==1)
		System.out.println("Stocks:"mf.);
		*/
		//calculate NAV
		System.out.println("nav price:"+price);
		mf.setMutualFundPrice(price);
		mf.setNoofStocks(total_stocks);
		investor.mutualFunds.add(mf);	
		System.out.println(""+mf.getNoofStocks());
		System.out.println(""+investor.amountInAccount);	
		mf.setMutualFundID("MF000001");	
		Listing.getInstance().getAllMutualFunds().add(mf);
		System.out.println("Mf 01:"+Listing.getInstance().getAllMutualFunds().size());
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
		
		Stock stock1 = new Stock();
		stock1.setdStockPrice(100);
		stock1.setNumberOfStocks(10);
		stock1.setStockid("C02");
		stock1.setStockname("Microsoft");
		
		Stock stock2 = new Stock();
		stock2.setdStockPrice(600);
		stock2.setNumberOfStocks(10);
		stock2.setStockid("C03");
		stock2.setStockname("Yahoo");
		
		Stock stock3 = new Stock();
		stock3.setdStockPrice(300);
		stock3.setNumberOfStocks(10);
		stock3.setStockid("C04");
		stock3.setStockname("Google");
		
		Listing.getInstance().getAllStocks().add(0,stock);
		Listing.getInstance().getAllStocks().add(1,stock1);
		Listing.getInstance().getAllStocks().add(2,stock2);
		Listing.getInstance().getAllStocks().add(3,stock3);
		
		
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
				System.out.println("2. List mutual funds");
				System.out.println("3. Split stock");
				System.out.println("4. Exit");
				
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
						Investor investor = new Investor();
						investor.setInvestorID("INV01STK01");
						investor.setStrFirstName("Akshay");
						investor.setStrLastName("Kumar");
						investor.setStrAddress("Colonade");
						investor.setStrState("CA");
						investor.setStrEmail("aks@gmail.com");	
						investor.setAmountInAccount(10000000);
						investor.setnPhone(4089899898L);
						
						TestFacadeClient tc=new TestFacadeClient();
						tc.callOperationMf();
					}
					
					if (option1.equals("3")){
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
					if(option1.equals("4")) break;
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
		
						
	}

}
