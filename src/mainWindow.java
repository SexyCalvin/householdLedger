import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

class mainWindow extends JFrame{
	static DataExchange dataExchange = new DataExchange();
	private static final long serialVersionUID = 1L;
	mainWindow() {
		String[] months = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
						"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		
		JLabel label1 = new JLabel("월");
		JLabel label2 = new JLabel("일");
		JLabel label3 = new JLabel("수입");
		JLabel label4 = new JLabel("지출");
		JLabel label5 = new JLabel("비고");
		JTextField txt1 = new JTextField(2);
		JTextField txt2 = new JTextField(2);
		JTextField txt3 = new JTextField(20);
		JTextField txt4 = new JTextField(20);
		JTextField txt5 = new JTextField(20);
		JButton load = new JButton("불러오기");
		JButton save = new JButton("저장");
		
		//JLayeredPane layeredPane = new JLayeredPane();
		
		setTitle("가계부 - 메인");
		setSize(800, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane1 = new JLayeredPane();
		layeredPane1.setBounds(0, 0, 800, 450);
		layeredPane1.setLayout(null);
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		
		JComboBox monthCombo = new JComboBox(months);
		JComboBox dayCombo = new JComboBox(days);
		
		label1.setBounds(20, 30, 50, 30);
		label2.setBounds(70, 30, 50, 30);
		label3.setBounds(120, 30, 50, 30);
		label4.setBounds(240, 30, 50, 30);
		label5.setBounds(360, 30, 50, 30);
		txt1.setBounds(20, 60, 50, 30);
		txt2.setBounds(70, 60, 50, 30);
		txt3.setBounds(120, 60, 120, 30);
		txt4.setBounds(240, 60, 120, 30);
		txt5.setBounds(360, 60, 120, 30);
		load.setBounds(480, 60, 100, 30);
		save.setBounds(580, 60, 100, 30);
		monthCombo.setBounds(20, 90, 50, 30);
		dayCombo.setBounds(70, 90, 50, 30);
		
		txt1.setText("1");
		monthCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = ((JComboBox<String>)e.getSource()).getSelectedIndex();
				txt1.setText(months[index]);
			}
		});
		txt2.setText("1");
		dayCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = ((JComboBox<String>)e.getSource()).getSelectedIndex();
				txt2.setText(days[index]);
			}
		});
		final int month; final int day;
		load.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int month = Integer.parseInt(txt1.getText());
				int day = Integer.parseInt(txt2.getText());
				try {
					txt3.setText(dataExchange.dataReading(31*(month-1)+day-1, 2));
					txt4.setText(dataExchange.dataReading(31*(month-1)+day-1, 3));
					txt5.setText(dataExchange.dataReading(31*(month-1)+day-1, 4));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int month = Integer.parseInt(txt1.getText());
				int day = Integer.parseInt(txt2.getText());
				try {
					dataExchange.dataEditing(31*(month-1)+day-1, 2, txt3.getText());
					dataExchange.dataEditing(31*(month-1)+day-1, 3, txt4.getText());
					dataExchange.dataEditing(31*(month-1)+day-1, 4, txt5.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		txt1.setEditable(false); txt2.setEditable(false);
		
        panel.add(label1); panel.add(label2); panel.add(label3); panel.add(label4); panel.add(label5);
        panel.add(txt1); panel.add(txt2); panel.add(txt3); panel.add(txt4); panel.add(txt5);
		panel.add(monthCombo); panel.add(dayCombo);
		panel.add(load); panel.add(save);
		//layeredPane1.add(panel);
		//add(panel);
		setResizable(false);
		setVisible(true);
	}
}
