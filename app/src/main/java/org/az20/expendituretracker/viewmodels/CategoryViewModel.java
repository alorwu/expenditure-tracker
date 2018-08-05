package org.az20.expendituretracker.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import org.az20.expendituretracker.database.Category;
import org.az20.expendituretracker.database.CategoryRepository;


import java.util.List;

public class CategoryViewModel extends AndroidViewModel {

    private CategoryRepository mCategoryRepository;
    private LiveData<List<Category>> allCategories;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        mCategoryRepository = new CategoryRepository(application);
        allCategories = mCategoryRepository.getAllCategories();
    }

    public LiveData<List<Category>> getAllCategories() {
        return allCategories;
    }

    public void addCategory(Category cat){
        mCategoryRepository.addCategory(cat);
    }
}
