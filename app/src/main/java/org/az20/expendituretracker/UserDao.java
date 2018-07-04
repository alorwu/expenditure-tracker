package org.az20.expendituretracker;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;


@Dao
public interface UserDao {

    @Insert
    void addUser(User user);

    @Query("select username, hashed_password from users where username = :user and hashed_password "
           + "= :password")
    int findUser(String user, String password);

    @Delete
    void deleteUser(User user);
}
