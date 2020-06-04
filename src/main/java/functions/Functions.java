package functions;

import databases.ErrorParser;
import databases.guiErrorWindow;
import databases.guiLogin;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Functions {

    final String URL = "jdbc:postgresql://localhost:5432/postgres";

    Connection connect = null;
    CallableStatement cDB = null;
    PreparedStatement ps = null;

    ErrorParser parser = new ErrorParser();

    String username = guiLogin.getRememberUser();
    String pwd = guiLogin.getRememberPwd();

    public void RegDriver() {

        try {
            //Регистрация драйвера
            Driver driver = new org.postgresql.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        boolean comparator = false;
        if(o == this)
            comparator = true;
        if(o == null || o.getClass() != this.getClass())
            comparator = false;
        return comparator;
    }

    public void workWithException(SQLException e) {
        String result = parser.parse(e.getMessage());
        guiErrorWindow gui = new guiErrorWindow(result);
        gui.pack();
        gui.setSize(new Dimension(300, 100));
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public void CreateDB(){

        try {
            connect = DriverManager.getConnection(URL, username, pwd);
            cDB = connect.prepareCall("{call createWorkersDB()}");
            cDB.execute();
        } catch(SQLException e){
            workWithException(e);
        } finally {
            try{
                cDB.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void DeleteDB(){

        try {
            connect = DriverManager.getConnection(URL, username, pwd);
            cDB = connect.prepareCall("{call deleteWorkersDB()}");
            cDB.execute();
        } catch(SQLException e){
            workWithException(e);
        } finally {
            try{
                cDB.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void AddNewWorker(String name, String project, String position){

        try {
            if(name.equals("")) name = null;
            connect = DriverManager.getConnection(URL, username, pwd);
            cDB = connect.prepareCall("{call AddNewWorker(?, ?, ?)}");
            cDB.setString(1, name);
            cDB.setString(2, project);
            cDB.setString(3, position);
            cDB.execute();
        } catch(SQLException e){
            workWithException(e);
        } finally {
            try{
                cDB.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void DeleteWorkerByName(String name) {

        try {
            connect = DriverManager.getConnection(URL, username, pwd);
            cDB = connect.prepareCall("{call DeleteWorkerByName(?)}");
            cDB.setString(1, name);
            cDB.execute();
        } catch(SQLException e){
            workWithException(e);
        } finally {
            try{
                cDB.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void UpdateWorkerByName(String name, String newName, String newProj, String newPos) {

        try {
            connect = DriverManager.getConnection(URL, username, pwd);
            cDB = connect.prepareCall("{call UpdateWorkerByName(?, ?, ?, ?)}");
            cDB.setString(1, name);
            cDB.setString(2, newName);
            cDB.setString(3, newProj);
            cDB.setString(4, newPos);
            cDB.execute();
        } catch(SQLException e){
            workWithException(e);
        } finally {
            try{
                cDB.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void CleanDB() {

        try {
            connect = DriverManager.getConnection(URL, username, pwd);
            cDB = connect.prepareCall("{call CleanDB()}");
            cDB.execute();
        } catch(SQLException e){
            workWithException(e);
        } finally {
            try{
                cDB.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String getWorkerInfo(String name) {
        String result = null;
        try {
            connect = DriverManager.getConnection(URL, username, pwd);
            ps = connect.prepareStatement(
                    "select * from FindWorkerByName(?) as t(n varchar, project varchar, pos varchar)");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            String wname;
            String pr;
            String pos;
            while(rs.next()) {
                wname=rs.getString(1);
                pr=rs.getString(2);
                pos=rs.getString(3);
                result = "ФИО: " + wname + "\n" +
                         "Проект: " + pr + "\n" +
                         "Должность: " + pos;
            }
        } catch(SQLException e){
            result = e.getMessage();
            result = parser.parse(result);
        } finally {
            try{
                ps.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void CreateNewUser(String type, String name, String pass) {
        if(type.equals(""))
            type = null;
        if(name.equals(""))
            name = null;
        if(pass.equals(""))
            pass = null;
        try {
            connect = DriverManager.getConnection(URL, "postgres", "postgresqlpassword");
            cDB = connect.prepareCall("{call CreateNewUser(?, ?, ?)}");
            cDB.setString(1, type);
            cDB.setString(2, name);
            cDB.setString(3, pass);
            cDB.execute();
        } catch(SQLException e){
            //workWithException(e);
            e.printStackTrace();
        } finally {
            try{
                cDB.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
