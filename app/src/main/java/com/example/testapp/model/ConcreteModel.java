package com.example.testapp.model;

import android.util.Log;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.lang.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class ConcreteModel implements AbstractModel{

    InetAddress ip;
    int port;
    private ThreadPool tp;
    private boolean stop = false;
    private double aileronVal;
    private double elevatorVal;
    private double rudderVal;
    private double throttleVal;

    Socket socket;
    PrintWriter out;

    Queue<String> massagesQueue = new LinkedList<>();
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
            //Thread t = new Thread(this.tp);
            final InetAddress myIp = this.ip;
            final int myPort = this.port;
            final Queue<String> myQueue = new LinkedList<>();
            Thread t = new Thread() {

                //private InetAddress ip = myIp;
                //private int port = myPort;
                //private Queue<String> q = myQueue;
                public void run()
                {
                    try {
                        socket = new Socket(ip, port);
                        Log.d("abc", "connect to server");
                        out  = new PrintWriter(socket.getOutputStream(), true);

                        while(!stop)
                        {
                            if(massagesQueue.isEmpty())
                            {
                                while(true);
                                //wait();
                            }
                            String toSend  = massagesQueue.poll();
                            out.print(toSend);
                            out.flush();
                            Log.d("send to client", toSend);

                        }
                    } catch (IOException e)
                    {

                    } //catch (InterruptedException e)
                    {

                    }
                }
            };
            t.start();



        } catch (Exception e) {
            ;
        }
    }
    public void setElevator(double i)
    {
        this.elevatorVal = i;
        //this.tp.addString("elevator" + i);
        massagesQueue.add("set /flight/elevator " + i + "\r\n");
        //notify();
    }

    public void setAileron(double i)
    {
        this.aileronVal = i;
        //this.tp.addString("aileron" + i);
        massagesQueue.add("set /flight/aileron " + i + "\r\n");
        //notify();
    }
    public void setRudder(double i)
    {
        this.rudderVal = i;
        //this.tp.addString("rudder" + i);
        massagesQueue.add("set /flight/rudder " + i + "\r\n");
        //notify();
    }
    public void setThrottle(double i)
    {
        this.throttleVal = i;
        //this.tp.addString("throttle" + i);
        massagesQueue.add("set /flight/rudder " + i + "\r\n");
        //notify();
    }

}
