package hotel.management.system.admin.room;

import hotel.management.system.Conn;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class Room extends JFrame {
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

    public abstract double getHargaKamar(); // Deklarasikan metode abstrak getHargaKamar()

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
                JOptionPane.showMessageDialog(null, "Nomor kamar sudah ada. Silakan masukkan nomor kamar yang berbeda.");
            } else {
                // Nomor kamar tidak ada dalam database, eksekusi perintah INSERT
                query = "INSERT INTO room(roomnumber, availability, cleaning_status, price, bed_type) VALUES (?, ?, ?, ?, ?)";
                pstmt = c.connection.prepareStatement(query);
                pstmt.setString(1, roomNumber);
                pstmt.setString(2, availability);
                pstmt.setString(3, status);
                pstmt.setDouble(4, price);
                pstmt.setString(5, getBedType());
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Kamar berhasil ditambahkan");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract String getBedType(); // Deklarasikan metode abstrak getBedType()
}
