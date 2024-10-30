import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String contactDetails;
    private List<String> reservationHistory;

    public Customer(String name, String contactDetails) {
        this.name = name;
        this.contactDetails = contactDetails;
        this.reservationHistory = new ArrayList<>();
    }

    public void addReservation(String reservation) {
        reservationHistory.add(reservation);
    }

    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public List<String> getReservationHistory() {
        return reservationHistory;
    }
}
