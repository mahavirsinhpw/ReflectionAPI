package com.reflection;

class A {

}

interface I1 {

}

interface I2 {

}

class Hello extends A implements I1, I2 {
	int a = 99;
	int b;

	static {
		System.out.println("sb in Hello");
	}
	{
		System.out.println("IB in Hello");
	}

	Hello() {
		System.out.println("Default Const in Hello");
	}

	Hello(int b) {
		System.out.println("1 para Const in Hello");
		this.b = b;
	}

	void show() {
		System.out.println("show in HEllo");
		System.out.println(a);
		System.out.println(b);
	}
}

public class ReflectionAPIDemo {
	public static void main(String[] args) {
//		
//		Hello h = new Hello();
//		h.show();

		try {
			Class cls = Class.forName("com.reflection.Hello");
			Hello h = (Hello) cls.newInstance();
			h.show();

			System.out.println("*****Information about class****\n");

			ClassLoader cl = cls.getClassLoader();
			System.out.println(cl.getName());
			System.out.println(cl);

			System.out.println("*********\n");

			System.out.println(cls); // internally toString is overridden in Class class
			System.out.println(cls.getName());
			System.out.println(cls.getPackageName());
			System.out.println(cls.getSuperclass());
			Class[] cls1 = cls.getInterfaces();
			for (int i = 0; i < cls1.length; i++) {
				System.out.println(cls1[i].getName());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
