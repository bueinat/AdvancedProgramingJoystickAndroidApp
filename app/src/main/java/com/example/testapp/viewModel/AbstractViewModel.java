package com.example.testapp.viewModel;

import java.io.Serializable;

public interface AbstractViewModel extends Serializable {
//    public double throttle;
//    public void setThrottle(double new_throttle) { this.throttle = new_throttle; }
    void setThrottle(double new_throttle);
    void runModel();

}
