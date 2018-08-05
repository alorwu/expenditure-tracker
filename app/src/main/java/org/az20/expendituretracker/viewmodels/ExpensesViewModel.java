package org.az20.expendituretracker.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import org.az20.expendituretracker.database.Expenses;
import org.az20.expendituretracker.database.ExpensesRepository;

import java.util.List;

public class ExpensesViewModel extends AndroidViewModel {

    private ExpensesRepository expensesRepository;
    private LiveData<List<Expenses>> allExpenses;

    public ExpensesViewModel(@NonNull Application application) {
        super(application);

        expensesRepository = new ExpensesRepository(application);
        allExpenses = expensesRepository.getAllExpenses();
    }

    public LiveData<List<Expenses>> getAllExpenses() {
        return allExpenses;
    }

    public void addExpenses(Expenses expense){
        expensesRepository.addExpenses(expense);
    }
}
