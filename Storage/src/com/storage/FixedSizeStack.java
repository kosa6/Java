package com.storage;

import java.util.Stack;

public class FixedSizeStack<E> extends Stack<E> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //Nie mam pojecia po co to
	
	private final int MAX_SIZE;
	
	FixedSizeStack(int size) {
		super();
		this.MAX_SIZE=size;
	}
	
	public E push(E object) {
		if(this.MAX_SIZE==this.size()) {
			throw new IndexOutOfBoundsException("Stack is full");
		}
		else {
			return super.push(object);
		}
	}
	public E get(int index) {
		index -=(this.MAX_SIZE - this.size());
		return super.get(index);
	}

}
