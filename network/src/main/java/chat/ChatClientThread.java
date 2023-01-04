package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.SocketException;
import java.util.Scanner;


public class ChatClientThread extends Thread {
	
	
	BufferedReader bufferedReader;
	
	public ChatClientThread(BufferedReader bufferedReader) {
		this.bufferedReader=bufferedReader;
		
	}

	@Override
	public void run() {
		try {
			String message =null;

			while(true) { 
				 message = bufferedReader.readLine();
				 System.out.println(message);
				
			}
			
			
		} catch (SocketException e) {
			System.out.println("채팅방을 나갔습니다.");
		}catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			
		}
		
		
	}
	
	}

	
	

