
public class SystemInformation extends Information{
	
	public SystemInformation(DisplayFormat df,Investor buyer,Investor seller){
		super(df,buyer,seller);
	}
	public  void sendNotification(){
		display();
	}
}
