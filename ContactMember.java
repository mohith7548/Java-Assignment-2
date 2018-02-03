import java.io.Serializable;
import java.util.Scanner;

public class ContactMember implements Serializable {
	private String name;
	private long phoneno;
	private String street, city, state;
	private int pincode;
	public static Scanner in = new Scanner(System.in);
	
	public ContactMember(String name, long phoneno, String street, String city, String state, int pincode) {
		this.name = name;
		this.phoneno = phoneno;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "Name: "+name+"\nPhone Number: "+phoneno+"\nStreet: "+street+"\nCity: "+
				city+"\nState: "+state+"\nPincode: "+pincode+"\n";
	}
}
