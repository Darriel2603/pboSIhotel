package hotel.management.system;

import javax.swing.*;
import java.awt.*;

public class Reception extends JFrame {

    Reception() {
        getContentPane();
        setLayout(null);

        JButton btnCustomer = new JButton("New Customer");
        btnCustomer.setBounds(100, 50, 200, 60);
        add(btnCustomer);

        JButton btnRoom = new JButton("Rooms");
        btnRoom.setBounds(100, 130, 200, 60);
        add(btnRoom);

        JButton btnDepartment = new JButton("Department");
        btnDepartment.setBounds(100, 210, 200, 60);
        add(btnDepartment);

        JButton btnEmployee = new JButton("Employee Info");
        btnEmployee.setBounds(100, 290, 200, 60);
        add(btnEmployee);

        JButton btnCustomerInfo = new JButton("Customer Info");
        btnCustomerInfo.setBounds(100, 370, 200, 60);
        add(btnCustomerInfo);

        JButton btnCheckout = new JButton("Checkout");
        btnCheckout.setBounds(100, 450, 200, 60);
        add(btnCheckout);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(100, 530, 200, 60);
        add(btnLogout);

        setBounds(500, 200, 400, 700);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
    new Reception();
    }
}
