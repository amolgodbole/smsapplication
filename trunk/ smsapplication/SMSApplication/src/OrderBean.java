import java.security.Timestamp;
import java.sql.Time;
import java.util.Iterator;
import java.util.List;


public class OrderBean {

	String 		strOrderID;
	boolean 	partialOrderFlag;
	String 		orderType;//should be set to MutualFund or Should be set to Stocks
	String 		investorID;
	String 	    orderProcessType; // Buy order or sell order
	double 	    bidAmount;
	double      askAmount;
	int			noOfStocks;
	String 		stockID;
	String		mutualFundID;
	Stock		stock = new Stock();
	
	/*Account account;
	*/
	
	
	
	
	public String getStrOrderID() {
		return strOrderID;
	}



	public String getStockID() {
		return stockID;
	}



	public void setStockID(String stockID) {
		this.stockID = stockID;
	}



	public String getMutualFundID() {
		return mutualFundID;
	}



	public void setMutualFundID(String mutualFundID) {
		this.mutualFundID = mutualFundID;
	}



	public Stock getStock() {
		return stock;
	}



	public void setStock(Stock stock) {
		this.stock = stock;
	}



	public int getNoOfStocks() {
		return noOfStocks;
	}



	public void setNoOfStocks(int noOfStocks) {
		this.noOfStocks = noOfStocks;
	}



	public void setStrOrderID(String strOrderID) {
		this.strOrderID = strOrderID;
	}



	public boolean isPartialOrderFlag() {
		return partialOrderFlag;
	}



	public void setPartialOrderFlag(boolean partialOrderFlag) {
		this.partialOrderFlag = partialOrderFlag;
	}
	
	/*



	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}*/



	public String getOrderType() {
		return orderType;
	}



	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public void createOrder(){
	System.out.println("Order created");	
	}
	
	public void updateOrder(){
		
	}
	
	public void deleteOrder(){
		
	}



	public String getInvestorID() {
		return investorID;
	}



	public void setInvestorID(String investorID) {
		this.investorID = investorID;
	
	}



	public String getOrderProcessType() {
		return orderProcessType;
	}



	public void setOrderProcessType(String orderProcessType) {
		this.orderProcessType = orderProcessType;
	}



	public double getBidAmount() {
		return bidAmount;
	}



	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}



	public double getAskAmount() {
		return askAmount;
	}



	public void setAskAmount(double askAmount) {
		this.askAmount = askAmount;
	}
}
