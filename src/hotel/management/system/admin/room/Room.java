package hotel.management.system.admin.room;

import hotel.management.system.Conn;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Room extends JFrame {
    protected String roomNumber;
    protected String availability;
    protected String status;
    protected final double price; // Tambahkan kata kunci "final"

    public Room(String roomNumber, String availability, String status, double price) {
        this.roomNumber = roomNumber;
        this.availability = availability;
        this.status = status;
        this.price = price;
    }

    public void addRoomToDatabase() {
        try {
            Conn c = new Conn();

            // Validasi nomor kamar yang tidak konflik
            String query = "SELECT * FROM room WHERE roomnumber = ?";
            PreparedStatement pstmt = c.connection.prepareStatement(query);
            pstmt.setString(1, roomNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Konflik nomor kamar, minta pengguna memasukkan nomor kamar yang berbeda
                JOptionPane.showMessageDialog(null, "The room number already exists. Please enter a different room number.");
            } else {
                // Nomor kamar tidak ada dalam database, eksekusi perintah INSERT
                query = "INSERT INTO room VALUES(?, ?, ?, ?, ?)";
                pstmt = c.connection.prepareStatement(query);
                pstmt.setString(1, roomNumber);
                pstmt.setString(2, availability);
                pstmt.setString(3, status);
                pstmt.setDouble(4, price);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Room Successfully Added");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}