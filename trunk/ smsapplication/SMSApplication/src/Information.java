
public abstract class Information
{
	protected DisplayFormat df;
	protected Investor buyer;
	protected Investor seller;
	
	public abstract void sendNotification();
	
	public Information(DisplayFormat df,Investor buyer,Investor seller){
		this.df=df;
		this.buyer=buyer;
		this.seller=seller;
	}
	
	protected void display(){
		df.displayFormat(buyer,seller);
	}
}
