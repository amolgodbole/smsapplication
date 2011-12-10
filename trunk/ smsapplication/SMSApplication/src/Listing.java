import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



	
	
	import java.util.ArrayList;
import java.util.List;


	public class Listing {
		
		//Company company = new Company();
		Stock stock = new Stock();
		List<Stock> allStocks = new ArrayList<Stock>();
		List<MutualFund> allMutualFunds=new ArrayList<MutualFund>();
		
		
		
		
		//Default Constructor
		public Listing()
		{
			Stock stock1 = new Stock();
			
			stock1.setdStockPrice(400.67d);
			stock1.setNumberOfStocks(10);
			stock1.setStockid("C01");
			stock1.setStockname("Apple");
			allStocks.add(stock1);
		}
		

		
		//Getters and Setters
		public List<MutualFund> getAllMutualFunds() {
			return allMutualFunds;
		}

		public void setAllMutualFunds(List<MutualFund> allMutualFunds) {
			this.allMutualFunds = allMutualFunds;
		}
		/*public Company getCompany() {
			return company;
		}
		public void setCompany(Company company) {
			this.company = company;
		}*/
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
			this.allStocks = allStocks;
		}
	/*	public Listing(Company company)
		{
			this.company = company;
		}*/
		
		
		
		/*
		 * 
		 * //List<Stock> stockList = new ArrayList<Stock>(); 
		 * public void addToList(Stock sb){
		System.out.println("Stock list has been added to listings");
		stockList.add(sb);
		
		Iterator<Stock> itr = stockList.iterator();
		
		while(itr.hasNext()) {
			Stock stockBean = (Stock) itr.next();
			System.out.println("--------------------------------------------------");
			System.out.println("Company name: "+stockBean.getStrCompanyName());
			System.out.println("--------------------------------------------------");
			System.out.println("Company id: "+stockBean.getStrCompanyID());
			System.out.println("Stock name: "+stockBean.getStockname());
			System.out.println("Stock id: "+stockBean.getStockid());
			System.out.println("Stock price: "+stockBean.getdStockPrice());
			System.out.println("Stock count: "+stockBean.getAllStocks());
			System.out.println("--------------------------------------------------");
		}
	}
	
	
	void processRequestType(int requestType)
		{
			
			//if(requestType==1)
				
				
				
				//stock.listStock(this.stock);
			
			//if(requestType==2)stock.deleteStock(this.stock);
			
		}
	*/



	}


