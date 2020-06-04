package databases;

import functions.Functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class guiLogin extends JFrame {
    private JPanel panel1;
    private JTextField loginField;
    private JButton connectToDB;
    private JButton createUser;
    private JPasswordField pwdField;

    final String URL = "jdbc:postgresql://localhost:5432/postgres";

    Connection connect = null;

    static String rememberUser;
    static String rememberPwd;

    Functions function = new Functions();

    public guiLogin() {
        this.getContentPane().add(panel1);
        function.RegDriver();
        this.connectToDB.addActionListener(new guiConnectToDBListener());
        this.createUser.addActionListener(new guiCreateUserListener());
    }

    public static String getRememberUser() {
        return rememberUser;
    }

    public static String getRememberPwd() {
        return rememberPwd;
    }

    private class guiConnectToDBListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            String login = loginField.getText();
            String pwd = pwdField.getText();

            try {
                connect = DriverManager.getConnection(URL, login, pwd);
                if(connect.isClosed())
                    throw new SQLException("Неверное сочетание логина и пароля");
                else {
                    connect.close();
                    rememberUser = login;
                    rememberPwd = pwd;
                    openMenu();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void openMenu() {
            guiLab5 gui = new guiLab5();

            gui.pack();
            gui.setSize(new Dimension(800, 500));
            gui.setVisible(true);
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    private class guiCreateUserListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            guiCreateUser gui = new guiCreateUser();

            gui.pack();
            gui.setSize(new Dimension(800, 500));
            gui.setVisible(true);
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
    }

}
