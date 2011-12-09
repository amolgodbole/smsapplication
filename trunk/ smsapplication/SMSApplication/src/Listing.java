import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



	
	
	import java.util.ArrayList;
	import java.util.List;


	public class Listing {
		
		public List<MutualFund> getAllMutualFunds() {
			return allMutualFunds;
		}

		public void setAllMutualFunds(List<MutualFund> allMutualFunds) {
			this.allMutualFunds = allMutualFunds;
		}

		public List<StockBean> getStockList() {
			return stockList;
		}

		public void setStockList(List<StockBean> stockList) {
			this.stockList = stockList;
		}

		Company company = new Company();
		Stock stock = new Stock();
		List<Stock> allStocks = new ArrayList<Stock>();
		
		List<MutualFund> allMutualFunds=new ArrayList<MutualFund>();
		
		List<StockBean> stockList = new ArrayList<StockBean>(); 
		public Listing(){
			
		}
		
		public void addToList(StockBean sb){
			System.out.println("Stock list has been added to listings");
			stockList.add(sb);
			
			Iterator<StockBean> itr = stockList.iterator();
			
			while(itr.hasNext()) {
				StockBean stockBean = (StockBean) itr.next();
				System.out.println("--------------------------------------------------");
				System.out.println("Company name: "+stockBean.getStrCompanyName());
				System.out.println("--------------------------------------------------");
				System.out.println("Company id: "+stockBean.getStrCompanyID());
				System.out.println("Stock name: "+stockBean.getStockname());
				System.out.println("Stock id: "+stockBean.getStockid());
				System.out.println("Stock price: "+stockBean.getdStockPrice());
				System.out.println("Stock count: "+stockBean.getTotalNoStocks());
				System.out.println("--------------------------------------------------");
			}
		}
		public Company getCompany() {
			return company;
		}
		public void setCompany(Company company) {
			this.company = company;
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
			this.allStocks = allStocks;
		}
		public Listing(Company company)
		{
			this.company = company;
		}
		
		void processRequestType(int requestType)
		{
			
			//if(requestType==1)
				
				
				
				//stock.listStock(this.stock);
			
			//if(requestType==2)stock.deleteStock(this.stock);
			
		}
		



	}


