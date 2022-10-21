package edu.asu.ptbs;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

abstract public class ProductMenu extends JDialog {
	Product theProduct;
	boolean bLogout = true;

	JRadioButton TradeRadio = new JRadioButton();
	JComboBox<Trade> TradeCombox = new JComboBox<>();
	JButton TradeViewButton = new JButton();
	JButton TradeAddButton = new JButton();
	JRadioButton OptionRadio = new JRadioButton();
	JLabel TradeContentLabel = new JLabel();
	JComboBox<String> OptionCombo = new JComboBox<>();
	JButton OptionViewButton = new JButton();
	JButton OptionAddButton = new JButton();
	JButton buttonChangeCourse = new JButton();
	JButton buttonLogout = new JButton();

	public ProductMenu() {

		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setModal(true);
		setSize(503, 294);
	}

	private void jbInit() throws Exception {
		buttonChangeCourse.setText("ChangeProduct");
		buttonChangeCourse.setBounds(new Rectangle(101, 211, 73, 37));
		buttonChangeCourse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChangeCourse_actionPerformed(e);
			}
		});
		this.getContentPane().setLayout(null);
		this.setTitle("");
		buttonLogout.setText("Logout");
		buttonLogout.setBounds(new Rectangle(267, 215, 73, 37));
		buttonLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLogout_actionPerformed(e);
			}
		});
		this.getContentPane().add(buttonChangeCourse, null);
		this.getContentPane().add(buttonLogout, null);
	}

	/*
	 * when the add button is pressed, call add assignment function of facade, after
	 * that refresh window
	 */

	/*
	 * when the add button is pressed, call ViewAssignment function of facade, after
	 * that refresh window
	 */

	abstract void ShowMenu(Product theProduct);

	abstract void ShowAddButtons();

	abstract void ShowViewButtons();

	abstract void ShowRadios();

	abstract void ShowComboxes();

	abstract void ShowLabel();

	void AssignmentAddButton_actionPerformed(ActionEvent e) {
		PTBSMain.theFacade.AddTrade(theProduct);
		refresh();
	}

	void AssignmentViewButton_actionPerformed(ActionEvent e) {
		Trade theTrade = (Trade) TradeCombox.getSelectedItem();
		PTBSMain.theFacade.ViewTrade(theTrade);
	}

	void refresh() {
		TradeCombox.removeAllItems();
		Iterator<Trade> Iter = theProduct.tradingList.iterator();
		while (Iter.hasNext()) {
			TradeCombox.addItem(Iter.next());
		}
	}

	void buttonChangeCourse_actionPerformed(ActionEvent e) {
		bLogout = false;
		setVisible(false);
	}

	void buttonLogout_actionPerformed(ActionEvent e) {
		bLogout = true;
		setVisible(false);
	}

	boolean ifLogout() {
		return bLogout;
	}
}