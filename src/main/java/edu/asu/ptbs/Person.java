package edu.asu.ptbs;

import java.util.Iterator;

abstract public class Person {
	int type = 0; // type=0 : buyer, type=1 instructor
	String UserName;
	ClassProductList ProductList;
	ProductMenu theProductMenu;
	Product CurrentProduct;
	Trade CurrentTrade;

	public Person() {
		ProductList = new ClassProductList();
	}

	abstract public ProductMenu CreateProductMenu(Product theProduct, int theLevel);

	public void showAddButton() {
		theProductMenu.ShowAddButtons();
	}

	public void showViewButtons() {
		theProductMenu.ShowViewButtons();
	}

	public void showComboxes() {
		theProductMenu.ShowComboxes();
	}

	public void showRadios() {
		theProductMenu.ShowRadios();
	}

	public void show() {
		theProductMenu.setVisible(true);
	}

	public boolean ifLogout() {
		return theProductMenu.ifLogout();
	}

	// show the trading list
	public boolean ShowMenu() {
		Iterator<Trade> theIter = CurrentProduct.tradingList.iterator();
		theProductMenu.theProduct = CurrentProduct;
		Trade theTrade;
		while (theIter.hasNext()) {
			theTrade = (Trade) theIter.next();
			theProductMenu.TradeCombox.addItem(theTrade);
		}
		return false;
	}

	public ClassProductList GetProductList() {
		return ProductList;
	}

	public void AddProduct(Product theProduct) {
		ProductList.add(theProduct);
	}
}