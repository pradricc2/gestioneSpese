package service;

import dao.IncomeExpenseDAO;
import model.IncomeExpense;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;


@ApplicationScoped
public class IncomeExpenseService {

    public IncomeExpenseService() {
        // Costruttore vuoto
    }


    @EJB
    private IncomeExpenseDAO incomeExpenseDAO;

    public List<IncomeExpense> getAll() {
        return incomeExpenseDAO.findAll();
    }

    public IncomeExpense addIncomeExpense (IncomeExpense incomeExpense) {
        incomeExpenseDAO.save(incomeExpense);
        return incomeExpense;
    }

    public IncomeExpense getById(Long id) {
        return incomeExpenseDAO.findById(id);
    }

    public IncomeExpense updateIncomeExpense(IncomeExpense incomeExpense) {
        IncomeExpense entity = incomeExpenseDAO.findById(incomeExpense.getId());
        if (entity != null) {
            entity.setDescription(incomeExpense.getDescription());
            entity.setAmount(incomeExpense.getAmount());
            entity.setDate(incomeExpense.getDate());
            entity.setTypeIncome(incomeExpense.isTypeIncome());
            incomeExpenseDAO.update(incomeExpense);
        }
        return entity;
    }

    public void deleteIncomeExpense(Long id) {
        incomeExpenseDAO.delete(id);
    }
}
