package hotel.management.system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import net.proteanit.sql.*;



public class Room extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JLabel availabilityLabel, cleanStatusLabel, priceLabel, typeLabel, roomnumberLabel, idLabel;

    Room() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(410, 240, 1100, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/hotel/management/system/assets/hotelroom2.jpg"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon roomImage = new ImageIcon(scaledImage);
        JLabel roomImageLabel = new JLabel(roomImage);
        roomImageLabel.setBounds(500, 0, 600, 600);
        add(roomImageLabel);

        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        contentPane.add(table);

        JButton loadDataBtn = new JButton("Load Data");
        loadDataBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    ResultSet rs =  c.s.executeQuery("select * from room");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        loadDataBtn.setBounds(100, 470, 120, 30);
        loadDataBtn.setBackground(Color.BLACK);
        loadDataBtn.setForeground(Color.white);
        contentPane.add(loadDataBtn);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });

        backButton.setBounds(290, 470, 120, 30);
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        contentPane.add(backButton);

        availabilityLabel = new JLabel("Availability");
        availabilityLabel.setBounds(119, 15, 69, 14);
        contentPane.add(availabilityLabel);

        cleanStatusLabel = new JLabel("Clean Status");
        cleanStatusLabel.setBounds(216, 15, 76, 14);
        contentPane.add(cleanStatusLabel);

        priceLabel = new JLabel("Price");
        priceLabel.setBounds(330, 15, 76, 14);
        contentPane.add(priceLabel);

        typeLabel = new JLabel("Bed Type");
        typeLabel.setBounds(417, 15, 76, 14);
        contentPane.add(typeLabel);

        roomnumberLabel = new JLabel("Room Number");
        roomnumberLabel.setBounds(12, 15, 90, 14);
        contentPane.add(roomnumberLabel);

        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
    }

}
