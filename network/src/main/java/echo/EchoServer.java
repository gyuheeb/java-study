package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
		public static final int PORT = 8000;
		
		public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket =new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0",8000),10);
			log("start...[PORT :" + PORT + "]");

			Socket socket = serverSocket.accept();
			
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");
			
			try {
					PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
					BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
					
			
				while(true) {
					String data = br.readLine();
					if(data ==null) {
						log("closed by client");
						break;
					}
					log("received:"+ data);
					pw.println(data); //ln 필수 
				}
			}catch(SocketException ex) {
				System.out.println("[server]suddenlyclosed by Client" );
			}catch(IOException ex) {
				log("error :" + ex);
			}finally {
				try {
					if(socket != null && !socket.isClosed()) {
					socket.close();
					}
				}catch(IOException ex){
					ex.printStackTrace();
				}
			}
				
			
		
	
		} catch (IOException e) {
			log("[server] error:"+ e);
		}finally {
			try {
				if(serverSocket != null&& !serverSocket.isClosed()) { 
					serverSocket.close();}
				}catch (IOException e) {
					e.printStackTrace();
					}
				
			}
			
		}
		private static void log(String message) {
			System.out.println("[EchoClient] "+message);
		}
	}

