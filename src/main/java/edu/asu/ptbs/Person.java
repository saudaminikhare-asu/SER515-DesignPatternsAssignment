package edu.asu.ptbs;

public abstract class Person {

	private ProductMenu theProductMenu;

	public abstract void showMenu();

	public void showAddButton(){}

	public void showViewButton(){}

	public void showRadioButton(){}

	public void showLabels(){}

	/*
	The abstract factory method.
	 */
	public abstract ProductMenu createProductMenu();

}
