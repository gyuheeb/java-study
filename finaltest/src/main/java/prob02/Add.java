package prob02;

public class Add implements Arithmetic {

	@Override
	public int calculate(int a, int b) {
		int result = a+b;
		System.out.println(result);
		return result;
		
	}
	}

