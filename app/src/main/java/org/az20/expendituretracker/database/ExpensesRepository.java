package org.az20.expendituretracker.database;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ExpensesRepository {

    private ExpensesDao mExpensesDao;
    private LiveData<List<Expenses>> mExpenses;

    public ExpensesRepository(Application application){
        AppDatabase appDatabase = AppDatabase.getDatabase(application);
        mExpensesDao = appDatabase.expensesDao();
        mExpenses = mExpensesDao.getAllExpenses();
    }

    public void addExpenses(Expenses expenses) {
        new ExpensesRepository.addExpensesAsyncTask(mExpensesDao).execute(expenses);
    }

    public LiveData<List<Expenses>> getAllExpenses() {
        return mExpenses;
    }

    public static class addExpensesAsyncTask extends AsyncTask<Expenses, Void, Void> {

        private ExpensesDao asyncTaskDao;

        addExpensesAsyncTask(ExpensesDao expensesDao){
            asyncTaskDao = expensesDao;
        }
        @Override
        protected Void doInBackground(final Expenses... params) {
            asyncTaskDao.addExpenses(params[0]);
            return null;
        }
    }
}
