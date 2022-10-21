package edu.asu.ptbs;

import java.util.Date;

public class Offering {
	String theBuyer = "";
	String offeringFileName = "";
	Date theOfferingDate = new Date();
	int theGrade;
	boolean reported = false;

	public Offering() {
	}

	@Override
	public String toString() {
		String string;
		string = theBuyer + "  " + offeringFileName + " OfferingGrade=" + getGradeInt() + "  ";
		if (isReported())
			string += "reported";
		else
			string += "not reported";

		return (string);
	}

	String getGradeString() {
		if (isReported())
			return "" + theGrade;
		else
			return "-1";
	}

	int getGradeInt() {
		return theGrade;
	}

	public void setReported(boolean reported) {
		this.reported = reported;
	}

	public boolean isReported() {
		return reported;
	}
}