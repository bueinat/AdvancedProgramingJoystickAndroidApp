package com.example.testapp.viewModel;
import com.example.testapp.model.ConcreteModel;

import java.net.InetAddress;


public class ConcreteViewModel implements AbstractViewModel{

    private double throttle;


    @Override
    public void setThrottle(double new_throttle) {
        this.throttle = new_throttle;
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
