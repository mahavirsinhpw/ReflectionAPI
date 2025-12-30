package com.reflection.p2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

class Emp {
	private int eid;
	private double esal;
	private String ename;

	enum Week {
		SUN, TUE, WED;
	}

	@interface MyAnno {
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid, int num, char ch) {
		this.eid = eid;
	}

	public double getEsal() {
		return esal;
	}

	public void setEsal(double esal, float data, String name) {
		this.esal = esal;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	// constructor
	public Emp(int eid, double esal, String ename) {
		super();
		this.eid = eid;
		this.esal = esal;
		this.ename = ename;
	}

	Emp() {
	}

	class A {
	}

	class B {
	}
}

public class ReflectionAPIDemo5 {
	public static void main(String[] args) throws Exception {
		Class cls = Class.forName("com.reflection.p2.Emp");

		Constructor[] cons = cls.getDeclaredConstructors();
		for (Constructor c : cons) {
			System.out.println("name of cons : " + c.getName());
			System.out.println("name of con parameter : " + c.getParameterCount());

			Parameter[] params = c.getParameters();
			for (Parameter p : params) {
				System.out.println("params of cons : " + p);
			}
			System.out.println();
		}
		System.out.println();

		Method[] methods = cls.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println("name of method : " + m.getName());
			System.out.println("return type of method : " + m.getReturnType());
			System.out.println("method para count : " + m.getParameterCount());
			System.out.println();
			Parameter[] params = m.getParameters();
			for (Parameter p : params) {
				System.out.println("params of method : " + p);
			}
			System.out.println();

//	        Annotations
			Annotation[] anno = cls.getDeclaredAnnotations();
			for (Annotation annotation : anno) {
				System.out.println("Annotation: " + annotation);
			}

		}

	}
}
