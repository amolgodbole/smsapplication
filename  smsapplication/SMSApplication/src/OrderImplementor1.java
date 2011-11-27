

public class OrderImplementor1 extends MatchedType{

	private int _buyOrderID, _sellOrderID,_sellLot,_buyLot,_buyMatch,_sellMatch;
	
	public OrderImplementor1(ProcessOrderImplementor imp,int buyOrderID,int sellOrderID,int sellLot, int buyLot,int buyMatch,int sellMatch)
	{
		super(imp);
		_buyOrderID=buyOrderID;
		_sellOrderID=sellOrderID;
		_buyLot=buyLot;
		_sellLot=sellLot;
		_buyMatch=buyMatch;
		_sellMatch=sellMatch;
	}
	
	
	
	@Override
	public void processOrder() {
		processPartialOrder(_buyOrderID,_sellOrderID,_buyLot,_sellLot,_buyMatch,_sellMatch);
	}

	
		
	}

	

