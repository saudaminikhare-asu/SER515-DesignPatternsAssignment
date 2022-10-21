package edu.asu.ptbs;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class ProductSelectDlg extends JDialog {
	// 0 HighLevel presentation 1 LowLevel Experiment
	ClassProductList theProductList;
	Product SelectedProduct;
	int nProductCategory = 0;
	boolean m_bLogout = false;
	JComboBox<Product> ProductNameCom = new JComboBox<>();
	JRadioButton MeatProductRadio = new JRadioButton();
	JRadioButton ProduceProductRadio = new JRadioButton();
	JLabel jLabel1 = new JLabel();
	JButton OKButton = new JButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	JButton buttonLogout = new JButton();

	public ProductSelectDlg() {
		try {
			jbInit();
			setSize(420, 238);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.getContentPane().setLayout(null);
		ProductNameCom.setBounds(new Rectangle(155, 41, 203, 22));
		MeatProductRadio.setText("Meat");
		MeatProductRadio.setBounds(new Rectangle(50, 87, 103, 26));
		ProduceProductRadio.setToolTipText("");
		ProduceProductRadio.setSelected(true);
		ProduceProductRadio.setText("Produce");
		ProduceProductRadio.setBounds(new Rectangle(236, 88, 103, 26));
		jLabel1.setText("Product Name");
		jLabel1.setBounds(new Rectangle(39, 44, 85, 18));
		OKButton.setText("OK");
		OKButton.setBounds(new Rectangle(78, 139, 79, 29));
		OKButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OKButton_actionPerformed(e);
			}
		});
		buttonLogout.setText("Logout");
		buttonLogout.setBounds(new Rectangle(224, 140, 73, 31));
		buttonLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLogout_actionPerformed(e);
			}
		});
		this.getContentPane().add(ProductNameCom, null);
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(MeatProductRadio, null);
		this.getContentPane().add(ProduceProductRadio, null);
		this.getContentPane().add(OKButton, null);
		this.getContentPane().add(buttonLogout, null);
		buttonGroup1.add(MeatProductRadio);
		buttonGroup1.add(ProduceProductRadio);
	}

	/*
	 * show the theCourseList in a combox Show the Course type selection button
	 * return the pointer pointing to the Course object return the Course Type
	 */

	public Product ShowDlg(ClassProductList productList) {

		theProductList = productList;
		ProductIterator theIterator = new ProductIterator(theProductList);
		Product theProduct;
		while ((theProduct = (Product) theIterator.next()) != null) /// end of the list
		{
			ProductNameCom.addItem(theProduct);
		}
		setVisible(true);
		return SelectedProduct;
	}

	void OKButton_actionPerformed(ActionEvent e) {
		SelectedProduct = (Product) ProductNameCom.getSelectedItem();
		if (MeatProductRadio.isSelected())
			nProductCategory = 0; // Meat : 0
		else
			nProductCategory = 1; // Produce: 1
		setVisible(false);
	}

	public boolean isLogout() {
		return m_bLogout;
	}

	void buttonLogout_actionPerformed(ActionEvent e) {
		m_bLogout = true;
		setVisible(false);
	}
}