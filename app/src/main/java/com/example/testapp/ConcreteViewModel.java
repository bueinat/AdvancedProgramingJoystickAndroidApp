package com.example.testapp;

import android.util.Log;

import androidx.databinding.BaseObservable;

public class ConcreteViewModel extends BaseObservable implements AbstractViewModel {

    private double throttle;

    public double getThrottle() {
        Log.d("throttle", "This is my message");
        return this.throttle;
    }

    public void setThrottle(double newThrottle) {
        Log.d("throttle", "This is my message");
        this.throttle = newThrottle;
        // update model's throttle
    }
}
