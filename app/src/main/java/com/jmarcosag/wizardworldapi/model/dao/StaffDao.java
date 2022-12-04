package com.jmarcosag.wizardworldapi.model.dao;

import com.jmarcosag.wizardworldapi.model.entity.Staff;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;
import okhttp3.Request;
import okhttp3.Response;

public class StaffDao {


    private List<Staff> staffList;
    private String responseBody;

    public StaffDao() {
        this.staffList = new ArrayList<>();
        this.getFromApi();
        this.getStaffList();
    }

    //public void client() {
    //    OkHttpClient = OkHttpClient.Builder()
    //            .connectTimeout(10, TimeUnit.SECONDS)
    //            .Build()
    //}

    public void getFromApi() {
        Request.Builder builder = new Request.Builder();
        Request request = builder
                .url("https://wizard-world-api.herokuapp.com/Wizards")
                .get()
                .build();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            this.responseBody = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Staff> getStaffList() {
        try {
            JSONArray jsonArray = new JSONArray(responseBody);

            for(int i=0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = i;
                String name = jsonObject.getString("name");
                String house = jsonObject.getString("house");

                staffList.add(new Staff(id, name, house, null, null));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.staffList;
    }

    public Staff getStaffById(int id) {
        for (Staff staff : this.staffList) {
            if(staff.getId() == id) {
                return staff;
            }
        }
        return null;
    }

}
