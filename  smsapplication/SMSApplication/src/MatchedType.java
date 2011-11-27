
public abstract class MatchedType {

	ProcessOrderImplementor orderimp=null;
	
	protected ProcessOrderImplementor impl;
	
	public MatchedType(ProcessOrderImplementor proc_imp)
	{
		impl=proc_imp;
	}
	
	
	protected boolean processPartialOrder(int buyOrderID, int sellOrderID,int buyLot, int sellLot,int buyMatch,int sellMatch) 
	{
		impl.processPartialOrder(buyOrderID, sellOrderID, buyLot, sellLot, buyMatch, sellMatch);
		
		
		return true;
	}
	
	protected boolean processCompleteOrder(int buyOrderID, int sellOrderID)
	{
		impl.processCompleteOrder(buyOrderID, sellOrderID);
		return true;
	}
	
	public abstract void processOrder();
	

}	
