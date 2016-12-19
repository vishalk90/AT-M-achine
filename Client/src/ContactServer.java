import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by vishalkulkarni on 11/30/16.
 */
public class ContactServer {
    //static String hostName = "afs2.njit.edu";
    static String hostName = "afsaccess4.njit.edu";
    //static String hostName = "localhost";
    static int portNumber = 28195;
    private static Socket echoSocket = null;
    private static ObjectOutputStream outputStream = null;
    private static ObjectInputStream inputStream = null;
    public static TransactionObject sendTransaction(TransactionObject transactionObject) {
        TransactionObject response = null;
        try {
            if (echoSocket == null) {
                echoSocket = new Socket();
                SocketAddress endpoint = new InetSocketAddress(hostName, portNumber);
                echoSocket.connect(endpoint, 1000 * 5);
                outputStream = new ObjectOutputStream(echoSocket.getOutputStream());
                inputStream = new ObjectInputStream(echoSocket.getInputStream());
            }

            System.out.println(transactionObject.getId());
            outputStream.writeObject(transactionObject);

            if ((response = (TransactionObject) inputStream.readObject()) != null) {
                //System.out.println("Received:=" + response.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return response;
    }

}
