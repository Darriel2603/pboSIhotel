package hotel.management.system.admin.room;

public class SingleBedRoom extends Room {
    private static final double HARGA_KAMAR = 300000.0;

    public SingleBedRoom(String roomNumber, String availability, String status, double price) {
        super(roomNumber, availability, status, price);
    }

    public static double getHargaKamar() {
        return HARGA_KAMAR;
    }
}