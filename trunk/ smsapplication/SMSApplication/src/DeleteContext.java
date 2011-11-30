
public class DeleteContext 
{

	private DeleteStrategy deleteStrategy;

	public DeleteContext() {
		// TODO Auto-generated constructor stub
	}

	public String delete(Investor investor, String OrderID, String OrderTypeDelete)
	{
		deleteStrategy = setDeleteStrategy(investor, OrderID,  OrderTypeDelete);
		
		return deleteStrategy.deleteOrder(investor, OrderID);
	}

	private DeleteStrategy setDeleteStrategy(Investor investor, String OrderID,String OrderTypeDelete) 
	{
		// TODO Auto-generated method stub
		

		if(OrderTypeDelete.equalsIgnoreCase("investor_delete"))
		{
			deleteStrategy =  new CustomerDelete();
		}
		else if(OrderTypeDelete.equalsIgnoreCase("expired") )
		{
			deleteStrategy = new Expired();
		}
		else if(OrderTypeDelete.equalsIgnoreCase("completed"))
		{
			deleteStrategy = new OrderCompletionState();
		}
		
		return deleteStrategy;
	}

}
