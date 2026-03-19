package br.com.fiap.expenses.services;

import br.com.fiap.expenses.models.Expense;
import br.com.fiap.expenses.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/* 3 - Service */

@Service
public class ExpenseService {
    @Autowired
    public ExpenseRepository repository;

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return findExpenseById(id);
    }

    public Expense addExpense(Expense expense) {
        return repository.save(expense);
    }

    public Expense updateExpense(Long id,Expense newExpense) {
        newExpense.setId(findExpenseById(id).getId());
        return repository.save(newExpense);
    }

    public void deleteExpense(Long id) {
        findExpenseById(id);
        repository.deleteById(id);
    }

    private Expense findExpenseById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense com id " + id + " não encontrado." ));
    }
}
