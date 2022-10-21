package edu.asu.ptbs;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class ReminderVisitor extends NodeVisitor {

	Reminder m_Reminder;

	public ReminderVisitor() {
	}

	public ReminderVisitor(Reminder reminder) {
		m_Reminder = reminder;
	}

	public void visitFacade(Facade facade) {
		ProductIterator productIterator = new ProductIterator(facade.theProductList);
		while (productIterator.hasNext()) {
			Product product = (Product) productIterator.next();
			product.accept(this);
		}
	}

	public void visitProduct(Product product) {
		Iterator<Trade> tradingIterator = product.tradingList.listIterator();
		while (tradingIterator.hasNext()) {
			Trade trade = (Trade) tradingIterator.next();
			trade.accept(this);
		}
	}

	public void visitTrade(Trade trade) {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int ntoday = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(trade.dueDate);
		int nDueDate = calendar.get(Calendar.DAY_OF_YEAR);
		if (nDueDate <= (ntoday + 1) && nDueDate >= ntoday) /// upcoming
		{
			m_Reminder.listUpcoming.add("today is " + today.toString() + " " + trade.tradeName
					+ " Due Date is " + trade.getDueDateString());
		}
		if (nDueDate < ntoday) {
			// put to the
			m_Reminder.listOverdue.add(trade.tradeName + " Due Date is " + trade.getDueDateString());
		}

	}

}