/*
 * Course.java
 *
 * CSci 364 -
 * Mobile Application Development
 *
 * Author: Brendan Teasdale
 *
 * */



package com.example.databaseassignment;

public class Course {
    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    public String getCourseTerm() {
        return CourseTerm;
    }

    public void setCourseTerm(String courseTerm) {
        CourseTerm = courseTerm;
    }

    public String getCoursePR() {
        return CoursePR;
    }

    public void setCoursePR(String coursePR) {
        CoursePR = coursePR;
    }

    String CourseName;
    String CourseID;
    String CourseTerm;
    String CoursePR;

}
