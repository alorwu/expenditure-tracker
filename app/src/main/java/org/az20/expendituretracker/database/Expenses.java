package org.az20.expendituretracker.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "expenses")
public class Expenses {


    @PrimaryKey(autoGenerate = true)
    private int expensesID;
    private String expensesTitle;
    private int amount;

    @Ignore
    public Expenses(String expensesTitle, int amount){
        this.expensesTitle = expensesTitle;
        this.amount = amount;
    }

    public Expenses(){}

    public int getExpensesID() {
        return expensesID;
    }

    public void setExpensesID(int expensesID) {
        this.expensesID = expensesID;
    }

    public String getExpensesTitle() {
        return expensesTitle;
    }

    public void setExpensesTitle(String expensesTitle) {
        this.expensesTitle = expensesTitle;
    }

    public int getExpensesAmount() {
        return amount;
    }

    public void setExpensesAmount(int amount) {
        this.amount = amount;
    }
}
