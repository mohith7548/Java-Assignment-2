import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncryptionProgram {
	public static final String secretKey = "";
	public static FileWriter fw = null;
	public static FileReader fr = null;
	public static BufferedReader br = null;
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the Target textfile: ");
		String inputfilename = in.nextLine();
		String encryptedContent = encrypt(readFromFile(inputfilename));
		System.out.println("Enter a file name to output Encrypted text: ");
		String outputfilename = in.nextLine();
		writeToFile(outputfilename, encryptedContent);
	}

	private static void writeToFile(String outputfilename, String encryptedContent) {
		try {
			fw = new FileWriter(outputfilename);
			System.out.println("Writing!! Completed");
			fw.write(encryptedContent);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String readFromFile(String filename) {
		String buffer = null;
		String content = "";
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			while( (buffer = br.readLine()) != null) {
				content += buffer;
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return content;
	}

	private static String encrypt(String plainText) {
		StringBuffer encryptedString = new StringBuffer();
		int encryptedInt;
		for (int i = 0; i < plainText.length(); i++) {
			encryptedString.append( (char)((int)plainText.charAt(i)+2) );
		}
		return encryptedString.toString();
	}

	
}
