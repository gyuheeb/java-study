package prob03;

public class CurrencyConverter {
	private static double rate;
	
	
	public static double  toDollar(double won) {
	     
		return(won*CurrencyConverter.rate);
		
	   }
	   public static double  toKRW(double dollar) {
		   return(dollar/CurrencyConverter.rate);
	   }
	   public static void setRate(double r) {
		   
		   CurrencyConverter.rate=r;
		   return CurrencyConverter.rate;
	   }
		   
		   
		   // 환율 설정(KRW/$1)
	   }
