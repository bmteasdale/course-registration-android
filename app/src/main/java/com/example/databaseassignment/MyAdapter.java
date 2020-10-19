/*
 * MyAdapter.java
 *
 * CSci 364 -
 * Mobile Application Development
 *
 * Author: Brendan Teasdale
 *
 * */



package com.example.databaseassignment;

//Import Classes
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    String [] courseNames = {
            "Introduction to Coding",
            "Introduction to Programming",
            "Programming and Data Structures",
            "Social Issues",
            "Health Analytics",
            "Data Science",
            "Advanced Data Structures",
            "Computer Organization",
            "Database Management Systems",
            "Discrete Structures",
            "Evolutionary Computation",
            "Theory of Computing",
            "Mobile App Development",
            "Data Communications and Networking",
            "Operating Systems"
    };
    String [] CourseIDs = {
            "CSci 128",
            "CSci 161",
            "CSci 162",
            "CSci 215",
            "CSci 225",
            "CSci 223",
            "CSci 255",
            "CSci 263",
            "CSci 275",
            "CSci 277",
            "CSci 340",
            "CSci 356",
            "CSci 364",
            "CSci 368",
            "CSci 375"
    };
    String [] CourseTerms = {
//            1 = Fall, 2 = Winter
            "2",
            "1",
            "2",
            "2",
            "1",
            "1",
            "1",
            "2",
            "2",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1"
    };
    String [] CoursePRs = {
            "N/A",
            "N/A",
            "CSci 161",
            "N/A",
            "CSci 161",
            "CSci 161",
            "CSci 162",
            "CSci 255",
            "CSci 162",
            "Math 101",
            "N/A",
            "CSci 277",
            "CSci 162",
            "CSci 255",
            "CSci 255"
    };


   ArrayList<Course> Courses = new ArrayList<Course>();
   ArrayList<String> CourseNameAL = new ArrayList<>();


    MyAdapter(){
        for (int i = 0; i < courseNames.length; i++) {

            Course course = new Course();
            course.setCourseName(courseNames[i]);
            course.setCourseID(CourseIDs[i]);
            course.setCourseTerm(CourseTerms[i]);
            course.setCoursePR(CoursePRs[i]);
            Courses.add(course);
            CourseNameAL.add(courseNames[i]);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        //Toast printed on hover state.
        ((MyViewHolder) viewHolder).itemTv.setText(CourseNameAL.get(position));
        Course course = Courses.get(position);
        ((MyViewHolder) viewHolder).bind(course);
    }


    @Override
    public int getItemCount() {
        return CourseNameAL.size();
    }

}