package edu.asu.ptbs;

public class Buyer extends Person {

	public Buyer() {
		type = 0; // type=0: student
	}

	public ProductMenu CreateProductMenu(Product theCourse, int theLevel) {

		if (theLevel == 0) // 0: MeatProduct
		{
			theProductMenu = new MeatProductMenu();
		} else // 1: ProductProduct
		{
			theProductMenu = new ProduceProductMenu();
		}
		return theProductMenu;
	}

	@Override
	public boolean ShowMenu() {
		super.ShowMenu();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
	}
}