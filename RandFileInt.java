import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class RandFileInt {
	
	public static FileOutputStream fos = null;
	public static ObjectOutputStream out = null;
	public static Random randNum = new Random();
	public static void main(String[] kune) {
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("myfile2");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<100;++i) {
			pw.println(randNum.nextInt());
		}
		pw.close();
		
	}

}
