package com.example.a21dh113686_tranhoaianhhuy;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProjectAdapter extends BaseAdapter {
    private Context context;
    private List<Project> projects;

    public ProjectAdapter(Context context, List<Project> projects) {
        this.context = context;
        this.projects = projects;
    }

    @Override
    public int getCount() {
        return projects.size();
    }

    @Override
    public Object getItem(int position) {
        return projects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_project_adapter, parent, false);
        }
        Project project = projects.get(position);

        TextView idTextView = convertView.findViewById(R.id.id_edit_text);
        idTextView.setText(project.getID());

        TextView projectNameTextView = convertView.findViewById(R.id.project_name_text_view);
        projectNameTextView.setText(project.getProjectName());

        TextView startYearTextView = convertView.findViewById(R.id.start_year_text_view);
        startYearTextView.setText(String.valueOf(project.getStartYear()));

        TextView endYearTextView = convertView.findViewById(R.id.end_year_text_view);
        endYearTextView.setText(String.valueOf(project.getEndYear()));

        TextView addressTextView = convertView.findViewById(R.id.address_text_view);
        addressTextView.setText(project.getAddress());

        return convertView;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}