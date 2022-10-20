package edu.asu.ptbs;

public interface ProductMenu {

	public abstract void showMenu();

	/*
	Call the implementation to show the "add" buttons.
	 */
	public abstract void showAddButton();

	/*
	Call the implementation to show the "view" buttons.
	 */
	public abstract void showViewButton();

	/*
	Call the implementation to show the radio buttons.
	 */
	public abstract void showRadioButton();

	/*
	Call the implementation to show the labels.
	 */
	public abstract void showLabels();

	public abstract void showComBoxes();

}
