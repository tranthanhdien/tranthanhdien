package com.java.core;

import java.util.HashSet;
import java.util.Vector;

public class TestJavaCore {
	public void printString() {
		for (int i = 0; i < 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("HELLO WORLD");
			} else if (i % 3 == 0) {
				System.out.println("Bội của 3");
			} else if (i % 5 == 0) {
				System.out.println("Bội của 5");
			} else {
				System.out.println(i);
			}
		}
	}

	public static Vector getData(Vector v) {
		return new Vector(new HashSet<>(v));
	}

	public static void main(String[] args) {
		int i;
		float f=2.3f;
		double d=2.7;
		i = ((int) (Math.ceil(f))*((int)Math.round(d));
		
		
		
		int arr1[][] = new int[5][5];
		int[][] arr2 = new int[5][5];
		int[] arr3[] = new int[5][5];
		String s = "Hello I'm Java";
		// System.out.println(s.substring(5)); // I'm Java
		// System.out.println(s.substring(0, 5));// Hello
		TestJavaCore test = new TestJavaCore();
		// test.printString();

		String str1 = "abc";
		String str2 = "def";
		String str3 = str1.concat(str2);
		System.out.println("Str3: " + str3);
		str1.concat(str2);
		System.out.println("Str1: " + str1);

		Vector data = new Vector();
		data.add("apple");
		data.add("mango");
		data.add("papaya");
		data.add("cherry");
		data.add("banana");
		data.add("apple");
		System.out.println(getData(data));

		try {
			return;
		} catch (Exception e) {
			System.out.println("Exception");
		} finally {
			System.out.println("Finally");
		}

	}

}
