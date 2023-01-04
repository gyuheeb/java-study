 package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

import chat.ChatServer;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});
		
		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});   //45-53 enter 시, send가능

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish(); // x누르면 채팅창 꺼짐 finish에 구현후 호출
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		//IOStream 받아오기 
		//ChatClientThread 생성하고 실행
		
	}
	private void finish() {
		//quit protocol 구현
			System.exit(0);
		
		//exit java(Application)
	
		//x누르면 창 닫기
		
	}
	
	private void sendMessage() {
		String message = textField.getText();	
		System.out.println("메세지 보내는 프로토콜 "+ message);
		
		textField.setText(" ");  //70-71 입력창 reset
		textField.requestFocus();
		
		// ChatClientThread 에서 서버로 부터 받은 메세지가 있다 치고
		updateTextArea("마이콜"+message);
	}
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
		
	}
	private class ChatClientThread extends Thread {
		
		Socket socket;
		Vector<Socket> vec;
		public ChatClientThread(Socket socket, Vector<Socket>vec) {
			this.socket =socket;
			this.vec = vec;
		}
	@Override 
	public void run() {
			BufferedReader br =null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String message =null;

			while(true) { 
				 message = br.readLine();
				 if(message == null) {
					 vec.remove(socket);
					 break;
				 }
				 log(message);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(br!=null)
					br.close();
				if(socket !=null)
					socket.close();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
		updateTextArea("안녕");
	}
	private void log(String message) {
		try{
			for(Socket socket:vec) {
		
			if(socket != this.socket) {
				PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
				pw.println(message);
				pw.flush();
			}}
		}
	catch(IOException e) {
		System.out.println(e.getMessage());
	}
	}
	}
	}
