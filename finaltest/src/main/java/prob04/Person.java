package prob04;

public class Person {
	private static int numberOfPerson; // 전체 인구수
	private int age;
	private String name;
	private static int Population;
	
	public static int getPopulation() {
		return numberOfPerson;
	}


	
		
	public Person(String name) {
		this.name=name;
		this.age=12;
		 numberOfPerson++;
		
	}
	public Person(int age, String name) {
		this.name=name;
		this.age=age;
		numberOfPerson++;
		
	}




	public  void selfIntroduce() {
		System.out.println("내 이름은 "+name+"이며, "+"나이는 "+age+ " 입니다.");
		
	}
	
	
	
	
}
