package com.kitec.generics;

public class Box<T extends Number> {
	private T content;

	public void setContent(T content) {
		this.content = content;
	}

	public T getContent() {
		return content;
	}

}