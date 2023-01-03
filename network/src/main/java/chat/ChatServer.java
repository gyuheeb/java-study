package chat;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ChatServer {
	public static final int PORT = 9000;
	
	public static void main(String[] args) {
		
		BufferedReader br =null;
		PrintWriter pw =null;
		Socket socket = null;
		ServerSocket serverSocket =null;
		Scanner scanner =null;
		
		
		try {		
			socket = new Socket();
			serverSocket =new ServerSocket();

			List<Writer> listWriters = new ArrayList<>();
			scanner = new Scanner(System.in);
		
	
			serverSocket.bind(new InetSocketAddress("0.0.0.0",PORT),10);
			log("start...[PORT :" + PORT + "]");
	
			
			
		while ( true ) {
			socket = serverSocket.accept();
			
			new ChatServerThread(socket, listWriters).start();

		}
		}catch(SocketException e) {
			System.out.println("[server] socket connect failed"+e);
		}
		catch (IOException e) {
		log("error : "+ e);
		}finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					
					serverSocket.close();
				}
				scanner.close();
			}catch(IOException ex){
				log("error : "+ ex);
			}
		}
		
}
	static void log(String message) {
		System.out.println("[ChatServer ] " + message);
		
	}
}
