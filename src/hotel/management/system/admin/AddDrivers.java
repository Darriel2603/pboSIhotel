package hotel.management.system.admin;

import hotel.management.system.Conn;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddDrivers extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField nameField, ageField, carCompanyField, brandCarField, locationField;
    private JComboBox<String> genderCB, availableCB;
    private JButton addBtn, cancelBtn;

    public AddDrivers() {
        setBounds(450, 200, 1000, 500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/hotel/management/system/assets/driver.jpg"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon driverImage = new ImageIcon(scaledImage);
        JLabel lblDriverImage = new JLabel(driverImage);
        lblDriverImage.setBounds(400, 30, 500, 370);
        contentPane.add(lblDriverImage);

        JLabel heading = new JLabel("Add Driver");
        heading.setFont(new Font("Inter", Font.BOLD, 18));
        heading.setBounds(194, 10, 160, 22);
        contentPane.add(heading);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        nameLabel.setBounds(64, 70, 102, 22);
        contentPane.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(174, 70, 156, 20);
        contentPane.add(nameField);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setForeground(Color.BLACK);
        ageLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        ageLabel.setBounds(64, 110, 102, 22);
        contentPane.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(174, 110, 156, 20);
        contentPane.add(ageField);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setForeground(Color.BLACK);
        genderLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        genderLabel.setBounds(64, 150, 102, 22);
        contentPane.add(genderLabel);

        genderCB = new JComboBox<>(new String[] { "Male", "Female" });
        genderCB.setBounds(176, 150, 154, 20);
        contentPane.add(genderCB);

        JLabel companyLabel = new JLabel("Company");
        companyLabel.setForeground(Color.BLACK);
        companyLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        companyLabel.setBounds(64, 190, 130, 22);
        contentPane.add(companyLabel);

        carCompanyField = new JTextField();
        carCompanyField.setBounds(174, 190, 156, 20);
        contentPane.add(carCompanyField);

        JLabel typeCarLabel = new JLabel("Brand/Type");
        typeCarLabel.setForeground(Color.BLACK);
        typeCarLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        typeCarLabel.setBounds(64, 230, 102, 22);
        contentPane.add(typeCarLabel);

        brandCarField = new JTextField();
        brandCarField.setBounds(174, 230, 156, 20);
        contentPane.add(brandCarField);

        JLabel availableLabel = new JLabel("Available");
        availableLabel.setForeground(Color.BLACK);
        availableLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        availableLabel.setBounds(64, 270, 102, 22);
        contentPane.add(availableLabel);

        availableCB = new JComboBox<>(new String[] { "Available", "Busy" });
        availableCB.setBounds(176, 270, 154, 20);
        contentPane.add(availableCB);

        JLabel locationLabel = new JLabel("Location");
        locationLabel.setForeground(Color.BLACK);
        locationLabel.setFont(new Font("Inter", Font.PLAIN, 17));
        locationLabel.setBounds(64, 310, 102, 22);
        contentPane.add(locationLabel);

        locationField = new JTextField();
        locationField.setBounds(174, 310, 156, 20);
        contentPane.add(locationField);

        addBtn = new JButton("Add");
        addBtn.addActionListener(this);
        addBtn.setBounds(64, 380, 111, 33);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        contentPane.add(addBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(this);
        cancelBtn.setBounds(198, 380, 111, 33);
        cancelBtn.setBackground(Color.WHITE);
        cancelBtn.setForeground(Color.BLACK);
        contentPane.add(cancelBtn);

        contentPane.setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addBtn){
            try{
                String nama = nameField.getText();
                String usia = ageField.getText();
                String jenisKelamin = (String) genderCB.getSelectedItem();
                String perusahaanMobil = carCompanyField.getText();
                String merekMobil = brandCarField.getText();
                String tersedia = (String) availableCB.getSelectedItem();
                String lokasi = locationField.getText();

                if (nama.isEmpty() || usia.isEmpty() || perusahaanMobil.isEmpty() || merekMobil.isEmpty() || lokasi.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please complete all fields");
                } else {
                    Conn c = new Conn();

                    String query = "INSERT INTO driver VALUES(?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement ps = c.connection.prepareStatement(query);
                    ps.setString(1, nama);
                    ps.setString(2, usia);
                    ps.setString(3, jenisKelamin);
                    ps.setString(4, perusahaanMobil);
                    ps.setString(5, merekMobil);
                    ps.setString(6, tersedia);
                    ps.setString(7, lokasi);

                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Driver added successfully");
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add driver");
                    }

                    ps.close();
                    c.connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred while adding the driver");
            }
        } else if (ae.getSource() == cancelBtn){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDrivers();
    }
}
