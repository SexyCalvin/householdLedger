import java.io.IOException;

public class Activate {
	static ScreenActs screenActs = new ScreenActs();
	static DataExchange dataExchange = new DataExchange();
	static ActFlow actFlow = new ActFlow();
	public static void main(String[] args) throws IOException {
		actFlow.run();
	}

}
