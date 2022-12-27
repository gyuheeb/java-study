package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> s =new Stack<>();
		
		s.push("포비");
		s.push("뽀로로");
		s.push("루피");
		
		while(! s.isEmpty()) {
			String str = s.pop();
			System.out.println(str);
		}
		
//		비어 있는 경우에는 예외발생
//		s.pop();
		
		s.push("포비");
		s.push("뽀로로");
		s.push("루피");
		
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
	}

}
