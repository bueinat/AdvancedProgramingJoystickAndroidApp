package com.example.testapp.model;

import android.util.Log;

import java.net.InetAddress;
import java.lang.*;


public class ConcreteModel {

    private ManageConnect manageConnect;

    public void connectToServer(InetAddress ip, int port) {
        if (this.manageConnect != null)
        {
            this.manageConnect.stopRun();
        }
        this.manageConnect = new ManageConnect(ip, port);
        new Thread(()-> {try {
            manageConnect.connectAndRun();
        } catch (InterruptedException ie)
        {
            Log.e("runModel","Exception throws: " + ie.getMessage());
        }}).start();
    }
    public void setElevator(double d)
    {
        if(this.manageConnect == null)
            return;
        this.manageConnect.addToQueue("set /controls/flight/elevator " + d + "\r\n");
    }
    public void setAileron(double d)
    {
        if(this.manageConnect == null)
            return;
        this.manageConnect.addToQueue("set /controls/flight/aileron " + d + "\r\n");
    }
    public void setRudder(double d)
    {
        if(this.manageConnect == null)
            return;
        this.manageConnect.addToQueue("set /controls/flight/rudder " + d + "\r\n");
    }
    public void setThrottle(double d)
    {
        if(this.manageConnect == null)
            return;
        this.manageConnect.addToQueue("set /controls/engines/current-engine/throttle " + d + "\r\n");
    }

}
