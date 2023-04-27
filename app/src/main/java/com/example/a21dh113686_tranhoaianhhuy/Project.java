package com.example.a21dh113686_tranhoaianhhuy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Project extends AppCompatActivity {


        private String ID;
        private String projectName;
        private int startYear;
        private int endYear;
        private String address;

        public Project(String ID, String projectName, int startYear, int endYear, String address) {
            this.ID = ID;
            this.projectName = projectName;
            this.startYear = startYear;
            this.endYear = endYear;
            this.address = address;
        }

        public String getID() {
            return ID;
        }

        public String getProjectName() {
            return projectName;
        }

        public int getStartYear() {
            return startYear;
        }

        public int getEndYear() {
            return endYear;
        }

        public String getAddress() {
            return address;
        }
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}