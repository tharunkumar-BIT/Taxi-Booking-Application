public class Booking {
    int bookingId;
    int customerId;
    char from;
    char to;
    int pickupTime;
    int dropTime;
    int amount;

    public Booking(int bookingId, int customerId, char from, char to, int pickupTime, int dropTime, int amount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.from = from;
        this.to = to;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.amount = amount;
    }
}
