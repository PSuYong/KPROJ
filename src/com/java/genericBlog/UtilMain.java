package com.java.genericBlog;

import java.util.Arrays;
import java.util.List;

public class UtilMain {
	public static void printList(List<?> list) {
		for(Object elem : list) {
			System.out.println(elem);
		}
	}
	
	public static void main(String[] args) {
//		Pair<Integer, String> p1 = new Pair<>(1, "apple");
//		Pair<Integer, String> p2 = new Pair<>(2, "pear");
//		boolean same = Util.compare(p1, p2);
		
		List<Integer> li = Arrays.asList(1, 2, 3);
		List<String>  ls = Arrays.asList("one", "two", "three");
		printList(li);
		printList(ls);
	}
}
