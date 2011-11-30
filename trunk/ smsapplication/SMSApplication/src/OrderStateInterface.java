
public interface OrderStateInterface {

	
	String processInitializedOrder(OrderBean order);
	String processActiveOrder(OrderBean order);
	String processDeletedOrder(OrderBean order);
	String processCompletedOrder(OrderBean order);
	void updateResult();



}
