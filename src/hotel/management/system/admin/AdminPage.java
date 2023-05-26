package hotel.management.system.admin;

import hotel.management.system.Dashboard;

import javax.swing.*;
import java.awt.*;

public class AdminPage extends JFrame {

    AdminPage(){
        getContentPane().setBackground(Color.WHITE);

        JButton btnEmployee = new JButton("Employee");
        btnEmployee.setBounds(200,50,100,100);
        add(btnEmployee);

        JButton btnDriver = new JButton("Driver");
        btnDriver.setBounds(200,180,100,100);
        add(btnDriver);

        JButton btnRoom = new JButton("Rooms");
        btnRoom.setBounds(200,300,100,100);
        add(btnRoom);

        setBounds(500,200,500,500);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminPage();
    }
}
