package hotel.management.system.admin;

import hotel.management.system.Conn;
import hotel.management.system.admin.room.Room;
import hotel.management.system.admin.room.SingleBedRoom;
import hotel.management.system.admin.room.DoubleBedRoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddRoom extends JFrame implements ActionListener {
    JLabel heading, roomnoLabel, availableLabel, cleanLabel, priceLabel, typeLabel;
    JTextField roomnoField, priceField;
    JComboBox<String> availableCombo, cleanCombo, typeCombo;
    JButton addBtn, cancelBtn;
    JLabel image;

    public AddRoom() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Inter", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);

        roomnoLabel = new JLabel("Room Number");
        roomnoLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        roomnoLabel.setBounds(60, 80, 120, 30);
        add(roomnoLabel);

        roomnoField = new JTextField();
        roomnoField.setBounds(200, 80, 150, 30);
        add(roomnoField);

        availableLabel = new JLabel("Availability");
        availableLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        availableLabel.setBounds(60, 130, 120, 20);
        add(availableLabel);

        String availableOption[] = {"Available", "Occupied"};
        availableCombo = new JComboBox<>(availableOption);
        availableCombo.setBounds(200, 130, 150, 30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);

        cleanLabel = new JLabel("Cleaning Status");
        cleanLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        cleanLabel.setBounds(60, 180, 120, 20);
        add(cleanLabel);

        String cleanOption[] = {"Cleaned", "Dirty"};
        cleanCombo = new JComboBox<>(cleanOption);
        cleanCombo.setBounds(200, 180, 150, 30);
        cleanCombo.setBackground(Color.WHITE);
        add(cleanCombo);

        priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        priceLabel.setBounds(60, 230, 120, 20);
        add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(200, 230, 150, 30);
        add(priceField);

        typeLabel = new JLabel("Bed Type");
        typeLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        typeLabel.setBounds(60, 280, 120, 20);
        add(typeLabel);

        String typeOption[] = {"Single Bed", "Double Bed"};
        typeCombo = new JComboBox<>(typeOption);
        typeCombo.setBounds(200, 280, 150, 30);
        typeCombo.setBackground(Color.WHITE);
        typeCombo.addActionListener(this); // Tambahkan ActionListener untuk menangani perubahan tipe kamar
        add(typeCombo);

        addBtn = new JButton("Tambah Kamar");
        addBtn.setForeground(Color.WHITE);
        addBtn.setBackground(Color.BLACK);
        addBtn.setBounds(60, 350, 130, 30);
        addBtn.addActionListener(this);
        add(addBtn);

        cancelBtn = new JButton("Batal");
        cancelBtn.setBackground(Color.WHITE);
        cancelBtn.setBackground(Color.WHITE);
        cancelBtn.setBounds(220, 350, 130, 30);
        cancelBtn.addActionListener(this);
        add(cancelBtn);

        ImageIcon i1 = new ImageIcon("src/hotel/management/system/assets/hotelroom.jpg");
        Image i2 = i1.getImage().getScaledInstance(500, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(400, 80, 500, 250);
        add(image);

        setBounds(490, 305, 940, 470);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == typeCombo) {
            String selectedType = (String) typeCombo.getSelectedItem();
            double finalPrice;

            if (selectedType.equals("Single Bed")) {
                finalPrice = new SingleBedRoom("", "", "", 0).getHargaKamar(); // Mengambil harga kamar dari kelas SingleBedRoom
            } else {
                finalPrice = new DoubleBedRoom("", "", "", 0).getHargaKamar(); // Mengambil harga kamar dari kelas DoubleBedRoom
            }

            priceField.setText(String.valueOf(finalPrice)); // Mengatur nilai harga kamar pada priceField
        } else if (ae.getSource() == addBtn) {
            String roomNumber = roomnoField.getText();
            String availability = (String) availableCombo.getSelectedItem();
            String cleaningStatus = (String) cleanCombo.getSelectedItem();
            double price = Double.parseDouble(priceField.getText());
            String bedType = (String) typeCombo.getSelectedItem();

            // Lakukan operasi database untuk menyimpan data kamar ke dalam tabel
            try {
                Room room;
                if (bedType.equals("Single Bed")) {
                    room = new SingleBedRoom(roomNumber, availability, cleaningStatus, price);
                } else {
                    room = new DoubleBedRoom(roomNumber, availability, cleaningStatus, price);
                }
                room.addRoomToDatabase();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gagal menambahkan kamar. Silakan coba lagi.");
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
