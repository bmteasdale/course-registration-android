/*
 * DatabaseHelper.java
 *
 * CSci 364 -
 * Mobile Application Development
 *
 * Author: Brendan Teasdale
 *
 * */

package com.example.databaseassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Courses.db";
    public static final String TABLE_NAME = "FALL_TABLE";
    public static final String COL_1 = "CName";
    public static final String COL_2 = "ID";
    public static final String COL_3 = "Term";
    public static final String COL_4 = "PR";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (CNAME TEXT PRIMARY KEY, ID TEXT, TERM TEXT, PR TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Boolean insertData(String CNAME, String ID, String TERM, String PR) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_1, CNAME);
        cv.put(COL_2, ID);
        cv.put(COL_3, TERM);
        cv.put(COL_4, PR);

        long result = db.insert(TABLE_NAME,null,cv);
        return result != -1;
    }

    public void DeleteData(String CNAME) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = ("DELETE FROM " + TABLE_NAME + " WHERE " + COL_1 + " = '" + CNAME + "'");
        db.execSQL(query);
    }

    public Cursor getFallCourses() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT CNAME FROM " + TABLE_NAME + " WHERE TERM='1'", null);
        return res;
    }

    public Cursor getWinterCourses() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT CNAME FROM " + TABLE_NAME + " WHERE TERM='2'", null);
        return res;
    }

    public Integer getFallRowCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE TERM='1'",null
        );
        return cursor.getCount();
    }

    public Integer getWinterRowCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE TERM='2'",null
        );
        return cursor.getCount();
    }

}
