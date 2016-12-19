package com.edu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vishalkulkarni on 12/10/16.
 */


public class StartMaster {

    private JFrame frame;
    private JPanel cards = new JPanel(new CardLayout());
    static TransactionObject t = new TransactionObject();
    //private ATMMainController controller = new ATMMainController(this);

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        StartMaster window = new StartMaster();
        window.frame.setVisible(true);
        window.showLoginPanel();
    }

    /**
     * Create the application.
     */
    public StartMaster() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - 300, dim.height / 2 - 300);

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the panel that contains the "cards".
        cards.add(new Panel());
        cards.add(new LoginPage(this), "LOGIN_PANEL");


        //cards.add(new UserPage(), "USER_PANEL");

        frame.add(cards, BorderLayout.CENTER);
        frame.setResizable(false);
    }

    public void showLoginPanel() {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "LOGIN_PANEL");
    }

    public void showAdminPage(TransactionObject t_in) {
        cards.add(new AdminPage(this, t_in), "ADMIN_PANEL");

        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "ADMIN_PANEL");
    }
    public void showUserPage(TransactionObject t_in) {
        cards.add(new UserPage(this, t_in), "USER_PANEL");

        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "USER_PANEL");
    }
}
