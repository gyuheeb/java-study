package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;
//final 대입이 끝났다
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		Goods[] goods = new Goods[COUNT_GOODS];
		
		
		for(int i=0; i<COUNT_GOODS ;i++) {
			String info=scanner.nextLine();
			String[] infos = info.split(" ");
			System.out.println(infos[0]+"(가격:"+infos[1]+")이 "+infos[2]+"개 입고 되었습니다.");
			
			goods[i]=new Goods();
			
		
		
		
				
				
		for(int j=0; j<COUNT_GOODS ;j++) {
			Good[j].bev(info[j]);
		
		}
		scanner.close();
	
	}
