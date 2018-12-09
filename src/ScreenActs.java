import java.awt.*;
import java.awt.event.*;

import java.io.*;

import javax.swing.JTextField;
import javax.swing.*;
import java.text.*;
import java.util.Calendar;
import java.util.Date;

public class ScreenActs extends JFrame implements ActionListener{
	static ScreenActs screenActs = new ScreenActs();
	static DataExchange dataExchange = new DataExchange();
	
	private static final long serialVersionUID = 1L;
	/*Calendar calendar = Calendar.getInstance();
	int hour = calendar.get(Calendar.HOUR_OF_DAY);
	int min = calendar.get(Calendar.MINUTE);
	int sec = calendar.get(Calendar.SECOND);*/
	
	javax.swing.Timer timer;
	
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
	
	public void LoginScreen() throws IOException {
		setTitle("가계부 - 로그인");
		//GridLayout grid = new GridLayout(2,3);
		//setLayout(grid);
		setSize(800, 450);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 450);
		layeredPane.setLayout(null);
		JPanel panel = new JPanel();
		
		//Container contentPane = this.getContentPane();
		//contentPane.setLayout(null);
		
		JButton logIn = new JButton("Log IN");
		
		txtId.setText(dataExchange.accountGet(0));
		txtPwd.setText("비밀번호를 입력하십시오.");
		
		label1.setBounds(250, 100, 100, 30);
		label2.setBounds(250, 170, 100, 30);
		txtId.setBounds(370, 100, 180, 30);
		txtPwd.setBounds(370, 170, 180, 30);
		logIn.setBounds(370, 250, 70, 48);
		
		label1.setOpaque(false);
		label2.setOpaque(false);
		txtId.setOpaque(false);
		txtPwd.setOpaque(false);
		
		
		label1.setForeground(Color.red);
		label2.setForeground(Color.red);
		txtId.setForeground(Color.black);
		txtPwd.setForeground(Color.black);
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				//char[] pass = txtPwd.getPassword();
				String pwd = txtPwd.getText();
				try {
					if (!id.equals(dataExchange.accountGet(0)) || !pwd.equals(dataExchange.accountGet(1))) {
						JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 맞지 않습니다.");
					} else {
						boolean isLogin = id.equals(dataExchange.accountGet(0))&&pwd.equals(dataExchange.accountGet(1));
						if(isLogin) {
							JOptionPane.showMessageDialog(null, "로그인 성공. 어서 오십시오, "+dataExchange.accountGet(0)+"님.");
						}
					}
				} catch (HeadlessException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pwd = null;
			}
		};
		logIn.addActionListener(listener);
		
		layeredPane.add(label1);
		layeredPane.add(txtId);
		layeredPane.add(label2);
		layeredPane.add(txtPwd);
		layeredPane.add(logIn);
		
		//contentPane.add(panel);
		layeredPane.add(panel);
		add(layeredPane);
		setVisible(true);
	}
	
	public void mainScreen() {
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
