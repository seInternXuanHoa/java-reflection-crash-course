package gpcoder.java.reflection.objenesis;

public class Vehicle {
	private Vehicle() {
		throw new UnsupportedOperationException("Can't create new instance");
	}

	public void run() {
		System.out.println("Vehicle is running...");
	}
}
