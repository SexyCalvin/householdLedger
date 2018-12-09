import java.io.IOException;

public class ActFlow {
	static ScreenActs screenActs = new ScreenActs();
	static DataExchange dataExchange = new DataExchange();
	
	public static void run() throws IOException {
		dataExchange.GeneratingExcel();
		screenActs.LoginScreen();
		
	}
}
