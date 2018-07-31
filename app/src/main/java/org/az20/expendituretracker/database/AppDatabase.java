package org.az20.expendituretracker.database;


import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.arch.persistence.room.Database;

@Database (entities = {User.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract UserDao userDao();

    private static AppDatabase mInstance;

    public static AppDatabase getDatabase(final Context context) {
        if (mInstance == null) {
            synchronized (AppDatabase.class) {
                if (mInstance == null) {
                    // Room running on main UI Thread
                    mInstance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "user_database").allowMainThreadQueries()
                            .build();
                }
            }
        }
        return mInstance;
    }
}
