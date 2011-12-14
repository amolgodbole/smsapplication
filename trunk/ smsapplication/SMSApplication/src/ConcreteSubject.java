
public class ConcreteSubject extends AbstractSubject
{
	
	Investor buyer;
	Investor seller;
	OrderBean buyerOrder;
	OrderBean sellerOrder;
	Double price;
	
	
	public ConcreteSubject()
	{
		
	}
	
	public ConcreteSubject(Investor buyer, Investor seller, Double price, OrderBean buyerOrder, OrderBean sellerOrder)
	{
		this.buyer = buyer;
		this.seller = seller;
		this.price = price;
		this.buyerOrder = buyerOrder;
		this.sellerOrder = sellerOrder;
	}
	
	
	
}
