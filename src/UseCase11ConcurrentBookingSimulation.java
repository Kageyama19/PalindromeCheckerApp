import java.util.*;

// Represents a booking request
class BookingRequest {
    private String guestName;
    private String roomType;

    public BookingRequest(String guestName, String roomType) {
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

// Shared booking processor
class ConcurrentBookingProcessor {

    private Map<String, Integer> roomInventory = new HashMap<>();

    public ConcurrentBookingProcessor() {
        roomInventory.put("Standard", 2);
        roomInventory.put("Deluxe", 1);
        roomInventory.put("Suite", 1);
    }

    // Critical section (thread-safe)
    public synchronized void processBooking(BookingRequest request) {

        String roomType = request.getRoomType();
        int available = roomInventory.getOrDefault(roomType, 0);

        if (available > 0) {
            roomInventory.put(roomType, available - 1);

            System.out.println(
                    request.getGuestName() +
                            " successfully booked a " +
                            roomType + " room."
            );
        } else {
            System.out.println(
                    request.getGuestName() +
                            " failed to book " +
                            roomType + " (No rooms available)"
            );
        }
    }

    public void displayInventory() {
        System.out.println("\nFinal Room Inventory:");
        for (String type : roomInventory.keySet()) {
            System.out.println(type + " -> " + roomInventory.get(type));
        }
    }
}

// Thread representing a guest
class GuestThread extends Thread {

    private ConcurrentBookingProcessor processor;
    private BookingRequest request;

    public GuestThread(ConcurrentBookingProcessor processor, BookingRequest request) {
        this.processor = processor;
        this.request = request;
    }

    @Override
    public void run() {
        processor.processBooking(request);
    }
}

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        ConcurrentBookingProcessor processor = new ConcurrentBookingProcessor();

        List<GuestThread> guests = new ArrayList<>();

        guests.add(new GuestThread(processor, new BookingRequest("Alice", "Standard")));
        guests.add(new GuestThread(processor, new BookingRequest("Bob", "Standard")));
        guests.add(new GuestThread(processor, new BookingRequest("Charlie", "Standard")));
        guests.add(new GuestThread(processor, new BookingRequest("David", "Deluxe")));
        guests.add(new GuestThread(processor, new BookingRequest("Eva", "Suite")));

        // Start all threads
        for (GuestThread guest : guests) {
            guest.start();
        }

        // Wait for all threads to finish
        for (GuestThread guest : guests) {
            try {
                guest.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        processor.displayInventory();
    }
}