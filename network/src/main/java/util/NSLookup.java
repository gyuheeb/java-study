package util;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print(">>");
			String str = scanner.nextLine();
			
//			String line="www.douzone.com";
			if(str.equals("exit")) {
				break;
				
			}
			try {
				InetAddress[] inetAddresses=InetAddress.getAllByName(str);
				for(int i=0;i<inetAddresses.length;i++) {
					System.out.println(inetAddresses[i].getHostName()+" : "+inetAddresses[i].getHostAddress());
				}
				
				
				
			
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
