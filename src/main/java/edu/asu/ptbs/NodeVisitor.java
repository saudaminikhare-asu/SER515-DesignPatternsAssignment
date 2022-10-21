package edu.asu.ptbs;

abstract public class NodeVisitor {

	public NodeVisitor() {
	}

	public NodeVisitor(Object visitor) {
	}

	abstract public void visitFacade(Facade facade);

	abstract public void visitProduct(Product product);

	abstract public void visitTrade(Trade trade);

}