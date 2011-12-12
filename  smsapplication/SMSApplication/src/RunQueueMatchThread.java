
public class RunQueueMatchThread {

	
	
	public static void main(String[] args)  {
	

		ActiveState as = ActiveState.getInstance();
		as.setThreadChanger("false");
		as.start();

	}

}
