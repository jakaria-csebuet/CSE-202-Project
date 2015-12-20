package sample;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

class GameClient extends Frame implements Runnable
{
    Socket soc;
    String sendTo;
    String LoginName;
    Thread t=null;
    DataOutputStream dout;
    DataInputStream din;
    String msgFromServer;
    GameClient(String LoginName, String chatwith) throws Exception
    {
        super(LoginName);
        this.LoginName=LoginName;
        sendTo=chatwith;
        soc=new Socket("127.0.0.1",5217);

        din=new DataInputStream(soc.getInputStream());
        dout=new DataOutputStream(soc.getOutputStream());
        dout.writeUTF(LoginName);

        t=new Thread(this);
        t.start();

    }

    public void sendGrid(int pos)
    {
        try {
                dout.writeUTF(sendTo + " "  + "DATA" + " " + pos );
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    public int myGrid(){
        int i = (int)msgFromServer.charAt(0)+(int)msgFromServer.charAt(1) - 528 ;
        return i ;
    }

    public boolean opponentGrid(){
        if (msgFromServer =="true") return true ;
        return false ;
    }

    public void close()
    {
        try
        {
                dout.writeUTF(LoginName + " LOGOUT");
                System.exit(1);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }

    }

    public void run()
    {
        while(true)
        {
            try
            {

                msgFromServer = din.readUTF();


            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}