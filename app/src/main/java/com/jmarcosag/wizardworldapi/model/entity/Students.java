package com.jmarcosag.wizardworldapi.model.entity;

import com.jmarcosag.wizardworldapi.model.service.StudentResponse;

import java.util.List;

public class Students {

        private int id;
        private String name;
        private String house;
        private String actor;
        private String image;

        public Students(int id, String name, String house, String actor, String image) {
            this.id = id;
            this.name = name;
            this.house = house;
            this.actor = actor;
            this.image = image;
        }

    //public StudentsList(List<StudentResponse> resultadoStudents) {
    //}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHouse() {
            return house;
        }

        public void setHouse(String house) {
            this.house = house;
        }

        public String getActor() {
            return actor;
        }

        public void setActor(String actor) {
            this.actor = actor;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
}
