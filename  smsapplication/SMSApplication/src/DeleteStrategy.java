
public interface DeleteStrategy {

	boolean expiredType=false;
	boolean orderCompletionStateType=false;
	boolean customerDeleteType=false;

	public String deleteOrder(Investor investor, String OrderID);

}
