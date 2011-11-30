
public interface ActiveOrderStateInterface {

	void receiveOrder();
	void processMatching();
	void updateResult();
	public ActiveStates getMatched();
	public ActiveStates getMatching();
	public ActiveStates getWaiting();

	public void setState(ActiveState state);
	void setStates(ActiveStates state);
}
