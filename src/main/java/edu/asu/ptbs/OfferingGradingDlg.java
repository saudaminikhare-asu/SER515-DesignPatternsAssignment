package edu.asu.ptbs;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class OfferingGradingDlg extends JDialog {
	Offering theOffering;
	JLabel jLabel1 = new JLabel();
	JTextField tfGrad = new JTextField();
	JButton buttonOK = new JButton();
	JLabel labelSolutionFileName = new JLabel();

	public OfferingGradingDlg() {
		try {
			jbInit();
			setSize(316, 186);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		jLabel1.setText("Offering File Name");
		jLabel1.setBounds(new Rectangle(23, 30, 121, 18));
		this.getContentPane().setLayout(null);
		tfGrad.setBounds(new Rectangle(25, 66, 100, 22));
		buttonOK.setText("OK");
		buttonOK.setBounds(new Rectangle(217, 67, 79, 29));
		buttonOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonOK_actionPerformed(e);
			}
		});
		labelSolutionFileName.setBounds(new Rectangle(212, 34, 163, 18));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(tfGrad, null);
		this.getContentPane().add(labelSolutionFileName, null);
		this.getContentPane().add(buttonOK, null);
	}

	void show(Offering offering) {
		theOffering = offering;
		tfGrad.setText("" + theOffering.getGradeInt());
		labelSolutionFileName.setText(theOffering.offeringFileName);
		setVisible(true);
	}

	void buttonOK_actionPerformed(ActionEvent e) {
		theOffering.theGrade = Integer.parseInt(tfGrad.getText());
		setVisible(false);
	}

}