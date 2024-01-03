import java.util.Arrays;

public class Bus {
    private String busNumber;
    private int capacity;
    private boolean[] seats;

    public Bus(String busNumber, int capacity) {
        this.busNumber = busNumber;
        this.capacity = capacity;
        this.seats = new boolean[capacity];
        Arrays.fill(seats, false);  // Initialize seats with false values
    }

    // ... rest of the Bus class ...



   

    public String getBusNumber() {
        return busNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean[] getSeats() {
        return Arrays.copyOf(seats, seats.length);
    }
    public boolean bookSeat(int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= capacity && !seats[seatNumber - 1]) {
            seats[seatNumber - 1] = true;
            return true;
        }
        return false;
    }
}
 