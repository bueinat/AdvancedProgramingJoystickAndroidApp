package com.example.testapp;

public class ConcreteViewModel implements AbstractViewModel{

    private double throttle;
    @Override
    public void setThrottle(double new_throttle) {
        this.throttle = new_throttle;
    }
}
