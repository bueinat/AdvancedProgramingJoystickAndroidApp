package com.example.testapp.viewModel;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.testapp.model.ConcreteModel;

import java.net.InetAddress;

public class ConcreteViewModel extends BaseObservable implements AbstractViewModel {


    private ConcreteModel model;
    private InetAddress ip;
    private int port;

    private double aileron;
    private double elevator;
    private double rudder;
    @Bindable
    private double throttle;

    @Bindable
    private int throttleProgress = 100;


    // bind the data to ip and to port, and then call runModel
    // bind each of the properties, and then call model.set for each one of them
    // i think the set methods behind is not necessary

    @Bindable
    public double getThrottle() {
        Log.d("throttle", "This is my message");
        return this.throttle;
    }


        public void setAileron(double new_aileron) {
            this.throttle = new_aileron;
            this.model.setAileron(new_aileron);
        }
        public void setElevator(double new_elevator) {
            this.throttle = new_elevator;
            this.model.setElevator(new_elevator);
        }
        public void setRudder(double new_rudder) {
            this.throttle = new_rudder;
            this.model.setRudder(new_rudder);
        }


    @Override
    @Bindable
    public void setThrottle(double newThrottle) {
        Log.d("throttle", "This is my message");
        this.throttle = newThrottle;
        notifyPropertyChanged(BR.throttle);
        // update model's throttle
    }

    private double progressToValue(int progress) { return (double)(progress - 100) / 100; }
    @Bindable
    public int getThrottleProgress() {
        Log.d("ThrottleProgress get", "This is my message " + progressToValue((this.throttleProgress)));
        return this.throttleProgress;
    }

    @Bindable
    public void setThrottleProgress(int newThrottle) {
        Log.d("ThrottleProgress set", "This is my message " + progressToValue((this.throttleProgress)));
        this.throttleProgress = newThrottle;
        notifyPropertyChanged(BR.throttleProgress);
        // update model's throttle
    }

    @Override
        public void runModel ()
        {
            Log.d("runModel", "This is my message");
            try {
                // ip and port for example
                InetAddress ip = InetAddress.getByAddress(
                        new byte[]{(byte) 212, (byte) 76, (byte) 112, (byte) 219});
                this.model = new ConcreteModel(ip, 6400);
                model.connectToServer();
            } catch (Exception e) {
                System.out.println("failed to create the variable \"ip\"");
            }
        }

}
