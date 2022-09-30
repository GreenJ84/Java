package com.jessegreenough.savetravels.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jessegreenough.savetravels.models.Expense;
import com.jessegreenough.savetravels.services.ExpenseService;


@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	private final ExpenseService expenseService;
	
	public ExpenseController (ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@RequestMapping("")
	public String display(
			@ModelAttribute("expense") Expense expense,
			BindingResult result,
			Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/new")
	public String createExpense(
				@Valid @ModelAttribute("expense") Expense expense,
				BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		expenseService.newExpense(expense);
		return "redirect:/expenses";
	}
	
	@RequestMapping("/edit/{id}")
	public String editExpense(
				@PathVariable("id") Long expenseId,
				Model model) {
		Expense editable = expenseService.findExpense(expenseId);	
		model.addAttribute("expense", editable);

		return "edit.jsp";
	}
	
	@PutMapping(value="/{id}")
	public String updateExpense(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "edit.jsp";
		}
		expenseService.updateExpense(expense);
		return "redirect:/expenses";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteExpense(
				@PathVariable("id") Long id) {
		System.out.println("why");
		expenseService.delete(id);
		return "redirect:/expenses";
		}
	
	@RequestMapping("/display/{id}")
	public String display(
			@PathVariable("id") Long id,
			Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		
		return "display.jsp";
	}
	
	
}
