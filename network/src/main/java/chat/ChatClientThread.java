package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
				//writer.println(scanner.nextLine()); 
			}
			
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			
		}
		
		
	}
	
	}

	
	

