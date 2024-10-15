package dao;

import model.IncomeExpense;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class IncomeExpenseDAO {

    @PersistenceContext(unitName = "incomeExpensePU")
    private EntityManager entityManager;

    public void save(IncomeExpense entity) {
        entityManager.persist(entity);
    }

    public IncomeExpense findById(Long id) {
        return entityManager.find(IncomeExpense.class, id);
    }

    public List<IncomeExpense> findAll() {
        return entityManager.createQuery("SELECT e FROM IncomeExpense e", IncomeExpense.class).getResultList();
    }

    public void update(IncomeExpense entity) {
        entityManager.merge(entity);
    }

    public void delete(Long id) {
        IncomeExpense entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}

