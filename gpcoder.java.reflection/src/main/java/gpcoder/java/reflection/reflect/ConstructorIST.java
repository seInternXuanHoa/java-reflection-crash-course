package gpcoder.java.reflection.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorIST {
	public static void main(String[] args) {
		Class<?> clazz = Vehicle.class;
		
		// All Constructor
		Constructor<?>[] clazzConstructors = clazz.getConstructors();
		System.out.println("All Constructor:");
		for (Constructor<?> clazzConstructor : clazzConstructors) {
			System.out.println("Constructor Index: " + clazzConstructor.getName());
		}
		
		// Condition Constructor
		Constructor<?> clazzAllArgsConstructor = null;
		try {
			clazzAllArgsConstructor = clazz.getConstructor(new Class<?>[] {String.class, Integer.TYPE});
			System.out.println("All args parameter: " + clazzAllArgsConstructor.getName());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		// Get All Parameter:
		Class<?>[] clazzAllArgsConstructorParameters = clazzAllArgsConstructor.getParameterTypes();
		System.out.println("All Parametter in All Args Constructor:");
		for (Class<?> clazzAllArgsConstructorParameter : clazzAllArgsConstructorParameters) {
			System.out.println("Args Index: " + clazzAllArgsConstructorParameter.getName());
		}
		
		// Create new Instance:
		try {
			Vehicle vehicle = (Vehicle) clazz.newInstance();
			System.out.println(vehicle);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		try {
			Vehicle vehicle = (Vehicle) clazzAllArgsConstructor.newInstance("Vehicle", 200);
			System.out.println(vehicle);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
