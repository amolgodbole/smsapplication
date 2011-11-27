
public class OrderImplementor2 extends MatchedType{

	private int _buyOrderID,_sellOrderID;
	public OrderImplementor2(ProcessOrderImplementor imp,int buyOrderID,int sellOrderID)
	{
		super(imp);
		_buyOrderID=buyOrderID;
		_sellOrderID=sellOrderID;
		
	}
	
	
	
	@Override
	public void processOrder() {
		processCompleteOrder(_buyOrderID,_sellOrderID);
	}

	
	
}
