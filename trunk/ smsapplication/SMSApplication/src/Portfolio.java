import java.util.List;


public class Portfolio {

	int profileId;
	int orderId;
	int accountId;
	int requestType;
	//Investor investor = new Investor();
	private Profile profile = new Profile();
	private Account account = new Account();
	//private Order order;
	
	public Portfolio(Investor investor){
		//this.investor=investor;
	}
	
	public Portfolio()
	{
		
		Investor investor = new Investor();
		investor.setInvestorID("INV01STK01");
		investor.setStrFirstName("Kaustubh");
		investor.setStrLastName("Phadnis");
		investor.setStrAddress("37 S ,8th Street");
		investor.setStrState("CA");
		investor.setStrEmail("kmp@gmail.com");	
		investor.setnPhone(4089899898L);
		
		InvestorListing allinvestors = new InvestorListing();
		List<Investor> thisInvestor = allinvestors.getAllInvestors();
		thisInvestor.add(investor);
		
		
		new InvestorListing().setAllInvestors(thisInvestor);
		
		
		if(requestType==1)profile.testprofile(investor);
		
		if(requestType==2)account.accountOperations(investor);
		
		if(requestType==3) {
			System.out.println("In Portfolio");
			//this.order = new Order(investor);
			//order.orderOperation();
			new Order().orderOperation();
		}
	}
	
	void processRequestType(int requestType)
	
	{
		
		Investor investor = new Investor();
		investor.setInvestorID("INV01STK01");
		investor.setStrFirstName("Kaustubh");
		investor.setStrLastName("Phadnis");
		investor.setStrAddress("37 S ,8th Street");
		investor.setStrState("CA");
		investor.setStrEmail("kmp@gmail.com");	
		investor.setnPhone(4089899898L);
		
		InvestorListing allinvestors = new InvestorListing();
		List<Investor> thisInvestor = allinvestors.getAllInvestors();
		thisInvestor.add(investor);
		
		
		new InvestorListing().setAllInvestors(thisInvestor);
		if(requestType==1)profile.testprofile(investor);
		
		if(requestType==2)account.accountOperations(investor);
		
		if(requestType==3) {
			System.out.println("In Portfolio");
			//this.order = new Order(investor);
			//order.orderOperation();
			new Order().orderOperation();
		}
	};
}
