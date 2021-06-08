package Model;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ConcreteModel implements AbstractModel{

    private InetAddress port;
    private int ip;
    public int aileronVal;

    public void func()
    {
        try {
            Socket fg = new Socket(port, ip);
            PrintWriter out  = new PrintWriter(fg.getOutputStream(), true);

            out.print("set /controls/flight/aileron" + aileronVal + "\r\n");
        } catch (Exception e)
        {
            ;
        }
    }
}
