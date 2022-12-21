package gpcoder.java.reflection.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionIST {
	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("gpcoder.java.reflection.reflect.Vehicle");
			Class<?> otherClass = Vehicle.class;
			Class<?> otherClazz = new Vehicle().getClass();

			System.out.println(clazz);
			System.out.println(otherClass);
			System.out.println(otherClazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Class
		Class<?> clazz = Vehicle.class;

		System.out.println("Class name: " + clazz.getName());
		System.out.println("Class simple name: " + clazz.getSimpleName());

		// Package
		Package clazzPackage = clazz.getPackage();
		System.out.println("Package: " + clazzPackage.getName());
		System.out.println("Class modifier: " + clazz.getModifiers());
		System.out.println("Class modifier is public: " + Modifier.isPublic(clazz.getModifiers()));
		System.out.println("Class modifier is protected: " + Modifier.isProtected(clazz.getModifiers()));
		System.out.println("Class modifier is private: " + Modifier.isPrivate(clazz.getModifiers()));
		System.out.println("Class is abstract: " + Modifier.isAbstract(clazz.getModifiers()));
		System.out.println("Class is interface: " + Modifier.isInterface(clazz.getModifiers()));
		System.out.println("Class is final: " + Modifier.isFinal(clazz.getModifiers()));

		// Super Class
		Class<?> superClazz = clazz.getSuperclass();
		System.out.println("Supper class: " + superClazz.getName());

		Class<?>[] implInterfaces = clazz.getInterfaces();
		for (Class<?> implInterface : implInterfaces) {
			System.out.println("Implement Interface Index: " + implInterface.getName());
		}

		// Constructor
		Constructor<?>[] clazzConstructors = clazz.getConstructors();
		for (Constructor<?> clazzConstructor : clazzConstructors) {
			System.out.println("Constructor Index: " + clazzConstructor.getName() + ", has parameter: "
					+ clazzConstructor.getParameters());
		}
		
		// Method
		Method[] clazzMethods = clazz.getMethods();
		for (Method clazzMethod : clazzMethods) {
			System.out.println("Method Index: " + clazzMethod.getName());
		}
		
		// Field:
		Field[] clazzFields = clazz.getFields();
		for (Field clazzField : clazzFields) {
			System.out.println("Field Index: " + clazzField.getName());
		}
		
		// Annotation:
		Annotation[] clazzAnnotations = clazz.getAnnotations();
		for (Annotation clazzAnnotation : clazzAnnotations) {
			System.out.println("Annotation Index: " + clazzAnnotation.annotationType().getName());
		}
	}
}
