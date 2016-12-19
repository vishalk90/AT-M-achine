package com.edu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vishalkulkarni on 12/17/16.
 */
public class AdminPage extends JPanel {

    JButton depositPanelButton;
    JButton withdrawPanleButton;
    JButton transferPanleButton;
    JButton logOffButton;
    JButton addNewUserPanelButton;
    JButton deleteUserPanelButton;
    JButton transferAmountButton;
    JButton depositAmountButton;
    JButton withdrawAmountButton;
    JButton addNewUserButton;
    JButton deleteUserButton;

    JPanel adminpanel;

    //boolean waitFlag = false;

    JLabel message;
    JTextField checkingBalanceTx;
    JTextField savingBalanceTx;
    JTextField transferToTx;
    JTextField amountToTransferTx;
    JTextField amountToDepositTx;
    JTextField amountToWithdrawTx;
    JTextField userNameTx;
    JTextField passwordTx;

    private StartMaster view;
    String saving = "";
    String checking = "";


    private final static int lengthX = 165;
    private final static int lengthY = 80;

    public AdminPage(StartMaster view, TransactionObject t) {

        super();
        this.view = (StartMaster) view;
        System.out.println("t: " + t.getName());
        //loginButton = new JButton("Login");
        adminpanel = new JPanel();

        depositPanelButton = new JButton("Deposit");
        withdrawPanleButton = new JButton("Withdraw");

        transferPanleButton = new JButton("Transfer");
        logOffButton = new JButton("Log Off");
        addNewUserPanelButton = new JButton("Add New User");
        deleteUserPanelButton = new JButton("Delete User");

        transferAmountButton = new JButton("Transfer");
        depositAmountButton = new JButton("Deposit");
        withdrawAmountButton = new JButton("Withdraw");
        addNewUserButton = new JButton("Add");
        deleteUserButton = new JButton("Delete");


        message = new JLabel();

        // splited getMessage to get the saving and checking values
        saving = t.getMessage().substring("saving=".length() + 1, t.getMessage().indexOf(","));
        checking = t.getMessage().substring(t.getMessage().indexOf(",") + "checking=".length(), t.getMessage().length());


        String[] accounts = {"Checking", "Saving"};
        JComboBox<String> transferFromComboBox = new JComboBox<String>(accounts);

        String[] userTypes = {"ADMIN", "USER"};
        JComboBox<String> userTypeComboBox = new JComboBox<String>(userTypes);

        JComboBox<String> userListComboBox = new JComboBox<String>();


        setLayout(null);
        JLabel heading = new JLabel("<html>" + "NJIT - ATM Machine -" + "<font color='red'>" + " [Admin]" + "</font></html>");
        JLabel subheading = new JLabel("Vishal Kulkarni");
        JLabel userName = new JLabel("<html>" + "Welcome - " + "<font color='green'>" + t.getName() + "</font></html>");

        JLabel checkingBalanceLabel = new JLabel("Checking Balance");
        JLabel savingBalanceLabel = new JLabel("Saving Balance");
        JLabel transferFromLabel = new JLabel("Transfer From");
        JLabel transferToLabel = new JLabel("Transfer To");
        JLabel TransferAmountLabel = new JLabel("Transfer Amount");
        JLabel DepositAmountLabel = new JLabel("Deposit Amount");
        JLabel WithdrawAmountLabel = new JLabel("Withdraw Amount");
        JLabel UserNameLabel = new JLabel("User Name");
        JLabel UserPasswordLabel = new JLabel("User Password");
        JLabel UserTypeLabel = new JLabel("User Type");
        JLabel selectUser = new JLabel("Select User");

        amountToTransferTx = new JTextField();
        amountToDepositTx = new JTextField();
        amountToWithdrawTx = new JTextField();

        checkingBalanceTx = new JTextField("checkingBalance");
        transferToTx = new JTextField("TransferTo");
        passwordTx = new JTextField("Password");
        //userTypeTx= new JTextField("UserType");
        userNameTx = new JTextField("UserName");
        savingBalanceTx = new JTextField("savingBalance");
        checkingBalanceTx.setText("$" + checking);
        savingBalanceTx.setText("$" + saving);
        checkingBalanceTx.setEditable(false);
        savingBalanceTx.setEditable(false);
        transferToTx.setText("   Saving");
        transferToTx.setVisible(false);
        transferToTx.setEditable(false);

        passwordTx.setText("");
        passwordTx.setVisible(false);
        UserPasswordLabel.setVisible(false);

        userNameTx.setText("");
        userNameTx.setVisible(false);
        UserNameLabel.setVisible(false);

        userTypeComboBox.setVisible(false);
        userListComboBox.setVisible(false);
        selectUser.setVisible(false);
        UserTypeLabel.setVisible(false);
        deleteUserButton.setVisible(false);

        checkingBalanceTx.setHorizontalAlignment(JTextField.RIGHT);
        savingBalanceTx.setHorizontalAlignment(JTextField.RIGHT);
        amountToTransferTx.setHorizontalAlignment(JTextField.RIGHT);
        amountToDepositTx.setHorizontalAlignment(JTextField.RIGHT);
        amountToWithdrawTx.setHorizontalAlignment(JTextField.RIGHT);

        transferFromComboBox.setBounds(lengthX, lengthY + 100 + 10, 150, 25);

        transferFromLabel.setBounds(lengthX - 120, lengthY + 100 + 10, 150, 20);
        transferToLabel.setBounds(lengthX - 120, lengthY + 125 + 10, 150, 20);
        transferToTx.setBounds(lengthX, lengthY + 125 + 10, 150, 20);
        passwordTx.setBounds(lengthX, lengthY + 125 + 10, 150, 20);
        UserPasswordLabel.setBounds(lengthX - 120, lengthY + 125 + 10, 150, 20);
        userTypeComboBox.setBounds(lengthX, lengthY + 150 + 10, 150, 25);
        userListComboBox.setBounds(lengthX, lengthY + 100, 150, 25);
        selectUser.setBounds(lengthX - 120, lengthY + 100, 150, 25);
        deleteUserButton.setBounds(lengthX, lengthY + 130, 150, 20);
        UserTypeLabel.setBounds(lengthX - 120, lengthY + 150 + 10, 150, 25);
        userNameTx.setBounds(lengthX, lengthY + 100 + 10, 150, 20);
        UserNameLabel.setBounds(lengthX - 120, lengthY + 100 + 10, 150, 20);

        amountToTransferTx.setBounds(lengthX, lengthY + 165, 150, 20);
        amountToDepositTx.setBounds(lengthX, lengthY + 115, 150, 20);
        amountToWithdrawTx.setBounds(lengthX, lengthY + 115, 150, 20);

        TransferAmountLabel.setBounds(lengthX - 120, lengthY + 165, 150, 20);
        DepositAmountLabel.setBounds(lengthX - 120, lengthY + 115, 150, 20);
        WithdrawAmountLabel.setBounds(lengthX - 120, lengthY + 115, 150, 20);
        transferAmountButton.setBounds(lengthX, lengthY + 190, 150, 20);
        depositAmountButton.setBounds(lengthX, lengthY + 140, 150, 20);
        withdrawAmountButton.setBounds(lengthX, lengthY + 140, 150, 20);
        addNewUserButton.setBounds(lengthX, lengthY + 190, 150, 20);
        //deleteUserButton.setBounds(lengthX, lengthY + 190, 150, 20);

        amountToTransferTx.setVisible(false);
        amountToDepositTx.setVisible(false);
        amountToWithdrawTx.setVisible(false);
        TransferAmountLabel.setVisible(false);
        DepositAmountLabel.setVisible(false);
        WithdrawAmountLabel.setVisible(false);
        transferAmountButton.setVisible(false);
        depositAmountButton.setVisible(false);
        withdrawAmountButton.setVisible(false);
        addNewUserButton.setVisible(false);
        deleteUserButton.setVisible(false);

        heading.setBounds(lengthX, lengthY - 50, 240, 20);
        heading.setHorizontalAlignment(SwingConstants.CENTER);


        depositPanelButton.setBounds(lengthX + 180, lengthY + 50 - 40, 220, 80);
        withdrawPanleButton.setBounds(lengthX + 180, lengthY + 135 - 40, 220, 80);
        transferPanleButton.setBounds(lengthX + 180, lengthY + 220 - 40, 220, 80);
        addNewUserPanelButton.setBounds(lengthX + 180, lengthY + 305 - 40, 220, 80);
        deleteUserPanelButton.setBounds(lengthX + 180, lengthY + 390 - 40, 220, 80);
        logOffButton.setBounds(lengthX + 300, lengthY - 50, 80, 40);
        userName.setBounds(lengthX - 120, lengthY, 150, 20);

        checkingBalanceLabel.setBounds(lengthX - 120, lengthY + 50, 150, 20);
        savingBalanceLabel.setBounds(lengthX - 120, lengthY + 75, 150, 20);
        checkingBalanceTx.setBounds(lengthX, lengthY + 50, 150, 20);
        savingBalanceTx.setBounds(lengthX, lengthY + 75, 150, 20);


        message.setBounds(lengthX + 5, lengthY, 200, 20);

        message.setVisible(false);
        transferFromLabel.setVisible(false);
        transferToLabel.setVisible(false);
        transferFromComboBox.setVisible(false);


        adminpanel.add(amountToTransferTx);
        adminpanel.add(amountToDepositTx);
        adminpanel.add(amountToWithdrawTx);
        adminpanel.add(TransferAmountLabel);
        adminpanel.add(DepositAmountLabel);
        adminpanel.add(WithdrawAmountLabel);
        adminpanel.add(transferAmountButton);
        adminpanel.add(depositAmountButton);
        adminpanel.add(withdrawAmountButton);

        adminpanel.add(checkingBalanceTx);
        adminpanel.add(savingBalanceTx);
        adminpanel.add(userName);
        adminpanel.add(checkingBalanceLabel);
        adminpanel.add(savingBalanceLabel);
        adminpanel.add(transferToTx);
        adminpanel.add(passwordTx);
        adminpanel.add(userTypeComboBox);
        adminpanel.add(userListComboBox);
        adminpanel.add(selectUser);
        adminpanel.add(deleteUserButton);
        adminpanel.add(userNameTx);
        adminpanel.add(UserNameLabel);
        adminpanel.add(UserPasswordLabel);
        adminpanel.add(UserTypeLabel);
        adminpanel.add(transferFromComboBox);
        adminpanel.add(transferFromLabel);
        adminpanel.add(transferToLabel);

        adminpanel.add(depositPanelButton);
        adminpanel.add(withdrawPanleButton);
        adminpanel.add(transferPanleButton);
        adminpanel.add(logOffButton);
        adminpanel.add(addNewUserButton);


        adminpanel.add(addNewUserPanelButton);
        adminpanel.add(deleteUserPanelButton);


        adminpanel.add(message);
        adminpanel.setSize(600, 600);
        adminpanel.setLayout(null);
        adminpanel.add(heading);
        //adminpanel.add(subheading);
        add(adminpanel);
        setVisible(true);


        transferFromComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (((JComboBox) e.getSource()).getSelectedItem().equals("Saving")) {
                    transferToTx.setText("   Checking");
                } else {
                    transferToTx.setText("   Saving");
                }
            }
        });


        logOffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                view.showLoginPanel();
            }
        });


        depositPanelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                savingBalanceTx.setText("$" + saving);
                checkingBalanceTx.setText("$" + checking);

                transferFromComboBox.setVisible(false);
                transferFromLabel.setVisible(false);
                transferToLabel.setVisible(false);
                transferToTx.setVisible(false);
                amountToTransferTx.setVisible(false);
                TransferAmountLabel.setVisible(false);
                transferAmountButton.setVisible(false);

                amountToDepositTx.setVisible(true);
                DepositAmountLabel.setVisible(true);
                depositAmountButton.setVisible(true);

                withdrawAmountButton.setVisible(false);
                amountToWithdrawTx.setVisible(false);
                WithdrawAmountLabel.setVisible(false);

                passwordTx.setVisible(false);
                userNameTx.setVisible(false);
                userTypeComboBox.setVisible(false);
                UserNameLabel.setVisible(false);
                UserPasswordLabel.setVisible(false);
                UserTypeLabel.setVisible(false);
                addNewUserButton.setVisible(false);

                savingBalanceLabel.setVisible(true);
                checkingBalanceLabel.setVisible(true);
                savingBalanceTx.setEditable(false);
                checkingBalanceTx.setEditable(false);

                userListComboBox.setVisible(false);
                deleteUserButton.setVisible(false);
                selectUser.setVisible(false);
                message.setVisible(false);
                amountToDepositTx.setText("0");
            }

        });
        depositAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (String.valueOf(amountToDepositTx.getText()).matches("[-+]?[0-9]*\\.?[0-9]+") ) {


                    message.setText(null);
                    message.setVisible(false);

                    float s = Float.parseFloat(savingBalanceTx.getText().substring(1, savingBalanceTx.getText().length()));
                    float c = Float.parseFloat(checkingBalanceTx.getText().substring(1, checkingBalanceTx.getText().length()));
                    float amount = Float.parseFloat(amountToDepositTx.getText());
                    //System.out.println("s c a "+ s +" "+c+" "+amount+"");

                    ContactServer con = new ContactServer();
                    TransactionObject transferObject = new TransactionObject();

                    //ContactServer con = new ContactServer();
                    c = c + amount;
                    checking = Float.toString(c);
                    saving = Float.toString(s);
                    transferObject.setName(t.getName());
                    transferObject.setMessage("saving=" + (s) + ",current=" + (c));
                    transferObject.setId("DEPOSIT");
                    TransactionObject tin = con.sendTransaction(transferObject);
                    if (tin.getId() != null) {

                        message.setText("<html><font color='green'>" + "Balance Updated!" + "</font></html>");
                        message.setVisible(true);
                        savingBalanceTx.setText("$" + Float.toString(s));
                        checkingBalanceTx.setText("$" + Float.toString(c));
                    } else {
                        message.setText("<html><font color='red'>" + "Transaction Not Possbile!" + "</font></html>");
                        message.setVisible(true);
                    }

                } else {
                    message.setText("<html><font color='red'>" + "Invalid amount entered!" + "</font></html>");
                    message.setVisible(true);
                }

            }
        });


        withdrawPanleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                savingBalanceTx.setText("$" + saving);
                checkingBalanceTx.setText("$" + checking);

                transferFromComboBox.setVisible(false);
                transferFromLabel.setVisible(false);
                transferToLabel.setVisible(false);
                transferToTx.setVisible(false);
                amountToTransferTx.setVisible(false);
                TransferAmountLabel.setVisible(false);
                transferAmountButton.setVisible(false);

                amountToDepositTx.setVisible(false);
                DepositAmountLabel.setVisible(false);
                depositAmountButton.setVisible(false);

                withdrawAmountButton.setVisible(true);
                amountToWithdrawTx.setVisible(true);
                WithdrawAmountLabel.setVisible(true);

                passwordTx.setVisible(false);
                userNameTx.setVisible(false);
                userTypeComboBox.setVisible(false);
                UserNameLabel.setVisible(false);
                UserPasswordLabel.setVisible(false);
                UserTypeLabel.setVisible(false);
                addNewUserButton.setVisible(false);

                savingBalanceLabel.setVisible(true);
                checkingBalanceLabel.setVisible(true);
                savingBalanceTx.setEditable(false);
                checkingBalanceTx.setEditable(false);

                userListComboBox.setVisible(false);
                deleteUserButton.setVisible(false);
                selectUser.setVisible(false);
                message.setVisible(false);
                amountToWithdrawTx.setText("0");
            }

        });
        withdrawAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (String.valueOf(amountToWithdrawTx.getText()).matches("[-+]?[0-9]*\\.?[0-9]+") ) {


                    message.setText(null);
                    message.setVisible(false);

                    float s = Float.parseFloat(savingBalanceTx.getText().substring(1, savingBalanceTx.getText().length()));
                    float c = Float.parseFloat(checkingBalanceTx.getText().substring(1, checkingBalanceTx.getText().length()));
                    float amount = Float.parseFloat(amountToWithdrawTx.getText());
                    //System.out.println("s c a "+ s +" "+c+" "+amount+"");

                    ContactServer con = new ContactServer();
                    TransactionObject transferObject = new TransactionObject();

                    if (c >= amount) {
                        c = c - amount;
                        //ContactServer con = new ContactServer();
                        checking = Float.toString(c);
                        saving = Float.toString(s);

                        transferObject.setName(t.getName());
                        transferObject.setMessage("saving=" + (s) + ",current=" + (c));
                        transferObject.setId("WITHDRAW");
                        TransactionObject tin = con.sendTransaction(transferObject);
                        if (tin.getId() != null) {

                            message.setText("<html><font color='green'>" + "Balance Updated!" + "</font></html>");
                            message.setVisible(true);
                            savingBalanceTx.setText("$" + Float.toString(s));
                            checkingBalanceTx.setText("$" + Float.toString(c));
                        } else {
                            message.setText("<html><font color='red'>" + "Transaction Not Possbile!" + "</font></html>");
                            message.setVisible(true);
                        }
                    } else {
                        message.setText("<html><font color='red'>" + "Transaction Not Possbile!" + "</font></html>");
                        message.setVisible(true);
                    }
                } else {
                    message.setText("<html><font color='red'>" + "Invalid Amount Entered!" + "</font></html>");
                    message.setVisible(true);
                }

            }
        });


        transferPanleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                savingBalanceTx.setText("$" + saving);
                checkingBalanceTx.setText("$" + checking);

                transferFromComboBox.setVisible(true);
                transferFromLabel.setVisible(true);
                transferToLabel.setVisible(true);
                transferToTx.setVisible(true);
                amountToTransferTx.setVisible(true);
                TransferAmountLabel.setVisible(true);
                transferAmountButton.setVisible(true);

                amountToDepositTx.setVisible(false);
                DepositAmountLabel.setVisible(false);
                depositAmountButton.setVisible(false);

                withdrawAmountButton.setVisible(false);
                amountToWithdrawTx.setVisible(false);
                WithdrawAmountLabel.setVisible(false);

                passwordTx.setVisible(false);
                userNameTx.setVisible(false);
                userTypeComboBox.setVisible(false);
                UserNameLabel.setVisible(false);
                UserPasswordLabel.setVisible(false);
                UserTypeLabel.setVisible(false);
                addNewUserButton.setVisible(false);

                savingBalanceLabel.setVisible(true);
                checkingBalanceLabel.setVisible(true);
                savingBalanceTx.setEditable(false);
                checkingBalanceTx.setEditable(false);

                userListComboBox.setVisible(false);
                deleteUserButton.setVisible(false);
                selectUser.setVisible(false);
                message.setVisible(false);
                amountToTransferTx.setText("0");
            }
        });
        transferAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (String.valueOf(amountToTransferTx.getText()).matches("[-+]?[0-9]*\\.?[0-9]+")) {


                    message.setText(null);
                    message.setVisible(false);

                    float s = Float.parseFloat(savingBalanceTx.getText().substring(1, savingBalanceTx.getText().length()));
                    float c = Float.parseFloat(checkingBalanceTx.getText().substring(1, checkingBalanceTx.getText().length()));
                    float amount = Float.parseFloat(amountToTransferTx.getText());
                    //System.out.println("s c a "+ s +" "+c+" "+amount+"");

                    ContactServer con = new ContactServer();
                    TransactionObject transferObject = new TransactionObject();
                    if (transferFromComboBox.getSelectedItem().equals("Checking") && amount <= c) {
                        s = s + amount;
                        c = c - amount;
                        //ContactServer con = new ContactServer();
                        checking = Float.toString(c);
                        saving = Float.toString(s);

                        transferObject.setName(t.getName());
                        transferObject.setMessage("saving=" + (s) + ",current=" + (c));
                        transferObject.setId("TRANSFER");
                        TransactionObject tin = con.sendTransaction(transferObject);
                        if (tin.getId() != null) {

                            message.setText("<html><font color='green'>" + "Balance Updated!" + "</font></html>");
                            message.setVisible(true);
                            savingBalanceTx.setText("$" + Float.toString(s));
                            checkingBalanceTx.setText("$" + Float.toString(c));
                        } else {
                            message.setText("<html><font color='red'>" + "Transaction Not Possbile!" + "</font></html>");
                            message.setVisible(true);
                        }
                    } else if (transferFromComboBox.getSelectedItem().equals("Saving") && amount <= s) {
                        s = s - amount;
                        c = c + amount;

                        checking = Float.toString(c);
                        saving = Float.toString(s);

                        //ContactServer con = new ContactServer();
                        transferObject.setName(t.getName());
                        transferObject.setMessage("saving=" + s + " ,current=" + c);
                        transferObject.setId("TRANSFER");
                        TransactionObject tin = con.sendTransaction(transferObject);
                        if (tin.getId() != null) {
                            message.setText("<html><font color='green'>" + "Balance Updated!" + "</font></html>");
                            message.setVisible(true);
                            savingBalanceTx.setText("$" + Float.toString(s));
                            checkingBalanceTx.setText("$" + Float.toString(c));
                        } else {
                            message.setText("<html><font color='red'>" + "Transaction Not Possbile!" + "</font></html>");
                            message.setVisible(true);
                        }
                    } else {
                        message.setText("<html><font color='red'>" + "Transaction Not Possbile!" + "</font></html>");
                        message.setVisible(true);
                    }
                } else {
                    message.setText("<html><font color='red'>" + "Invalid Amount Entered!" + "</font></html>");
                    message.setVisible(true);
                }
            }
        });


        addNewUserPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferFromComboBox.setVisible(false);
                transferFromLabel.setVisible(false);
                transferToLabel.setVisible(false);
                transferToTx.setVisible(false);
                amountToTransferTx.setVisible(false);
                TransferAmountLabel.setVisible(false);
                transferAmountButton.setVisible(false);

                amountToDepositTx.setVisible(false);
                DepositAmountLabel.setVisible(false);
                depositAmountButton.setVisible(false);

                withdrawAmountButton.setVisible(false);
                amountToWithdrawTx.setVisible(false);
                WithdrawAmountLabel.setVisible(false);

                checkingBalanceTx.setText("0");
                savingBalanceTx.setText("0");
                passwordTx.setText("");
                userNameTx.setText("");

                passwordTx.setVisible(true);
                userNameTx.setVisible(true);
                userTypeComboBox.setVisible(true);
                UserNameLabel.setVisible(true);
                UserPasswordLabel.setVisible(true);
                UserTypeLabel.setVisible(true);
                savingBalanceLabel.setVisible(true);
                checkingBalanceLabel.setVisible(true);
                savingBalanceTx.setEditable(true);
                checkingBalanceTx.setEditable(true);
                addNewUserButton.setVisible(true);

                userListComboBox.setVisible(false);
                deleteUserButton.setVisible(false);
                selectUser.setVisible(false);
                message.setVisible(false);


            }
        });

        addNewUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(String.valueOf(savingBalanceTx.getText()));
                if (String.valueOf(savingBalanceTx.getText()).matches("[-+]?[0-9]*\\.?[0-9]+") && String.valueOf(checkingBalanceTx.getText()).matches("[-+]?[0-9]*\\.?[0-9]+")) {


                    ContactServer con = new ContactServer();
                    TransactionObject transferObject = new TransactionObject();
                    transferObject.setName(userNameTx.getText());
                    transferObject.setNum(passwordTx.getText());
                    transferObject.setMessage("saving=" + savingBalanceTx.getText() + " ,current=" + checkingBalanceTx.getText());
                    transferObject.setId("CREATE");
                    transferObject.setType(userTypeComboBox.getSelectedItem().toString());
                    TransactionObject tin = con.sendTransaction(transferObject);
                    if (tin.getId() != null && tin.getId().equals("1")) {
                        message.setText("<html><font color='red'>" + tin.getName() + "</font><font color='green'>" + " Added!" + "</font></html>");
                        message.setVisible(true);
                    } else {
                        System.out.println(tin.getMessage());
                        message.setText("<html><font color='red'>" + "Not valid input..try again!" + "</font></html>");
                        message.setVisible(true);
                    }

                } else {
                    message.setText("<html><font color='red'>" + "Not valid input..try again!" + "</font></html>");
                    message.setVisible(true);
                }

            }
        });


        deleteUserPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferFromComboBox.setVisible(false);
                transferFromLabel.setVisible(false);
                transferToLabel.setVisible(false);
                transferToTx.setVisible(false);
                amountToTransferTx.setVisible(false);
                TransferAmountLabel.setVisible(false);
                transferAmountButton.setVisible(false);

                amountToDepositTx.setVisible(false);
                DepositAmountLabel.setVisible(false);
                depositAmountButton.setVisible(false);

                withdrawAmountButton.setVisible(false);
                amountToWithdrawTx.setVisible(false);
                WithdrawAmountLabel.setVisible(false);

                passwordTx.setVisible(false);
                userNameTx.setVisible(false);
                userTypeComboBox.setVisible(false);
                UserNameLabel.setVisible(false);
                UserPasswordLabel.setVisible(false);
                UserTypeLabel.setVisible(false);
                savingBalanceLabel.setVisible(true);
                checkingBalanceLabel.setVisible(true);
                savingBalanceTx.setText("$" + saving);
                checkingBalanceTx.setText("$" + checking);
                savingBalanceTx.setEditable(false);
                checkingBalanceTx.setEditable(false);
                addNewUserButton.setVisible(false);

                userListComboBox.setVisible(true);
                userListComboBox.setEditable(false);
                try {
                    if (userListComboBox.getItemAt(0) == null) {
                        userListComboBox.removeAllItems();
                        for (String accountUser : findUsers()) {
                            userListComboBox.addItem(accountUser);

                        }
                    } else {
                        userListComboBox.removeAllItems();
                        for (String accountUser : findUsers()) {
                            userListComboBox.addItem(accountUser);

                        }

                    }

                    //userListComboBox.removeAllItems();
//                    for (String accountUser : findUsers()) {
//                        userListComboBox.addItem(accountUser);
//
//                    }
                } catch (Exception e1) {
                    System.out.println(e1);
                }

                deleteUserButton.setVisible(true);
                selectUser.setVisible(true);

            }
        });

        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedUserName = userListComboBox.getSelectedItem().toString();
                System.out.print("selected User:" + selectedUserName);
                if (!(t.getName().equals(selectedUserName))) {
                    ContactServer con = new ContactServer();
                    TransactionObject transferObject = new TransactionObject();
                    transferObject.setName(selectedUserName);
                    transferObject.setId("DELETE");

                    TransactionObject tin = con.sendTransaction(transferObject);

                    if (tin.getId() != null && tin.getId().equals("1")) {
                        message.setText("<html><font color='red'>" + selectedUserName + "</font><font color='green'>" + " deleted!" + "</font></html>");
                        message.setVisible(true);
                        try {
                            userListComboBox.removeAllItems();
                            for (String accountUser : findUsers()) {
                                userListComboBox.addItem(accountUser);

                            }
                        } catch (Exception e1) {
                            System.out.println(e1);
                        }


                    } else {
                        message.setText("<html><font color='red'>" + "Action Failed!" + "</font></html>");
                        message.setVisible(true);
                    }
                } else {
                    message.setText("<html><font color='red'>" + "Select Different User!" + "</font></html>");
                    message.setVisible(true);
                }


            }
        });

        userListComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedUserName = "";
                try {
                    selectedUserName = ((JComboBox) e.getSource()).getSelectedItem().toString();
                } catch (Exception e1) {
                    System.out.println(e1);
                }
//                finally {
                //((JComboBox) e.getSource()).setSelectedItem(selectedUserName);
//                }


                ContactServer con = new ContactServer();
                TransactionObject transferObject = new TransactionObject();
                transferObject.setName(selectedUserName);
                transferObject.setId("BALANCE");

                TransactionObject tin = con.sendTransaction(transferObject);

                if (tin.getId() != null && tin.getId().equals("Login Successful!!!")) {

                    Float savings = new Float(tin.getMessage().substring("saving=".length() + 1, tin.getMessage().indexOf(",")));
                    Float currents = new Float(tin.getMessage().substring(tin.getMessage().indexOf(",") + "current=".length() + 1, tin.getMessage().length()));

                    savingBalanceTx.setText("$" + savings.toString());
                    checkingBalanceTx.setText("$" + currents.toString());


                    message.setText("<html><font color='red'>" + selectedUserName + "</font><font color='green'>" + " selected!" + "</font></html>");
                    message.setVisible(true);

                } else {
                    //heading.setText(t.getName());
                    message.setText("<html><font color='red'>" + "Action Failed!" + "</font></html>");
                    message.setVisible(true);
                }


            }
        });


    }

    public List<String> findUsers() {
        ContactServer con = new ContactServer();
        TransactionObject request = new TransactionObject();
        request.setId("FETCH_USERS");

        TransactionObject response = con.sendTransaction(request);
        List<String> users = new ArrayList<String>();

        if (response != null && response.getMessage() != null && response.getMessage().length() > 0) {
            String temp = response.getMessage();
            temp = temp.substring(1, temp.length()) + ",";
            users = Arrays.asList(temp.split(","));
        }

        return users;
    }


}
