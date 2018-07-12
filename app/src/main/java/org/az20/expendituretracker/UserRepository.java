package org.az20.expendituretracker;

import android.app.Application;
import android.os.AsyncTask;

public class UserRepository {


    private UserDao mUserDao;
    private int users;


    UserRepository(Application application, String usr, String pwd) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mUserDao = db.userDao();
        users = mUserDao.findUser(usr, pwd);
    }


    public int findUser(String usr, String pwd) {
        return users;
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
