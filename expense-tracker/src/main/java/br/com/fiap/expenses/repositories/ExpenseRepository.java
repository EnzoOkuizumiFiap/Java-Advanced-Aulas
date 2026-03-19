package br.com.fiap.expenses.repositories;

import br.com.fiap.expenses.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

/* 3 - interface JPA*/

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    //JPA
}