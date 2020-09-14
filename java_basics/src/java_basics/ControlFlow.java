package java_basics;

public class ControlFlow {

	public static void main(String[] args) {
		boolean hungry = true;
		
		if (!hungry) {
			System.out.println(" I am not hungry ");
			
		}else {
			System.out.println("I am dying");
		}
		
		int favTemp = 75;
		int currentTemp = 60;
		String opinion;
		
		if (currentTemp < (favTemp -30)) {
			opinion = "abc";
		} else if(currentTemp < (favTemp -20)) {
			opinion = "def";
		} else if (currentTemp > (favTemp +10)) {
			opinion = "ghi";
		} else {
			opinion = "It's perfect";
		}
	
		System.out.println(opinion);
       
	}

}
