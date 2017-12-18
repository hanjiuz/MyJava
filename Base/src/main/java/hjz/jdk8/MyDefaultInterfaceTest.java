package hjz.jdk8;

public class MyDefaultInterfaceTest {
	
	public static String test(MyFunctionalInterface f) {
		String a = "Hello";
		String b = "World";
		return f.myMethod(a, b);
	}

	public static void main(String[] args) {
		
		//pass a lambda expression
		String c = MyDefaultInterfaceTest.test( (String a, String b) -> a + " " + b );
		
		System.out.println(c);

	}

}
