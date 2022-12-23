package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a=10;
		int b= 10-a;
		
		
		System.out.println("Some Code1...");
		try {
			System.out.println("Some Code2...");
			System.out.println("Some Code3...");
			
			int result =(1+2+3)/b;
			
			System.out.println("Some Code4...");
			System.out.println("Some Code5...");
					
		}catch(ArithmeticException ex) {
//			   예외 처리 
//			 -> 1. 로깅
			System.out.println("error:"+  ex);
//			 -> 2. 사 과..
			System.out.println("미아냉..");
//			 -> 3. 정상종료  
			return; // -> 리턴으로 종류
//			System.exit(0); //erro 코드를 밖으로 내보내준다..
//			ex.printStackTrace();  -> 예외 처리시 표시라도 해줘.. ㅠ(따로 처리 방법 없으면 이렇게)
			
		} finally {
			System.out.println("♥ ♥ ♥ ♥ 자원정리 예: file close ♥ ♥ ♥ ♥");
		//정상 :(try block)이 끝나고 catch문에서 예외 후  finally  실행
		}
		
		
		System.out.println("Some Code6...");
		System.out.println("Some Code7...");
		//예외처리 후 정상으로 처리될 수 있어 보통 작성 x .. return...
		
		
	}

}
