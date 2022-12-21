package gpcoder.java.reflection.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class StaticIST {
	public static void main(String[] args) {
		Class<?> clazz = Vehicle.class;
		Vehicle vehicle = new Vehicle();

		// Remove Final:
		try {
			Field staticField = clazz.getDeclaredField("AUTHOR");
			staticField.setAccessible(true);

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(staticField, staticField.getModifiers() & ~Modifier.FINAL);

			// Setter:
			staticField.set(null, "InternSeXuanHoa");
			
			// Getter:
			System.out.println("Author: " + staticField.get(null));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}
}