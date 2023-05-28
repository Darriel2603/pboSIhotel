package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception() {
        getContentPane();
        setLayout(null);

        JButton btnCustomer = new JButton("New Customer");
        btnCustomer.setBounds(100, 30, 200, 60);
        btnCustomer.setFont(new Font("Inter", Font.BOLD, 17));
        btnCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewCustomer();
            }
        });
        add(btnCustomer);

        JButton btnRoom = new JButton("Rooms");
        btnRoom.setBounds(100, 110, 200, 60);
        btnRoom.setFont(new Font("Inter", Font.BOLD, 17));
        add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton btnEmployee = new JButton("Employee Info");
        btnEmployee.setBounds(100, 190, 200, 60);
        btnEmployee.setFont(new Font("Inter", Font.BOLD, 17));
        btnEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee();
            }
        });
        add(btnEmployee);


        JButton btnCustomerInfo = new JButton("Customer Info");
        btnCustomerInfo.setBounds(100, 270, 200, 60);
        btnCustomerInfo.setFont(new Font("Inter", Font.BOLD, 17));
        btnCustomerInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerInfo();
            }
        });
        add(btnCustomerInfo);

        JButton btnUpdateStatus = new JButton("Update Status");
        btnUpdateStatus.setBounds(100, 350, 200, 60);
        btnUpdateStatus.setFont(new Font("Inter", Font.BOLD, 17));
        btnUpdateStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateCheck();
            }
        });
        add(btnUpdateStatus);

        JButton btnUpdateRoom = new JButton("Update Room Status");
        btnUpdateRoom.setBounds(100, 430, 200, 60);
        btnUpdateRoom.setFont(new Font("Inter", Font.BOLD, 17));
        btnUpdateRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateRoom();
            }
        });
        add(btnUpdateRoom);

        JButton btnPickupService = new JButton("Pickup Service");
        btnPickupService.setBounds(100, 510, 200, 60);
        btnPickupService.setFont(new Font("Inter", Font.BOLD, 17));
        btnPickupService.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PickUp();
            }
        });
        add(btnPickupService);

        JButton btnSearchRoom = new JButton("Search Room");
        btnSearchRoom.setBounds(100, 590, 200, 60);
        btnSearchRoom.setFont(new Font("Inter", Font.BOLD, 17));
        btnSearchRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();
            }
        });
        add(btnSearchRoom);

        JButton checkOutBtn = new JButton("Checkout");
        checkOutBtn.setBounds(100, 670, 200, 60);
        checkOutBtn.setFont(new Font("Inter", Font.BOLD, 17));
        checkOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CheckOut();
            }
        });
        add(checkOutBtn);

        JButton logOutBtn = new JButton("Logout");
        logOutBtn.setBounds(100, 750, 200, 60);
        logOutBtn.setFont(new Font("Inter", Font.BOLD, 17));
        logOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
            }
        });
        add(logOutBtn);

        setBounds(760, 100, 400, 880);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
