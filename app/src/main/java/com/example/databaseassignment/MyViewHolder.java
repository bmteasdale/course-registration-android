/*
 * MyViewHolder.java
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
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyViewHolder extends RecyclerView.ViewHolder
implements View.OnClickListener{
    Context context = itemView.getContext();
    public TextView itemTv;
    Course nCourse;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        itemTv = (TextView) itemView.findViewById(R.id.itemTv);
        itemView.setOnClickListener(this);
    }
    public void bind(Course course){
        nCourse = course;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(),CourseDetails.class);
        intent.putExtra("CourseName",nCourse.getCourseName());
        intent.putExtra("CourseID", nCourse.getCourseID());
        intent.putExtra("CourseTerm", nCourse.getCourseTerm());
        intent.putExtra("CoursePR", nCourse.getCoursePR());
        context.startActivity(intent);
    }
}