import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by vishalkulkarni on 11/29/16.
 * Run this class to start Server.
 */
public class StartServer {
    public static void main(String [] args){
        try {
            ServerSocket myServerSocket = new ServerSocket(28195);
            while(true) {
                Socket incoming = myServerSocket.accept();
                new ObjectHandler(incoming).start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
