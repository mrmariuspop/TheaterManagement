
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SellTicketFrame extends JFrame implements ActionListener {

	 JLabel titleLbl = new JLabel("Title");
	 JLabel rowLbl = new JLabel("Row");
	 JLabel colLbl = new JLabel("Col");
	 JTextField rowTxt = new JTextField(20);
	 
	 JComboBox genreList = new JComboBox();
	 
	 {
	 try {
		    String[] titleCmb = new String[5];
		    int i = 0;
		    
			List<Show> lista = DbConnection.displayAllShows();
			
			for (Show iterator : lista) {
				String da = iterator.getTitle();
				
				titleCmb[i] = da;
				i++;

			}
			
			 genreList = new JComboBox(titleCmb);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 }
	 
//	 String[] titleCmb = {"Opera", "Balet"};
	 
	 
	 JButton sellBtn = new JButton("Sell");
	 
	 
	 JTextField colTxt = new JTextField(20);
	 
	 
	 
	
	public SellTicketFrame()
	{
		JFrame frame = new JFrame("Sell Ticket Window");
		frame.setSize(300, 300);

		JPanel panel = new JPanel();
		frame.add(panel);

		frame.setVisible(true);
		panel.setLayout(null);
		
		
		panel.add(colLbl);
		panel.add(colTxt);
		
		colTxt.setBounds(100,100,160,25);
		
		rowTxt.setBounds(100, 70 ,160, 25);
		panel.add(rowTxt);
		
		//dateTxt.setBounds(100, 100 ,160, 25);
		
		
		titleLbl.setBounds(10, 40, 80, 25);
		panel.add(titleLbl);

		rowLbl.setBounds(10,70,80,25);
		panel.add(rowLbl);
		
		colLbl.setBounds(10,100,80,25);

		
//		
		genreList.setBounds(100, 40, 160, 25);
		panel.add(genreList);

		
		
		sellBtn.setBounds(100, 180, 80, 25);
		panel.add(sellBtn);
		sellBtn.addActionListener(this);
		
	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sellBtn)
		{
			boolean b;
			try {
				b = DbConnection.checkIfSeatTaken(String.valueOf(genreList.getSelectedItem()), Integer.parseInt(rowTxt.getText()), Integer.parseInt(colTxt.getText()));
				if (b) 
				{
					JOptionPane.showMessageDialog(null, "Seat unavailable!", "Error", JOptionPane.ERROR);

				}
				else 
				{
					int seats = DbConnection.noOfTicketSoldForAShow(String.valueOf(genreList.getSelectedItem()));
					if (seats >= 5) 
					{
						JOptionPane.showMessageDialog(null, "No more seats available for this show!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else 
					{
						if (Integer.parseInt(rowTxt.getText()) >65 || Integer.parseInt(colTxt.getText())> 65 || Integer.parseInt(colTxt.getText()) <0|| Integer.parseInt(colTxt.getText()) <0) 
						{
							JOptionPane.showMessageDialog(null, "Invalid seat!", "Error", JOptionPane.ERROR_MESSAGE);

						}
						else 
						{
							DbConnection.insertTicket(String.valueOf(genreList.getSelectedItem()), Integer.parseInt(rowTxt.getText()), Integer.parseInt(colTxt.getText()));
							JOptionPane.showMessageDialog(null, "Ticket sold!", "Check", JOptionPane.INFORMATION_MESSAGE);
							DbConnection.updateNoTickets(String.valueOf(genreList.getSelectedItem()));
						}
						
						
					}
					
				}
				
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Seat unavailable!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			System.out.println("Sell Ticket Buton pressed");
			
					
			
			
		}

	}



}