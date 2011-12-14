
public class EmailFormatDisplay extends DisplayFormat{

	public void displayFormat(Investor buyer,Investor seller){
		// Display information
		System.out.println("Email notification sent to buyer : " +buyer.getStrFirstName());
		System.out.println("Email notification sent to seller : " +seller.getStrFirstName());
		
	}
}
	