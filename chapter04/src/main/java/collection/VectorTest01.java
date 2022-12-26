package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		Vector<String> v= new Vector<>();
		
		
		v.addElement("뽀로로");
		v.addElement("루피");
		v.addElement("포비");
		
		// 순회1
		for(int i =0;i<v.size();i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
		//삭제
		v.removeElementAt(2);
		
		
		//순회 2
		Enumeration<String> e= v.elements();
		while(e.hasMoreElements()) {
			String s =e.nextElement();
			System.out.println(s);
		}
	}}


