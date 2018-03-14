
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

		
public class CashierFrame extends JFrame implements ActionListener {

	JButton sellTicketBtn=new JButton(new ImageIcon("C:\\Users\\Pop\\Downloads\\ttk.png"));
	JButton seeAllTicketsBtn=new JButton(new ImageIcon("C:\\Users\\Pop\\Downloads\\aalltkt.png"));
	public CashierFrame()
	{
		JFrame frame = new JFrame("User Window");
		frame.setSize(650, 650);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	
		
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\Pop\\Downloads\\ttklogo.png"));
		panel.add(background);
		background.setBounds(130,-0,350,350);
		
		panel.add(sellTicketBtn);
		sellTicketBtn.setBounds(80,450,50,50);
		
		JLabel sellTicket = new JLabel("Sell ticket");
		panel.add(sellTicket);
		sellTicket.setBounds(78, 485,100,50);

		
		
		panel.add(seeAllTicketsBtn);
		seeAllTicketsBtn.setBounds(80+400,450,50,50);
		
		JLabel seeAllTickets = new JLabel("See all tickets for a show");
		panel.add(seeAllTickets);
		seeAllTickets.setBounds(440, 485,150,50);
		
		
	
		
		
		
		sellTicketBtn.addActionListener(this);
		seeAllTicketsBtn.addActionListener(this);
	}

	@Override
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sellTicketBtn) {
			System.out.println("Sell ticket frame opened"); // quit application and close frame when QUIT is
							// pressed
		}
		if (e.getSource() == seeAllTicketsBtn) {
			System.out.println("See all tickets frame opened"); // quit application and close frame when QUIT is
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