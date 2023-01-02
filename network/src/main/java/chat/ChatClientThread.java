package chat;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientThread extends Thread {
	Socket socket =null;
	Scanner scanner = new Scanner(System.in);
	
	public ChatClientThread(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
		try {
		
			OutputStream out = socket.getOutputStream();
            		
			PrintWriter writer = new PrintWriter(out, true);
			
			while(true) { 
				writer.println(scanner.nextLine()); 
			}
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
		super.run();
	}

	
	
}
