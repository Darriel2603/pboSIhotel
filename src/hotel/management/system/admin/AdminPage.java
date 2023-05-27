package hotel.management.system.admin;

import hotel.management.system.Dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame {

    public AdminPage(){
        getContentPane();
        setLayout(null);

        JButton btnEmployee = new JButton("Add Employee");
        btnEmployee.setBounds(100,50,200,60);
        btnEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
            }
        });
        add(btnEmployee);

        JButton btnDriver = new JButton("Add Driver");
        btnDriver.setBounds(100,150,200,60);
        add(btnDriver);

        btnDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDrivers();
            }
        });

        JButton btnRoom = new JButton("Add Rooms");
        btnRoom.setBounds(100,250,200,60);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddRoom();
            }
        });
        add(btnRoom);

        setBounds(760,440,400,400);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminPage();
    }
}
