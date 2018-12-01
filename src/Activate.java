
public class Activate {
	static ScreenActs screenActs = new ScreenActs();
	static DataExchange dataExchange = new DataExchange();
	
	public static void main(String[] args) {
		screenActs.LoginScreen();
		dataExchange.GeneratingExcel();
	}

}
