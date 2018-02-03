import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExampleOfDate {
	public static Date date;
	public static Scanner in = new Scanner(System.in);
	public static DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public static void main(String[] kune) {
		System.out.println("Enter first date in dd/MM/yyyy");
		String buf = in.nextLine();
		try {
			date = formatter.parse(buf);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Date: "+date.toString());
	}
}
