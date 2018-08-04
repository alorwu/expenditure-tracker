package org.az20.expendituretracker.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class CategoryRepository {

    private CategoryDao mCategoryDao;
    private LiveData<List<Category>> mCategory;

    public CategoryRepository(Application application){
        AppDatabase appDatabase = AppDatabase.getDatabase(application);
        mCategoryDao = appDatabase.categoryDao();
        mCategory = mCategoryDao.getAllCategories();
    }

    public void addCategory(Category cat) {
        new CategoryRepository.addCategoryAsyncTask(mCategoryDao).execute(cat);
    }

    public LiveData<List<Category>> getAllCategories() {
        return mCategory;
    }

    public static class addCategoryAsyncTask extends AsyncTask<Category, Void, Void> {

        private CategoryDao asyncTaskDao;

        addCategoryAsyncTask(CategoryDao categoryDao){
            asyncTaskDao = categoryDao;
        }
        @Override
        protected Void doInBackground(final Category... params) {
            asyncTaskDao.addCategory(params[0]);
            return null;
        }
    }
}
