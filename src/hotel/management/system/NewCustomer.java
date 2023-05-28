package hotel.management.system;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {
    JComboBox<String> idcombo;
    JTextField idNumberField, nameField, countryField, depositField;
    JRadioButton maleRB, femaleRB;
    JButton addBtn, cancelBtn;
    Choice chooseRoom;
    JLabel checkinTime;

    NewCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("New Customer Form");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Inter", Font.BOLD, 20));
        add(text);

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(35, 80, 100, 20);
        idLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        add(idLabel);

        String option[] = {"KTP","Passport", "SIM", "KTM", "Student Card"};
        idcombo = new JComboBox<>(option);
        idcombo.setBounds(200, 80, 150, 25);
        idcombo.setBackground(Color.WHITE);
        add(idcombo);

        JLabel numberLabel = new JLabel("ID Number");
        numberLabel.setBounds(35, 120, 100, 20);
        numberLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        add(numberLabel);

        idNumberField = new JTextField();
        idNumberField.setBounds(200, 120, 150, 25);
        add(idNumberField);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(35, 160, 150, 25);
        nameLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200, 160, 150, 25);
        add(nameField);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(35, 200, 100, 20);
        genderLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        add(genderLabel);

        maleRB = new JRadioButton("Male");
        maleRB.setBackground(Color.WHITE);
        maleRB.setBounds(200, 200, 60, 25);
        add(maleRB);

        femaleRB = new JRadioButton("Female");
        femaleRB.setBackground(Color.WHITE);
        femaleRB.setBounds(270, 200, 100, 25);
        add(femaleRB);

        JLabel countryLabel = new JLabel("Country");
        countryLabel.setBounds(35, 240, 150, 25);
        countryLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        add(countryLabel);

        countryField = new JTextField();
        countryField.setBounds(200, 240, 150, 25);
        add(countryField);

        JLabel roomLabel = new JLabel("Choose Room");
        roomLabel.setBounds(35, 280, 150, 20);
        roomLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        add(roomLabel);

        chooseRoom = new Choice();
        chooseRoom.setBounds(200, 280, 150, 25);
        add(chooseRoom);

        fillRoomChoices();

        JLabel timeLabel = new JLabel("Checkin Time");
        timeLabel.setBounds(35, 320, 150, 20);
        timeLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        add(timeLabel);

        Date date = new Date();

        checkinTime = new JLabel("" + date);
        checkinTime.setBounds(200, 320, 150, 20);
        checkinTime.setFont(new Font("Inter", Font.PLAIN, 16));
        add(checkinTime);

        JLabel depositLabel = new JLabel("Deposit");
        depositLabel.setBounds(35, 360, 150, 25);
        depositLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        add(depositLabel);

        depositField = new JTextField();
        depositField.setBounds(200, 360, 150, 25);
        add(depositField);

        addBtn = new JButton("Add");
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        addBtn.setBounds(50, 410, 120, 30);
        addBtn.addActionListener(this);
        add(addBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBackground(Color.WHITE);
        cancelBtn.setForeground(Color.BLACK);
        cancelBtn.setBounds(200, 410, 120, 30);
        cancelBtn.addActionListener(this);
        add(cancelBtn);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/hotel/management/system/assets/reception.jpg"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon driverImage = new ImageIcon(scaledImage);
        JLabel lblDriverImage = new JLabel(driverImage);
        lblDriverImage.setBounds(400,50,300,400);
        add(lblDriverImage);

        setBounds(560, 265, 800, 550);
        setResizable(false);
        setVisible(true);
    }

    // Metode untuk mengisi pilihan kamar yang tersedia
    private void fillRoomChoices() {
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM room WHERE availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                chooseRoom.add(rs.getString("ROOMNUMBER"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addBtn) {
            // Validasi input
            if (idNumberField.getText().isEmpty() || nameField.getText().isEmpty() || countryField.getText().isEmpty() || depositField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields");
                return;
            }

            // Logika tambahan saat menambahkan pelanggan baru
            String id = (String) idcombo.getSelectedItem();
            String idNumber = idNumberField.getText();
            String name = nameField.getText();
            String gender = maleRB.isSelected() ? "Male" : "Female";
            String country = countryField.getText();
            String room = chooseRoom.getSelectedItem();
            String time = checkinTime.getText();
            String deposit = depositField.getText();

            try {
                String query = "INSERT INTO kustomer VALUES ('" + id + "', '" + idNumber + "', '" + name + "', '" + gender + "', '" + country + "', '" + room + "', '" + time + "', '" + deposit + "')";
                String query2 = "UPDATE room SET availability = 'Occupied' WHERE roomnumber = '" + room + "'";

                Conn conn = new Conn();
                conn.s.executeQuery(query);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");

                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }

        } else if (ae.getSource() == cancelBtn) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
