import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;


//The organization of the panel 

public class datePanel extends JPanel 
{
	
	
	private final 	JPanel             dateJPanel      = new JPanel();
	private final   JComboBox<Integer> DayJComboBox;   // holds days
	private final   JComboBox<Integer> MonthJComboBox; // holds month
	private final   JComboBox<Integer> YearJComboBox; // holds years
	private final 	JPanel             buttonJPanel      = new JPanel();
	private final 	JButton[]          buttons		      = new JButton[2];

	private final 	JTextArea     ReminderField;
	private int dd=1;
	private int mm=1;
	private int yy=2010;
	private static Formatter output;
	
	
	String rem;

	private static final Integer[] days =
	{1, 2, 3, 4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
			
	private static final Integer[] months =
	{1,2,3,4,5,6,7,8,9,10,11,12};
		
	private static final Integer[] years =
	{2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020};
	
	
	
	public datePanel(Map<date,String> myMap, String path)
	{
 	
	DayJComboBox = new JComboBox<Integer>(days);
	DayJComboBox.setMaximumRowCount(5);

	MonthJComboBox = new JComboBox<Integer>(months);
	MonthJComboBox.setMaximumRowCount(5);
	
	YearJComboBox = new JComboBox<Integer>(years);
	YearJComboBox.setMaximumRowCount(5);
	
	dateJPanel.add(DayJComboBox );
	dateJPanel.add(MonthJComboBox );
	dateJPanel.add(YearJComboBox );
	
	ReminderField=new JTextArea(20,40);
	
//Two buttons:
//One for saving the reminder for the given day
//One for checking the reminder for that day if exists.
	this.buttons[0] = new JButton("Save Reminder");
	this.buttons[1] = new JButton("Get Reminder");	
	buttonJPanel.add(buttons[0]);	
	buttonJPanel.add(buttons[1]);
	
	
	
	this.add(dateJPanel,BorderLayout.NORTH);
	this.add(ReminderField,BorderLayout.CENTER);
	this.add(buttonJPanel,BorderLayout.SOUTH);
	
	
		
//Save reminder	
	buttons[0].addActionListener(
			 new ActionListener() // anonymous inner class
			 {
			 @Override
			 public void actionPerformed(ActionEvent event)
			 {
				 date date1=new date(dd,mm,yy);
				 rem=ReminderField.getText();	 				
			     myMap.put(date1,rem);				
			   
			  	addRecords(path,myMap);
			  	closeFile();
			 }
			 }
			 );
	
//get reminder
//The user is responsible to check for each day if there is a reminder for it.
//If the user just writes down his notes without checking, the existing information for that day 
//would be deleted and the new reminder would be saved after the user presses save button. 

	buttons[1].addActionListener(
			 new ActionListener() // anonymous inner class
			 {
			 @Override
			 public void actionPerformed(ActionEvent event)
			 {
			 date date1=new date(dd,mm,yy);	 
			 ReminderField.setText(myMap.get(date1));		
			 }
			 }
			 );

	
	
	DayJComboBox.addItemListener(
			new ItemListener() // anonymous inner class
			{
			// handle JComboBox event
			@Override
			public void itemStateChanged(ItemEvent event)
			{
			// determine whether item selected
			if (event.getStateChange() == ItemEvent.SELECTED)
			dd=(int)DayJComboBox.getSelectedItem();
			}
			} // end anonymous inner class
			); // end call
	
	MonthJComboBox.addItemListener(
			new ItemListener() // anonymous inner class
			{
			// handle JComboBox event
			@Override
			public void itemStateChanged(ItemEvent event)
			{
			// determine whether item selected
			if (event.getStateChange() == ItemEvent.SELECTED)
			mm=(int)MonthJComboBox.getSelectedItem();
			}
			} 
			); 
	
	YearJComboBox.addItemListener(
			new ItemListener() // anonymous inner class
			{
			// handle JComboBox event
			@Override
			public void itemStateChanged(ItemEvent event)
			{
			// determine whether item selected
			if (event.getStateChange() == ItemEvent.SELECTED)
			yy=(int)YearJComboBox.getSelectedItem();
			}
			} 
			); 

	
	}
	
//Method for adding records to the reminder list	

	public static void addRecords(String p, Map<date,String> myMap)  
	 {
		try {output=new Formatter(p);} 
		
		catch (SecurityException securityException)
			{
			 System.err.println("Write permission denied. Terminating.");
			System.exit(1); 
			 }
			catch (FileNotFoundException fileNotFoundException)
			 {
			 System.err.println("Error opening file. Terminating.");
			 System.exit(1); 
			 }
		
		Set<date> keys = myMap.keySet();

		
		for(date d:keys)
		{
		try
			{	
		output.format("%d %d %d %s .%n", d.getDay(),d.getMonth(),d.getYear(),myMap.get(d));		
		   }
		catch (FormatterClosedException formatterClosedException)
		 {
		 System.err.println("Error writing to file. Terminating.");
		 break;
		 }
		 catch (NoSuchElementException elementException)
		 {
		 System.err.println("Invalid input. Please try again.");	
		 }		
		}
	 }	
	
	public static void closeFile()
	 {
	 if (output != null)
		 output.close();
	 }
	
}
