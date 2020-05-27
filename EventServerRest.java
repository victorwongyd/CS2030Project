package cs2030.simulator;

/**
 *  Event Server Rest extends from ServerEvent to represent a 
 *  Server resting.
 */
public class EventServerRest extends ServerEvent {
    private Server server;
    private double time;

    /**
     *  Constructor creates a Server Event where Server is resting.
     *  
     *  @param server Server reference.
     *  @param time Time reference.
     */
    public EventServerRest(Server server, double time) {
        this.server = server;
        this.time = time;
    }

    public double getTime() {
        return this.time;
    }

    public Server getEntity() {
        return this.server;
    }
    
    /**
     *  Execution of event. The execution  will account for the rest period of the
     *  Server.
     *  
     *  @param shop Shop reference.
     *  @param stats Stats reference.
     *  
     *  @return EventServerBack event. 
     */
    public Event execute(Shop shop, Stats stats) {
        double newTime = this.time + shop.getRestPeriod();
        this.server.setNextTime(newTime);
        return new EventServerBack(this.server, newTime);
    }
}
