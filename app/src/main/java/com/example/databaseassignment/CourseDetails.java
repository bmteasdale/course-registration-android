/*
* CourseDetails.java
*
* CSci 364 -
* Mobile Application Development
*
* Author: Brendan Teasdale
*
* */


package com.example.databaseassignment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class CourseDetails extends AppCompatActivity {

    DatabaseHelper myDB;
    Button regBtn;
    Button returnBtn;
    TextView courseNameTV;
    TextView courseIDTV;
    TextView courseTermTV;
    TextView coursePRTV;

    List<String> CoursesCompleted = Arrays.asList("CSci 161","CSci 162", "Math 101", "N/A");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        Context context = this;
        myDB = new DatabaseHelper(context);

        regBtn = findViewById(R.id.regBtn);
        returnBtn = findViewById(R.id.returnBtn);
        courseNameTV = findViewById(R.id.CourseNameDetail);
        courseIDTV = findViewById(R.id.courseIDDetail);
        courseTermTV = findViewById(R.id.CourseTermDetail);
        coursePRTV = findViewById(R.id.CoursePRDetail);

        Intent intent = getIntent();
        String CourseNameFromIntent = intent.getStringExtra("CourseName");
        String CourseIDFromIntent = intent.getStringExtra("CourseID");
        String CourseTermFromIntent = intent.getStringExtra("CourseTerm");
        String CoursePRFromIntent = intent.getStringExtra("CoursePR");


        courseNameTV.setText(CourseNameFromIntent);
        courseIDTV.setText(CourseIDFromIntent);
        courseTermTV.setText(CourseTermFromIntent);
        coursePRTV.setText(CoursePRFromIntent);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent(CourseDetails.this, MainActivity.class);
                startActivity(returnIntent);
            }
        });

        addData();
    }

    public void addData() {
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer FallTableSize = myDB.getFallRowCount();
                Integer WinterTableSize = myDB.getWinterRowCount();

                if (FallTableSize != 3 && courseTermTV.getText().toString().equals("1")) {
                    if (CoursesCompleted.contains(coursePRTV.getText().toString())) {
                        Boolean isInserted = myDB.insertData(courseNameTV.getText().toString(),
                                courseIDTV.getText().toString(),
                                courseTermTV.getText().toString(),
                                coursePRTV.getText().toString());
                        if (isInserted) {
                            Toast.makeText(getApplicationContext(),
                                    "Success: Data Inserted!",
                                    Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(CourseDetails.this, MyCourses.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Error: Course may already be registered.",
                                    Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Error: PreReq not previously completed.",
                                Toast.LENGTH_LONG).show();
                    }
                }

                else if (WinterTableSize != 3 && courseTermTV.getText().toString().equals("2")) {
                    if (CoursesCompleted.contains(coursePRTV.getText().toString())) {
                        Boolean isInserted = myDB.insertData(courseNameTV.getText().toString(),
                                courseIDTV.getText().toString(),
                                courseTermTV.getText().toString(),
                                coursePRTV.getText().toString());
                        if (isInserted) {
                            Toast.makeText(getApplicationContext(),
                                    "Success: Data Inserted!",
                                    Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(CourseDetails.this, MyCourses.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Error: Course may already be registered.",
                                    Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Error: PreReq not previously completed.",
                                Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Error: Term " + courseTermTV.getText().toString() + " is full!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}