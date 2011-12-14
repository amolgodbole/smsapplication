
public abstract class StockDecorator extends StockItem {

	protected StockItem stockItem;
	
	public StockDecorator(StockItem stockItem)
	{
		this.stockItem=stockItem;
	}
	
	
}
