package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

//port 마음대로
public class ChatServerThread extends Thread {
	private List<Writer> listWriters;
	private String nickname;
	private Socket socket;

	
	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		
		this.socket =socket;
		this.listWriters=listWriters;
		}
		@Override
		public void run() {
			super.run();
	try {
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
	PrintWriter printWriter = new PrintWriter( new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8));
	
		while(true) {
			String request = bufferedReader.readLine();
			if(request == null) {
				ChatServer.log("클라이언트로 부터 연결 끊김");
				doQuit(printWriter);
				break;
				}
			String[] tokens =request.split(" : ");
			if("join".equals(tokens[0])) {
				doJoin(tokens[1], printWriter);
			} else if("message".equals(tokens[0])) {
				doMessage(tokens[1]);
			}else if("quit".equals(tokens[0])) {
				doQuit(printWriter);
			}
			else {
				log ("에러: 알수 없는 요청( " + tokens[0] + ")" );
			}
			}
	
			}catch (IOException e) {
	           log("채팅방을 나갔습니다.");}
	
		}
	private void log(String string) {
		  System.out.println(string);
			
		}
	private void doJoin(String nickName, Writer writer) throws IOException {
		this.nickname=nickName;
		String data = nickName + "님이 참여하였습니다." ;
		broadcast(data);
		
		/*writer pool에 저장*/
		addWriter(writer);
		
		//ack
		((PrintWriter) writer).println("join:ok");
        writer.flush();
		
	}
		private void addWriter(Writer writer) {
			synchronized(listWriters) {
				listWriters.add(writer);
			}
		}
	
		private void broadcast(String data) {
			synchronized(listWriters) {
				for(Writer writer:listWriters) {
					PrintWriter printWriter = (PrintWriter)writer;
					printWriter.println(data);
					printWriter.flush();
				}
			}
		}
		private void doMessage (String message) throws IOException {
			String data = nickname + " : "+message;
			broadcast(data);
		}
	
		private void doQuit(Writer writer) throws IOException{
			removeWriter(writer);
			String data = nickname +"님이 퇴장하였습니다.";
			broadcast(data);
		}
	
		private void removeWriter(Writer writer) {
			listWriters.remove(writer);
		}

		
		

}
