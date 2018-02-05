import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

//all the file methods :
//1.Create new file to input our records
//2.Open already existing file 
//3.Load records


public class fileMethods {
	private static Scanner input;	
	private static Formatter output;
	
	public static void openFile(String path)
	 {
	 try
	 {	
	 input = new Scanner(Paths.get(path)); // open the file
	 }
	 catch (IOException ioException)
	  {
	  System.err.println("Error opening file. Terminating.");
	  System.exit(1);
	  }
	 }
	
//The reminder for each date is written into the text file and is appended 	automatically with " . "
//Thus, the user shouldn't add any ...signs.
	
	public static void readRecords( Map<date,String> myMap)
	{
		try 
		{
			 while (input.hasNext()) // more data to read
			 { 				 
			 int dd = input.nextInt();
			 int mm = input.nextInt();
			 int yy = input.nextInt();
			 String rem=input.next();			
			 boolean t =true;
			
			while(t)
			{String temp=input.next();				
				if (temp.equals("."))
				{  
					t=false;break; 
				}
				else {rem+=" "+temp;}
			 }
			
				
		
			 date date2=new date(dd,mm,yy); 
			 myMap.put(date2, rem);
			    }
		 }
		catch (NoSuchElementException elementException)
		 {
		 System.err.println("File improperly formed. Terminating.");
		 }
		 catch (IllegalStateException stateException)
		 {
		 System.err.println("Error reading from file. Terminating.");
		 }
	} 
	
	
	
	public static void createFile_new(String name)
	 {
	 try
	 {
	  output = new Formatter(name);
	 }
	 catch (SecurityException securityException)
	 {
	 System.err.println("Write permission denied. Terminating.");
	 System.exit(1); // terminate the program
	 }
	 catch (FileNotFoundException fileNotFoundException)
	 {
	 System.err.println("Error opening file. Terminating.");
	 System.exit(1); // terminate the program
	 }
	 }	
	
	
}
