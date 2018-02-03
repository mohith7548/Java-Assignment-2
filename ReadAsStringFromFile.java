import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.util.Scanner;

public class ReadAsStringFromFile {
	public static FileReader fr = null;
	public static FileWriter fw = null;
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] kune) {
		System.out.println("Enter a file Name: ");
		String inputfilename = in.nextLine();
		try {
			fw = new FileWriter(inputfilename);
			System.out.println("Writing!!");
			fw.write("Fuck Your Ribbons Becaz I'm just not a Pretty Girl");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String buffer;
		try {
			fr = new FileReader(inputfilename);
			BufferedReader br = new BufferedReader(fr);
			while((buffer = br.readLine()) != null) {
				System.out.println(buffer);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
