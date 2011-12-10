import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestCompanyListing 
{
	Stock stock = new Stock();
	
	public TestCompanyListing() {
		// TODO Auto-generated constructor stub
	}
	
	public TestCompanyListing(Company company) {
		// TODO Auto-generated constructor stub
	}
	
	public void callOperation(){
		int choice = 0;
			while(true) {
				System.out.println("Enter your choice : ");
				System.out.println("1. List Stock");
				System.out.println("2. Split Stock");
				System.out.println("3. Exit");
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String option;
				
				try {
					option = br.readLine();
					if(option.equals("1")) {
						choice=1;
						//stock.processRequestType(choice);
					}
					if(option.equals("2")){
						choice=2;
						//stock.processRequestType(choice);
					}
					if(option.equals("3")) break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestCompanyListing tc = new TestCompanyListing();
		tc.callOperation();
	}

}
