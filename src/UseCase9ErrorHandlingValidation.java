import java.util.*;

// Custom Exception
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Represents a Reservation
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

// Booking System with validation
class BookingSystem {

    private Map<String, Integer> roomInventory = new HashMap<>();

    public BookingSystem() {
        roomInventory.put("Standard", 2);
        roomInventory.put("Deluxe", 1);
        roomInventory.put("Suite", 1);
    }

    public void confirmBooking(Reservation reservation) throws InvalidBookingException {

        String roomType = reservation.getRoomType();

        // Validate room type
        if (!roomInventory.containsKey(roomType)) {
            throw new InvalidBookingException("Invalid room type: " + roomType);
        }

        int available = roomInventory.get(roomType);

        // Prevent negative inventory
        if (available <= 0) {
            throw new InvalidBookingException("No rooms available for type: " + roomType);
        }

        // Update inventory safely
        roomInventory.put(roomType, available - 1);

        System.out.println("Booking confirmed for " + reservation.getGuestName() +
                " in room type: " + roomType);
    }

    public void displayInventory() {
        System.out.println("\nCurrent Room Inventory:");
        for (String type : roomInventory.keySet()) {
            System.out.println(type + " -> " + roomInventory.get(type));
        }
    }
}

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        BookingSystem system = new BookingSystem();

        try {

            Reservation r1 = new Reservation("Alice", "Deluxe");
            Reservation r2 = new Reservation("Bob", "Suite");
            Reservation r3 = new Reservation("Charlie", "Premium"); // invalid room type

            system.confirmBooking(r1);
            system.confirmBooking(r2);
            system.confirmBooking(r3);

        } catch (InvalidBookingException e) {
            System.out.println("Booking Failed: " + e.getMessage());
        }

        system.displayInventory();
    }
}
