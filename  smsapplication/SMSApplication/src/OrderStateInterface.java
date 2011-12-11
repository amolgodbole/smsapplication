
public interface OrderStateInterface {

	
	public String processInitializedOrder(OrderBean order);
	public String processActiveOrder(OrderBean order);
	public String processDeletedOrder(OrderBean order);
	public String processCompletedOrder(OrderBean order);
	void updateResult();
	public String processOrder(OrderBean order);



}
