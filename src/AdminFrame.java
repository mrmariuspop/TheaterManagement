
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

		
public class AdminFrame extends JFrame implements ActionListener {

	JButton addCashier=new JButton(new ImageIcon("C:\\Users\\Pop\\Downloads\\addCashier.png"));
	JButton showsBtn=new JButton(new ImageIcon("C:\\Users\\Pop\\Downloads\\show.png"));
	JButton export=new 	JButton(new ImageIcon("C:\\Users\\Pop\\Downloads\\exp.png"));
	public AdminFrame()
	{
		JFrame frame = new JFrame("User Window");
		frame.setSize(650, 650);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\Pop\\Downloads\\adminlogo.png"));
		panel.add(background);
		background.setBounds(130,-70,350,350);
		
		panel.add(addCashier);
		addCashier.setBounds(80,250,50,50);
		
		JLabel cashiers = new JLabel("Cashiers");
		panel.add(cashiers);
		cashiers.setBounds(78, 285,100,50);

		JLabel welcome = new JLabel("Welcome Marius Pop!");
		panel.add(welcome);
		welcome.setBounds(250,100,200,200);
		
		
		panel.add(showsBtn);
		showsBtn.setBounds(80+400,250,50,50);
		
		JLabel showsLbl = new JLabel("Shows");
		panel.add(showsLbl);
		showsLbl.setBounds(485, 283,100,50);
		
		
	
		panel.add(export);
		export.setBounds(80,450,50,50);
		
		JLabel persInfo = new JLabel("Export to csv");
		panel.add(persInfo);
		persInfo.setBounds(70, 485 ,150,50);

		
		
		addCashier.addActionListener(this);
		showsBtn.addActionListener(this);
	}

	@Override
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addCashier) {
			CashierEditFrame cash1 = new CashierEditFrame();

			System.out.println("Cashier Window opened!"); // quit application and close frame when QUIT is
							// pressed
		}
		if (e.getSource() == showsBtn) {
			ShowsFrame cash1 = new ShowsFrame();
			System.out.println("Shows Window opened!"); // quit application and close frame when QUIT is
							// pressed
		}
		
		
		
		
//		showsBtn
//		if (e.getSource() == registerButton) {
//			RegisterFrame frame2 = new RegisterFrame();
//							// pressed
//		}
//
	}



}