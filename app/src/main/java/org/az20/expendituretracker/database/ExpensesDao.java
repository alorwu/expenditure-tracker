package org.az20.expendituretracker.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ExpensesDao {

    @Insert
    void addExpenses(Expenses expenses);

    @Query("select * from expenses")
    LiveData<List<Expenses>> getAllExpenses();

    @Delete
    void deleteExpenses(Expenses expenses);
}
