package com.edu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vishalkulkarni on 12/17/16.
 */
public class UserPage extends JPanel {

    JButton depositPanelButton;
    JButton withdrawPanleButton;
    JButton transferPanleButton;
    JButton logOffButton;
    //JButton addNewUserPanelButton;
    //JButton deleteUserPanelButton;
    JButton transferAmountButton;
    JButton depositAmountButton;
    JButton withdrawAmountButton;
    //JButton addNewUserButton;
    //JButton deleteUserButton;

    JPanel userPanel;

    JLabel message;
    JTextField checkingBalanceTx;
    JTextField savingBalanceTx;
    JTextField transferToTx;
    JTextField amountToTransferTx;
    JTextField amountToDepositTx;
    JTextField amountToWithdrawTx;

    private StartMaster view;
    String saving = "";
    String checking = "";


    private final static int lengthX = 165;
    private final static int lengthY = 80;

    public UserPage(StartMaster view, TransactionObject t) {
        super();
        this.view = (StartMaster) view;
        System.out.println("t: " + t.getName());
        //loginButton = new JButton("Login");
        userPanel = new JPanel();

        depositPanelButton = new JButton("Deposit");
        withdrawPanleButton = new JButton("Withdraw");

        transferPanleButton = new JButton("Transfer");
        logOffButton = new JButton("Log Off");
        //addNewUserPanelButton = new JButton("Add New User");
        //deleteUserPanelButton = new JButton("Delete User");

        transferAmountButton = new JButton("Transfer");
        depositAmountButton = new JButton("Deposit");
        withdrawAmountButton = new JButton("Withdraw");
        //addNewUserButton = new JButton("Add");
        //deleteUserButton = new JButton("Delete");


        message = new JLabel();

        // splited getMessage to get the saving and checking values
        saving = t.getMessage().substring("saving=".length() + 1, t.getMessage().indexOf(","));
        checking = t.getMessage().substring(t.getMessage().indexOf(",") + "checking=".length(), t.getMessage().length());


        String[] choices = {"Checking", "Saving"};
        JComboBox<String> transferFromComboBox = new JComboBox<String>(choices);


        setLayout(null);
        JLabel heading = new JLabel("NJIT - ATM Machine");
        JLabel subheading = new JLabel("Vishal Kulkarni");
        JLabel userName = new JLabel("<html>" + "Welcome - " + "<font color='green'>" + t.getName() + "</font></html>");

        JLabel checkingBalanceLabel = new JLabel("Checking Balance");
        JLabel savingBalanceLabel = new JLabel("Saving Balance");
        JLabel transferFromLabel = new JLabel("Transfer From");
        JLabel transferToLabel = new JLabel("Transfer To");
        JLabel TransferAmountLabel = new JLabel("Transfer Amount");
        JLabel DepositAmountLabel = new JLabel("Deposit Amount");
        JLabel WithdrawAmountLabel = new JLabel("Withdraw Amount");

        amountToTransferTx = new JTextField();
        amountToDepositTx = new JTextField();
        amountToWithdrawTx = new JTextField();

        checkingBalanceTx = new JTextField("checkingBalance");
        transferToTx = new JTextField("TransferTo");
        savingBalanceTx = new JTextField("savingBalance");
        checkingBalanceTx.setText("$" + checking);
        savingBalanceTx.setText("$" + saving);
        checkingBalanceTx.setEditable(false);
        savingBalanceTx.setEditable(false);
        transferToTx.setText("   Saving");
        transferToTx.setVisible(false);
        transferToTx.setEditable(false);

        checkingBalanceTx.setHorizontalAlignment(JTextField.RIGHT);
        savingBalanceTx.setHorizontalAlignment(JTextField.RIGHT);
        amountToTransferTx.setHorizontalAlignment(JTextField.RIGHT);
        amountToDepositTx.setHorizontalAlignment(JTextField.RIGHT);
        amountToWithdrawTx.setHorizontalAlignment(JTextField.RIGHT);

        transferFromComboBox.setBounds(lengthX, lengthY + 100 + 10, 150, 25);
        transferFromLabel.setBounds(lengthX - 120, lengthY + 100 + 10, 150, 20);
        transferToLabel.setBounds(lengthX - 120, lengthY + 125 + 10, 150, 20);
        transferToTx.setBounds(lengthX, lengthY + 125 + 10, 150, 20);

        amountToTransferTx.setBounds(lengthX, lengthY + 165, 150, 20);
        amountToDepositTx.setBounds(lengthX, lengthY + 115, 150, 20);
        amountToWithdrawTx.setBounds(lengthX, lengthY + 115, 150, 20);

        TransferAmountLabel.setBounds(lengthX - 120, lengthY + 165, 150, 20);
        DepositAmountLabel.setBounds(lengthX - 120, lengthY + 115, 150, 20);
        WithdrawAmountLabel.setBounds(lengthX - 120, lengthY + 115, 150, 20);
        transferAmountButton.setBounds(lengthX, lengthY + 190, 150, 20);
        depositAmountButton.setBounds(lengthX, lengthY + 140, 150, 20);
        withdrawAmountButton.setBounds(lengthX, lengthY + 140, 150, 20);

        amountToTransferTx.setVisible(false);
        amountToDepositTx.setVisible(false);
        amountToWithdrawTx.setVisible(false);
        TransferAmountLabel.setVisible(false);
        DepositAmountLabel.setVisible(false);
        WithdrawAmountLabel.setVisible(false);
        transferAmountButton.setVisible(false);
        depositAmountButton.setVisible(false);
        withdrawAmountButton.setVisible(false);

        heading.setBounds(lengthX, lengthY - 50, 240, 20);
        heading.setHorizontalAlignment(SwingConstants.CENTER);


        depositPanelButton.setBounds(lengthX + 180, lengthY + 50 - 40, 220, 80);
        withdrawPanleButton.setBounds(lengthX + 180, lengthY + 135 - 40, 220, 80);
        transferPanleButton.setBounds(lengthX + 180, lengthY + 220 - 40, 220, 80);
        //addNewUserPanelButton.setBounds(lengthX + 180, lengthY + 305 - 40, 220, 80);
        //deleteUserPanelButton.setBounds(lengthX + 180, lengthY + 390 - 40, 220, 80);
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


        userPanel.add(amountToTransferTx);
        userPanel.add(amountToDepositTx);
        userPanel.add(amountToWithdrawTx);
        userPanel.add(TransferAmountLabel);
        userPanel.add(DepositAmountLabel);
        userPanel.add(WithdrawAmountLabel);
        userPanel.add(transferAmountButton);
        userPanel.add(depositAmountButton);
        userPanel.add(withdrawAmountButton);

        userPanel.add(checkingBalanceTx);
        userPanel.add(savingBalanceTx);
        userPanel.add(userName);
        userPanel.add(checkingBalanceLabel);
        userPanel.add(savingBalanceLabel);
        userPanel.add(transferToTx);
        userPanel.add(transferFromComboBox);
        userPanel.add(transferFromLabel);
        userPanel.add(transferToLabel);

        userPanel.add(depositPanelButton);
        userPanel.add(withdrawPanleButton);
        userPanel.add(transferPanleButton);
        userPanel.add(logOffButton);


        //userPanel.add(addNewUserPanelButton);
        //userPanel.add(deleteUserPanelButton);


        userPanel.add(message);
        userPanel.setSize(600, 600);
        userPanel.setLayout(null);
        userPanel.add(heading);
        //userPanel.add(subheading);
        add(userPanel);
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
            }

        });
                depositAmountButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
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

                    }
                });
//                System.out.println("loginButton" + userNameTextField.getText() + userPasswordTextField.getText());
//                ContactServer con = new ContactServer();
//                TransactionObject T_out = new TransactionObject();
//                T_out.setId("LOGIN");
//                T_out.setType("ACTIVE");
//                T_out.setName(userNameTextField.getText());
//                T_out.setNum(userPasswordTextField.getText());
//                T_out.setMessage("alive");
//                TransactionObject T_in = (TransactionObject) con.sendTransaction(T_out);
//                if (T_in.getId() != null) {
//                    System.out.println("I'm here now " + T_in.getMessage());
//                    message.setText(T_in.getMessage());
//                    message.setVisible(true);
//                } else {
//                    message.setText("Login Failed!!!");
//                    message.setVisible(true);
//                }



        withdrawPanleButton.addActionListener(new ActionListener() {
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

                withdrawAmountButton.setVisible(true);
                amountToWithdrawTx.setVisible(true);
                WithdrawAmountLabel.setVisible(true);
            }

        });
                withdrawAmountButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        message.setText(null);
                        message.setVisible(false);

                        float s = Float.parseFloat(savingBalanceTx.getText().substring(1, savingBalanceTx.getText().length()));
                        float c = Float.parseFloat(checkingBalanceTx.getText().substring(1, checkingBalanceTx.getText().length()));
                        float amount = Float.parseFloat(amountToWithdrawTx.getText());
                        //System.out.println("s c a "+ s +" "+c+" "+amount+"");

                        ContactServer con = new ContactServer();
                        TransactionObject transferObject = new TransactionObject();

                        if(c >= amount){
                            c = c - amount;
                            //ContactServer con = new ContactServer();

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
                        }
                        else
                        {
                            message.setText("<html><font color='red'>" + "Transaction Not Possbile!" + "</font></html>");
                            message.setVisible(true);
                        }


                    }
                });

                //controller.attemptLogin(userNameTextField.getText(), userPasswordTextField.getText());
//                System.out.println("userPasswordTextField" + userNameTextField.getText() + userPasswordTextField.getText());
//                ContactServer con = new ContactServer();
//                TransactionObject a = new TransactionObject();
//                a.setId("LOGIN");
//                a.setType("ACTIVE");
//                a.setName(userNameTextField.getText());
//                a.setNum(userPasswordTextField.getText());
//                a.setMessage("alive");
//                if (con.sendTransaction(a).getId() != null) {
//                    System.out.println("I'm here now " + con.sendTransaction(a).getMessage());
//                }


        transferPanleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

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
            }
        });
                transferAmountButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
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

                    }
                });





    }


}
