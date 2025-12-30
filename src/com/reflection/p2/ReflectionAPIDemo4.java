package com.reflection.p2;

import java.lang.reflect.Field;

class Hi{
	private int id=101;
	private String name = "Deepika";
}

public class ReflectionAPIDemo4 {
	public static void main(String[] args) throws Exception {
		Class cls = Class.forName("com.reflection.p2.Hi");
		Hi hi = (Hi)cls.newInstance();
		
//		 Access particular private field 
		Field ageField=  cls.getDeclaredField("id");
		ageField.setAccessible(true);
		int ageValue = ageField.getInt(hi);
		System.out.println("value of private field id :"+ageValue);
		
		Field nameField = cls.getDeclaredField("name");
		nameField.setAccessible(true);
		String nameValue = (String) nameField.get(hi);
		System.out.println("value of private field name is : "+nameValue);
		
//		Modify particular private field
		nameField.set(hi, "DeepikaBa");
		String mName =(String) nameField.get(hi);
		System.out.println("value of modified field is : "+ mName);
		
//		Accessing All Private Fields
		Field[] fields = cls.getDeclaredFields();
		for(Field f : fields) {
			f.setAccessible(true);
			System.out.println(f.getName()+" = "+f.get(hi));
		}
		
		
	}
}
