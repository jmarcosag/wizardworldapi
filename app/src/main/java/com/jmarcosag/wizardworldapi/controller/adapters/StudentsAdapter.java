package com.jmarcosag.wizardworldapi.controller.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jmarcosag.wizardworldapi.R;
import com.jmarcosag.wizardworldapi.model.entity.Students;
import com.jmarcosag.wizardworldapi.model.service.StudentResponse;

import java.util.List;

public class StudentsAdapter extends BaseAdapter {

    private List<Students> studentsList;

    public StudentsAdapter(List<Students> spellsList) {
        this.studentsList = spellsList;
    }

    private List<StudentResponse> student;

    //public ListaStudentsAdapter(List<StudentResponse> student){
    //    this.student = student;
    //}

    @Override
    public int getCount() {
        return this.studentsList.size();
    }
    @Override
    public Object getItem(int position) {
        return this.studentsList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return this.studentsList.get(position).getId();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.students_item, parent, false);
        }

        Students students = (Students) getItem(position);
        TextView studentName = convertView.findViewById(R.id.studentName);
        TextView studentHouse = convertView.findViewById(R.id.studentHouse);
        TextView studentActor = convertView.findViewById(R.id.studentActor);

        ImageView staffImage = convertView.findViewById(R.id.studentImage);

        studentName.setText(students.getName());
        studentActor.setText(students.getActor());
        studentHouse.setText(students.getHouse());

        Glide.with(parent.getContext()).load(students.getImage()).into(staffImage);

        Glide
                .with(parent.getContext())
                .load(students.getImage())
                .into((ImageView) convertView.findViewById(R.id.studentImage));



        return convertView;
    }
}
