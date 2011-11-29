import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestFacadeClient {

	/**
	 * @param args
	 * @throws IOException 
	 */
	Investor investor = new Investor();
	public TestFacadeClient(Investor investor)
	{
		this.investor = investor;
	}
	public void callOperation(){
		int choice = 0;
		System.out.println("Enter your choice : ");
		System.out.println("1. Access Profile");
		System.out.println("2. Access Account");
		System.out.println("3. Manage Order");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String option;
		try {
			option = br.readLine();
			if(option.equals("1")) choice=1;
			if(option.equals("2")) choice=2;
			if(option.equals("3")) choice=3;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	
		
		Portfolio portfolio = new Portfolio(choice,investor);
		portfolio.processRequestType();

	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		Investor investor = new Investor();
		investor.setInvestorID("INV01STK01");
		investor.setStrFirstName("Kaustubh");
		investor.setStrLastName("Phadnis");
		investor.setStrAddress("37 S ,8th Street");
		investor.setStrState("CA");
		investor.setStrEmail("kmp@gmail.com");	
		investor.setAccountBal(9856); 
		investor.setnPhone(4089899898L);
		TestFacadeClient tc = new TestFacadeClient(investor);
		tc.callOperation();
		
			
		
				
	}

}
