package collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;




public class ArrayListTest {

	public static void main(String[] args) {
		List<String> list= new ArrayList<>();
		
		
		list.add("뽀로로");
		list.add("루피");
		list.add("포비");
		
		// 순회1
		for(int i =0;i<list.size();i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		//삭제
		list.remove(2);
		
		
		//순회 2
		Iterator<String> it= list.iterator();
		while(it.hasNext()) {
			String s =it.next();
			System.out.println(s);
		}
		
		//순회 3
		for(String s: list) {
			System.out.println(s);
	}
	}

}
