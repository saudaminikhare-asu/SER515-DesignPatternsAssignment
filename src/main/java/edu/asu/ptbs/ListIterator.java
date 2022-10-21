package edu.asu.ptbs;

import java.util.ArrayList;
import java.util.Iterator;

public class ListIterator implements Iterator<Object> {
	ArrayList<Object> theList;
	int CurrentNumber = -1;

	public ListIterator() {
	}

	public ListIterator(ArrayList<Object> list) {
		theList = list;
	}

	public boolean hasNext() {
		if (CurrentNumber >= theList.size() - 1)
			return false;
		else
			return true;
	}

	public Object next() {
		if (hasNext() == true) {
			CurrentNumber++;
			return theList.get(CurrentNumber);
		} else {
			return null;
		}
	}

	public void remove() {
		theList.remove(CurrentNumber);
	}
}