import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


public class Listing 
{

	private static Listing instance;
	Stock stock = new Stock();
	private static List<Stock> allStocks = new ArrayList<Stock>();
	private static List<MutualFund> allMutualFunds=new ArrayList<MutualFund>();

	//Default Constructor
	private Listing()
	{
		/*Stock stock1 = new Stock();
		stock1.setdStockPrice(400.67d);
		stock1.setNumberOfStocks(11);
		stock1.setStockid("C01");
		stock1.setStockname("Apple");
		//stock1.buyQueue
		allStocks.add(stock1);*/
		
		InvestorListing invList = InvestorListing.getinstance();
		List<Investor> allInvestors = invList.getAllInvestors();
		//List<Investor> allInvestors = new ArrayList<Investor>();
		SortedMap<Double, OrderBean> buyQueue = new TreeMap<Double, OrderBean>();
		SortedMap<Double, OrderBean> sellQueue = new TreeMap<Double, OrderBean>();
		Stock stock1 = new Stock();
		stock1.setdStockPrice(400.67d);
		stock1.setNumberOfStocks(10);
		stock1.setStockid("C01");
		stock1.setStockname("Apple");
		//Set buy and sell order queue here .... for error in line 48 activestate.java
		Investor investor = new Investor();
		investor.setInvestorID("INV000004");
		investor.setStrFirstName("ABC");
		investor.setStrLastName("PQR");
		investor.setStrAddress("37 S ,8th Street");
		investor.setStrState("CA");
		investor.setStrEmail("kmp@gmail.com");	
		investor.setnPhone(4089899898L);
		investor.setAmountInAccount(10000.00d);
		
		OrderBean order = new OrderBean();
		List<OrderBean> orderList=new ArrayList<OrderBean>();
		
		order.setStrOrderID("O0000001");
		order.setPartialOrderFlag(true);
		order.setOrderType("STOCK");
		order.setInvestorID("INV000004");
		order.setOrderProcessType("Buy_Orders");
		order.setBidAmount(451.22);
		order.setNoOfStocks(10);
		order.setStockID("C01");
		orderList.add(order);
		investor.setOrderList(orderList);
		allInvestors.add(investor);
		
		buyQueue.put(stock1.getdStockPrice(), order);
		stock1.setBuyQueue(buyQueue);
		
		Investor investor1 = new Investor();
		investor1.setInvestorID("INV000005");
		investor1.setStrFirstName("ABC");
		investor1.setStrLastName("PQR");
		investor1.setStrAddress("37 S ,8th Street");
		investor1.setStrState("CA");
		investor1.setStrEmail("kmp@gmail.com");	
		investor1.setnPhone(4089899898L);
		investor1.setAmountInAccount(10000.00d);
		
		OrderBean order1 = new OrderBean();
		List<OrderBean> orderList1=new ArrayList<OrderBean>();
		
		order1.setStrOrderID("O0000002");
		order1.setPartialOrderFlag(true);
		order1.setOrderType("STOCK");
		order1.setInvestorID("INV000005");
		order1.setOrderProcessType("Sell_Orders");
		order1.setBidAmount(450.22);
		order1.setNoOfStocks(10);
		order1.setStockID("C01");
		orderList1.add(order1);
		investor1.setOrderList(orderList1);
		allInvestors.add(investor1);
		Double d = 450.22d;
		
		sellQueue.put(d, order1);
		stock1.setSellQueue(sellQueue);	
		
		/*Investor investor2 = new Investor();
		investor2.setInvestorID("INV000002");
		investor2.setStrFirstName("Amol");
		investor2.setStrLastName("Godbole");
		investor2.setStrAddress("201, S 4th Street, San Jose");
		investor2.setStrState("CA");
		investor2.setStrEmail("amol.godbole@hotmail.com");	
		investor2.setnPhone(408123456L);
		
		allInvestors.add(investor2);*/
		
		invList.setAllInvestors(allInvestors);
		allStocks.add(stock1);
		
		
		
	}

	public static Listing getInstance()
	{
		if(instance == null)
		{
			instance = new Listing();
		}
		return instance;
	}

	//Getters and Setters
	public List<MutualFund> getAllMutualFunds() {
		return allMutualFunds;
	}

	public void setAllMutualFunds(List<MutualFund> allMutualFunds) {
		Listing.allMutualFunds = allMutualFunds;
	}

	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public List<Stock> getAllStocks() {
		return allStocks;
	}
	public void setAllStocks(List<Stock> allStocks) {
		Listing.allStocks = allStocks;
	}

}


