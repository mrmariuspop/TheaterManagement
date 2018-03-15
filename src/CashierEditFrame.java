
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

		
public class CashierEditFrame extends JFrame implements ActionListener {

	JLabel displayAll=new JLabel(new ImageIcon("C:\\Users\\Pop\\Downloads\\cashi.png"));

	
	JButton addCashier=new JButton("Add");
	JButton updateCashier=new JButton("Update");
	JButton deleteCashier=new JButton("Delete");
	JButton display=new JButton("Display");

	
	public CashierEditFrame()
	{
		JFrame frame = new JFrame("User Window");
		frame.setSize(650, 650);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	
		
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		
		panel.add(displayAll);
		displayAll.setBounds(130,-70,350,350);
		
		panel.add(addCashier);
		addCashier.setBounds(80,250,100,25);
		
		JLabel cashiers = new JLabel("Create Cashier");
		panel.add(cashiers);
		cashiers.setBounds(85, 260,100,50);

		JLabel welcome = new JLabel("Welcome Marius Pop!");
		panel.add(welcome);
		welcome.setBounds(250,100,200,200);
		
		panel.add(updateCashier);
		updateCashier.setBounds(80+400,250,100,25);
		
		JLabel payTaxes = new JLabel("Update Cashier");
		panel.add(payTaxes);
		payTaxes.setBounds(485, 260,100,50);
		
		
		panel.add(deleteCashier);
		deleteCashier.setBounds(80,430,100,25);
		
		JLabel persInfo = new JLabel("Delete Cashier");
		panel.add(persInfo);
		persInfo.setBounds(85, 440 ,150,50);

		panel.add(display);
		display.setBounds(80+400,430,100,25);
		
		JLabel displayLbl = new JLabel("Display All");
		
		panel.add(displayLbl);
		displayLbl.setBounds(500, 440 ,150,50);
		
		addCashier.addActionListener(this);
		updateCashier.addActionListener(this);
		deleteCashier.addActionListener(this);
		display.addActionListener(this);

	}

	@Override
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addCashier) {
			AddCashierFrame addCashier = new AddCashierFrame();
			System.out.println("Add new cashier window!"); // quit application and close frame when QUIT is
							// pressed
		}
		if (e.getSource() == updateCashier) {
			UpdateCashierFrame updateCashierFrame = new UpdateCashierFrame();
			System.out.println("Update a cashier!"); // quit application and close frame when QUIT is
							// pressed
		}
		if (e.getSource() == deleteCashier) {
			RemoveCashierFrame deleteCashierFrame = new RemoveCashierFrame();
			System.out.println("Pick a cashier to delete!"); // quit application and close frame when QUIT is
							// pressed
		}
		if (e.getSource()==display)
		{
			try {
				List<Cashier> displayAllCashiers = DbConnection.displayAllCashiers();
				CashiersTable ct = new CashiersTable(displayAllCashiers);
				ct.displayTableCust();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Internal Error", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
//		
//		if (e.getSource() == registerButton) {
//			RegisterFrame frame2 = new RegisterFrame();
//							// pressed
//		}
//
	}



}