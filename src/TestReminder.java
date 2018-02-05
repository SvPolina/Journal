import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Map;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Set;
import java.util.TreeSet;

//Journal application
//The user is responsible to check for each day if there is a reminder for it.
//If the user writes  his notes without checking, the existing information for that day 
//would be deleted and the new information would be saved after the user presses the save button. 

public class TestReminder {
	
	//public static Formatter output;	
	private static datePanel myShape;
	public static void main(String[] args)
	 {  
//The user is asked to choose if he wants to create a new text file for his reminder list (choice 1)
//Or wants to use the already existing list(choice 2)		
		String input= JOptionPane.showInputDialog(
				"1-Start new reminder list\n"+
				"2-Load reminder list from file\n");
		int choice=Integer.parseInt(input);
		Map<date,String> myMap=new HashMap<>();

//wants to create a new text file for his reminder list		
		if (choice==1)
		{
			JFrame f = new JFrame();
			String Nmessage= String.format("Please enter the file name ");	
//The user is asked to give a name to his file				
			String Ninput=JOptionPane.showInputDialog(f,Nmessage);
			String s=Ninput+".txt";
			fileMethods.createFile_new(s);	
			myShape=new  datePanel(myMap,s); 		
		}
		
String p="reminder.txt"; 
// wants to use the already existing reminder list		

		if (choice==2)
		{   
			JFrame f = new JFrame();			
			fileMethods.openFile(p);
			fileMethods.readRecords(myMap);	
            myShape=new  datePanel(myMap,p); 		
        }
                    
       			
		JFrame application=new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(myShape);
		application.setSize(500,500);
		application.setVisible(true);					
	 }			
		
}
