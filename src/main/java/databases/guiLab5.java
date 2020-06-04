package databases;

import functions.Functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiLab5 extends JFrame {
    private JPanel panel;
    private JButton createDB;
    private JButton deleteDB;
    private JButton addNewWorkerToDB;
    private JButton deleteWorkerFromDB;
    private JButton cleanDB;
    private JButton searchWorker;
    private JButton updateInfo;

    Functions function = new Functions();

    

    public guiLab5() {
        this.getContentPane().add(panel);
        this.createDB.addActionListener(new guiCreateDBListener());
        this.deleteDB.addActionListener(new guiDeleteDBListener());
        this.addNewWorkerToDB.addActionListener(new guiAddWorkerListener());
        this.deleteWorkerFromDB.addActionListener(new guiDeleteWorkerListener());
        this.cleanDB.addActionListener(new guiCleanDBListener());
        this.searchWorker.addActionListener(new guiSearchWorkerListener());
        this.updateInfo.addActionListener(new guiUpdateInfoListener());
    }

    private class guiCreateDBListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            function.CreateDB();
        }
    }

    private class guiDeleteDBListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            function.DeleteDB();
        }
    }

    private class guiAddWorkerListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            guiAddWorker addForm = new guiAddWorker();

            addForm.pack();
            addForm.setSize(new Dimension(400, 250));
            addForm.setVisible(true);
            addForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
    }

    private class guiDeleteWorkerListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            guiDeleteWorker deleteForm = new guiDeleteWorker();

            deleteForm.pack();
            deleteForm.setSize(new Dimension(400, 250));
            deleteForm.setVisible(true);
            deleteForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
    }

    private class guiSearchWorkerListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            guiSearchWorker search = new guiSearchWorker();

            search.pack();
            search.setSize(new Dimension(400, 250));
            search.setVisible(true);
            search.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
    }

    private class guiUpdateInfoListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            guiUdateWorker update = new guiUdateWorker();

            update.pack();
            update.setSize(new Dimension(600, 400));
            update.setVisible(true);
            update.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
    }

    private class guiCleanDBListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            function.CleanDB();
        }
    }
}
