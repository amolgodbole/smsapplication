import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


public  class Stock //extends Listing
{
	String stockid="";
	String stockname="";
	public double dStockPrice = 0.0d;
	String strCompanyName;
	String strCompanyID;
	//private Company company;
	//List<Stock> allStocks = new ArrayList<Stock>();
	public SortedMap<Double, OrderBean> buyQueue = new TreeMap<Double, OrderBean>();
	public SortedMap<Double, OrderBean> sellQueue = new TreeMap<Double, OrderBean>();
	public int numberOfStocks = 0;
	
	
	
	
	


	/*public Stock(Company company,double price)
	{
		this.company=company;
		this.dStockPrice=price;
		this.strCompanyName=company.strCompanyName;
		this.numberOfStocks=100;
		this.stockid=company.strCompanyID;
		this.stockname="Apple";
	}*/


	public Stock() 
	{
		
	}

	/*
	 * This method is used to list a stock in the stock exchange.
	 */
/*	public void listStock(Stock stock) {
		
		allStocks.add(stock);
		
		
	}*/
//	Company apple=new Company();
	
	
	
	public int getNumberOfStocks() {
		return numberOfStocks;
	}


	public void setNumberOfStocks(int numberOfStocks) {
		this.numberOfStocks = numberOfStocks;
	}
	

	public String getStockid() {
		return stockid;
	}


	public SortedMap<Double, OrderBean> getBuyQueue() {
		return buyQueue;
	}


	public void setBuyQueue(SortedMap<Double, OrderBean> buyQueue) {
		this.buyQueue = buyQueue;
	}


	public SortedMap<Double, OrderBean> getSellQueue() {
		return sellQueue;
	}


	public void setSellQueue(SortedMap<Double, OrderBean> sellQueue) {
		this.sellQueue = sellQueue;
	}


	public void setStockid(String stockid) {
		this.stockid = stockid;
	}


	public String getStockname() {
		return stockname;
	}


	public void setStockname(String stockname) {
		this.stockname = stockname;
	}


	public double getdStockPrice() {
		return dStockPrice;
	}


	public void setdStockPrice(double dStockPrice) {
		this.dStockPrice = dStockPrice;
	}


	public String getStrCompanyName() {
		return strCompanyName;
	}


	public void setStrCompanyName(String strCompanyName) {
		this.strCompanyName = strCompanyName;
	}


	public String getStrCompanyID() {
		return strCompanyID;
	}


	public void setStrCompanyID(String strCompanyID) {
		this.strCompanyID = strCompanyID;
	}


/*	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}*/


	/*public List<Stock> getAllStocks() {
		return allStocks;
	}*/


/*	public void setAllStocks(List<Stock> allStocks) {
		this.allStocks = allStocks;
	}


	

	public List<Stock> getListOfAllStocks()
	{
		
		return allStocks ;
		
	}

	public void deleteStock(Stock stock) {
		// TODO Auto-generated method stub
		
	}
*/
	
	
}
