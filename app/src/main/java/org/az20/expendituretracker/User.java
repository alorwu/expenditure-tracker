package org.az20.expendituretracker;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "users")
public class User {


    public User(String fullname, String username, String email, String password){

        this.name = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name = "full_name")
    private String name;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "user_email")
    private String email;

    @ColumnInfo(name = "hashed_password")
    private String password;


    public void setName(String fullname) {
        this.name = fullname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
