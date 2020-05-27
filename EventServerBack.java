package cs2030.simulator;

/**
 *  Event Server Back extends from ServerEvent to represent a 
 *  Server becoming available again after rest.
 */
public class EventServerBack extends ServerEvent {
    private Server server;
    private double time;
    
    /**
     *  Constructor creates a Server Event where Server
     *  is available again after rest.
     *  
     *  @param server Server reference.
     *  @param time Time reference.
     */
    public EventServerBack(Server server, double time) {
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
     *  Execution of event. The execution will account for the Server
     *  becoming available again.
     *  
     *  @param shop Shop reference.
     *  @param stats Stats reference.
     *
     *  @return null
     */
    public Event execute(Shop shop, Stats stats) {
        this.server.increaseSlot();
        this.server.setState(false); //available
        return null;
    }
}
