package com.kitec.Jcollection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollection<T> implements Collection<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private T[] elements;
	private int size;

	public MyCollection() {
		elements = (T[]) new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		for (T element : elements) {
			if (element != null && element.equals(o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(elements, size);
	}

	@Override
	public <E> E[] toArray(E[] a) {
		if (a.length < size) {
			return (E[]) Arrays.copyOf(elements, size, a.getClass());
		}
		System.arraycopy(elements, 0, a, 0, size);
		if (a.length > size) {
			a[size] = null;
		}
		return a;
	}

	@Override
	public boolean add(T e) {
		if (size == elements.length) {
			expandCapacity();
		}
		elements[size++] = e;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		for (int i = 0; i < size; i++) {
			if (elements[i] != null && elements[i].equals(o)) {
				removeElementAtIndex(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object element : c) {
			if (!contains(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean modified = false;
		for (T element : c) {
			if (add(element)) {
				modified = true;
			}
		}
		return modified;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean modified = false;
		for (Object element : c) {
			modified |= remove(element);
		}
		return modified;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean modified = false;
		for (int i = 0; i < size; i++) {
			if (!c.contains(elements[i])) {
				removeElementAtIndex(i);
				modified = true;
				i--;
			}
		}
		return modified;
	}

	@Override
	public void clear() {
		Arrays.fill(elements, null);
		size = 0;
	}

	// Helper method to remove an element at the specified index
	private void removeElementAtIndex(int index) {
		System.arraycopy(elements, index + 1, elements, index, size - index - 1);
		elements[--size] = null;
	}

	// Helper method to expand the capacity of the internal array
	private void expandCapacity() {
		int newCapacity = elements.length * 2;
		elements = Arrays.copyOf(elements, newCapacity);
	}

	// Custom iterator implementation
	private class MyIterator implements Iterator<T> {
		private int currentIndex = 0;

		@Override
		public boolean hasNext() {
			return currentIndex < size;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return elements[currentIndex++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
}
