package com.edu.server;

import oracle.jdbc.OracleDriver;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.*;

/**
 * Created by vishalkulkarni on 11/29/16.
 */
public class ObjectHandler extends Thread {

    private Socket incoming;

    private static Connection connection = null;

    public ObjectHandler(Socket in) {
        incoming = in;
    }

    public void run() {
        try {
            ObjectOutputStream OutputStream = new ObjectOutputStream(incoming.getOutputStream());
            ObjectInputStream InputStream = new ObjectInputStream(incoming.getInputStream());

            TransactionObject request = null;
            TransactionObject response = null;
            while ((request = (TransactionObject) InputStream.readObject()) != null) {
                System.out.println("Message received: " + request.getId());
                switch (request.getId()) {
                    case "FETCH_ACTIVE_USERS":
                        response = fetchUsers(true);
                        break;
                    case "FETCH_FROZEN_USERS":
                        response = fetchUsers(false);
                        break;
                    case "BALANCE":
                        response = fetchAccount(request, true);
                        break;
                    case "CREATE":
                        createAccount(request);
                        break;
                    case "DELETE":
                        deleteAccount(request);
                        break;
                    case "DEPOSIT":
                        updateBalanceAccount(request);
                        break;
                    case "REACTIVATE":
                        reActivateAccount(request);
                        break;
                    case "FREEZE":
                        freezeAccount(request);
                        break;
                    case "TRANSFER":
                        updateBalanceAccount(request);
                        break;
                    case "WITHDRAW":
                        updateBalanceAccount(request);
                        break;
                    case "LOGIN":
                        response = fetchAccount(request, false);
                        break;
                }
                System.out.println(response.getId());
                OutputStream.writeObject(response);
            }
        }
        catch (Exception e){

        }

    }

    private static void freezeAccount(TransactionObject request) {


    }





    private static void reActivateAccount(TransactionObject request) {


    }





    private static void updateBalanceAccount(TransactionObject request) {



    }






    private static void deleteAccount(TransactionObject request) {


    }





    private static void createAccount(TransactionObject request) {

    }





    private static TransactionObject fetchAccount(TransactionObject request, boolean b) {
        TransactionObject transactionObject = new TransactionObject();


        return transactionObject;
    }






    private static Connection createConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@prophet.njit.edu:1521:course";
        String ucid = "vvk27"; // my ucid
        String dbpassword = "7oU3XNmFT"; // my Oracle password
        try {
            DriverManager.registerDriver(new OracleDriver());
        } catch (Exception e) {
            System.err.println("Unable to load driver.");
            e.printStackTrace();
        }
        System.out.println("Driver loaded.");
        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(url, ucid, dbpassword);

        return connection;
    }

    private static TransactionObject fetchUsers(boolean liveUser) {
        TransactionObject transactionObject = new TransactionObject();
        try {
            Connection conn = createConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = null;
            transactionObject.setMessage("");

            if (liveUser) {
                rs = stmt.executeQuery("SELECT USERNAME from ATM_TRANSACTION WHERE STATUS='ACTIVE'");
            } else {
                rs = stmt.executeQuery("SELECT USERNAME from ATM_TRANSACTION WHERE STATUS!='ACTIVE'");
            }

            while (rs.next()) {
                String username = rs.getString("USERNAME");
                System.out.println("USERNAME: " + username);
                transactionObject.setMessage(transactionObject.getMessage() + "," + username);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactionObject;
    }
}
