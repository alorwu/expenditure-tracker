package org.az20.expendituretracker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import org.az20.expendituretracker.database.Income;
import org.az20.expendituretracker.database.IncomeRepository;

import java.util.List;

public class IncomeViewModel extends AndroidViewModel {

    private IncomeRepository mIncomeRepository;
    private LiveData<List<Income>> allIncome;

    public IncomeViewModel(@NonNull Application application) {
        super(application);
        mIncomeRepository = new IncomeRepository(application);
        allIncome = mIncomeRepository.getAllIncome();
    }

    public LiveData<List<Income>> getAllIncome() {
        return allIncome;
    }

    public void addIncome(Income income){
        mIncomeRepository.addIncome(income);
    }
}
