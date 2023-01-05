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

import chat.ChatClientThread;
import chat.ChatServer;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private String name;
	private BufferedReader br;
	private PrintWriter pw;
	
	

	public ChatWindow(String name, BufferedReader br, PrintWriter pw) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.name=name;
		this.br=br;
		this.pw=pw;
		new ChatClientThread(br).start();
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
		});   //enter 시, send가능

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

	}
	private void finish() {
		//quit protocol 구현
		pw.println("quit");
			System.exit(0);
	}
	
	private void sendMessage() {
		String message = textField.getText();	
		System.out.println("메세지 보내는 프로토콜 : "+ message);
		
		textField.setText("");  // 입력창 reset
		textField.requestFocus();

		
		if(message.equals("quit")) {
			finish();
		}else if(message.equals("")) {
			
		}
		else {
			pw.println("message:"+message);
		}
		
	
	}
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
		
	}
	private class ChatClientThread extends Thread {
		BufferedReader br;
		public ChatClientThread(BufferedReader br) {
			this.br = br;
			
		}
	@Override 
	public void run() {
		String message = null;
		
		while(true) {
			try {
				message = br.readLine();
				System.out.println(message);
				updateTextArea(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
			
	}
}
}
