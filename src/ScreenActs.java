import java.awt.*;
import java.awt.event.*;
import javax.swing.JTextField;

import javax.swing.*;
import java.text.*;
import java.util.Calendar;
import java.util.Date;

public class ScreenActs extends JFrame {
	private static final long serialVersionUID = 1L;
	/*Calendar calendar = Calendar.getInstance();
	int hour = calendar.get(Calendar.HOUR_OF_DAY);
	int min = calendar.get(Calendar.MINUTE);
	int sec = calendar.get(Calendar.SECOND);*/
	
	javax.swing.Timer timer;
	
	JPanel panel = new JPanel();
	JLabel label1 = new JLabel("아이디");
	JLabel label2 = new JLabel("패스워드");
	JTextField txtId = new JTextField(20);
	JTextField txtPwd = new JTextField(20);
	
	/*public void TimerDisplay() {
		//time
		timer = new javax.swing.Timer(1000, this);
		timer.setInitialDelay(0);
		timer.start();
					
		label_ = new JLabel("Current Time || " + hour + ":" + min + ":" + sec, Label.RIGHT);
		add(label_);
	}*/
	
	public void LoginScreen() {
		//GridLayout grid = new GridLayout(2,3);
		//setLayout(grid);
		setBounds(100, 100, 400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		JButton logIn = new JButton("Log IN");
		
		label1.setBounds(20, 50, 120, 20);
		label2.setBounds(50, 50, 120, 20);
		txtId.setBounds(20, 180, 100, 20);
		txtPwd.setBounds(50, 180, 100, 20);
		
		panel.add(label1);
		panel.add(txtId);
		panel.add(label2);
		panel.add(txtPwd);
		panel.add(logIn);
		
		contentPane.add(panel);
		
		setVisible(true);
	}
	
	public void mainScreen() {
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
