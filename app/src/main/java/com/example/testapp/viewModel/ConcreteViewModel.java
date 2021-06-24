package com.example.testapp.viewModel;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.testapp.model.ConcreteModel;

import java.net.InetAddress;


public class ConcreteViewModel extends BaseObservable {

    private ConcreteModel model;


    public ConcreteViewModel()
    {
        this.model = new ConcreteModel();
    }
    @Bindable
    private String ip;
    private String port;

    @Bindable
    public String getIp() { return ip; }

    @Bindable
    public void setIp(String new_ip) {
        this.ip = new_ip;
        notifyPropertyChanged(BR.ip);
    }

    @Bindable
    public String getPort() { return port; }

    @Bindable
    public void setPort(String new_port) {
        this.port = new_port;
        notifyPropertyChanged(BR.port);
    }


    private double progressToRudder(int progress) { return (double)(progress - 100) / 100; }
    private int rudderToProgress(double value) { return (int)((value + 1) * 100); }
    private double progressToThrottle(int progress) { return (double)progress / 100.0; }
    private int throttleToProgress(double value) { return (int)(value * 100); }

    @Bindable
    private double aileron;
    @Bindable
    private double elevator;

    @Bindable
    private int throttleProgress = 100;


    @Bindable
    public double getThrottle() {
        return progressToThrottle(this.throttleProgress);
    }


    @Bindable
    public void setThrottle(double new_throttle) {

        setThrottleProgress(throttleToProgress(new_throttle));
        notifyPropertyChanged(BR.throttle);
    }

    @Bindable
    public int getThrottleProgress() {
        return this.throttleProgress;
    }

    @Bindable
    public void setThrottleProgress(int new_throttle) {
        this.throttleProgress = new_throttle;
        notifyPropertyChanged(BR.throttleProgress);
        this.model.setThrottle(getThrottle());
    }

    @Bindable
    private int rudderProgress = 100;


    @Bindable
    public double getRudder() { return progressToRudder(this.rudderProgress); }


    @Bindable
    public void setRudder(double new_rudder) {
        setRudderProgress(rudderToProgress(new_rudder));
        notifyPropertyChanged(BR.rudder);
    }

    @Bindable
    public int getRudderProgress() { return this.rudderProgress; }

    @Bindable
    public void setRudderProgress(int new_rudder) {
        this.rudderProgress = new_rudder;
//        notifyPropertyChanged(BR.rudderProgress);
        this.model.setRudder(getRudder());
    }


    @Bindable
    public double getAileron() {
        return this.aileron;
    }

    @Bindable
    public void setAileron(double new_aileron) {
        Log.d("AileronProgress set", "This is my message " + this.aileron);
        this.aileron = new_aileron;
        this.model.setAileron(new_aileron);
    }

    @Bindable
    public double getElevator() {
        return this.elevator;
    }

    @Bindable
    public void setElevator(double new_elevator) {
        this.elevator = new_elevator;
        this.model.setElevator(new_elevator);
    }


    public void runModel ()
    {

        try {

            this.model = new ConcreteModel();

            InetAddress newIP = InetAddress.getByName(this.ip);
            int newPort = Integer.parseInt(this.port);
            this.model.connectToServer(newIP, newPort);
            this.model.setThrottle(0.0);
            this.model.setRudder(0.0);
            this.model.setAileron(0.0);
            this.model.setElevator(0.0);
        } catch (Exception e) {
            Log.e("runModel","failed to connect to the FlightGear");
        }
    }

}
