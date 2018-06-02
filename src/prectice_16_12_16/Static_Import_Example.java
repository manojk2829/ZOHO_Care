package prectice_16_12_16;
import static prectice_16_12_16.AnotherStaticMethod.anotherStaticMethodCall;

public class Static_Import_Example {

	public static void main(String[] args) {
		System.out.println("Main function calling..");
		next();
		anotherStaticMethodCall();
	}
	
	public static void next(){
		System.out.println("Next Method");
	}

}
