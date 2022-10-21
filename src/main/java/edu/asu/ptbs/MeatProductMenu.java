package edu.asu.ptbs;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;

public class MeatProductMenu extends ProductMenu {

	/*
	 * JButton AssignmentAddButton = new JButton(); JRadioButton OptionRadio = new
	 * JRadioButton(); JComboBox OptionCombo = new JComboBox(); JButton
	 * OptionViewButton = new JButton(); JButton OptionAddButton = new JButton();
	 */

	public MeatProductMenu() {
	}

	void ShowMenu(Product theProduct) {
		ShowViewButtons();
		ShowRadios();
		ShowComboxes();
		setVisible(true);
	}

	void ShowAddButtons() {
		TradeAddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AssignmentAddButton_actionPerformed(e);
			}
		});
		TradeAddButton.setText("Add");
		TradeAddButton.setBounds(new Rectangle(389, 54, 79, 29));
		OptionAddButton.setText("Add");
		OptionAddButton.setBounds(new Rectangle(390, 125, 79, 29));
		this.getContentPane().add(TradeAddButton, null);
		this.getContentPane().add(OptionAddButton, null);
	}

	void ShowRadios() {
		TradeRadio.setText("Trade");
		TradeRadio.setBounds(new Rectangle(21, 55, 103, 26));
		this.getContentPane().add(TradeRadio, null);
		OptionRadio.setText("Meat Product");
		OptionRadio.setBounds(new Rectangle(21, 128, 103, 26));
		this.getContentPane().add(OptionRadio, null);
	}

	void ShowComboxes() {
		TradeCombox.setBounds(new Rectangle(140, 57, 126, 22));
		OptionCombo.setBounds(new Rectangle(137, 127, 126, 22));
		this.getContentPane().add(TradeCombox, null);
		this.getContentPane().add(OptionCombo, null);
		refresh();
	}

	void ShowViewButtons() {
		TradeViewButton.setText("View");
		TradeViewButton.setBounds(new Rectangle(290, 54, 79, 29));
		TradeViewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AssignmentViewButton_actionPerformed(e);
			}
		});
		OptionViewButton.setText("View");
		OptionViewButton.setBounds(new Rectangle(290, 124, 79, 29));
		this.getContentPane().add(TradeViewButton, null);
		this.getContentPane().add(OptionViewButton, null);
	}

	void ShowLabel() {
		TradeContentLabel.setText("Trade Content");
		TradeContentLabel.setBounds(new Rectangle(23, 186, 432, 99));
		this.getContentPane().add(TradeContentLabel, null);
	}
}