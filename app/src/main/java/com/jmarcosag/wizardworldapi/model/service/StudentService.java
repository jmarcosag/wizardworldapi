package com.jmarcosag.wizardworldapi.model.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface StudentService {

    @GET("/Wizards")
    Call<StudentResult> obterNomeEstudantes();

}
