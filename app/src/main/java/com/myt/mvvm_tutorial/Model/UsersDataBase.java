package com.myt.mvvm_tutorial.Model;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Users.class}, version = 1)
public abstract class UsersDataBase extends RoomDatabase {
    public static UsersDataBase instance;
    public abstract UserDAO userDao();

    //this constructor is responsible to create our database or migrate it
    public static synchronized UsersDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    UsersDataBase.class, "users")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new CreateDb(instance).execute();
        }
    };

    private static class CreateDb extends AsyncTask<Void,Void,Void>{
        private  UserDAO userDao;

        public CreateDb(UsersDataBase db) {
            this.userDao = db.userDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            userDao.insert(new Users("test","test"));
            return null;
        }
    }
}
