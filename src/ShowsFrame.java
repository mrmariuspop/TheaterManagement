
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

		
public class ShowsFrame extends JFrame implements ActionListener {

	JLabel displayAll=new JLabel(new ImageIcon("C:\\Users\\Pop\\Downloads\\trt.png"));

	
	JButton addShow=new JButton("Add");
	JButton updateShow=new JButton("Update");
	JButton deleteShow=new JButton("Delete");
	JButton displayAllShows=new JButton("Display");

	
	public ShowsFrame()
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
		
		panel.add(addShow);
		addShow.setBounds(80,250,100,25);
		
		JLabel cashiers = new JLabel("Create Show");
		panel.add(cashiers);
		cashiers.setBounds(85, 260,100,50);

		
		panel.add(updateShow);
		updateShow.setBounds(80+400,250,100,25);
		
		JLabel payTaxes = new JLabel("Update Show");
		panel.add(payTaxes);
		payTaxes.setBounds(485, 260,100,50);
		
		
		panel.add(deleteShow);
		deleteShow.setBounds(80,430,100,25);
		
		JLabel persInfo = new JLabel("Delete Show");
		panel.add(persInfo);
		persInfo.setBounds(85, 440 ,150,50);

		panel.add(displayAllShows);
		displayAllShows.setBounds(80+400,430,100,25);
		
		JLabel displayLbl = new JLabel("Display All");
		
		panel.add(displayLbl);
		displayLbl.setBounds(500, 440 ,150,50);
		
		addShow.addActionListener(this);
		updateShow.addActionListener(this);
		deleteShow.addActionListener(this);
		displayAllShows.addActionListener(this);

	}

	@Override
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addShow) {
			System.out.println("Add new show window!"); // quit application and close frame when QUIT is
							// pressed
		}
		if (e.getSource() == updateShow) {
			System.out.println("Update a show!"); // quit application and close frame when QUIT is
							// pressed
		}
		if (e.getSource() == deleteShow) {
			System.out.println("Pick a show to delete!"); // quit application and close frame when QUIT is
							// pressed
		}
		if (e.getSource() == displayAllShows) {
			System.out.println("Display all shows window!"); // quit application and close frame when QUIT is
							// pressed
		}
//		
//		if (e.getSource() == registerButton) {
//			RegisterFrame frame2 = new RegisterFrame();
//							// pressed
//		}
//
	}



}