package databases;

import functions.Functions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiSearchWorker extends JFrame {
    private JPanel panel;
    private JTextField searchCriteria;
    private JButton startSearch;
    private JTextArea searchResult;

    String scriteria;

    Functions function = new Functions();

    public guiSearchWorker() {
        this.getContentPane().add(panel);
        this.startSearch.addActionListener(new guiStartSearchListener());
    }

    private class guiStartSearchListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            scriteria = searchCriteria.getText();
            searchResult.setText(function.getWorkerInfo(scriteria));

        }
    }
}
