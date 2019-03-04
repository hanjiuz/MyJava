package hjz.tools;

public class InterestsCalculation {

	public static void main(String[] args) {
		double principal = 10000;  //principal
		double rate = 0.006;   //0.6% every month
		
		//change the month to other values to see actual interests
		//1,3,6,12,18,24,36
		int month = 1; //months
		System.out.println("month: "+month);
		
		double actual = 0;
		for(int i=1; i<=month; i++) {
			actual = actual + (principal/month)*i; 
		}
		
		double interests1 = principal * rate * month;
		
		System.out.println("actual: "+actual);
		System.out.println("interests1: "+interests1);
		
		double raterate = (principal*month)/actual;
		System.out.println("raterate: "+raterate);
	}

}
