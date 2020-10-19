/*
 * CourseDelete.java
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
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CourseDelete extends AppCompatActivity {

    Button deleteBtn;
    Button returnBtn;
    TextView courseTV;
    DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_delete);


        deleteBtn = findViewById(R.id.DeleteBtn);
        returnBtn = findViewById(R.id.Return_to_Courses);
        courseTV = findViewById(R.id.CourseNameTV);

        if (getIntent() != null) {
            courseTV.setText(getIntent().getStringExtra("CName"));
        }

        myDB = new DatabaseHelper(this);


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseName = courseTV.getText().toString();
                Intent intent = new Intent(CourseDelete.this, MyCourses.class);

                if (!courseName.equals("Advanced Data Structures") && !courseName.equals("Computer Organization")){
                    myDB.DeleteData(courseName);
                    Toast.makeText(getApplicationContext(),"Success: Course Deleted!",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error: " + courseName + " cannot be deleted.",Toast.LENGTH_SHORT).show();
                }
//

            }
        });

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseDelete.this, MyCourses.class);
                startActivity(intent);
            }
        });
    }
}
