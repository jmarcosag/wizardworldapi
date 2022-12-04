package com.jmarcosag.wizardworldapi.model.service;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {

    private static StudentService INSTANCE;

    public static StudentService getInstance(){
        if (INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE = retrofit.create(StudentService.class);
        }
        return INSTANCE;
    }

}
