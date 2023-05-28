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
    Choice roomNumberChoice;
    JButton checkBtn, updateBtn, cancelBtn;

    UpdateRoom() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(760, 315, 400, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel heading = new JLabel("Update Room Status");
        heading.setFont(new Font("Inter", Font.BOLD, 25));
        heading.setBounds(30, 20, 250, 30);
        contentPane.add(heading);

        JLabel roomnumberLabel = new JLabel("Room Number");
        roomnumberLabel.setBounds(30, 80, 100, 20);
        contentPane.add(roomnumberLabel);

        roomNumberChoice = new Choice();
        roomNumberChoice.setBounds(200, 80, 150, 25);
        contentPane.add(roomNumberChoice);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from room");
            while (rs.next()) {
                roomNumberChoice.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel availableLabel = new JLabel("Availability");
        availableLabel.setBounds(30, 130, 100, 20);
        contentPane.add(availableLabel);

        availabilityField = new JTextField();
        availabilityField.setBounds(200, 130, 150, 25);
        contentPane.add(availabilityField);

        JLabel cleanStatusLabel = new JLabel("Cleaning Status");
        cleanStatusLabel.setBounds(30, 180, 100, 20);
        contentPane.add(cleanStatusLabel);

        cleanStatusField = new JTextField();
        cleanStatusField.setBounds(200, 180, 150, 25);
        contentPane.add(cleanStatusField);

        checkBtn = new JButton("Check");
        checkBtn.setBackground(Color.BLACK);
        checkBtn.setForeground(Color.WHITE);
        checkBtn.setBounds(30, 250, 100, 30);
        contentPane.add(checkBtn);
        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String roomNumber = roomNumberChoice.getSelectedItem();
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select * from room where roomnumber = '" + roomNumber + "'");

                    if (rs.next()) {
                        availabilityField.setText(rs.getString("AVAILABILITY"));
                        cleanStatusField.setText(rs.getString("cleaning_status"));
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });

        updateBtn = new JButton("Update");
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setBounds(150, 250, 100, 30);
        contentPane.add(updateBtn);
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn conn = new Conn();
                    String roomNumber = roomNumberChoice.getSelectedItem();
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
        cancelBtn.setBounds(270, 250, 100, 30);
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
