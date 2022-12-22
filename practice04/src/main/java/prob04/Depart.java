package prob04;

public class Depart extends Employee {
	
	private String Department;
	
//	
//	public void Department(String Depart) {
//		this.Department = Depart;
//		System.out.println(Department);
//	}
	public Depart(String string, int i, String department) {
		super(string , i);
		this.Department = department;
		
	}
	public void getInformation() {
		System.out.println( "이름:" + getName() + " 연봉:" + 
	getSalary()+" 부서 : "+ Department );
	}

}
