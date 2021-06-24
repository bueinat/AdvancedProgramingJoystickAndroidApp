package com.example.testapp.model;
import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;


public class ManageConnect {
    private Queue<String> massagesQueue;
    private Boolean keepRun;
    private PrintWriter out;
    private Socket socket;

    private InetAddress ip;
    private int port;

    public ManageConnect(InetAddress ip, int port)
    {
        this.ip = ip;
        this.port = port;

        this.massagesQueue = new LinkedList<>();
        this.keepRun = true;
    }

    public synchronized void addToQueue(String s)
    {
        massagesQueue.add(s);
        notify();
    }


    public synchronized void connectAndRun() throws IOException
    {

        this.socket = new Socket(ip, port);
        this.out = new PrintWriter(socket.getOutputStream(), true);
        String s;
        while(true)
        {
            if(massagesQueue.isEmpty())
                try {
                    wait();
                } catch (InterruptedException ie)
                {

                }
            s = massagesQueue.poll();if (s.equals("stop"))
            {
                break;
            }
            out.print(s);
            out.flush();
        }
        try {
            this.socket.close();
            this.out.close();
        }catch(IOException ioe)
        {
            Log.e("ConnectAndRun: ", "Failed to close socket");
        }

    }

    public void stopRun()
    {
        this.keepRun = false;
    }

}
