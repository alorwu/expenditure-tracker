package org.az20.expendituretracker.database;

import android.app.Application;
import android.os.AsyncTask;

public class UserRepository {


    private UserDao mUserDao;

    public UserRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mUserDao = db.userDao();
    }


    public User findUser(String user, String pwd) {
        return mUserDao.findUser(user, pwd);
    }


    public void addUser (User user) {
        new insertAsyncTask(mUserDao).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.addUser(params[0]);
            return null;
        }
    }
}
