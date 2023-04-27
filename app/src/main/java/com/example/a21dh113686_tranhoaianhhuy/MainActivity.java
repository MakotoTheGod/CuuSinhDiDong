package com.example.a21dh113686_tranhoaianhhuy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ProjectAdapter projectAdapter;
    private ProjectManager databaseHelper;

    private EditText projectNameEditText;
    private EditText startYearEditText;
    private EditText endYearEditText;
    private EditText addressEditText;

    private Button saveButton;

    private EditText idEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        databaseHelper = new ProjectManager(this);

        // set adapter for ListView
        projectAdapter = new ProjectAdapter(this, databaseHelper.getAllProjects());
        listView.setAdapter(projectAdapter);

        // set click listener for "Show All" button
        Button showAllButton = findViewById(R.id.show_all_button);
        showAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Project> allProjects = databaseHelper.getAllProjects();
                projectAdapter.setProjects(allProjects);
                projectAdapter.notifyDataSetChanged();
            }
        });

        // set references to EditTexts
        projectNameEditText = findViewById(R.id.project_name_edit_text);
        startYearEditText = findViewById(R.id.start_year_edit_text);
        endYearEditText = findViewById(R.id.end_year_edit_text);
        addressEditText = findViewById(R.id.address_edit_text);
        idEditText = findViewById(R.id.id_edit_text);


        saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get input values from EditTexts

                String ID = idEditText.getText().toString().trim();
                String projectName = projectNameEditText.getText().toString().trim();
                int startYear = Integer.parseInt(startYearEditText.getText().toString().trim());
                int endYear = Integer.parseInt(endYearEditText.getText().toString().trim());
                String address = addressEditText.getText().toString().trim();

                // create new project object and add to database
                Project project = new Project(ID, projectName, startYear, endYear, address);
                databaseHelper.addProject(project);

                // update list view
                List<Project> allProjects = databaseHelper.getAllProjects();
                projectAdapter.setProjects(allProjects);
                projectAdapter.notifyDataSetChanged();

                // clear input fields
                idEditText.setText("");
                projectNameEditText.setText("");
                startYearEditText.setText("");
                endYearEditText.setText("");
                addressEditText.setText("");
            }
        });
    }
}

