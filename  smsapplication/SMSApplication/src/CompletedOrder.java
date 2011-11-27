
public class CompletedOrder extends ProcessOrderImplementor{

	int buyOrderID;
	int sellOrderID;
	


	@Override
	public boolean processPartialOrder(int buyOrderID, int sellOrderID,
			int buyLot, int sellLot, int buyMatch, int sellMatch) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean processCompleteOrder(int buyOrderID, int sellOrderID) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
