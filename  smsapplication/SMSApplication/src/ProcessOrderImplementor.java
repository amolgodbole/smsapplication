
public abstract class ProcessOrderImplementor {

	abstract public boolean processPartialOrder(int buyOrderID, int sellOrderID,int buyLot,int  sellLot,int  buyMatch,int sellMatch);
	
	abstract public boolean processCompleteOrder(int buyOrderID, int sellOrderID);

}
