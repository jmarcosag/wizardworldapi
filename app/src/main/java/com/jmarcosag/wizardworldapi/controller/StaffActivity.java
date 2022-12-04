package com.jmarcosag.wizardworldapi.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jmarcosag.wizardworldapi.R;
import com.jmarcosag.wizardworldapi.model.dao.StaffDao;
import com.jmarcosag.wizardworldapi.model.entity.Staff;

public class StaffActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff_content);


        Intent intent = getIntent();
        int staff_id = (int) intent.getSerializableExtra("staff_id");

        StaffDao staffDao = new StaffDao();
        Staff staff = staffDao.getStaffById(staff_id);

        TextView staffName = (TextView) findViewById(R.id.staffName);
        TextView staffHouse = (TextView) findViewById(R.id.staffHouse);
        TextView staffActor = (TextView) findViewById(R.id.staffActor);

        ImageView staffImage = (ImageView) findViewById(R.id.staffImage);

        staffName.setText(staff.getName());
        staffHouse.setText(staff.getHouse());
        staffActor.setText(staff.getActor());

        Glide.with(this).load(staff.getImage()).into(staffImage);

    }
}
