package com.jmarcosag.wizardworldapi.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jmarcosag.wizardworldapi.R;
import com.jmarcosag.wizardworldapi.controller.adapters.StudentsAdapter;
import com.jmarcosag.wizardworldapi.model.dao.StudentsDao;
import com.jmarcosag.wizardworldapi.model.entity.Students;
import com.jmarcosag.wizardworldapi.model.service.ApiService;
import com.jmarcosag.wizardworldapi.model.service.StudentResult;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_content);

        Intent intent = getIntent();
        int student_id = (int) intent.getSerializableExtra("student_id");

        //RecyclerView recyclerStudents = findViewById(R.id.recycler_students);

        //ApiService.getInstance().obterNomeEstudantes()
        //        .enqueue(new Callback<StudentResult>() {
        //                     @Override
        //                     public void onResponse(Call<StudentResult> call, Response<StudentResult> response) {
        //                         if (response.isSuccessful()){
        //                             RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(StudentsActivity.this);
        //                             recyclerStudents.setLayoutManager(linearLayoutManager);
        //                             recyclerStudents.setAdapter(new Students(response.body().getResultadoStudents()));
        //                         }
        //                     }
//
        //                     @Override
        //                     public void onFailure(Call<StudentResult> call, Throwable t) {
//
        //                     }
        //                 });

                        StudentsDao studentsDao = new StudentsDao();
        Students students = studentsDao.getStudentsById(student_id);

        TextView studentName = (TextView) findViewById(R.id.studentName);
        TextView studentHouse = (TextView) findViewById(R.id.studentHouse);
        TextView studentActor = (TextView) findViewById(R.id.studentActor);

        ImageView studentImage = (ImageView) findViewById(R.id.studentImage);

        studentName.setText(students.getName());
        studentHouse.setText(students.getHouse());
        studentActor.setText(students.getActor());

        Glide.with(this).load(students.getImage()).into(studentImage);
    }
}
