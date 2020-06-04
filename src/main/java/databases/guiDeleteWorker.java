package databases;

import functions.Functions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiDeleteWorker extends JFrame {
    private JTextField workerName;
    private JButton deleteWorker;
    private JPanel panel;

    Functions function = new Functions();
    String name;

    public guiDeleteWorker() {
        this.getContentPane().add(panel);
        this.deleteWorker.addActionListener(new deleteWorkerListener());
    }

    private class deleteWorkerListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            name = workerName.getText();
            function.DeleteWorkerByName(name);
        }
    }
}
