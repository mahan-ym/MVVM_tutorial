package com.myt.mvvm_tutorial.Model;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Update;

public class UsersRepository {
    private UserDAO userDao;
    private LiveData<List<String>> usernames;

    public UsersRepository(Application application){
        UsersDataBase usersData = UsersDataBase.getInstance(application);
        userDao = usersData.userDao();
        usernames = userDao.getUserNames();
    }
    public void insert(Users user){
        new InsertUserTask(userDao).execute(user);
    }
    public void delete(Users user){
        new DeleteUserTask(userDao).execute(user);
    }

    public void update(Users user){
        new UpdateUserTask(userDao).execute(user);
    }

    public LiveData<List<String>> getUserNames(){
        return usernames;
    }
    //these functions are used to perform database operations on another thread

    private static class InsertUserTask extends AsyncTask<Users,Void,Void>{
        private UserDAO userDao;
        private InsertUserTask(UserDAO userDao){
            this.userDao=userDao;
        }

        @Override
        protected Void doInBackground(Users... users) {
            userDao.insert(users[0]);
            return null;
        }
    }
    private static class DeleteUserTask extends AsyncTask<Users,Void,Void>{
        private UserDAO userDao;
        private DeleteUserTask(UserDAO userDao){
            this.userDao=userDao;
        }

        @Override
        protected Void doInBackground(Users... users) {
            userDao.delete(users[0]);
            return null;
        }
    }
    private static class UpdateUserTask extends AsyncTask<Users,Void,Void>{
        private UserDAO userDao;
        private UpdateUserTask(UserDAO userDao){
            this.userDao=userDao;
        }

        @Override
        protected Void doInBackground(Users... users) {
            userDao.update(users[0]);
            return null;
        }
    }
}
