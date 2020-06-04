package databases;

import functions.Functions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiCreateUser extends JFrame{
    private JPanel panel;
    private JTextField newLogin;
    private JPasswordField newPass;
    private JButton create;
    private JRadioButton adminGroupRadioButton;
    private JRadioButton userGroupRadioButton;

    String userType;
    String login;
    String pass;

    Functions function = new Functions();

    public guiCreateUser() {
        this.getContentPane().add(panel);
        this.create.addActionListener(new guiCreateUserListener());
    }

    private class guiCreateUserListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            userType = "";
            if(adminGroupRadioButton.isSelected())
                userType = "adminGroup";
            if(userGroupRadioButton.isSelected())
                userType = "userGroup";
            login = newLogin.getText();
            pass = newPass.getText();

            function.CreateNewUser(userType, login, pass);
        }
    }
}
