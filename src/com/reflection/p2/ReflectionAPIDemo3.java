package com.reflection.p2;

import java.lang.reflect.Method;

class Hello {
	public int a = 10;
	public int b = 20;
	private int d = 50;

	void m1(String s1, String s2) {
		System.out.println("m1 in Hello");
		System.out.println(a);
		System.out.println(b);
	}

	void m2(int i1, int i2) {
		int c = 30;
		System.out.println("m2 in Hello");
		System.out.println(c);
	}

	void m3() {
		System.out.println("m3 in Hello");
	}

	private void mPrivate() {
		System.out.println("mprivate in Hello ");
	}
}

public class ReflectionAPIDemo3 {
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("com.reflection.p2.Hello");
			Hello h = (Hello) cls.newInstance();

			Method[] m = cls.getDeclaredMethods();
			for (int i = 0; i < m.length; i++) {
				System.out.println(m[i].getName());

				String[] st = { "Hi", "Dosto" };
				if (m[i].getName().equals("m1")) {
					m[i].invoke(h, st);
				}

				Integer[] in = { 1000, 2000 };
				if (m[i].getName().equals("m2")) {
					m[i].invoke(h, in);
				}

				if (m[i].getName().equals("m3")) {
					m[i].invoke(h, null);
				}

				if (m[i].getName().equals("mPrivate")) {
//					m[i].invoke(h,null); // can not access private method. just can get information
					System.out.println(m[i].getName());
				}

			}
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
