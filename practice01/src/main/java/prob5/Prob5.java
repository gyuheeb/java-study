package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for(int i=1; i<1000;i++) {
			if(i == 3 || i == 6 || i == 9){
	            System.out.println(i +"짝");	
			}
			else if(i>10) {
				if((i%10==3) || (i%10==6) || (i%10==9)) {
					if((i/10==3) || (i/10==6)|| (i/10==9) ) {
						System.out.println(i +"짝짝");
					}
					else if((i/100==3) || (i/100==6)|| (i/100==9) ) {
						System.out.println(i +"짝짝");
					}
					else {
						System.out.println(i +"짝");
					}
				}
			
			}
	}
}
}
