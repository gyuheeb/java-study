package prob01;

public class Printer {
//	private int count;
//	private String ans;
//	private double rate;
//	private String name;
//	
//	
//	
//	public Printer(int count, String ans, double rate,String name) {
//		this.count =count;
//		this.ans =ans;
//		this.rate =rate;
//		this.name =name;	
//	}
//	
//	public int getCount() {
//		return count;
//	}
//
//	public void setCount(int count) {
//		this.count = count;
//	}
//
//	public String getAns() {
//		return ans;
//	}
//
//	public void setAns(String ans) {
//		this.ans = ans;
//	}
//
//	public double getRate() {
//		return rate;
//	}
//
//	public void setRate(double rate) {
//		this.rate = rate;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void show() {
//		System.out.println(count);
//		System.out.println(ans);
//		System.out.println(rate);
//		System.out.println(name);				
//	}
//	
//	public void println(double d) {
//		System.out.println(d);
//	}
//	public void println(String s) {
//		System.out.println(s);
//	}
	
	public <T> void println(T... ts) {  //(T... ts)는 파라미터의 개수를 제한 하지x
		for(T t:ts) {
		System.out.println(t);
	}}
	
	public int sum(Integer...nums) {             //가변파라미터
		int s=0;
		for(Integer n:nums) {
			s+=n;
		}
		return s;
	}
	
	
	
}
