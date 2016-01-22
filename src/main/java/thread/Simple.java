package thread;

public class Simple {
	public static void main(String ...args){

		// Simple example
		Runnable r = () -> System.out.println("Hello!");
		r.run();

	}

}