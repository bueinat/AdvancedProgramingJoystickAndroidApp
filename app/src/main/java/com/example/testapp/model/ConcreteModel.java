package com.example.testapp.model;

import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.lang.*;


public class ConcreteModel implements AbstractModel{

    private ManageConnect manageConnect;

    /*
    public ConcreteModel(InetAddress ip, int port)
    {
        this.manageConnect = new ManageConnect(ip, port);
    }
*/
    public void connectToServer(InetAddress ip, int port) {
        this.manageConnect = new ManageConnect(ip, port);
        new Thread(()-> {try {
            manageConnect.connectAndRun();
        } catch (InterruptedException ie)
        {
            Log.d("connectAndRun", "Exception throws: " + ie.getMessage());
        }}).start();
        /*
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    manageConnect.connectAndRun();
                } catch (InterruptedException ie)
                {
                    Log.d("connectAndRun", "Exception throws: " + ie.getMessage());
                }
            }
        };
        t.start();
*/

    }
    public void setElevator(double d)
    {
        if(this.manageConnect == null)
        {
            return;
        }
        this.manageConnect.addToQueue("set /controls/flight/elevator " + d + "\r\n");
    }
    public void setAileron(double d)
    {
        if(this.manageConnect == null)
        {
            return;
        }
        this.manageConnect.addToQueue("set /controls/flight/aileron " + d + "\r\n");
    }
    public void setRudder(double d)
    {
        if(this.manageConnect == null)
        {
            return;
        }
        this.manageConnect.addToQueue("set /controls/flight/rudder " + d + "\r\n");
    }
    public void setThrottle(double d)
    {
        if(this.manageConnect == null)
        {
            return;
        }
        this.manageConnect.addToQueue("set /controls/engines/current-engine/throttle " + d + "\r\n");
    }

}
