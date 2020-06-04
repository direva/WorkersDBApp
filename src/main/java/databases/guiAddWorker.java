package databases;

import functions.Functions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;


public class guiAddWorker extends JFrame {
    private JPanel panel;
    private JTextField nameField;
    private JTextField positionField;
    private JTextField projectField;
    private JButton addButton;

    String name;
    String position;
    String project;

    Functions function = new Functions();

    public guiAddWorker() {
        this.getContentPane().add(panel);
        this.addButton.addActionListener(new addBtnListener());
    }

    private class addBtnListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            name = nameField.getText();
            position = positionField.getText();
            project = projectField.getText();

            function.AddNewWorker(name, project, position);
        }
    }
}


