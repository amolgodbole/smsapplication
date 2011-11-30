
public class Listing {
	
	Company company = new Company();
	Stock stock = new Stock();
	
	public Listing(Company company)
	{
		this.company = company;
	}
	public Listing() {
		// TODO Auto-generated constructor stub
	}
	void processRequestType(int requestType)
	{
		
		if(requestType==1)stock.listStock(this.company);
		
		if(requestType==2)stock.deleteStock(this.company);
		
	}


}
