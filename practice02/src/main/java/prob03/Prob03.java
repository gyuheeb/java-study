package prob03;

public class Prob03 {
	
	public static void main(String args[]) {
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };
		// 원래 배열 원소 출력	
		String str = String.valueOf(c);
		System.out.println(str);
		str = str.replace(' ', ',');
		System.out.println(str);
		
	}
}
