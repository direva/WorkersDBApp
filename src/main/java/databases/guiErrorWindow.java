package databases;

import javax.swing.*;

public class guiErrorWindow extends JFrame {
    private JTextArea errorLog;
    private JPanel panel1;

    public guiErrorWindow(String log) {
        this.getContentPane().add(panel1);
        errorLog.setText(log);
    }
}
