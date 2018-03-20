
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

		
public class CancelReservationFrame extends JFrame implements ActionListener {

	 JLabel titleLbl = new JLabel("Title");
	 JLabel rowLbl = new JLabel("Row");
	 JLabel colLbl = new JLabel("Col");
	 
	 JTextField titleTxt = new JTextField(20);
	 JTextField rowTxt = new JTextField(20);
	 JTextField colTxt = new JTextField(20);


	 JButton cancelBtn = new JButton("Cancel");

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
	 
	public CancelReservationFrame()
	{
		JFrame frame = new JFrame("Cancel Reservation");
		frame.setSize(450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);

		frame.setVisible(true);
		panel.setLayout(null);

		
		titleLbl.setBounds(10, 10, 80, 25);
		panel.add(titleLbl);
		
		rowLbl.setBounds(10, 40, 80, 25);
		panel.add(rowLbl);
		panel.add(colLbl);
		panel.add(colTxt);
		
		colLbl.setBounds(10,70,80,25);
		colTxt.setBounds(100,70,160,25);
		
		panel.add(genreList);
		genreList.setBounds(100, 10, 160, 25);
		panel.add(titleTxt);
		panel.add(rowTxt);
		rowTxt.setBounds(100, 40, 160, 25);
		

		
		
		cancelBtn.setBounds(100, 120, 80, 25);
		panel.add(cancelBtn);
		cancelBtn.addActionListener(this);
		
	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelBtn)
		{

			try {
				System.out.println("Am intrat aici");
				int i = DbConnection.removeTicketByShowNameAndSeatAndCol(String.valueOf(genreList.getSelectedItem()), Integer.parseInt(rowTxt.getText()), Integer.parseInt(colTxt.getText()));
				JOptionPane.showMessageDialog(null, "Reservation succesfully canceled!", "Check", JOptionPane.INFORMATION_MESSAGE);

			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Seat not found!", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
							// pressed
		}

	}



}