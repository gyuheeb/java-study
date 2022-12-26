package prob02;

public class Div implements Arithmetic {
	int result=0;
	@Override
	public int calculate(int a, int b) {
		if(a>b) {
			result = a/b;
		}
		else {
			 result = b/a;
		}
		System.out.println(result);
		return result;
	}
	
}

