package hotel.management.system;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame {
    private JPanel contentPane;
    private JLabel idLabel, numberLabel, nameLabel, genderLabel, countryLabel, roomLabel, checkinstatusLabel, depositLabel;
    private JTable table;

    CustomerInfo() {
        setBounds(510, 240, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton exitbutton = new JButton("Back");
        exitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        exitbutton.setBounds(450, 510, 120, 30);
        exitbutton.setBackground(Color.WHITE);
        exitbutton.setForeground(Color.BLACK);
        contentPane.add(exitbutton);

        JButton loadDataButton = new JButton("Load Data");
        loadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn conn = new Conn();

                    ResultSet rs = conn.s.executeQuery("select * from kustomer");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        loadDataButton.setBounds(300, 510, 120, 30);
        loadDataButton.setBackground(Color.BLACK);
        loadDataButton.setForeground(Color.white);
        contentPane.add(loadDataButton);

        idLabel = new JLabel("ID");
        idLabel.setBounds(31, 11, 46, 14);
        contentPane.add(idLabel);

        numberLabel = new JLabel("ID Number");
        numberLabel.setBounds(150, 11, 60, 14);
        contentPane.add(numberLabel);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(270, 11, 65, 14);
        contentPane.add(nameLabel);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(360, 11, 46, 14);
        contentPane.add(genderLabel);

        table = new JTable();
        table.setBounds(0, 40, 900, 450);
        contentPane.add(table);

        countryLabel = new JLabel("Country");
        countryLabel.setBounds(480, 11, 46, 14);
        contentPane.add(countryLabel);

        roomLabel = new JLabel("Room Number");
        roomLabel.setBounds(580, 11, 90, 14);
        contentPane.add(roomLabel);

        checkinstatusLabel = new JLabel("Check-in Time");
        checkinstatusLabel.setBounds(680, 11, 100, 14);
        contentPane.add(checkinstatusLabel);

        depositLabel = new JLabel("Deposit");
        depositLabel.setBounds(800, 11, 100, 14);
        contentPane.add(depositLabel);

        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
    }
}
