import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MyDate {
	public static DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	private static Date date1;
	private static Date date2;
	private static long diff;
	public static Scanner in = new Scanner(System.in);
	
	public static long dateDifference(Date date1, Date date2) {
		long diff = date2.getTime() - date1.getTime();
		//return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		return (diff/(1000 * 60 * 60 * 24));
	}
	
	public static void main(String[] kune) {
		System.out.println("Enter Dates in format: dd/MM/yyyy");
		System.out.println("Enter Date-1: ");
		String str_date1 = in.nextLine();
		
		System.out.println("Enter Date-2: ");
		String str_date2 = in.nextLine();
		
		try {
			date1 = format.parse(str_date1);
			date2 = format.parse(str_date2);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		diff = dateDifference(date1, date2);
		System.out.println("Given dates difference is: "+ diff);		
	}
}
