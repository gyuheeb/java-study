
package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClient {

	private static Socket socket;
	private static final int PORT = 9000;

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = new Socket();

		while (true) {
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();

			if (!name.isEmpty()) {
				break;
			}
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		

		try {
			String message = null;
			socket.connect(new InetSocketAddress("0.0.0.0", PORT));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			pw.println("join:" + name);
			new ChatClientThread(br).start();

			while (true) {
				message = scanner.nextLine();
				if ("quit".equals(message))
		               break;
				pw.println("message:" + message);
				
		
			}
			

		} catch (SocketException e) {
			System.out.println("[Client] socket disconnected" + e);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
				scanner.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}