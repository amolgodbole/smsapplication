
public interface ActiveStatesInterface 
{
	
	String processMatching();
	String updateResult();
	
	String processWaitingOrder(OrderBean order, StockOrderInterface stockOrderInterface);
	String processMatchedOrder(OrderBean order, StockOrderInterface stockOrder);
	String processMatchingOrder(OrderBean order,StockOrderInterface stockOrderInterface);

	
}
