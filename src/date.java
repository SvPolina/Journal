//Date class


public class date {
	
	private int year; // 0 - 2050
	private int month; // 1 - 12
	private int day;// 1 - 31
	
	public date(){
		this(1,1,0);
	}
	
	public date(int day, int month, int year)
	{
		 if (year < 0 || year >= 2050)
		throw new IllegalArgumentException("year must be 0-2050");
		
		 if (month < 1 || month > 12)
		 throw new IllegalArgumentException("month must be 1-12");
	
		if(month == 1 ||month == 3 ||month == 5 ||month == 7 ||month == 8 ||month == 10 ||month == 12) 
		{
		if (day < 1 || day > 31)
		throw new IllegalArgumentException("day must be 1-31");
		} 
		
		if(month == 4 ||month == 6 ||month == 9 ||month == 11 ) 
		{
		if (day < 1 || day > 30)
		throw new IllegalArgumentException("day must be 1-30");
		} 
		
		if(month == 2 ) 
		{
		if (day < 0 || day > 29)
		throw new IllegalArgumentException("day must be 1-29");
		} 
			
		 this.year = year;
		 this.month = month;
		 this.day = day;
	}
		
		
	public date(date date)
	{
	this(date.getDay(), date.getMonth(),date.getYear() );
	}
	
	
	
	public void setDate(int day, int month, int year)
	 {
		 if (year < 0 || year >= 2050)
				throw new IllegalArgumentException("year must be 0-2050");
				
				if (month < 1 || month > 12)
				throw new IllegalArgumentException("month must be 1-12");
			
				if(month == 1 ||month == 3 ||month == 5 ||month == 7 ||month == 8 ||month == 10 ||month == 12) 
				{
				if (day < 1 || day > 31)
				throw new IllegalArgumentException("day must be 1-31");
				} 
				
				if(month == 4 ||month == 6 ||month == 9 ||month == 11 ) 
				{
				if (day < 1 || day > 30)
				throw new IllegalArgumentException("day must be 1-30");
				} 
				
				if(month == 2 ) 
				{
				if (day < 1 || day > 29)
				throw new IllegalArgumentException("day must be 1-29");
				} 
					
				 this.year = year;
				 this.month = month;
				 this.day = day;
     }
	
	
	public void setYear(int year)
	 {
	 if (year < 0 || year >= 2050)
	 throw new IllegalArgumentException("year must be 0-2050");
	
	 this.year = year;
	 }
	
	 // validate and set minute
	 public void setMonth(int month)
	 {
	 if (month < 1 || month > 12)
	 throw new IllegalArgumentException("month must be 1-12");
		 
	 this.month = month;
	 }
	
	 // validate and set second
	 public void setDay(int day)
	 {
		 if(month == 1 ||month == 3 ||month == 5 ||month == 7 ||month == 8 ||month == 10 ||month == 12) 
			{
			if (day < 1 || day > 31)
			throw new IllegalArgumentException("day must be 1-31");
			} 
			
		if(month == 4 ||month == 6 ||month == 9 ||month == 11 ) 
			{
			if (day < 1 || day > 30)
			throw new IllegalArgumentException("day must be 1-30");
			} 
			
		if(month == 2 ) 
			{
			if (day < 0 || day > 29)
			throw new IllegalArgumentException("day must be 1-29");
			} 
	
	 this.day = day;
	 }
	
	public int getYear()
	 {
	 return year;
	 }
	
	 // get month value
	 public int getMonth()
	 {
	 return month;
	 }
	
	public int getDay()
	 {
	 return day;
	 }
	
	
	@Override
	public boolean equals(Object date1)
	{
	date date2=(date)date1;
	if (this.getYear()==date2.getYear()&&this.getMonth()==date2.getMonth()&&this.getDay()==date2.getDay()){return true;}	
	else return false;
	}
	
	@Override
	public int hashCode()
	{
		int result = 17;
		
		int Yint = this.getYear();
		Integer YInteger = new Integer(Yint);
		int Mint = this.getMonth();
		Integer MInteger = new Integer(Mint);
		int Dint = this.getDay();
		Integer DInteger = new Integer(Dint);
		
		
        result = 31 * result +  (YInteger!=null ? YInteger.hashCode():0);
        result = 31 * result +  (MInteger!=null ? MInteger.hashCode():0);
        result = 31 * result +  (DInteger!=null ? DInteger.hashCode():0);
        return result;	
	}
	
}

