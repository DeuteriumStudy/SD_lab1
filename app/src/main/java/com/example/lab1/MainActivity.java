package com.example.lab1;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        ListAdapter listAdapter = new ListAdapter(1000000);
        recyclerView.setAdapter(listAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (Build.VERSION.SDK_INT < 21) {
                finishAffinity(); //finish this and all parent activities
            } else {
                finishAndRemoveTask(); //finish activity and task, requires API 21
            }

            return false;
        }

        return super.onKeyDown(keyCode, event);
    }
}
