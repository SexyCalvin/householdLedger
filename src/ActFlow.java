import java.io.IOException;
import java.io.*;
import javax.swing.*;
import javax.swing.JFrame;

public class ActFlow extends JFrame {
	private static final long serialVersionUID = 1L;
	static ScreenActs screenActs = new ScreenActs();
	static DataExchange dataExchange = new DataExchange();
	
	public static void run() throws IOException {
		File f = new File("D:/DataExcel.xls");
		if (!f.isFile()) {
			dataExchange.GeneratingExcel();
		}
		screenActs.LoginScreen();
	}
}
