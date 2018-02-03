import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DecryptionProgram {
	public static final String secretKey = "";
	public static FileWriter fw = null;
	public static FileReader fr = null;
	public static BufferedReader br = null;
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] kune) {
		System.out.println("Enter the Encrypted textfile: ");
		String inputfilename = in.nextLine();
		String decryptedContent = decrypt(readFromFile(inputfilename));
		System.out.println("Enter a file name to output the Decrypted text: ");
		String outputfilename = in.nextLine();
		writeToFile(outputfilename, decryptedContent);
	}
	
	private static void writeToFile(String outputfilename, String encryptedContent) {
		try {
			fw = new FileWriter(outputfilename);
			System.out.println("Writing! Completed!! ");
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
	
	private static String decrypt(String decryptedText) {
		StringBuffer decryptedString = new StringBuffer();
		int decryptedInt;
		for (int i = 0; i < decryptedText.length(); i++) {
			char buffer = (char) ((int)decryptedText.charAt(i)-2);
			decryptedString.append(buffer );
		}
		return decryptedString.toString();
	}
}
