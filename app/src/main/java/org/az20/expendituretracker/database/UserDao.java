package org.az20.expendituretracker.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


@Dao
public interface UserDao {

    @Insert
    void addUser(User user);

    @Query("select * from users where username = :user")
    User findUser(String user);

    // TODO: Not implemented yet
    @Delete
    void deleteUser(User user);
}
