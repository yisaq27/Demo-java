public class Route {
    private String routeNumber;
    private String source;
    private String destination;

    public Route(String routeNumber, String source, String destination) {
        this.routeNumber = routeNumber;
        this.source = source;
        this.destination = destination;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
    public String displayroute(){
        return routeNumber+"\t"+source+"\t"+destination;
    }
}
