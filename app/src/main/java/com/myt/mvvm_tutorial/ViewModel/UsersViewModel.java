package com.myt.mvvm_tutorial.ViewModel;

import android.app.Application;

import com.myt.mvvm_tutorial.Model.Users;
import com.myt.mvvm_tutorial.Model.UsersRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class UsersViewModel extends AndroidViewModel {

    private UsersRepository repository;
    private LiveData<List<String>> userNames;

    public UsersViewModel(@NonNull Application application) {
        super(application);
        repository = new UsersRepository(application);
        userNames = repository.getUserNames();
    }

    public void insert(Users user){
        repository.insert(user);
    }
    public void Delete(Users user){
        repository.delete(user);
    }
    public void Update(Users user){
        repository.update(user);
    }
    public LiveData<List<String>> getUserNames(){
        return userNames;
    }
}
