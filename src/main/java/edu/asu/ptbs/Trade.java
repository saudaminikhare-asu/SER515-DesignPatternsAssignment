package edu.asu.ptbs;

import java.text.DateFormat;
import java.util.Date;

public class Trade {

	protected String tradeName;
	protected String strTradeFilename;
	protected Date dueDate = new Date();
	protected String tradeSpec;
	protected OfferingList theOfferingList = new OfferingList();
	protected Offering suggestedOffering= new Offering();

	public Trade() {
	}

	public void setDueDate(Date theDueDate) {
		this.dueDate = theDueDate;
	}

	public void setTradeSpec(String theSpec) {
		this.tradeSpec = theSpec;
	}

	public boolean isOverDue() {
		Date today;
		today = new Date();
		if (today.after(this.dueDate)) {
			return true;
		} else {
			return false;
		}
	}

	public Offering addOffering() {
		Offering myOffering = new Offering();
		return myOffering;
	}

	//// add the theSolution to the Solutionlist
	public void addOffering(Offering theOffering) {
		theOfferingList.add(theOffering);
	}

	public void submitOffering() {
	}

	public void getOfferingList() {
	}

	/*
	 * return the solution of the give name
	 */
	public Offering getOffering(String buyerName) {
		OfferingIterator Iterator = new OfferingIterator(theOfferingList);
		return (Offering) Iterator.next(buyerName);
	}

	public Offering getSuggestedOffering() {
		return suggestedOffering;
	}

	public OfferingIterator getOfferingIterator() {
		OfferingIterator theOfferingIterator = new OfferingIterator(theOfferingList);
		return theOfferingIterator;
	}

	public String toString() {
		return tradeName;
	}

	public String getDueDateString() {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		return dateFormat.format(dueDate);
	}

	public void accept(NodeVisitor visitor) {
		visitor.visitTrade(this);
	}
}