import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AddressBook implements Serializable{
	
	public static boolean running = true;
	public static List<ContactMember>AdBook = new ArrayList<ContactMember>();
	public static Scanner in = new Scanner(System.in);
	public static int index = 0;
	public static FileOutputStream fos = null;
	public static ObjectOutputStream out = null;
	public static FileInputStream fin = null;
	public static ObjectInputStream oin = null;
	
	public static void main(String[] kune) {
		while(running) {
			System.out.println("Enter Your choice:");
			System.out.println("0>Load Addressbook\n1>Add\n2>Display First Contact\n3>Dispaly next contact\n4>Display Previous conctact\n5>Display last contact\n6>Display all\n7>Exit\n");
			int choice = in.nextInt();
			switch(choice) {
			case 0:
				loadFile(); break;
			case 1:
				add(); System.out.println(); break;
			case 2:
				display(0); break;
			case 3:
				++index;
				if(index < AdBook.size())
					display(index); 
				else
					System.out.println("This is only the last Record\n");
				break;
			case 4:
				--index;
				if(index != 0)
					display(index); 
				if(index == 0) System.out.println("This is the very first Record\n");
				break;
			case 5:
				display(AdBook.size() - 1); break;
			case 6:
				displayAll(); break;
			case 7:
				saveInFile(); running = false; break;
			default:
				System.out.println("Check your choice number again!!\n");
			}	
		}
		System.exit(0);
}

	private static void displayAll() {
		Iterator<ContactMember> it = AdBook.iterator();
		while(it.hasNext()) {
			ContactMember cm = (ContactMember) it.next();
			System.out.println(cm.toString());
		}
	}

	private static void add() {
		System.out.print("Enter Name: ");
		String name = in.nextLine();
		name = in.nextLine();
		System.out.print("Enter phone Number: ");
		long phoneno = in.nextLong();
		System.out.print("Enter Street: ");
		String street = in.nextLine();
		street = in.nextLine();
		System.out.print("Enter City: ");
		String city = in.nextLine();
		System.out.print("Enter State: ");
		String state = in.nextLine();
		System.out.print("Enter Pincode: ");
		int pincode = in.nextInt();
		ContactMember cm = new ContactMember(name, phoneno, street, city, state, pincode);
		AdBook.add(cm);
	}

	private static void saveInFile() {
		try {
			fos = new FileOutputStream("Address_book");
			out = new ObjectOutputStream(fos);
			out.writeObject(AdBook);
			out.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadFile() {
		File file = new File("Address_book");
		if(file.exists()) {
			try {
				fin = new FileInputStream("Address_book");
				oin = new ObjectInputStream(fin);
				AdBook = (List<ContactMember>) oin.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("File Not Found!!");
		}
	}

	private static void display(int i) {
		ContactMember cm = AdBook.get(i);
		System.out.println(cm.toString());
	}
}
