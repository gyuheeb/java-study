package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s =new HashSet<>();
		
		String s1= new String("크롱");
		String s2 = new String("크롱");
		s.add("뽀로로");
		s.add("루피");
		s.add("포비");
		s.add(s1);
	//	s.add(s2);
//		s.add("크롱");
//		s.add("크롱"); //내용이 같아서 안됨.

		System.out.println(s.size());
		System.out.println(s.contains(s.contains(s2)));
		
		//순회1
		
		for(String str : s) {
			System.out.println(str);
		}
	}

}
