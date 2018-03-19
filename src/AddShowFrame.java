
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;

public class AddShowFrame extends JFrame implements ActionListener {

	 JLabel userLabel = new JLabel("Title");
	 JTextField titleTxt = new JTextField(20);
	 JLabel genreLbl = new JLabel("Genre");
	 JLabel distributionLbl = new JLabel("Distribution");
	 JTextField distributionTxt = new JTextField(20);
	 JTextField datePickerTxt = new JTextField(20);

	 
	 String[] genres = {"Opera", "Balet"};
	 JComboBox genreList = new JComboBox(genres);
	 
	 
	 JButton addShowBtn = new JButton("Add");
	 JLabel dateLbl = new JLabel("Date");
	 JLabel noTicketsLbl = new JLabel("No.Tickets");
	 
	 JTextField dateTxt = new JTextField(20);
	 JLabel zeroTicketsLbl = new JLabel("0");
	 
	 private static final Properties p = new Properties() {{
		    put("text.today", "Today");
		    put("text.month", "Month");
		    put("text.year", "Year");
		 }};
		 
	 UtilDateModel model = new UtilDateModel();
	 
	 
	 JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
//	 JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

	 
	 
	 
	
	public AddShowFrame()
	{
		JFrame frame = new JFrame("Register Window");
		frame.setSize(300, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);

		frame.setVisible(true);
		panel.setLayout(null);
		
//		panel.add(datePicker);
//		datePicker.setBounds(100, 100 ,160, 30);
		
		panel.add(datePickerTxt);
		datePickerTxt.setBounds(100, 100 ,160, 25);
		
		
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);
		panel.add(dateLbl);
		panel.add(noTicketsLbl);
		panel.add(dateTxt);
		panel.add(zeroTicketsLbl);
		
		distributionTxt.setBounds(100, 70 ,160, 25);
		panel.add(distributionTxt);
		
		//dateTxt.setBounds(100, 100 ,160, 25);
		zeroTicketsLbl.setBounds(100, 130 ,160, 25);
		
		titleTxt.setBounds(100, 10, 160, 25);
		panel.add(titleTxt);

		
		genreLbl.setBounds(10, 40, 80, 25);
		panel.add(genreLbl);

		distributionLbl.setBounds(10,70,80,25);
		panel.add(distributionLbl);
		
		dateLbl.setBounds(10,100,80,25);
		noTicketsLbl.setBounds(10,130,80,25);

		
		
		genreList.setBounds(100, 40, 160, 25);
		panel.add(genreList);

		
		
		addShowBtn.setBounds(100, 180, 80, 25);
		panel.add(addShowBtn);
		addShowBtn.addActionListener(this);
		
	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addShowBtn)
		{
			int aux2 = Integer.parseInt(zeroTicketsLbl.getText());
			String aux = (String) genreList.getSelectedItem();
			
		
			
			try {
				String startDate="01-02-2013";
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
				java.util.Date date = sdf1.parse(startDate);
				java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());  
				
				DbConnection.insertShow(titleTxt.getText(), aux, distributionTxt.getText(), sqlStartDate , aux2);
				JOptionPane.showMessageDialog(null, "Show succesfuly inserted!", "Check", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
				
			}

			
			
			
//			System.out.println(datePicker.getAlignmentY());
			
//			LocalDate localDate = datePicker.getValue();

//			System.out.println(((JTextComponent) datePicker).getText());
			
							// pressed
		}

	}



}