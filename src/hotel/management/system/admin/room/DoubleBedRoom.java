package hotel.management.system.admin.room;

public class DoubleBedRoom extends Room {
    private static final double HARGA_KAMAR = 600000.0;

    public DoubleBedRoom(String roomNumber, String availability, String status, double price) {
        super(roomNumber, availability, status, price);
    }

    @Override
    public double getHargaKamar() {
        return HARGA_KAMAR;
    }

    @Override
    protected String getBedType() {
        return "Double Bed";
    }
}