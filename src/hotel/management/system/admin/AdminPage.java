package hotel.management.system.admin;

import hotel.management.system.Dashboard;

import javax.swing.*;
import java.awt.*;

public class AdminPage extends JFrame {

    public AdminPage(){
        getContentPane();
        setLayout(null);

        JButton btnEmployee = new JButton("Employee");
        btnEmployee.setBounds(100,50,200,60);
        btnEmployee.setBackground(Color.red);
        add(btnEmployee);

        JButton btnDriver = new JButton("Driver");
        btnDriver.setBounds(100,150,200,60);
        add(btnDriver);

        JButton btnRoom = new JButton("Rooms");
        btnRoom.setBounds(100,250,200,60);
        add(btnRoom);

        setBounds(500,200,400,400);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminPage();
    }
}
