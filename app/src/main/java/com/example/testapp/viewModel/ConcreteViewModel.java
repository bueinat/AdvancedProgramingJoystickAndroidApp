package com.example.testapp.viewModel;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.testapp.model.ConcreteModel;

import java.net.InetAddress;

public class ConcreteViewModel extends BaseObservable implements AbstractViewModel {

    // bind the data to ip and to port, and then call runModel
    // bind each of the properties, and then call model.set for each one of them
    // I think the set methods behind is not necessary

    private ConcreteModel model;
    private InetAddress ip;
    private int port;

    private double progressToValue(int progress) { return (double)(progress - 100) / 100; }
    private int valueToProgress(double value) { return (int)((value + 1) * 100); }

    @Bindable
    private double aileron;
    @Bindable
    private double elevator;
    @Bindable
    private double rudder;

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
        Log.d("ThrottleProgress set", "This is my message " + progressToValue((this.throttleProgress)));
        this.throttleProgress = new_throttle;
        notifyPropertyChanged(BR.throttleProgress);
        this.model.setThrottle(getRudder());
    }

    @Bindable
    private int rudderProgress = 100;

    @Override
    @Bindable
    public double getRudder() {
        Log.d("rudder", "This is my message");
        return progressToValue(this.rudderProgress);
    }

    @Override
    @Bindable
    public void setRudder(double new_rudder) {
        // update model's throttle
        Log.d("rudder", "This is my message");
        setRudderProgress(valueToProgress(new_rudder));
        notifyPropertyChanged(BR.rudder);
    }

    @Bindable
    public int getRudderProgress() {
        Log.d("RudderProgress get", "This is my message " + progressToValue((this.rudderProgress)));
        return this.rudderProgress;
    }

    @Bindable
    public void setRudderProgress(int new_rudder) {
        Log.d("ThrottleProgress set", "This is my message " + progressToValue((this.rudderProgress)));
        this.rudderProgress = new_rudder;
//        notifyPropertyChanged(BR.rudderProgress);
        this.model.setRudder(getRudder());
    }


    public void setAileron(double new_aileron) {
        this.aileron = new_aileron;
        this.model.setAileron(new_aileron);
    }

    @Override
    public double getElevator() {
        return this.elevator;
    }

    public void setElevator(double new_elevator) {
        this.elevator = new_elevator;
        this.model.setElevator(new_elevator);
    }


    @Override
    public double getAileron() {
        return this.aileron;
    }

    @Override
    public void runModel ()
    {
        // what happens if you click the button after
        // you've already connected
        Log.d("runModel", "This is my message");
        try {
            // ip and port for example
            InetAddress ip = InetAddress.getByAddress(
                    new byte[]{(byte) 192, (byte) 168, (byte) 2, (byte) 107});
            this.model = new ConcreteModel(ip, 5400);
            this.model.setThrottle(1.0);
            this.model.setRudder(0.1);
            this.model.setAileron(0.2);
            model.connectToServer();
        } catch (Exception e) {
            System.out.println("failed to create the variable \"ip\"");
        }
    }

}
