package com.example.testapp.viewModel;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.testapp.model.ConcreteModel;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ConcreteViewModel extends BaseObservable implements AbstractViewModel {

    // bind the data to ip and to port, and then call runModel
    // bind each of the properties, and then call model.set for each one of them
    // I think the set methods behind is not necessary

    private ConcreteModel model;
//    private InetAddress ip;
//    private int port;

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


    private double progressToValue(int progress) { return (double)(progress - 100) / 100; }
    private int valueToProgress(double value) { return (int)((value + 1) * 100); }

    @Bindable
    private double aileron;
    @Bindable
    private double elevator;

    @Bindable
    private int throttleProgress = 100;

    @Override
    @Bindable
    public double getThrottle() {
        Log.d("throttle", "This is my message");
        return progressToValue(this.throttleProgress);
        //bind the data to ip and to port, and then call runModel

        //bind each of the properties, and then call model.set for each one of them
        //i think the set methods behind is not necessary
    }


    @Override
    @Bindable
    public void setThrottle(double new_throttle) {
        // update model's throttle
        Log.d("throttle", "This is my message");
        setThrottleProgress(valueToProgress(new_throttle));
        notifyPropertyChanged(BR.throttle);
    }

    @Bindable
    public int getThrottleProgress() {
        Log.d("ThrottleProgress get", "This is my message " + progressToValue((this.throttleProgress)));
        return this.throttleProgress;
    }

    @Bindable
    public void setThrottleProgress(int new_throttle) {
//        Log.d("ThrottleProgress set", "This is my message " + progressToValue((this.throttleProgress)));
        this.throttleProgress = new_throttle;
        notifyPropertyChanged(BR.throttleProgress);
        this.model.setThrottle(getRudder());
    }

    @Bindable
    private int rudderProgress = 100;

    @Override
    @Bindable
    public double getRudder() { return progressToValue(this.rudderProgress); }

    @Override
    @Bindable
    public void setRudder(double new_rudder) {
        // update model's throttle
//        Log.d("rudder", "This is my message");
        setRudderProgress(valueToProgress(new_rudder));
        notifyPropertyChanged(BR.rudder);
    }

    @Bindable
    public int getRudderProgress() { return this.rudderProgress; }

    @Bindable
    public void setRudderProgress(int new_rudder) {
//        Log.d("ThrottleProgress set", "This is my message " + progressToValue(this.rudderProgress));
        this.rudderProgress = new_rudder;
//        notifyPropertyChanged(BR.rudderProgress);
        this.model.setRudder(getRudder());
    }

    @Override
    @Bindable
    public double getAileron() {
        return this.aileron;
    }

    @Bindable
    public void setAileron(double new_aileron) {
//        Log.d("AileronProgress set", "This is my message " + this.aileron);
        this.aileron = new_aileron;
        this.model.setAileron(new_aileron);
    }

    @Override
    @Bindable
    public double getElevator() {
        return this.elevator;
    }

    @Bindable
    public void setElevator(double new_elevator) {
        Log.d("ElevatorProgress set", "This is my message " + this.elevator);
        this.elevator = new_elevator;
        this.model.setElevator(new_elevator);
    }

    @Override
    public void runModel ()
    {
        // what happens if you click the button after
        // you've already connected
//        Log.d("runModel", "This is my message");
        try {

            // ip and port for example
            InetAddress ip = InetAddress.getByAddress(
                    new byte[]{(byte) 192, (byte) 168, (byte) 2, (byte) 107});
            this.model = new ConcreteModel(ip, 5400);

//            this.model = new ConcreteModel(this.ip, this.port);
            this.model.setThrottle(1.0);
            this.model.setRudder(0.1);
            this.model.setAileron(0.2);
            model.connectToServer();
        } catch (Exception e) {
            System.out.println("failed to create the variable \"ip\"");
        }
    }

}
