package hotel.management.system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame {
    private JPanel contentPane;
    private JTextField availabilityField, cleanStatusField, roomNumField;
    Choice idCustomChoice;
    JButton checkBtn, updateBtn, cancelBtn;

    UpdateRoom() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(760, 315, 400, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel heading = new JLabel("Update Room Status");
        heading.setFont(new Font("Inter", Font.BOLD, 25));
        heading.setBounds(30, 20, 250, 30);
        contentPane.add(heading);

        JLabel idLabel = new JLabel("Customer ID");
        idLabel.setBounds(30, 80, 100, 20);
        contentPane.add(idLabel);

        idCustomChoice = new Choice();
        idCustomChoice.setBounds(200, 80, 150, 25);
        contentPane.add(idCustomChoice);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from kustomer");
            while (rs.next()) {
                idCustomChoice.add(rs.getString("id_number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel roomnumberLabel = new JLabel("Room Number");
        roomnumberLabel.setBounds(30, 130, 100, 20);
        contentPane.add(roomnumberLabel);

        roomNumField = new JTextField();
        roomNumField.setBounds(200, 130, 150, 25);
        contentPane.add(roomNumField);

        JLabel availableLabel = new JLabel("Availability");
        availableLabel.setBounds(30, 180, 100, 20);
        contentPane.add(availableLabel);

        availabilityField = new JTextField();
        availabilityField.setBounds(200, 180, 150, 25);
        contentPane.add(availabilityField);

        JLabel cleanStatusLabel = new JLabel("Cleaning Status");
        cleanStatusLabel.setBounds(30, 230, 100, 20);
        contentPane.add(cleanStatusLabel);

        cleanStatusField = new JTextField();
        cleanStatusField.setBounds(200, 230, 150, 25);
        contentPane.add(cleanStatusField);

        checkBtn = new JButton("Check");
        checkBtn.setBackground(Color.BLACK);
        checkBtn.setForeground(Color.WHITE);
        checkBtn.setBounds(30, 300, 100, 30);
        contentPane.add(checkBtn);
        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idCustomer = idCustomChoice.getSelectedItem();
                    Conn conn = new Conn();
                    ResultSet rs1 = conn.s.executeQuery("select * from kustomer where id_number = " + idCustomer);

                    while (rs1.next()) {
                        roomNumField.setText(rs1.getString("room"));
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
                try {
                    Conn conn = new Conn();
                    ResultSet rs2 = conn.s.executeQuery("select * from room where roomnumber = " + roomNumField.getText());
                    while (rs2.next()) {
                        availabilityField.setText(rs2.getString("AVAILABILITY"));
                        cleanStatusField.setText(rs2.getString("cleaning_status"));
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });

        updateBtn = new JButton("Update");
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setBounds(150, 300, 100, 30);
        contentPane.add(updateBtn);
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn conn = new Conn();
                    String idCustomer = idCustomChoice.getSelectedItem();
                    String roomNumber = roomNumField.getText();
                    String available = availabilityField.getText();
                    String clean = cleanStatusField.getText();

                    conn.s.executeUpdate("UPDATE room SET AVAILABILITY = '" + available + "', CLEANING_STATUS = '" + clean + "' WHERE ROOMNUMBER = '" + roomNumber + "'");
                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");

                    setVisible(false);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }

        });

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setBounds(270, 300, 100, 30);
        contentPane.add(cancelBtn);
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}
