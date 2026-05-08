package com.iluv2code.springboot.demo.mycoolapp.common;

public class SwimCoach implements Coach {

    public SwimCoach () {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    public String getDailyWorkout () {
        return "Swim 1000 meters as a warm up";
    }
}
