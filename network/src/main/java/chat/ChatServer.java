package chat;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import echo.EchoRequestHandler;

public class ChatServer {
	public static final int PORT = 5000;
	
	public static void main(String[] args) {
		
		BufferedReader br =null;
		PrintWriter pw =null;
		Socket socket = null;
		ServerSocket serverSocket =null;
		Scanner scanner =null;
		
		
		try {
			
			//1. 키보드 
			scanner = new Scanner(System.in);
			//2. socket 생성
			serverSocket =new ServerSocket();
			//3. 연결
			serverSocket.bind(new InetSocketAddress("0.0.0.0",PORT),10);
			log("start...[PORT :" + PORT + "]");
			
			
			//4. reader/writer 생성
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
			new EchoRequestHandler(socket).start();
			String inputMessage = br.readLine();
			if(inputMessage.equals("quit")) {
				System.out.println("종료하였습니다.");
				break;
			}
			
		System.out.println(nickname+" : ");
		String input = scanner.nextLine ();
		pw.write(inputMessage+"\n");
		pw.flush();
		}
		}catch(SocketException e) {
			System.out.println("[server] socket connect failed");
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
