package com.jmarcosag.wizardworldapi.controller.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jmarcosag.wizardworldapi.R;
import com.jmarcosag.wizardworldapi.model.entity.Staff;

import java.util.List;

public class StaffAdapter extends BaseAdapter {

    private List<Staff> staffList;

    public StaffAdapter(List<Staff> staffList) {
        this.staffList = staffList;
    }

    @Override
    public int getCount() {
        return this.staffList.size();
    }
    @Override
    public Object getItem(int position) {
        return this.staffList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return this.staffList.get(position).getId();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.staff_item, parent, false);
        }

        Staff staff = (Staff) getItem(position);
        TextView staffName = convertView.findViewById(R.id.staffName);
        TextView staffHouse = convertView.findViewById(R.id.staffHouse);
        TextView staffActor = convertView.findViewById(R.id.staffActor);

        ImageView staffImage = convertView.findViewById(R.id.staffImage);

        staffName.setText(staff.getName());
        staffActor.setText(staff.getActor());
        staffHouse.setText(staff.getHouse());

        Glide.with(parent.getContext()).load(staff.getImage()).into(staffImage);

        Glide
                .with(parent.getContext())
                .load(staff.getImage())
                .into((ImageView) convertView.findViewById(R.id.staffImage));


        return convertView;
    }
}
