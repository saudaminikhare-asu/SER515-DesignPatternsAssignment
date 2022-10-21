package edu.asu.ptbs;

public class Seller extends Person {

	public Seller() {
		type = 1; // type=1 :Seller
	}

	public ProductMenu CreateProductMenu(Product theProduct, int theLevel) {
		if (theLevel == 0) // 0: Highlevel defined in CourseSeletDlg.
		{
			theProductMenu = new MeatProductMenu();
		} else // 1: LowLevel
		{
			theProductMenu = new ProduceProductMenu();
		}
		return theProductMenu;
	}

	public boolean ShowMenu() {
		super.ShowMenu();
		showAddButton();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
	}
}