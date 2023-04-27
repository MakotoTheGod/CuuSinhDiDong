package com.example.a21dh113686_tranhoaianhhuy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import com.example.a21dh113686_tranhoaianhhuy.Project;

public class ProjectManager extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ProjectManager.db";

    private static final String TABLE_PROJECT = "Project";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_PROJECTNAME = "Projectname";
    private static final String COLUMN_STARTYEAR = "StartYear";
    private static final String COLUMN_ENDYEAR = "EndYear";
    private static final String COLUMN_ADDRESS = "Address";

    public ProjectManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PROJECT_TABLE = "CREATE TABLE " + TABLE_PROJECT + "("
                + COLUMN_ID + " TEXT PRIMARY KEY,"
                + COLUMN_PROJECTNAME + " TEXT,"
                + COLUMN_STARTYEAR + " INTEGER,"
                + COLUMN_ENDYEAR + " INTEGER,"
                + COLUMN_ADDRESS + " TEXT" + ")";
        db.execSQL(CREATE_PROJECT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROJECT);
        onCreate(db);
    }

    public void addProject(Project project) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, project.getID());
        values.put(COLUMN_PROJECTNAME, project.getProjectName());
        values.put(COLUMN_STARTYEAR, project.getStartYear());
        values.put(COLUMN_ENDYEAR, project.getEndYear());
        values.put(COLUMN_ADDRESS, project.getAddress());

        db.insert(TABLE_PROJECT, null, values);
        db.close();
    }

    public List<Project> getAllProjects() {
        ArrayList<Project> projects = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_PROJECT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String ID = cursor.getString(0);
                String projectname = cursor.getString(1);
                int startYear = cursor.getInt(2);
                int endYear = cursor.getInt(3);
                String address = cursor.getString(4);

                Project project = new Project(ID, projectname, startYear, endYear, address);
                projects.add(project);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return projects;
    }
}

