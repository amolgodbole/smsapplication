import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
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
		
		/*Investor investor = new Investor();
		investor.setInvestorID("INV01STK01");
		investor.setStrFirstName("Kaustubh");
		investor.setStrLastName("Phadnis");
		investor.setStrAddress("37 S ,8th Street");
		investor.setStrState("CA");
		investor.setStrEmail("kmp@gmail.com");	
		investor.setnPhone(4089899898L);
		investor.setAmountInAccount(10000.00d);
		
		Investor investor1 = new Investor();
		investor1.setInvestorID("INV000002");
		investor1.setStrFirstName("Amol");
		investor1.setStrLastName("Godbole");
		investor1.setStrAddress("201, S 4th Street, San Jose");
		investor1.setStrState("CA");
		investor1.setStrEmail("amol.godbole@hotmail.com");	
		investor1.setnPhone(408123456L);
		investor1.setAmountInAccount(10000.00d);
		
		Investor investor2 = new Investor();
		investor2.setInvestorID("INV000003");
		investor2.setStrFirstName("Akshay");
		investor2.setStrLastName("Kumar");
		investor2.setStrAddress("201, S 4th Street, San Jose");
		investor2.setStrState("CA");
		investor2.setStrEmail("ak@hotmail.com");	
		investor2.setnPhone(408123456L);
		investor2.setAmountInAccount(10000.00d);
		
		InvestorListing allinvestors = InvestorListing.getinstance();;
		List<Investor> thisInvestor = new ArrayList<Investor>();
		thisInvestor.add(investor);
		thisInvestor.add(investor1);
		//InvestorListing.getinstance().addInvestor(investor1);
		thisInvestor.add(investor2);
		
		int size = thisInvestor.size();
		
		System.out.println("Size of Investor Array: "+size);
		
		
		allinvestors.setAllInvestors(thisInvestor);
		
		
		if(requestType==1)profile.testprofile(investor1);
		
		if(requestType==2)account.accountOperations(investor1);
		
		if(requestType==3) {
			System.out.println("In Portfolio");
			//this.order = new Order(investor);
			//order.orderOperation();
			new Order(investor1).orderOperation();
		}*/
	}
	
	void processRequestType(int requestType)
	
	{
		
		Investor investor = new Investor();
		investor.setInvestorID("INV000001");
		investor.setStrFirstName("Kaustubh");
		investor.setStrLastName("Phadnis");
		investor.setStrAddress("37 S ,8th Street");
		investor.setStrState("CA");
		investor.setStrEmail("kmp@gmail.com");	
		investor.setnPhone(4089899898L);
		investor.setAmountInAccount(10000.00d);
		
		Investor investor1 = new Investor();
		investor1.setInvestorID("INV000002");
		investor1.setStrFirstName("Amol");
		investor1.setStrLastName("Godbole");
		investor1.setStrAddress("201, S 4th Street, San Jose");
		investor1.setStrState("CA");
		investor1.setStrEmail("amol.godbole@hotmail.com");	
		investor1.setnPhone(408123456L);
		investor1.setAmountInAccount(10000.00d);
		
		Investor investor2 = new Investor();
		investor2.setInvestorID("INV000003");
		investor2.setStrFirstName("Akshay");
		investor2.setStrLastName("Kumar");
		investor2.setStrAddress("201, S 4th Street, San Jose");
		investor2.setStrState("CA");
		investor2.setStrEmail("ak@hotmail.com");	
		investor2.setnPhone(408123456L);
		investor2.setAmountInAccount(10000.00d);
		
		InvestorListing allinvestors = InvestorListing.getinstance();
		List<Investor> thisInvestor = allinvestors.getAllInvestors();
		thisInvestor.add(investor);
		thisInvestor.add(investor1);
		thisInvestor.add(investor2);
		int size = thisInvestor.size();
		
		//System.out.println("Size of Investor Array: "+size);
		
		
		allinvestors.setAllInvestors(thisInvestor);
		
		InvestorListing thisInvestorList = InvestorListing.getinstance();
		List<Investor> adk = thisInvestorList.getAllInvestors();
		int siz = adk.size();
		//System.out.println("Global List size: "+siz);
		
		//allinvestors.setAllInvestors(thisInvestor);
		
		if(requestType==1){
			Investor investorNew = new Investor();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			try {
			investorNew.setInvestorID("INV0000010");
			System.out.println("Enter your first name :");
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			investorNew.setStrFirstName(input.readLine());
			System.out.println("Enter your last name :");
			BufferedReader lastname=new BufferedReader(new InputStreamReader(System.in));
			investorNew.setStrLastName(lastname.readLine());
			System.out.println("Enter your address :");
			BufferedReader address=new BufferedReader(new InputStreamReader(System.in));
			investorNew.setStrAddress(address.readLine());
			System.out.println("Enter your state :");
			BufferedReader state=new BufferedReader(new InputStreamReader(System.in));
			investorNew.setStrState(state.readLine());
			System.out.println("Enter your email id :");
			BufferedReader email=new BufferedReader(new InputStreamReader(System.in));
			investorNew.setStrEmail(email.readLine());
			System.out.println("Enter your contact number :");
			BufferedReader number=new BufferedReader(new InputStreamReader(System.in));
			investorNew.setnMobile(Integer.parseInt(number.readLine()));
			System.out.println("Enter amount :");
			BufferedReader amount=new BufferedReader(new InputStreamReader(System.in));
			investorNew.setAmountInAccount(Double.parseDouble(amount.readLine()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			profile.testprofile(investorNew);
		}
		
		if(requestType==2)account.accountOperations(investor1);
		
		if(requestType==3) {
			System.out.println("In Portfolio");
			//this.order = new Order(investor);
			//order.orderOperation();
			new Order(investor1).orderOperation();
		}
	};
}
