
import java.util.Comparator;
public class DateComparator implements Comparator<date> {

	@Override
	public int compare(date date1, date date2)
	{
	int yearDifference = date1.getYear() - date2.getYear();
		
	if (yearDifference != 0) 
	return yearDifference;
	int monthDifference = date1.getMonth() - date2.getMonth();
		
	if (monthDifference != 0) 
	return monthDifference;
		
	int dayDifference = date1.getDay() - date2.getDay();
	return dayDifference;
	 
	}

}
