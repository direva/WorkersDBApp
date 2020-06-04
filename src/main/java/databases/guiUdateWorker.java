package databases;

import functions.Functions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiUdateWorker extends JFrame{
    private JPanel panel;
    private JTextField updateCriteria;
    private JTextField newName;
    private JTextField newProject;
    private JTextField newPosition;
    private JButton startUpdate;

    Functions function = new Functions();

    public guiUdateWorker() {
        this.getContentPane().add(panel);
        this.startUpdate.addActionListener(new guiStartUpdateListener());
    }

    private class guiStartUpdateListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            function.UpdateWorkerByName(
                    updateCriteria.getText(),
                    newName.getText(),
                    newProject.getText(),
                    newPosition.getText());
        }
    }

}
