package com.kitec.generics;

public class Main {
	public static void main(String[] args) {
		// Box 클래스의 상속 예제
//		Box<Integer> integerBox = new Box<>();
//		integerBox.setContent(10);
//		System.out.println(integerBox.getContent()); // 10
//
		Box<Double> doubleBox = new Box<>();

		ExtendedBox<Integer> intBox = new ExtendedBox<>();
		intBox.setContent(30);
		System.out.println(intBox.getContent());
//
		// GenericBox 클래스의 예제
//		GenericBox<Double> doubleBox = new GenericBox<>();
//		doubleBox.setContent(3.14);
//		System.out.println(doubleBox.getContent()); // 3.14

	}
}