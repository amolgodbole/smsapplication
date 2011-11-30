
public interface ActiveOrderStateInterface {

	void receiveOrder();
	void processMatching();
	void updateResult();
	public ActiveStatesInterface getMatched(StockOrderInterface stockOrder);
	public ActiveStatesInterface getMatching();
	public ActiveStatesInterface getWaiting();

	
	void setStates(ActiveStatesInterface state);
}
