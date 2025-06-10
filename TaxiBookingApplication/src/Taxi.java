import java.util.ArrayList;
import java.util.List;

public class Taxi {
    int id;
    int currentLocation;
    int freeTime;
    int totalEarnings;
    List<Booking> bookings;

    public Taxi(int id) {
        this.id = id;
        this.currentLocation = 'A';
        this.freeTime = 0;
        this.totalEarnings = 0;
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
        this.currentLocation = booking.to;
        this.freeTime = booking.dropTime;
        this.totalEarnings += booking.amount;
    }

    public void displayDetails() {
        System.out.println("Taxi-" + id + " Total Earnings: Rs. " + totalEarnings);
        System.out.println("BookingID CustomerID From To PickupTime DropTime Amount");
        for (Booking b : bookings) {
            System.out.printf("%9d %11d %4c %2c %10d %8d %6d\n", b.bookingId, b.customerId, b.from, b.to, b.pickupTime, b.amount);
        }
    }
}
