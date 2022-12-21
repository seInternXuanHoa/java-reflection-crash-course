package gpcoder.java.reflection.objenesis;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;

public class ObjenesisIST {
	public static void main(String[] args) {
		Objenesis objenesis = new ObjenesisStd();
		ObjectInstantiator<?> instantiator = objenesis.getInstantiatorOf(Vehicle.class);

		Vehicle vehicle = (Vehicle) instantiator.newInstance();
		vehicle.run();
	}
}
