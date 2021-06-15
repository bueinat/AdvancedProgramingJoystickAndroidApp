package com.example.testapp.viewModel;

import android.util.Log;

import androidx.databinding.BaseObservable;

import com.example.testapp.model.ConcreteModel;

import java.net.InetAddress;

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

    public void runModel()
    {
        try {
            InetAddress ip = InetAddress.getByAddress(
                    new byte[]{(byte) 212, (byte) 76, (byte) 112, (byte) 219});
            ConcreteModel model = new ConcreteModel(ip, 6400);
            model.connectToServer();
        } catch(Exception e)
        {
            System.out.println("failed to create the variable \"ip\"");
        }
    }
}
