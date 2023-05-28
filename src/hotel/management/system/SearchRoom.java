package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchRoom extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private Choice bedTypeChoice;
    private boolean searchPerformed = false;

    SearchRoom() {
        setBounds(530, 200, 700 ,500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel searchRoomLabel = new JLabel("Search Room");
        searchRoomLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        searchRoomLabel.setBounds(250, 11, 186, 31);
        contentPane.add(searchRoomLabel);

        JLabel roomBedTypeLabel = new JLabel("Room Bed Type");
        roomBedTypeLabel.setBounds(50, 73, 96, 14);
        contentPane.add(roomBedTypeLabel);

        JLabel roomNumberLabel = new JLabel("Room Number");
        roomNumberLabel.setBounds(23, 162, 96, 14);
        contentPane.add(roomNumberLabel);

        JLabel availableLabel = new JLabel("Availability");
        availableLabel.setBounds(175, 162, 120, 14);
        contentPane.add(availableLabel);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(458, 162, 46, 14);
        contentPane.add(priceLabel);

        JLabel bedTypeLabel = new JLabel("Bed Type");
        bedTypeLabel.setBounds(580, 162, 96, 14);
        contentPane.add(bedTypeLabel);

        JLabel cleanLabel = new JLabel("Clean Status");
        cleanLabel.setBounds(306, 162, 96, 14);
        contentPane.add(cleanLabel);

        JCheckBox availableOnly = new JCheckBox("Only Display Available");
        availableOnly.setBounds(400, 69, 205, 23);
        contentPane.add(availableOnly);

        bedTypeChoice = new Choice();
        bedTypeChoice.add("Single Bed");
        bedTypeChoice.add("Double Bed");
        bedTypeChoice.setBounds(153, 70, 120, 20);
        contentPane.add(bedTypeChoice);

        JButton searchBtn = new JButton("Search");
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from room where BED_TYPE = '"+bedTypeChoice.getSelectedItem()+"'";
                String sql2 = "select * from room where availability = 'Available' and BED_TYPE = '"+bedTypeChoice.getSelectedItem()+"'";

                try {
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery(sql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    if(availableOnly.isSelected()) {
                        rs = conn.s.executeQuery(sql2);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                }catch (SQLException ss) {
                    ss.printStackTrace();
                }
            }
        });
        searchBtn.setBounds(200, 400, 120, 30);
        searchBtn.setBackground(Color.BLACK);
        searchBtn.setForeground(Color.white);
        contentPane.add(searchBtn);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        backBtn.setBounds(380, 400, 120, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        contentPane.add(backBtn);

        table = new JTable();
        table.setBounds(0, 187, 700, 300);
        contentPane.add(table);


        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}