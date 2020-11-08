package com.myt.mvvm_tutorial.Model;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDAO {

    @Insert
    public void insert(Users user);

    @Delete
    public void delete(Users user);

    @Update
    public void update(Users user);

    @Query("SELECT * FROM users")
    public LiveData<List<String>> getUserNames();
}
