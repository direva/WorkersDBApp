package databases;


import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){

        guiLogin gui = new guiLogin();

        //Упаковываем все элементы с формы
        gui.pack();
        //Задаем размер окна
        gui.setSize(new Dimension(800, 500));
        //Отображаем окно
        gui.setVisible(true);

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
