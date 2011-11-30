
public class DeleteContext 
{

	private DeleteStrategy deleteStrategy;

	public DeleteContext() {
		// TODO Auto-generated constructor stub
	}

	public String delete(OrderBean order)
	{
		deleteStrategy = setDeleteStrategy(order);
		return null;
	}

	private DeleteStrategy setDeleteStrategy(OrderBean order) 
	{
		// TODO Auto-generated method stub
		return null;

		if(order.deleteMethod.equalsIgnoreCase("investor_delete"))
		{
			deleteStrategy =  new CustomerDelete();
		}
		else if(order.deleteMethod.equalsIgnoreCase("expired") )
		{
			deleteStrategy = new Expired();
		}
		else if(order.deleteMethod.equalsIgnoreCase("completed"))
		{
			deleteStrategy = new OrderCompletionState();
		}
	}

}
