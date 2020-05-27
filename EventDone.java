package cs2030.simulator;


/**
 *  Done Event extends from Event to represent a Customer who is done.
 */
public class EventDone extends CusEvent {
    private double time;
    private Customer cus;
    private Server server;

    /**
     *  Constructor creates a Customer Event where customer is done.
     *
     *  @param time Time reference.
     *  @param cus Customer reference.
     *  @param server Server serving reference Customer.
     */
    public EventDone(double time, Customer cus, Server server) {
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
     *  Execution of event. The referenced server increases by 1 slot because the Customer is done.
     *
     *  @param shop Shop reference.
     *  @param stats Stats reference.
     *
     *  @return null
     */
    public Event execute(Shop shop, Stats stats) {
        System.out.println(this);
        if (!(this.server instanceof SelfServer)) {
            if (shop.goingRest()) {
                return new EventServerRest(this.server, this.time);
            }
        }
        this.server.increaseSlot();
        this.server.setState(false); //available
        return null;
    }

    @Override
    public String toString() {
        return String.format("%.3f", this.time) + " " + this.cus
                + " done serving by " + this.server;
    }
}

    

