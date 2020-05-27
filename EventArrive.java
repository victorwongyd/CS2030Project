package cs2030.simulator;

/**
 *  Event Arrive extends from CusEvent to represent a Customer arriving.
 */
public class EventArrive extends CusEvent {
    private double time;
    private Customer cus;
    private boolean greedy;

    /**
     *  Constructor creates a new customer.
     *
     *  @param  time   Arrival Time reference of this event.
     */
    public EventArrive(double time, boolean greedy) {
        this.time = time;
        this.cus = new Customer(greedy);
        this.greedy = greedy;
    }
    
    public double getTime() {
        return this.time;
    }
    
    public Customer getEntity() {
        return this.cus;
    }
    
    @Override
    public String toString() {
        return String.format("%.3f",this.time) + " " + this.cus + " arrives";
    }

    /**
     *  Execution of event.
     *  <p>For an arrival event, there are 3 possibilities for a customer,
     *  the customer either leaves, waits, or is served immediately.
     *  This is determined by the availability of a Server.</p>
     *
     *  @param  shop Shop object.
     *  @param  stats  Stats object.
     *  @return Either a SERVES, WAITS, or LEAVES event.
     */
    public Event execute(Shop shop, Stats stats) {
        System.out.println(this);
        int serverID = shop.findServer(this.greedy); //not greedy

        if (serverID > 0) {
            Server s = shop.getServer(serverID);
            if (!(s.getState())) {
                return new EventServe(this.time, this.cus, s, true);
            } else { //WAITS
                return new EventWait(this.time, this.cus, s);
            }
        } else { //LEAVES
            return new EventLeave(this.time, this.cus);
        }
    }
}

