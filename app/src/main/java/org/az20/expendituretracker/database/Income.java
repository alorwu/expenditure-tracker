package org.az20.expendituretracker.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "income")
public class Income {

    @PrimaryKey(autoGenerate = true)
    private int incomeID;
    private String incomeTitle;
    private int amount;

    @Ignore
    public Income(String incomeTitle, int amount){
        this.incomeTitle = incomeTitle;
        this.amount = amount;
    }

    public Income(){}

    public int getIncomeID() {
        return incomeID;
    }

    public void setIncomeID(int income_id) {
        this.incomeID = incomeID;
    }

    public String getIncomeTitle() {
        return incomeTitle;
    }

    public void setIncomeTitle(String income_title) {
        this.incomeTitle = income_title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
