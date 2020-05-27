package cs2030.simulator;

/**
 *  Event Wait extends from CusEvent to represent a Customer who is waiting.
 */
public class EventWait extends CusEvent {
    private double time;
    private Customer cus;
    private Server server;
    
    /**
     *  Constructor creates an Event where customer is waiting.
     *
     *  @param time Time reference.
     *  @param cus Customer reference.
     *  @param server Server serving reference Customer.
     */
    public EventWait(double time, Customer cus, Server server) {
        this.time = time;
        this.cus = cus;
        this.server = server;
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
     *  Execution of event. The reference server decreases by 1 sot because Customer is waiting
     *  in the queue of the server.
     *
     *  @param shop Shop reference.
     *  @param stats Stats reference.
     *  @return  Serve Event.
     */
    public Event execute(Shop shop, Stats stats) {
        System.out.println(this);

        if (this.server instanceof SelfServer) {
            this.server = shop.getNextAvailSServer();
        }

        this.server.decreaseSlot();
        stats.addWaitTime(this.server.getNextTime() - this.time);
        return new EventServe(this.server.getNextTime(), this.cus, this.server, false);
    }

    @Override
    public String toString() {
        return String.format("%.3f", this.time) + " " + this.cus 
                + " waits to be served by " + this.server;
    }
}

