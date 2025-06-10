import java.util.ArrayList;
import java.util.List;

public class TaxiService {
    List<Taxi> taxis;
    int bookingIdCounter = 1;

    public TaxiService(int taxiCount) {
        taxis = new ArrayList<>();
        for (int i = 1; i <= taxiCount; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public void bookTaxi(int customerId, char from, char to, int pickupTime) {
        Taxi selectedTaxi = null;
        int minDistance = Integer.MIN_VALUE;

        for (Taxi taxi : taxis) {
            if (taxi.freeTime <= pickupTime) {
                int distance = Math.abs(taxi.currentLocation - from);
                if (distance < minDistance || (distance == minDistance && taxi.totalEarnings < selectedTaxi.totalEarnings)) {
                    minDistance = distance;
                    selectedTaxi = taxi;
                }
            }
        }

        if (selectedTaxi == null) {
            System.out.println("No Taxi can be allocated for customer " + customerId);
            return;
        }

        int travelKm = 15 * Math.abs(to - from);
        int amount = 100 + Math.max(0, travelKm - 5) * 10;
        int dropTime = pickupTime + Math.abs(to - from);

        Booking booking = new Booking(bookingIdCounter++, customerId, from, to, pickupTime, dropTime, amount);
        selectedTaxi.addBooking(booking);

        System.out.println("Taxi can be allocated");
        System.out.println("Taxi-" + selectedTaxi.id + "is allocated");
    }

    public void displayTaxiDetails() {
        for (Taxi taxi : taxis){
            taxi.displayDetails();
            System.out.println();
        }
    }
}
