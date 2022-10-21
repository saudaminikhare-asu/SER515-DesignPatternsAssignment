package edu.asu.ptbs;

import java.util.Iterator;

public class OfferingIterator implements Iterator<Offering> {
	OfferingList offeringList;

	/// currentOfferingNumber: point to the location before the first element
	int currentOfferingNumber = -1;

	public OfferingIterator() {
	}

	public OfferingIterator(OfferingList theOfferingList) {
		offeringList = theOfferingList;
		MoveToHead();
	}

	public void MoveToHead() {
		/// currentSolutionNumber: point to the location before the first element
		currentOfferingNumber = -1;
	}

	public boolean hasNext() {
		/** @todo: Implement this java.util.Iterator method */
		if (currentOfferingNumber >= offeringList.size() - 1)
			return false;
		else
			return true;
//    throw new java.lang.UnsupportedOperationException("Method hasNext() not yet implemented.");
	}

	public Offering next() {
		/** @todo: Implement this java.util.Iterator method */
		if (hasNext() == true) {
			currentOfferingNumber++;
			return offeringList.get(currentOfferingNumber);
		} else {
			return null;
		}
		// throw new java.lang.UnsupportedOperationException("Method next() not yet
		// implemented.");
	}

	/// get the next Solution that fits the Username;
	public Offering next(String userName) {
		Offering theSolution;
		theSolution = (Offering) next();
		while (theSolution != null) {
			if (userName.compareTo(theSolution.theBuyer) == 0) {
				return theSolution;
			}
			theSolution = (Offering) next();
		}
		return null;
	}

	public void remove() {
		currentOfferingNumber++;
		offeringList.remove(currentOfferingNumber);
	}

}