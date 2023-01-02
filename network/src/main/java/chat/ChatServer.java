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
			//1. 키보드 
			List<Writer> listWriters = new ArrayList<>();
			scanner = new Scanner(System.in);
			//2. socket 생성
			
			//3. 연결
			serverSocket.bind(new InetSocketAddress("0.0.0.0",PORT),10);
			log("start...[PORT :" + PORT + "]");
			//4. reader/writer 생성
			socket = serverSocket.accept();
			
			
		br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			//5. join 프로토클
			System. out. print("닉네임>" ) ;
			String nickname = scanner.nextLine () ;
			pw.println( "join:"+ nickname);
			pw.flush();
					
			//6. ChatClientReceiveThread 시작
				
		//7. 키보드 입력 처리
		while ( true ) {
			socket = serverSocket.accept();
			new ChatServerThread(socket, listWriters).start();
//			String inputMessage = br.readLine();
//			if(inputMessage.equals("quit")) {
//				System.out.println("종료하였습니다.");
//				break;
//			}
//			
//		System.out.println(nickname+" : ");
//		String input = scanner.nextLine ();
//		pw.write(inputMessage+"\n");
//		pw.flush();
		}
		}catch(SocketException e) {
			System.out.println("[server] socket connect failed"+e);
		}
		catch (IOException e) {
		log("error : "+ e);
		}finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					scanner.close();
			serverSocket.close();
				}
				
			}catch(IOException ex){
				log("error : "+ ex);
			}
		}
		
}

	static void log(String message) {
		System.out.println("[ChatServer ] " + message);
		
	}
}
