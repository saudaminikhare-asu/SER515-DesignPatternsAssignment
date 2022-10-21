package edu.asu.ptbs;

import java.util.Iterator;

public class ProductIterator implements Iterator<Product> {
	ClassProductList theProductList;
	int currentProductNumber = -1;

	public ProductIterator() {
	}

	public ProductIterator(ClassProductList productList) {
		theProductList = productList;
	}

	public boolean hasNext() {
		if (currentProductNumber >= theProductList.size() - 1)
			return false;
		else
			return true;
	}

	public Product next() {
		if (hasNext() == true) {
			currentProductNumber++;
			return theProductList.get(currentProductNumber);
		} else {
			return null;
		}
	}

	public void remove() {
		if (currentProductNumber == -1)
			currentProductNumber++;
		theProductList.remove(currentProductNumber);
	}

// the next Course that fits the given CourseName
	public Product next(String productName) {
		Product theProduct;
		theProduct = (Product) next();
		while (theProduct != null) {
			if (productName.compareTo(theProduct.toString()) == 0) {
				return theProduct;
			}
			theProduct = (Product) next();
		}
		return null;
	}

}