
public  class Stock extends Listing
{
	String stockid="";
	String stockname="";
	double dStockPrice = 0.0d;
	String strCompanyName;
	String strCompanyID;
	private Company company;
	
	
	public Stock(Company company)
	{
		this.company=company;
	}


	public Stock() {
		// TODO Auto-generated constructor stub
		super();
	}


	public void listStock(Company company) {
		// TODO Auto-generated method stub
		
	}


	public void deleteStock(Company company) {
		// TODO Auto-generated method stub
		
	}

	
}
