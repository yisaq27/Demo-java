import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BusManagementSystem busManagementSystem = new BusManagementSystem();

        Bus bus1 = new Bus("B001", 20);
        Bus bus2 = new Bus("B002", 15);
        Bus bus3 = new Bus("B003", 15);
        Bus bus4 = new Bus("B004", 15);
        Bus bus5 = new Bus("B005", 13);

        Route route1 = new Route("R001", "kilito", "Megenagna");
        Route route2 = new Route("R002", "Tulu dimtu", "Megenagna");

        busManagementSystem.addBus(bus1);// adding bus
        busManagementSystem.addBus(bus2);
        busManagementSystem.addBus(bus3);
        busManagementSystem.addBus(bus4);
        busManagementSystem.addBus(bus5);

        busManagementSystem.addRoute(route1);// adding route
        busManagementSystem.addRoute(route2);

        busManagementSystem.createSchedule(bus1, route1, "10:00 AM"); // creating Schedule bus with departure time
        busManagementSystem.createSchedule(bus2, route2, "02:30 PM");
        busManagementSystem.createSchedule(bus3, route2, "03:30 PM");
        busManagementSystem.createSchedule(bus4, route1, "04:30 PM");
        busManagementSystem.createSchedule(bus5, route1, "06:30 PM");

        Scanner scanner = new Scanner(System.in);

        boolean continueBooking = true;

        while (continueBooking) {
            // Display available routes
            System.out.println("Available Routes:");
            for (Route route : busManagementSystem.getRoutes()) {
                System.out.println(route.getRouteNumber() + ": " + route.getSource() + " to " + route.getDestination());
            }

            // User chooses a route
            System.out.print("Enter the route number you want to travel: ");
            String selectedRouteNumber = scanner.nextLine();
            Route selectedRoute = null;
            for (Route route : busManagementSystem.getRoutes()) {
                if (route.getRouteNumber().equalsIgnoreCase(selectedRouteNumber)) {
                    selectedRoute = route;
                    break;
                }
            }

            if (selectedRoute == null) {
                System.out.println("Invalid route number. Exiting the program.");
                System.exit(0);
            }

            // Display available buses for the selected route
            System.out.println("Available Buses for Route " + selectedRoute.getRouteNumber() + ":");
            List<Bus> busesForRoute = busManagementSystem.getBuses(selectedRoute);

            if (!busesForRoute.isEmpty()) {
                for (Bus bus : busesForRoute) {
                    // Find the corresponding schedule for the bus and route
                    Schedule schedule = busManagementSystem.findSchedule(bus, selectedRoute);

                    if (schedule != null) {
                        System.out.println("Bus: " + bus.getBusNumber() +
                                ", Capacity: " + bus.getCapacity() +
                                ", Departure Time: " + schedule.getDepartureTime());
                    } else {
                        System.out.println("Bus: " + bus.getBusNumber() +
                                ", Capacity: " + bus.getCapacity() +
                                ", No Departure Time available");
                    }
                }
            } else {
                System.out.println("No buses available for the selected route.");
                continue; // Skip to the next iteration of the loop
            }

            // User chooses a bus
            System.out.print("Enter the bus number you want to travel with: ");
            String selectedBusNumber = scanner.nextLine();
            Bus selectedBus = null;
            for (Bus bus : busManagementSystem.getBuses(selectedRoute)) {
                if (bus.getBusNumber().equalsIgnoreCase(selectedBusNumber)) {
                    selectedBus = bus;
                    break;
                }
            }

            if (selectedBus == null) {
                System.out.println("Invalid bus number. Exiting the program.");
                System.exit(0);
            }

            // Display available seats for the selected bus
            System.out.println("Available seats for Bus " + selectedBus.getBusNumber() + ":");
            boolean[] seats = selectedBus.getSeats();
            for (int i = 0; i < seats.length; i++) {
                if (!seats[i]) {
                    System.out.print((i + 1) + " ");
                }
            }
            System.out.println();

            // User chooses a seat
            System.out.print("Enter the seat number you want to book: ");
            int selectedSeatNumber = scanner.nextInt();

            if (selectedBus.bookSeat(selectedSeatNumber)) {
                System.out.println("Seat booked successfully!");
            } else {
                System.out.println("Seat not available or invalid seat number.");
            }

            // Ask the user if they want to continue booking
            System.out.print("Do you want to continue booking? (yes/no): ");
            scanner.nextLine(); // Consume the newline character
            String continueBookingInput = scanner.nextLine().toLowerCase();
            continueBooking = continueBookingInput.equals("yes");
        }

        System.out.println("Thank you for using the bus management system!");
        scanner.close();
    }
}
