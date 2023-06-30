package com.kitec.Jcollection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIteratorAgre implements Iterable<Integer> {
	private int[] elements;
	private int size;

	public MyIteratorAgre(int[] elements) {
		this.elements = elements;
		this.size = elements.length;
	}

	@Override
	public Iterator<Integer> iterator() {
		System.out.println("called iterator method");
		return new MyIterator();
	}

	private class MyIterator implements Iterator<Integer> {
		private int currentIndex;

		public MyIterator() {
			this.currentIndex = 0;
		}

		@Override
		public boolean hasNext() {
			System.out.println("hasNext : " + currentIndex);
			return currentIndex < size;
		}

		@Override
		public Integer next() {
			if (hasNext()) {
				System.out.println("next : " + currentIndex);
				return elements[currentIndex++];
			} else {
				throw new NoSuchElementException();
			}
		}

	}

}