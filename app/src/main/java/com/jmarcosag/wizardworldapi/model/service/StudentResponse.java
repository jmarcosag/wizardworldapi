package com.jmarcosag.wizardworldapi.model.service;

import com.squareup.moshi.Json;

public class StudentResponse {

    @Json(name = "firstName")
    private final String primeiroNome;

    @Json(name = "lastName")
    private final String ultimoNome;

    public StudentResponse(String primeiroNome, String ultimoNome){
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }
}
