import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Listing {
	
	
	List<StockBean> stockList = new ArrayList<StockBean>(); 
	public Listing(){
		
	}
	
	public void addToList(StockBean sb){
		System.out.println("Stock list has been added to listings");
		stockList.add(sb);
		
		Iterator<StockBean> itr = stockList.iterator();
		
		while(itr.hasNext()) {
			StockBean stockBean = (StockBean) itr.next();
			System.out.println("--------------------------------------------------");
			System.out.println("Company name: "+stockBean.getStrCompanyName());
			System.out.println("--------------------------------------------------");
			System.out.println("Company id: "+stockBean.getStrCompanyID());
			System.out.println("Stock name: "+stockBean.getStockname());
			System.out.println("Stock id: "+stockBean.getStockid());
			System.out.println("Stock price: "+stockBean.getdStockPrice());
			System.out.println("Stock count: "+stockBean.getTotalNoStocks());
			System.out.println("--------------------------------------------------");
		}
	}
	
}
