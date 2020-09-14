package java_basics;

public class MyUtils {
	public static String printSomeJunk(String arg) {
//		System.out.println("Some bla bla bla " + arg);
		return arg;
	}
	
	public static void printSomeJunk(int arg) {
		System.out.println("Integer passed in: " + arg);
	}
	
	public static void sum2Numbers(int firstArg, int secondArg) {
		System.out.println(firstArg + secondArg);
	}
	
	public  int add10(int someArg) {
		int result = someArg+10;
		return result;
	}

}
