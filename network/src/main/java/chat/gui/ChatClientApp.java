package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import chat.ChatServerThread;

public class ChatClientApp {
	public static final int PORT = 9000;

	public static void main(String[] args) {

		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = new Socket();

		try {
						socket.connect(new InetSocketAddress("0.0.0.0", PORT));

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			while (true) {

				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				name = scanner.nextLine();

				if (!name.isEmpty()) {
					break;
				}
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}
			
			pw.println("join:" + name);
			String line = br.readLine();
			System.out.println(line);
//			String line = "join:ok";
			
			if ("join:ok".equals(line)) {
				new ChatWindow(name,br,pw).show();
			}
			String message=null;
			while (true) {
				
				message = scanner.nextLine();
				if ("quit".equals(message))
		               break;
				pw.println("message:" + message);

			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		// 3. get iostream

		// 4.join protocol

		
		scanner.close();
	}

	/*-------------------------------------------------------------------------------*/
	private static void log(String message) {
		System.out.println("[ChatServer ] " + message);

	}
}