package com.example.testapp.model;

import java.net.InetAddress;
import java.lang.*;

public class ConcreteModel implements AbstractModel{

    private InetAddress ip;
    private int port;
    private ThreadPool tp;
    private int aileronVal;
    private int elevatorVal;
    private int rudderVal;
    private int throttleVal;
    public ConcreteModel(InetAddress ip, int port)
    {
        this.ip = ip;
        this.port = port;
        this.tp = new ThreadPool(1, ip, port);
        this.aileronVal = 0;
        this.elevatorVal = 0;
        this.rudderVal = 0;
        this.throttleVal = 0;
    }

    public void connectToServer() {
        //ThreadPool tp = new ThreadPool(1, ip, port);
        try {
            Thread t = new Thread(this.tp);
            t.start();

        } catch (Exception e) {
            ;
        }
    }
        public void setElevator(int i)
        {
            this.elevatorVal = i;
            this.tp.addString("elevator" + i);
        }

    public void setAileron(int i)
    {
        this.aileronVal = i;
        this.tp.addString("aileron" + i);
    }
    public void setRudder(int i)
    {
        this.rudderVal = i;
        this.tp.addString("rudder" + i);
    }
    public void setThrottle(int i)
    {
        this.throttleVal = i;
        this.tp.addString("throttle" + i);
    }

}
