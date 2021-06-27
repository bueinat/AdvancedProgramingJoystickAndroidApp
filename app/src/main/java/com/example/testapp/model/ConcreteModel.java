package com.example.testapp.model;

import android.util.Log;

import java.io.IOException;
import java.net.InetAddress;
import java.lang.*;


public class ConcreteModel {

    private ManageConnect manageConnect;
    private Thread thread;
    boolean isProblem;
    Boolean[] isFinish;

    public void connectToServer(InetAddress ip, int port) throws IOException{
        this.isProblem = false;
        this.isFinish = new Boolean[]{Boolean.FALSE};
        //this.isFinish[0] = false;
        /*
        if (this.manageConnect != null)
        {
            this.manageConnect.addToQueue("stop");
            try {
                this.thread.join();
            } catch(InterruptedException ie)
            {

            }
        }
         */
        this.manageConnect = new ManageConnect(ip, port);
        /*
        new Thread(()-> {try {
            manageConnect.connectAndRun();
        } catch (InterruptedException ie)
        {
            Log.e("runModel","Exception throws: " + ie.getMessage());
        }}).start();
         */

        this.thread = new Thread() {

            @Override
            public void run()
            {
                try {
                    manageConnect.connectAndRun(isFinish);
                } catch(Exception ioe)
                {
                    isProblem = true;
                }

            }
        };
        this.thread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException ie)
        {

        }
        if(isProblem)
        {
            throw new IOException();
        }
        if (!isFinish[0])
        {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie)
            {

            }
            if (!isFinish[0])
            {
                throw new IOException();
            }
        }
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
