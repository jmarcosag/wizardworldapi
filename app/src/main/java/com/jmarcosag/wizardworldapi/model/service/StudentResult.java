package com.jmarcosag.wizardworldapi.model.service;

import com.squareup.moshi.Json;

import java.util.List;

public class StudentResult {

    @Json(name = "id")
    private final List<StudentResponse> resultadoStudents;

    public StudentResult(List<StudentResponse> resultadoStudents){
        this.resultadoStudents = resultadoStudents;
    }

    public List<StudentResponse> getResultadoStudents() {
        return resultadoStudents;
    }
}
