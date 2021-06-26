package com.example.testapp.viewModel;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.testapp.model.ConcreteModel;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ConcreteViewModel extends BaseObservable {

    private ConcreteModel model;

    public ConcreteViewModel()
    {
        this.model = new ConcreteModel();
    }

    @Bindable
    String errorMessage = "no errors found";
    String defaultMessage = "no errors found";

    @Bindable
    public String getErrorMessage() { return this.errorMessage; }
    @Bindable
    public void setErrorMessage(String new_message ) {
        this.errorMessage = new_message;
        notifyPropertyChanged(BR.errorMessage);
    }
    // ip and port for connection
    @Bindable
    private String ip;
    @Bindable
    private String port;

    @Bindable
    public String getIp() { return ip; }

    @Bindable
    public String getPort() { return port; }

    @Bindable
    public void setIp(String new_ip) {
        this.ip = new_ip;
        notifyPropertyChanged(BR.ip);
    }

    @Bindable
    public void setPort(String new_port) {
        this.port = new_port;
        notifyPropertyChanged(BR.port);
    }

    // conversion methods
    private double progressToRudder(int progress) { return (double)(progress - 100) / 100; }
    private int rudderToProgress(double value) { return (int)((value + 1) * 100); }
    private double progressToThrottle(int progress) { return (double)progress / 100.0; }
    private int throttleToProgress(double value) { return (int)(value * 100); }

    @Bindable
    private int throttleProgress = 0;


    @Bindable
    public double getThrottle() {
        return progressToThrottle(this.throttleProgress);
    }


    @Bindable
    public void setThrottle(double new_throttle) {
//        setErrorMessage("Throttle had changed via setThrottle");
        setThrottleProgress(throttleToProgress(new_throttle));
        notifyPropertyChanged(BR.throttle);
    }

    @Bindable
    public int getThrottleProgress() { return this.throttleProgress; }

    @Bindable
    public void setThrottleProgress(int new_throttle) {
//        setErrorMessage("Throttle had changed via setThrottleProgress");
        this.throttleProgress = new_throttle;
        notifyPropertyChanged(BR.throttleProgress);
        this.model.setThrottle(getThrottle());
    }

    @Bindable
    private int rudderProgress = 0;


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
        notifyPropertyChanged(BR.rudderProgress);
        this.model.setRudder(getRudder());
    }

    @Bindable
    private double aileron = 0;
    @Bindable
    private double elevator = 0;

    @Bindable
    public double getAileron() {
        return this.aileron;
    }

    @Bindable
    public void setAileron(double new_aileron) {
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


    /**
     * run the model using the given ip and port
     */
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
            this.setErrorMessage(defaultMessage);
        } catch (UnknownHostException uhe) {
            this.setErrorMessage(uhe.getMessage());
            Log.e("runModel","failed to connect to the FlightGear");
        } catch (IOException ioe)
        {
            this.setErrorMessage("problem with connecting to simulator, try again");
            setErrorMessage(ioe.getMessage());
        }
    }

}
