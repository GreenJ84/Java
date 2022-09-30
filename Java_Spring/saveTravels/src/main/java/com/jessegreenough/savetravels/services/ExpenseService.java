package com.jessegreenough.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jessegreenough.savetravels.models.Expense;
import com.jessegreenough.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepo;

	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	public List<Expense> allExpenses(){
		return this.expenseRepo.findAll();
	}
	
	public Expense newExpense(Expense e) {
		return expenseRepo.save(e);
	}

	public Expense findExpense(Long id) {
		Optional<Expense> expense = expenseRepo.findById(id);
		if (expense.isPresent()) {
			return expense.get();
		}
		return null;
	}
	
	public void updateExpense(Expense e) {
		
		expenseRepo.save(e);
	}
	
	public void delete(Long id) {
		expenseRepo.deleteById(id);
	}

}
