package cs2030.simulator;

/**
 *  Serve Event extends from CusEvent to represent a Customer who is being served.
 */
public class EventServe extends CusEvent {
    private double time;
    private Customer cus;
    private Server server;
    private boolean newCus;
    
    /**
     *  Constructor creates an Event where customer is being served.
     *
     *  @param time Time reference.
     *  @param cus Customer reference.
     *  @param s Server serving reference Customer.
     *  @param newCus Indicate if Customer did not wait (EventArrive) or had to wait (EventWait).
     */
    public EventServe(double time, Customer cus, Server s, boolean newCus) {
        this.time = time;
        this.cus = cus;
        this.server = s;
        this.newCus = newCus;
    }

    public double getTime() {
        return this.time;
    }

    public Customer getEntity() {
        return this.cus;
    }

    public Server getServer() {
        return this.server;
    }
    
    /**
     *  Execution of event. The reference server 
     *  
     *
     *  @param shop Shop reference.
     *  @param stats Stats reference.
     *  @return  Serve Event.
     */
    public Event execute(Shop shop, Stats stats) {
        if (!this.server.getState()) { // Server is currently available 
            System.out.println(this);
            if (this.newCus) {
                this.server.decreaseSlot();
            }
            this.server.setNextTime(this.time + shop.getServeTime());
            stats.addNumServe();
            this.server.setState(true); // Server set to busy
            return new EventDone(this.server.getNextTime(), this.cus, this.server);
        } else { // Server is currently unavailable
            if (this.server instanceof SelfServer) {
                this.server = shop.getNextAvailSServer();
            }
            stats.addWaitTime(this.server.getNextTime() - this.time);
            return new EventServe(this.server.getNextTime(), this.cus, this.server, false);
        }
    }

    @Override
    public String toString() {
        return String.format("%.3f", this.time) + " " + this.cus + " served by " + this.server;
    }
}


