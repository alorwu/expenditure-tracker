package org.az20.expendituretracker.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class IncomeRepository {

    private IncomeDao mIncomeDao;
    private LiveData<List<Income>> mIncome;

    public IncomeRepository(Application application){
        AppDatabase appDatabase = AppDatabase.getDatabase(application);
        mIncomeDao = appDatabase.incomeDao();
        mIncome = mIncomeDao.getAllIncome();
    }

    public void addIncome(Income income) {
       new addIncomeAsyncTask(mIncomeDao).execute(income);
    }

    public LiveData<List<Income>> getAllIncome() {
        return mIncome;
    }

    public static class addIncomeAsyncTask extends AsyncTask<Income, Void, Void>{

        private IncomeDao asyncTaskDao;

        addIncomeAsyncTask(IncomeDao incomeDao){
            asyncTaskDao = incomeDao;
        }
        @Override
        protected Void doInBackground(final Income... params) {
            asyncTaskDao.addIncome(params[0]);
            return null;
        }
    }
}
