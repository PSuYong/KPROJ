package com.kitec.Jcollection;

public class Main {
	public static void testIterator() {
		int[] elements = { 1, 2, 3, 4, 5 };
		MyIteratorAgre collection = new MyIteratorAgre(elements);

		for (int num : collection) {
			System.out.println(num);
		}
	}

	public static void testCollection() {

//		MyCollection<Integer> collection2 = new MyCollection<>();
//		collection2.add(10);
//		collection2.add(20);
//		collection2.add(30);

		MyCollection<String> collection2 = new MyCollection<>();
		collection2.add("dd");
		collection2.add("bb");
		collection2.add("cc");

		for (String str : collection2) {
			System.out.println(str);
		}

		collection2.remove("bb");
		System.out.println("Size: " + collection2.size());
		System.out.println("Contains 20: " + collection2.contains("bb"));

	}

	public static void main(String[] args) {
		testIterator();
//		testCollection();
	}
}