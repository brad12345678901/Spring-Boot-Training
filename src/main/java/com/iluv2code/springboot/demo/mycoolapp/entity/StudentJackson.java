package com.iluv2code.springboot.demo.mycoolapp.entity;

public class StudentJackson {
    private String firstName;
    private String lastName;

    public StudentJackson() {}
    public StudentJackson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
