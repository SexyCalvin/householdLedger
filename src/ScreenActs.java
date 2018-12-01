import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.text.*;
import java.util.Calendar;
import java.util.Date;

public class ScreenActs extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	/*Calendar calendar = Calendar.getInstance();
	int hour = calendar.get(Calendar.HOUR_OF_DAY);
	int min = calendar.get(Calendar.MINUTE);
	int sec = calendar.get(Calendar.SECOND);*/
	
	javax.swing.Timer timer;
	JLabel label_;
	
	/*public void TimerDisplay() {
		//time
		timer = new javax.swing.Timer(1000, this);
		timer.setInitialDelay(0);
		timer.start();
				
		label_ = new JLabel("Current Time || " + hour + ":" + min + ":" + sec, Label.RIGHT);
		add(label_);
	}*/
	
	public void LoginScreen() {
		//super("¿ëµ·°ü¸®.exe");
		
		setBounds(100, 100, 1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JFrame.setDefaultLookAndFeelDecorated(true);
		
		//ScreenActs timerDisplay = new ScreenActs();
		Container contentPane = this.getContentPane();
		JPanel panel = new JPanel();
		//JFrame frame = new JFrame();
		
		//frame.setContentPane(timerDisplay);
		//frame.pack();
		//frame.setVisible(true);
		
		
		JButton startButton = new JButton("Log IN");
		//startButton.setMnemonic("enter");
		
		panel.add(startButton);
		contentPane.add(panel);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
