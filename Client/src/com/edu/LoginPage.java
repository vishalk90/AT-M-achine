package com.edu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vishalkulkarni on 12/10/16.
 */
public class LoginPage extends JPanel {


    JButton loginButton;
    JPanel loginpanel;
    JTextField userNameTextField;
    JTextField userPasswordTextField;
    JButton newUser;
    JLabel username;


    JLabel pin;
    JLabel message;
      TransactionObject T_out;
      TransactionObject T_in;

    private StartMaster view;

    private final static int lengthX = 165;
    private final static int lengthY = 80;

    public LoginPage(StartMaster view) {
        super();
        this.view = view;
        loginButton = new JButton("Login");
        loginpanel = new JPanel();
        userNameTextField = new JTextField(15);;//Utils.createUppercaseTextField(15);
        userPasswordTextField = new JPasswordField(15);
        //newUser = new JButton("New User?");
        username = new JLabel("Username");
        pin = new JLabel("Password");
        message = new JLabel();

        setLayout(null);
        JLabel heading = new JLabel("NJIT - ATM Machine : CS602");
        JLabel subheading = new JLabel("Developed by: VISHAL KULKARNI");

        heading.setBounds(lengthX, lengthY + 55, 240, 20);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        subheading.setBounds(lengthX, lengthY + 335, 240, 20);
        subheading.setHorizontalAlignment(SwingConstants.CENTER);

        userNameTextField.setBounds(lengthX + 74, lengthY + 128, 150, 20);
        userPasswordTextField.setBounds(lengthX + 74, lengthY + 158, 150, 20);
        loginButton.setBounds(lengthX+120, lengthY + 212, 105, 35);
        username.setBounds(lengthX, lengthY + 128, 80, 20);
        pin.setBounds(lengthX, lengthY + 158, 80, 20);
        message.setBounds(lengthX+90, lengthY+ 185, 200, 20);
        message.setVisible(false);

        loginpanel.add(loginButton);
        loginpanel.add(userNameTextField);
        loginpanel.add(userPasswordTextField);
        //loginpanel.add(newUser);
        loginpanel.add(username);
        loginpanel.add(pin);
        loginpanel.add(message);
        loginpanel.setSize(500, 500);
        loginpanel.setLayout(null);
        loginpanel.add(heading);
        loginpanel.add(subheading);

        userNameTextField.setText("");
        userPasswordTextField.setText("");

        add(loginpanel);
        setVisible(true);

        userNameTextField.setRequestFocusEnabled(true);
        userNameTextField.requestFocusInWindow();

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //controller.attemptLogin(userNameTextField.getText(), userPasswordTextField.getText());
                System.out.println("loginButton"+userNameTextField.getText()+userPasswordTextField.getText());
                ContactServer con = new ContactServer();
                T_out = new TransactionObject();
                T_out.setId("LOGIN");
                T_out.setName(userNameTextField.getText());
                T_out.setNum(userPasswordTextField.getText());
                T_in= (TransactionObject) con.sendTransaction(T_out);
                System.out.println(T_in.getId());
                if(T_in.getId()!=null)
                {
                    //System.out.println("t: "+StartMaster.t.getId());
                    message.setVisible(false);
                    if(T_in.getType().equals("ADMIN"))
                    {

                        System.out.println(T_in.getMessage());
                        view.showAdminPage(T_in);
                    }
                    else if(T_in.getType().equals("USER"))
                    {
                        System.out.println(T_in.getMessage());
                        view.showUserPage(T_in);
                    }

                }
                else
                {
                    StartMaster.t = null;
                    System.out.println("Login Failed!!!");
                    message.setText("<html><font color='red'>" + "Login Failed!!!" + "</font></html>");
                    message.setVisible(true);
                }

            }

        });

        userPasswordTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //controller.attemptLogin(userNameTextField.getText(), userPasswordTextField.getText());
                System.out.println("loginButton"+userNameTextField.getText()+userPasswordTextField.getText());
                ContactServer con = new ContactServer();
                T_out = new TransactionObject();
                T_out.setId("LOGIN");
                T_out.setName(userNameTextField.getText());
                T_out.setNum(userPasswordTextField.getText());
                T_in= (TransactionObject) con.sendTransaction(T_out);
                System.out.println(T_in.getId());
                if(T_in.getId()!=null)
                {
                    message.setVisible(false);
                    if(T_in.getType().equals("ADMIN"))
                    {
                        System.out.println(T_in.getMessage());
                        view.showAdminPage(T_in);
                    }
                    else if(T_in.getType().equals("USER"))
                    {
                        System.out.println(T_in.getMessage());
                        view.showUserPage(T_in);
                    }

                }
                else
                {
                    System.out.println("Login Failed!!!");
                    message.setText("<html><font color='red'>" + "Login Failed!!!" + "</font></html>");
                    message.setVisible(true);
                }
            }

        });

    }
    
    
}
