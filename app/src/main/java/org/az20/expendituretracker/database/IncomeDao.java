package org.az20.expendituretracker.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface IncomeDao {

    @Insert
    void addIncome(Income income);

    @Query("select * from income")
    LiveData<List<Income>> getAllIncome();

    // TODO: Not implemented yet
    @Delete
    void deleteIncome(Income income);

}
