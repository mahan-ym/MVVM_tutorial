package com.myt.mvvm_tutorial.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.myt.mvvm_tutorial.Model.Users;
import com.myt.mvvm_tutorial.R;
import com.myt.mvvm_tutorial.ViewModel.UsersViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UsersViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userViewModel = new ViewModelProvider(this).get(UsersViewModel.class);
        userViewModel.getUserNames().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
            //update any live data
                Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
            }
        });
    }
}