package com.example.testapp.model;
import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;


public class ManageConnect {
    private Queue<String> massagesQueue;
    private Boolean keepRun;
    private InetAddress ip;
    private int port;
    private PrintWriter out;
    private Socket socket;

    public ManageConnect(InetAddress ip, int port) throws IOException
    {
        this.massagesQueue = new LinkedList<>();
        this.keepRun = true;
        socket = new Socket(ip, port);
    }

    public synchronized void addToQueue(String s)
    {
        massagesQueue.add(s);
        notify();
    }


    public synchronized void connectAndRun() throws IOException, InterruptedException
    {
            out  = new PrintWriter(socket.getOutputStream(), true);
            Log.d("connectAndRun", "connect to server");

            while(keepRun)
            {
                if(massagesQueue.isEmpty())
                {
                    wait();
                }
                out.print(massagesQueue.poll());
                out.flush();
            }


    }

    public void stopRun()
    {
        this.keepRun = false;
    }

}
