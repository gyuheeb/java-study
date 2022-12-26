package prob02;

import java.util.Scanner;



public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			System.out.print( ">> " );
			String expression = scanner.nextLine();
			
			if( "quit".equals( expression ) ) {
				break;
			}
			
			String[] tokens = expression.split( " " );
			
			if( tokens.length != 3 ) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt( tokens[ 0 ] );
			int rValue = Integer.parseInt( tokens[ 1 ] );
			
			Arithmetic arithmetic = null;
			
			switch( tokens [ 2 ] ) {
			case "+" : {
				Add add = new Add();
				add.calculate(lValue,rValue);
				break;
			}
			case "-" : {
				Sub sub = new Sub();
				sub.calculate(lValue,rValue);
				
				break;
			}
			case "*" : {
				Mul mul = new Mul();
				mul.calculate(lValue,rValue);
				break;
			}
			case "/" : {
				Div div = new Div();
				div.calculate(lValue,rValue);
				break;
			}
			
			
		}
		
		scanner.close();
	}
}

}