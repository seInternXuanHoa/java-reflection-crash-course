package gpcoder.java.reflection.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public class ClassIST {
	public static void main(String[] args) {
		Class<?> clazz = Vehicle.class;
		
		// All Field (Public):
		Field[] clazzFields = clazz.getFields();
		System.out.println("All Field: ");
		for (Field clazzField : clazzFields) {
			System.out.println("Field Index: " + clazzField);
		}
		
		// All Field:
		Field[] clazzAllFields = clazz.getDeclaredFields();
		System.out.println("All Field: ");
		for (Field clazzAllField : clazzAllFields) {
			System.out.println("Field Index: " + clazzAllField.getName());
		}
		
		// Condition Field:
		try {
			Field clazzNameField = clazz.getDeclaredField("name");
			System.out.println("Name field: " + clazzNameField.getName() + ", has type: " + clazzNameField.getType().getSimpleName());
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		// Getter, Setter:
		try {
			Vehicle vehicle = new Vehicle();
			Field nameField = clazz.getDeclaredField("name");
			nameField.setAccessible(true);
			nameField.set(vehicle, "Volvo");
			String nameValue = (String) nameField.get(vehicle);
			System.out.println("Name value: " + nameValue);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		// Annotation
		Field nameField = null;
		try {
			nameField = clazz.getDeclaredField("name");
			Annotation[] fieldAnnotations = nameField.getAnnotations();
			System.out.println("All Annotation: ");
			for (Annotation annotation : fieldAnnotations) {
				System.out.println("Annotation Index: " + annotation.annotationType().getName());
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
