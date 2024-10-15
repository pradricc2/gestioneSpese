package model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "income_expense")
@Data
public class IncomeExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double amount;
    private LocalDate date;
    @Column(name = "isincome")
    private boolean typeIncome;

    // Getters and Setters
}

