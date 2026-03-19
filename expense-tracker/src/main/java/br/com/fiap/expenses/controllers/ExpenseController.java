package br.com.fiap.expenses.controllers;

import br.com.fiap.expenses.models.Expense;
import br.com.fiap.expenses.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* 2 - Controller */

@RestController
@RequestMapping("expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService service;

    @GetMapping
    public List<Expense> listAll() {
        return service.getAllExpenses();
    }

    @GetMapping("{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getExpenseById(id));
    }

    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addExpense(expense));
    }

    @PutMapping("{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense Expense) {
        return ResponseEntity.ok(service.updateExpense(id, Expense));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        service.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}
