package com.jmarcosag.wizardworldapi.model.dao;

import com.jmarcosag.wizardworldapi.model.entity.Students;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StudentsDao {

    private List<Students> studentsList;
    private String responseBody;

    public StudentsDao() {
        this.studentsList = new ArrayList<>();
        this.getFromApi();
        this.getStudentsList();
    }

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

    public List<Students> getStudentsList() {
        try {
            JSONObject jsonObject = new JSONObject(responseBody);
            JSONArray jsonArray = jsonObject.getJSONArray("id");

            for(int i=0; i < jsonArray.length(); i++) {
                JSONObject student = new JSONObject(jsonArray.getString(i));
                int id = i;
                String name = jsonObject.getString("firstName");
                String house = jsonObject.getString("lastName");

                studentsList.add(new Students(id, name, house, null, null));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.studentsList;
    }

    public Students getStudentsById(int id) {
        for (Students students : this.studentsList) {
            if(students.getId() == id) {
                return students;
            }
        }
        return null;
    }

}
