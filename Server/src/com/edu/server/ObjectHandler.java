package com.edu.server;

import com.edu.TransactionObject;
import oracle.jdbc.driver.OracleDriver;

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
        System.out.println("recched here!");
    }

    public void run() {
        try {
            //System.out.println("reached here!"+incoming);
            ObjectOutputStream OutputStream = new ObjectOutputStream(incoming.getOutputStream());
            ObjectInputStream InputStream = new ObjectInputStream(incoming.getInputStream());

            TransactionObject request = null;
            TransactionObject response = null;
            while ((request = (TransactionObject) InputStream.readObject()) != null) {
                System.out.println("Message received: " + request.getId());
                switch (request.getId()) {
                    case "BALANCE":
                        response = fetchAccount(request, true);
                        break;
                    case "CREATE":
                        response = createAccount(request);
                        break;
                    case "DELETE":
                        deleteAccount(request);
                        break;
                    case "DEPOSIT":
                        updateBalanceAccount(request);
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
            System.out.println(e);
        }

    }





    private static void updateBalanceAccount(TransactionObject request) {

        try {
            Connection conn = createConnection();
            Statement stmt = conn.createStatement();
            String user_name = request.getName();

            System.out.println("Message: " + request.getMessage());

            Float saving = new Float(request.getMessage().substring("saving=".length(), request.getMessage().indexOf(",")));
            Float current = new Float(request.getMessage().substring(request.getMessage().indexOf(",") + "current=".length()+1 , request.getMessage().length()));


            stmt.executeUpdate("UPDATE ATM_MACHINE_TABLE SET SAVING_BALANCE=" + saving + ", current_BALANCE=" + current
                    + " WHERE USER_NAME='" + user_name + "'");

            System.out.println("Balance Updated");
            request.setMessage("Balance Updated!");

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    private static void deleteAccount(TransactionObject request) {
        try {
            Connection conn = createConnection();
            Statement stmt = conn.createStatement();
            String user_name = request.getName();
            stmt.executeUpdate("DELETE ATM_MACHINE_TABLE WHERE USER_NAME='" + user_name + "'");
            System.out.println("DELETED DATA");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    private static TransactionObject createAccount(TransactionObject request) {
        try {
            Connection conn = createConnection();
            Statement stmt = conn.createStatement();
            System.out.println("Message: " + request.getMessage());

            Float saving = new Float(request.getMessage().substring("saving=".length(), request.getMessage().indexOf(",")));
            Float current = new Float(request.getMessage().substring(request.getMessage().indexOf(",") + "current=".length()+1 , request.getMessage().length()));
            int numberOfRowsUpdated = 0;
            System.out.println("Saving: " + saving);
            System.out.println("Checking: " + current);
            System.out.println("User Name: " + request.getName());
            System.out.println("User Password: " + request.getNum());
            System.out.println("User Type: " + request.getType());
            System.out.println("INSERT INTO ATM_MACHINE_TABLE " + "VALUES(" + "'" + request.getName() + "','" + request.getNum() + "','"
                    + saving + "','" + current+"','" + request.getType() + "')");
            numberOfRowsUpdated = stmt.executeUpdate("INSERT INTO ATM_MACHINE_TABLE " + "VALUES(" + "'" + request.getName() + "','" + request.getNum() + "','"
                    + saving + "','" + current+"','" + request.getType() + "')");
            request.setId(Integer.toString(numberOfRowsUpdated));

            System.out.println("Data inserted - "+numberOfRowsUpdated);

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return request;
        }
        return request;
    }


    private static TransactionObject fetchAccount(TransactionObject request, boolean authorized) {
        if (request != null) {

            try {
                Connection conn = createConnection();
                Statement stmt = conn.createStatement();
                String user_name = request.getName();
                String password = request.getNum();

                ResultSet rs = null;

                if (authorized) {
                    rs = stmt.executeQuery("SELECT * from ATM_MACHINE_TABLE WHERE USER_NAME='" + user_name + "'");
                } else {
                    rs = stmt.executeQuery("SELECT * from ATM_MACHINE_TABLE WHERE USER_PASSWORD='" + password
                            + "' AND USER_NAME='" + user_name + "'");
                }

                String balance = "saving=0:current=0";
                request.setName(null);
                request.setId(null);
                request.setType(null);

                while (rs.next()) {
                    String savingBalance = (new Float(rs.getFloat("SAVING_BALANCE"))).toString();
                    String currentBalance = (new Float(rs.getFloat("CURRENT_BALANCE"))).toString();
                    request.setName(rs.getString("USER_NAME"));
                    request.setNum(rs.getString("USER_PASSWORD"));
                    request.setType(rs.getString("STATUS"));
                    balance = " saving=" + savingBalance + " ,current=" + currentBalance;

                }
                if(request.getType()!=null)
                    request.setId("Login Successful!!!");

                request.setMessage(balance);

                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return request;

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
                rs = stmt.executeQuery("SELECT USER_NAME from ATM_MACHINE_TABLE WHERE STATUS='ACTIVE'");
            } else {
                rs = stmt.executeQuery("SELECT USER_NAME from ATM_MACHINE_TABLE WHERE STATUS!='ACTIVE'");
            }

            while (rs.next()) {
                String username = rs.getString("USER_NAME");
                System.out.println("USER_NAME: " + username);
                transactionObject.setMessage(transactionObject.getMessage() + "," + username);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactionObject;
    }
}
