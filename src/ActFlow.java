
public class ActFlow {
	static ScreenActs screenActs = new ScreenActs();
	static DataExchange dataExchange = new DataExchange();
	
	public static void run() {
		screenActs.LoginScreen();
		
		dataExchange.GeneratingExcel();
	
	}
}
