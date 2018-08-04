package org.az20.expendituretracker.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    void addCategory(Category cat);

    @Query("select * from category")
    LiveData<List<Category>> getAllCategories();

    // TODO: Not implemented yet
    @Delete
    void deleteCategory(Category cat);
}
