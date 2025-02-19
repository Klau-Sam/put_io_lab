package put.io.testing.mocks;

import java.net.ConnectException;
import java.util.List;

import put.io.students.fancylibrary.service.FancyService;

public class ExpenseManager {

	private ExpenseRepository expenseRepository;
	private FancyService fancyService;

	public ExpenseManager() {
		this.expenseRepository = new ExpenseRepository();
		this.fancyService = new FancyService();
	}

	public ExpenseManager(ExpenseRepository expRep, FancyService fanServ) {
		this.expenseRepository = expRep;
		this.fancyService = fanServ;
	}

	public long calculateTotal() {
		List<Expense> expenses = expenseRepository.getExpenses();

		return calculateTotal(expenses);
	}

	public long calculateTotalForCategory(String category) {
		List<Expense> expenses = expenseRepository.getExpensesByCategory(category);

		return calculateTotal(expenses);
	}

	private long calculateTotal(List<Expense> expenses) {
		long total = 0;

		for (Expense expense : expenses) {
			total += expense.getAmount();
		}

		return total;
	}

	public long calculateTotalInDollars() {
		long total = calculateTotal();

		double convertedTotal = -1;
		try {
			convertedTotal = fancyService.convert(total, "PLN", "USD");
		} catch (ConnectException e) {

		}

		return (int)convertedTotal;
	}

	public long convertExpenseToDollars(Expense expense) {
		double convertedAmount = 1;
		try {
			convertedAmount = fancyService.convert(expense.getAmount(), "PLN", "USD");
		} catch (ConnectException e) {

		}

		return (int)convertedAmount;
	}

}
