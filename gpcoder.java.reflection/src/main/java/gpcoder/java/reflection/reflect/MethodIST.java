package gpcoder.java.reflection.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodIST {
	public static void main(String[] args) {
		Class<?> clazz = Vehicle.class;
		
		// All Public Method:
		Method[] methods = clazz.getMethods();
		System.out.println("All public method: ");
		for (Method method : methods) {
			System.out.println("Method Index: " + method.getName());
		}
		
		// All Method:
		Method[] allMethods = clazz.getDeclaredMethods();
		System.out.println("All Method:");
		for (Method method : allMethods) {
			System.out.println("Method Index: " + method.getName());
		}
		
		// Condition Method:
		try {
			Method sellMethod = clazz.getDeclaredMethod("sell", int.class);
			System.out.println("Sell method: " + sellMethod.getName());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		// Invoke:
		try {
			Vehicle vehicle = new Vehicle();
			Method sellMethod = clazz.getDeclaredMethod("sell", int.class);
			sellMethod.setAccessible(true);
			sellMethod.invoke(vehicle, 200);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
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
