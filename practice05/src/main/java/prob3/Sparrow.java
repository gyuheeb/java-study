package prob3;

public class Sparrow extends Bird{
	
	@Override
	public void fly() {
		System.out.println("참새 ( "+name+" ) 날아다닙니다.");
		
	}
	@Override
	public void sing() {
		System.out.println("참새 ( "+name+" ) 소리내어 웁니다.");
		
	}
	@Override
	public  String toString() {
		return "참새의 이름은 "+getName()+" 입니다." ;
	
	}
	
//	오리(꽥꽥이)는 날지 않습니다.
//	오리(꽥꽥이)가  소리내어 웁니다.
}
