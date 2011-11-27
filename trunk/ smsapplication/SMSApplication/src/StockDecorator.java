
public abstract class StockDecorator {

	protected Stock stock;
	
	public StockDecorator(Stock s)
	{
		stock=s;
	}

	public void display() {
	stock.display();
	}

}
