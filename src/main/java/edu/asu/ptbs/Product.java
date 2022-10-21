package edu.asu.ptbs;

import java.util.ArrayList;

public class Product {
	String ProductName;
	public ArrayList<Trade> tradingList = new ArrayList<Trade>();
	int NumOfTrades;
	int nProductCategory;

	public Product(String strCourse, int theLevel) {
		this.ProductName = strCourse;

		// 0 HighLeve presentation 1 LowLevel Experiment
		this.nProductCategory = theLevel;
		// this.AssList = NULL;
		this.NumOfTrades = 0;
	}

	public void addTrade(Trade newTrade) {
		tradingList.add(newTrade);
	}

	public String toString() {
		return ProductName;
	}

	void accept(NodeVisitor visitor) {
		visitor.visitProduct(this);
	}

}