package com.example.testapp.model;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;


public class ThreadPool implements Runnable{
    private Queue<String> q;
    private int threadsNum;
    private Boolean keepRun;
    private InetAddress ip;
    private int port;

    public ThreadPool(int num, InetAddress ip, int port)
    {
        this.q = new LinkedList<>();
        this.threadsNum = num;
        this.keepRun = true;

        this.port = port;
        this.ip = ip;
    }

    public synchronized void addString(String s)
    {
        String string = "set /flight/" + s + "\r\n";
        q.add(string);
        notify();
    }

    @Override
    public void run()
    {
        PrintWriter out;
        InetAddress ip;
        try {

            Socket fg = new Socket(this.ip, this.port);
            System.out.println("connect to server");
            out  = new PrintWriter(fg.getOutputStream(), true);


            while(keepRun)
            {
                if(q.isEmpty())
                {
                    wait();
                }
                out.print(q.poll());
                out.flush();
            }

        } catch(Exception e)
        {
            ;
        }

        //return 1;
    }

    public void stopRun()
    {
        this.keepRun = false;
    }

}
