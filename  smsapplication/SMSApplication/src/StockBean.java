
public  class StockBean
{
	String stockid="";
	String stockname="";
	double dStockPrice = 0.0d;
	String strCompanyName;
	String strCompanyID;
	int totalNoStocks;
	
	
	public String getStockid() {
		return stockid;
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

	public int getTotalNoStocks() {
		return totalNoStocks;
	}
	public void setTotalNoStocks(int totalNoStocks) {
		this.totalNoStocks = totalNoStocks;
	}
	
}
