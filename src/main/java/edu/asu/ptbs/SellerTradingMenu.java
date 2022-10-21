package edu.asu.ptbs;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SellerTradingMenu extends TradingMenu {
	private Offering theOffering;
	private Trade theTrade;
	JComboBox<Offering> CombOfferingList = new JComboBox<>();
	JTextField tbTradeName = new JTextField();
	JTextField tbDueDate = new JTextField();
	JTextField tbSuggestedOffering = new JTextField();

	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JButton buttonGrade = new JButton();
	JButton buttonReport = new JButton();
	JButton buttonClose = new JButton();

	public SellerTradingMenu() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		jLabel1.setText("Trade Name");
		jLabel1.setBounds(new Rectangle(25, 31, 118, 18));
		this.getContentPane().setLayout(null);
		tbTradeName.setText("jTextField1");
		tbTradeName.setBounds(new Rectangle(192, 31, 341, 22));
		jLabel2.setText("Due Date");
		jLabel2.setBounds(new Rectangle(28, 90, 113, 18));
		tbDueDate.setText("tbDueDate");
		tbDueDate.setBounds(new Rectangle(195, 87, 337, 22));
		jLabel3.setText("Suggested Offering");
		jLabel3.setBounds(new Rectangle(28, 151, 118, 18));
		tbSuggestedOffering.setText("jTextField2");
		tbSuggestedOffering.setBounds(new Rectangle(197, 149, 339, 22));
		buttonGrade.setText("Grade");
		buttonGrade.setBounds(new Rectangle(458, 199, 79, 29));
		buttonGrade.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonGrade_actionPerformed(e);
			}
		});
		buttonReport.setText("Report");
		buttonReport.setBounds(new Rectangle(365, 249, 79, 29));
		buttonReport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonReport_actionPerformed(e);
			}
		});
		buttonClose.setText("Close");
		buttonClose.setBounds(new Rectangle(86, 253, 79, 29));
		buttonClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClose_actionPerformed(e);
			}
		});
		CombOfferingList.setBounds(new Rectangle(32, 204, 413, 22));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(tbTradeName, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(tbDueDate, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(tbSuggestedOffering, null);
		this.getContentPane().add(buttonClose, null);
		this.getContentPane().add(CombOfferingList, null);
		this.getContentPane().add(buttonGrade, null);
		this.getContentPane().add(buttonReport, null);
	}

	public void ShowMenu(Trade trade, Person person) {
		theTrade = trade;
		tbTradeName.setText(theTrade.tradeName);
		DateFormat theDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		tbDueDate.setText(theDateFormat.format(theTrade.dueDate));
		tbSuggestedOffering.setText(theTrade.suggestedOffering.offeringFileName);
		refreshSolutionList();
		setVisible(true);
	}

	void buttonClose_actionPerformed(ActionEvent e) {
		theTrade.tradeName = tbTradeName.getText();
		DateFormat tempDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		try {
			theTrade.dueDate = tempDateFormat.parse(tbDueDate.getText());
		} catch (Exception ee) {
		}
		;
		theTrade.suggestedOffering.offeringFileName = tbSuggestedOffering.getText();
		setVisible(false);
	}

	void buttonGrade_actionPerformed(ActionEvent e) {
		Offering theOffering = (Offering) CombOfferingList.getSelectedItem();
		if (theOffering == null)
			return;
		OfferingGradingDlg dlg = new OfferingGradingDlg();
		dlg.show(theOffering);
		refreshSolutionList();
	}

	void buttonReport_actionPerformed(ActionEvent e) {
		OfferingIterator iter = new OfferingIterator(theTrade.theOfferingList);
		while (iter.hasNext()) {
			Offering offering = (Offering) iter.next();
			offering.setReported(true);
		}
		refreshSolutionList();
	}

	private void refreshSolutionList() {
		CombOfferingList.removeAllItems();
		OfferingIterator offIterator = new OfferingIterator(theTrade.theOfferingList);
		while (offIterator.hasNext()) {
			theOffering = (Offering) offIterator.next();
			CombOfferingList.addItem(theOffering);
		}
	}
}