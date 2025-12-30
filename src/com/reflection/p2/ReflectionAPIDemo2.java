package com.reflection.p2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class A {

	int a = 101;

	void mA() {
		System.out.println("mA in A");
	}
}

class B extends A {

	public static final int b = 201;
	public int c = 303;
	int d = 404;
	final String s = "data";

	B() {
		System.out.println("Defalt cons in B");
	}

	void mB() {
		System.out.println("mB in B");
		System.out.println(b);
	}

	void mB1(int a, int b) {
		System.out.println("mB1 in B");

	}

	private void m2() throws Exception {

	}
}

public class ReflectionAPIDemo2 {
	public static void main(String[] args) {

		try {
			Class cls = Class.forName("com.reflection.p2.B");
			B b = (B) cls.newInstance();
//			System.out.println(Modifier.PUBLIC);
//			System.out.println(Modifier.PRIVATE);
//			System.out.println(Modifier.STATIC);
//			System.out.println(Modifier.FINAL);
//			System.out.println(Modifier.PUBLIC);
			System.out.println("*****\n");
			Field[] f = cls.getFields();
			for (int i = 0; i < f.length; i++) {
				System.out.println(f[i].getModifiers() + " Type : " + f[i].getType() + " Name :" + f[i].getName());
			}

			System.out.println("*****\n");
			Field[] fd = cls.getDeclaredFields();
			for (int i = 0; i < fd.length; i++) {
				System.out.println(fd[i].getModifiers() + " Type : " + fd[i].getType() + " Name :" + fd[i].getName());
			}

			System.out.println("*****\n");
			Class[] c = cls.getClasses();
			for (int i = 0; i < c.length; i++) {
				System.out.println(c[i].getModifiers() + " Type : " + c[i].getTypeName() + " Name :" + c[i].getName());
			}

			System.out.println("*****\n");
			Constructor[] con = cls.getConstructors();
			for (int i = 0; i < con.length; i++) {
				System.out.println(con[i].getModifiers() + " Name :" + con[i].getName());
			}

			System.out.println("*****\n");
			Method[] m = cls.getMethods();
			for (int i = 0; i < m.length; i++) {
				System.out.println(
						m[i].getModifiers() + " Type : " + m[i].getExceptionTypes() + " Name :" + m[i].getName());
			}

			System.out.println("*****\n");
			Method[] md = cls.getDeclaredMethods();
			for (int i = 0; i < md.length; i++) {
				System.out.println(
						md[i].getModifiers() + " Type : " + md[i].getExceptionTypes() + " Name :" + md[i].getName());
			}

			System.out.println("*****\n");
			Annotation[] a = cls.getAnnotations();
			for (int i = 0; i < a.length; i++) {
				System.out.println(a[i].annotationType());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
