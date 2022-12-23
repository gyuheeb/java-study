package prob4;

public class SoundTest {

	
	private static void printSound( Soundable soundable ) {
		System.out.println( soundable.sound() );
	}
	
	public static void main(String[] args) {
		printSound( new Cat() );
		printSound( new Dog() );
		printSound( new Sparrow() );
		printSound( new Duck() );
	}
	
	
}