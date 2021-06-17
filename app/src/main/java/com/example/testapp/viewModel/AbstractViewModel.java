package com.example.testapp.viewModel;

import java.io.Serializable;

public interface AbstractViewModel extends Serializable {

    double getThrottle();
    void setThrottle(double new_throttle);
    int getThrottleProgress();
    void setThrottleProgress(int new_throttle_progress);

    double getRudder();
    void setRudder(double new_rudder);
    int getRudderProgress();
    void setRudderProgress(int new_rudder_progress);

    double getAileron();
    void setAileron(double new_aileron);

    double getElevator();
    void setElevator(double new_elevator);

    void runModel();

}
