/*
 * MainActivity.java
 *
 * CSci 364 -
 * Mobile Application Development
 *
 * Author: Brendan Teasdale
 *
 * */



package com.example.databaseassignment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView simpleRv = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        simpleRv.setHasFixedSize(true);
        simpleRv.setLayoutManager(lm);
        MyAdapter a = new MyAdapter();
        simpleRv.setAdapter(a);

        //View Classes already Registed
        Button myCoursesBtn = (Button) findViewById(R.id.myCoursesBtn);
        myCoursesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyCourses.class);
                startActivity(intent);
            }
        });


    }

}
