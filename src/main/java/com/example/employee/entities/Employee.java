package com.example.employee.entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import javax.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDate;

@MongoEntity(collection = "employees")
public class Employee extends PanacheMongoEntity {

    private String name;
    private int age;

    @JsonbDateFormat("dd-MM-yyyy")
    private LocalDate birthDate;

    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
