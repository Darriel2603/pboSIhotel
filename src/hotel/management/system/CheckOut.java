package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

public class CheckOut extends JFrame {

    Choice customerIDChoose;
    JLabel roomLabel, checkintimeLabel, checkouttimeLabel;
    JButton checkOutBtn, cancelBtn, checkBtn;
    CheckOut() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Checkout");
        heading.setBounds(100, 20, 100, 30);
        heading.setFont(new Font("Inter", Font.PLAIN, 20));
        add(heading);

        JLabel idLabel = new JLabel("Customer ID");
        idLabel.setBounds(30, 80, 100, 30);
        add(idLabel);

        customerIDChoose = new Choice();
        customerIDChoose.setBounds(150, 80, 150, 25);
        add(customerIDChoose);


        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from kustomer");
            while (rs.next()) {
                customerIDChoose.add(rs.getString("id_number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkBtn = new JButton("Check");
        checkBtn.setBounds(320, 80, 100, 25);
        checkBtn.setBackground(Color.WHITE);
        checkBtn.setForeground(Color.BLACK);
        add(checkBtn);
        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select * from kustomer");
                    while(rs.next()) {
                        roomLabel.setText(rs.getString("ROOM"));
                        checkintimeLabel.setText(rs.getString("CHECKIN_TIME"));
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JLabel roomNumLabel = new JLabel("Room Number");
        roomNumLabel.setBounds(30, 130, 100, 30);
        add(roomNumLabel);

        roomLabel = new JLabel();
        roomLabel.setBounds(150, 130, 100, 30);
        add(roomLabel);

        JLabel checkinLabel = new JLabel("Checkin Time");
        checkinLabel.setBounds(30, 180, 100, 30);
        add(checkinLabel);

        checkintimeLabel = new JLabel();
        checkintimeLabel.setBounds(150, 180, 170, 30);
        add(checkintimeLabel);

        JLabel checkoutLabel = new JLabel("Checkout Time");
        checkoutLabel.setBounds(30, 230, 170, 30);
        add(checkoutLabel);

        Date date = new Date();
        checkouttimeLabel = new JLabel("" + date);
        checkouttimeLabel.setBounds(150, 230, 170, 30);
        add(checkouttimeLabel);

        checkOutBtn = new JButton("Checkout");
        checkOutBtn.setBackground(Color.BLACK);
        checkOutBtn.setForeground(Color.WHITE);
        checkOutBtn.setBounds(30, 280, 120, 30);
        add(checkOutBtn);
        checkOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query1 = "delete from kustomer where id_number = '" + customerIDChoose.getSelectedItem() + "'";

                String query2 = "update room set AVAILABILITY = 'Available' where ROOMNUMBER = '"+roomLabel.getText()+"'";


                try {
                    Conn conn = new Conn();
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Checkout Successfully");
                    setVisible(false);
                } catch (Exception c) {
                    c.printStackTrace();
                }
            }
        });

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setBounds(170, 280, 120, 30);
        add(cancelBtn);


        setBounds(300, 200, 800, 400);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
