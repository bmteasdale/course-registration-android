/*
 * MyCourses.java
 *
 * CSci 364 -
 * Mobile Application Development
 *
 * Author: Brendan Teasdale
 *
 * */

package com.example.databaseassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyCourses extends AppCompatActivity {

    DatabaseHelper mydb;
    ArrayAdapter LA1;
    ArrayAdapter LA2;
    Button AvailCoursesBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_courses);

        AvailCoursesBtn = findViewById(R.id.AvailCoursesBtn);
        ListView FallList = findViewById(R.id.FallTermLV);
        ListView WinterList = findViewById(R.id.WinterTermLV);

        mydb = new DatabaseHelper(this);
        if (mydb.getFallCourses().getCount() == 0)
            mydb.insertData("Advanced Data Structures", "CSci 255", "1", "CSci 162");
        if (mydb.getWinterCourses().getCount() == 0)
            mydb.insertData("Computer Organization", "CSci 263", "2", "CSci 255");

        Cursor FallData = mydb.getFallCourses();
        Cursor WinterData = mydb.getWinterCourses();

        ArrayList<String> FallCourses = new ArrayList<>();
        ArrayList<String> WinterCourses = new ArrayList<>();

        if (FallData.getCount() == 0 && WinterData.getCount() == 0) {
            Toast.makeText(this,"Error: DataBase is Empty", Toast.LENGTH_SHORT);
        }
        else {
            while(FallData.moveToNext()){
                FallCourses.add(FallData.getString(0));
                LA1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, FallCourses);
                FallList.setAdapter(LA1);
            }

            while(WinterData.moveToNext()) {
                WinterCourses.add(WinterData.getString(0));
                LA2 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,WinterCourses);
                WinterList.setAdapter(LA2);
            }
        }
        FallList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String CourseName = String.valueOf(parent.getItemAtPosition(position));
                Intent intent = new Intent(MyCourses.this, CourseDelete.class);
                intent.putExtra("CName", CourseName);
                startActivity(intent);
            }
        });
        WinterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String CourseName = String.valueOf(parent.getItemAtPosition(position));
                Intent intent = new Intent(MyCourses.this, CourseDelete.class);
                intent.putExtra("CName", CourseName);
                startActivity(intent);
            }
        });

        AvailCoursesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyCourses.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        if(LA1 != null) {
            LA1.notifyDataSetChanged();
        }
        if(LA2 != null) {
            LA2.notifyDataSetChanged();
        }
    }
}
