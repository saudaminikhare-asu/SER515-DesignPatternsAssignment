package edu.asu.ptbs;

import javax.swing.JDialog;

abstract public class TradingMenu extends JDialog {
	abstract void ShowMenu(Trade trade, Person per);

	public TradingMenu() {
		setModal(true);
		setSize(575, 330);
	}
}