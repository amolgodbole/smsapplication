import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestFacadeClientTwo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	Investor investor = new Investor();
	public TestFacadeClientTwo(Investor investor)
	{
		this.investor = investor;
	}
	public void callOperation(){
		int choice = 0;
		Portfolio portfolio = new Portfolio(investor);
		
			while(true) {
				System.out.println("Enter your choice : ");
				System.out.println("1. Access Profile");
				System.out.println("2. Access Account");
				System.out.println("3. Manage Order");
				System.out.println("4. Exit");
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String option;
				
				try {
					option = br.readLine();
					if(option.equals("1")){
						choice=1;
						portfolio.processRequestType(choice);
						
					}
					if(option.equals("2")){
						choice=2;
						portfolio.processRequestType(choice);
					}
					if(option.equals("3")){
						choice=3;
						portfolio.processRequestType(choice);
					}
					if(option.equals("4")) break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
				
			}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		Investor investor = new Investor();
		investor.setInvestorID("INV01STK01");
		investor.setStrFirstName("Akshay");
		investor.setStrLastName("Kumar");
		investor.setStrAddress("Colonade");
		investor.setStrState("CA");
		investor.setStrEmail("aks@gmail.com");	
		investor.setnPhone(4089899898L);
		TestFacadeClientTwo tc = new TestFacadeClientTwo(investor);
		tc.callOperation();
		
			
		
				
	}

}
