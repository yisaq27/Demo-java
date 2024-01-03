public class Schedule {
    private Bus bus;
    private Route route;
    private String departureTime;

    public Schedule(Bus bus, Route route, String departureTime) {
        this.bus = bus;
        this.route = route;
        this.departureTime = departureTime;
    }

    public Bus getBus() {
        return bus;
    }

    public Route getRoute() {
        return route;
    }

    public String getDepartureTime() {
        return departureTime;
    }
}
