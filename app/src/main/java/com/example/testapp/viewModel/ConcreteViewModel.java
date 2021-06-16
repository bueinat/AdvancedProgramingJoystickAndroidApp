package com.example.testapp.viewModel;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.testapp.model.ConcreteModel;

import java.net.InetAddress;

public class ConcreteViewModel extends BaseObservable implements AbstractViewModel {

    @Bindable
    private double throttle;

    @Bindable
    private int throttleProgress = 100;

    @Bindable
    private String userEmail;
    @Bindable
    public void setUserEmail(String email) {
        Log.d("setm", "This is my message");
        this.userEmail = email;
        notifyPropertyChanged(BR.userEmail);
    }
    @Bindable
    public String getUserEmail() {
        Log.d("getm", "This is my message");
        return this.userEmail;
    }

    @Bindable
    private String userPassword;
    @Bindable
    public void setUserPassword(String email) {
        Log.d("setps", "This is my message");
        this.userPassword = email;
        notifyPropertyChanged(BR.userPassword);
    }
    @Bindable
    public String getUserPassword() {
        Log.d("getps", "This is my message");
        return this.userPassword;
    }

    @Bindable
    public double getThrottle() {
        Log.d("throttle", "This is my message");
        return this.throttle;
    }

    @Override
    @Bindable
    public void setThrottle(double newThrottle) {
        Log.d("throttle", "This is my message");
        this.throttle = newThrottle;
        notifyPropertyChanged(BR.throttle);
        // update model's throttle
    }

    @Bindable
    public int getThrottleProgress() {
        Log.d("ThrottleProgress", "This is my message");
        return this.throttleProgress;
    }

    @Bindable
    public void setThrottleProgress(int newThrottle) {
        Log.d("ThrottleProgress", "This is my message");
        this.throttleProgress = newThrottle;
        notifyPropertyChanged(BR.throttleProgress);
        // update model's throttle
    }

    @Override
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
