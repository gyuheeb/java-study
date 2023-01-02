
package chat;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
public class ChatClient {
	
	private static Socket socket;
	
	private static final int PORT = 9000;
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		while( true ) {
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (!name.isEmpty()) {
				break;
			}
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		

		
		Socket socket = new Socket();
		
		try {
			socket.connect(new InetSocketAddress("0.0.0.0", PORT));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			pw.println("join:" + name);
			
			
			while(true) {
				String data;
				System.out.println(name +"님 대화를 입력해주세요. >>");
				data= scanner.nextLine();
				;
				
				
			}
			
			
		} catch (SocketException e) {
			System.out.println("[Client] socket disconnected"+e);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}scanner.close();
			} 
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}