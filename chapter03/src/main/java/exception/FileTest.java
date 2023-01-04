package exception;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream; 


public class FileTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("hello.txt");
			int data = fis.read();
			System.out.println((char)data);
		} catch (FileNotFoundException e) {
			System.out.println("erro:" +e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("erro:" +e);
			e.printStackTrace();
		}finally {
			try {
			if(fis != null) {
				fis.close();
			}
			fis.close();
			}catch (IOException e){
			e.printStackTrace();
		}

	}
	
	}
}
