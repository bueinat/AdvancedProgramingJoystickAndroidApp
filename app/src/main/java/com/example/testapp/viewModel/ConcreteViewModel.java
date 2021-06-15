package com.example.testapp.viewModel;

import android.util.Log;

import androidx.databinding.BaseObservable;

import com.example.testapp.model.ConcreteModel;

import java.net.InetAddress;

public class ConcreteViewModel extends BaseObservable implements AbstractViewModel {


    private ConcreteModel model;
    private InetAddress ip;
    private int port;

    private double aileron;
    private double elevator;
    private double rudder;
    private double throttle;

    public double getThrottle() {
        Log.d("throttle", "This is my message");
        return this.throttle;
    //bind the data to ip and to port, and then call runModel

    //bind each of the properties, and then call model.set for each one of them
    //i think the set methods behind is not necessary



    public void setAileron(double new_aileron) {
        this.throttle = new_aileron;
        this.model.setThrottle(new_aileron);
    }
    public void setElevator(double new_elevator) {
        this.throttle = new_elevator;
        this.model.setThrottle(new_elevator);
    }
    public void setRudder(double new_rudder) {
        this.throttle = new_rudder;
        this.model.setThrottle(new_rudder);
    }



    public void setThrottle(double newThrottle) {
        Log.d("throttle", "This is my message");
        this.throttle = newThrottle;
        // update model's throttle
    }

    public void runModel()
    {
        try {
            //ip and port for example
            InetAddress ip = InetAddress.getByAddress(
                    new byte[]{(byte) 212, (byte) 76, (byte) 112, (byte) 219});
            this.model = new ConcreteModel(ip, 6400);
            model.connectToServer();
        } catch(Exception e)
        {
            System.out.println("failed to create the variable \"ip\"");
        }
    }


}
