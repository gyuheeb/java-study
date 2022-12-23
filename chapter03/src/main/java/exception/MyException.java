package exception;

public class MyException extends Exception {
	private static final long serialVerxionUID = 1L;
	
	public MyException() {
		super("MyException Occurs");
	}
	public MyException(String message) {
		super(message);
	}
}
