
public class TestFacadeClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Investor investor = new Investor();
		investor.setStrFirstName("Kaustubh");
		investor.setStrLastName("Phadnis");
		investor.setStrAddress("37 S ,8th Street");
		investor.setStrState("CA");
		investor.setStrEmail("kmp@gmail.com");	
		
		Portfolio portfolio = new Portfolio(1,investor);
		portfolio.processRequestType();
		
	}

}
