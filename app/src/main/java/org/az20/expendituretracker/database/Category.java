package org.az20.expendituretracker.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "category")
public class Category {

    @PrimaryKey(autoGenerate = true)
    private int catID;
    private String catTitle;
    private int catAmount;

    @Ignore
    public Category(String catTitle, int amount){
        this.catTitle = catTitle;
        this.catAmount = amount;
    }

    public Category(){}

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getCatTitle() {
        return catTitle;
    }

    public void setCatTitle(String catTitle) {
        this.catTitle = catTitle;
    }

    public int getCatAmount() {
        return catAmount;
    }

    public void setCatAmount(int amount) {
        this.catAmount = amount;
    }
}
