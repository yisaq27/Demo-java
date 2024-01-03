import java.util.ArrayList;
import java.util.List;

public class BusManagementSystem {
    private List<Bus> buses;
    private List<Route> routes;
    private List<Schedule> schedules;

    public BusManagementSystem() {
        this.buses = new ArrayList<>();
        this.routes = new ArrayList<>();
        this.schedules = new ArrayList<>();
    }

    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public void createSchedule(Bus bus, Route route, String departureTime) {
        Schedule schedule = new Schedule(bus, route, departureTime);
        schedules.add(schedule);
    }

    public List<Route> getRoutes() {
        List<Route> uniqueRoutes = new ArrayList<>();
        for (Schedule schedule : schedules) {
            Route route = schedule.getRoute();
            if (!uniqueRoutes.contains(route)) {
                uniqueRoutes.add(route);
            }
        }
        return uniqueRoutes;
    }

    public List<Bus> getBuses(Route route) {
        List<Bus> busesForRoute = new ArrayList<>();
        
        for (Schedule schedule : schedules) {
            if (schedule.getRoute().equals(route) && !busesForRoute.contains(schedule.getBus())) {
                busesForRoute.add(schedule.getBus());
            }
        }
        
        return busesForRoute;
    }
    
    
    public List<Schedule> getSchedules(Route route) {
        return new ArrayList<>(schedules);
    }
    public Schedule findSchedule(Bus bus, Route route) {
        for (Schedule schedule : schedules) {
            if (schedule.getBus().equals(bus) && schedule.getRoute().equals(route)) {
                return schedule;
            }
        }
        return null;
    }
}
