package com.example.todo;

import java.io.Serializable;

public class Oficio implements Serializable {

    private String name;
    private  int age;

    public Oficio(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return  name + " " + age;
    }
}
