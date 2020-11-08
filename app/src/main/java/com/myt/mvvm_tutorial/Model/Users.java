package com.myt.mvvm_tutorial.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class Users {
    @PrimaryKey private int userId;

    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "user_password")
    private String userPassword;

    public Users(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}

