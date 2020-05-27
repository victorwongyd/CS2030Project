package cs2030.simulator;

/**
 *  Event Leave extends from CusEvent to represent a Customer leaving.
 */
public class EventLeave extends Event {
    private double time;
    private Customer cus;

    /**
     *  Constructor creates a customer who is leaving.
     *
     *  @param time Time reference.
     *  @param cus Customer reference.
     */
    public EventLeave(double time, Customer cus) {
        this.time = time;
        this.cus = cus;
    }

    public double getTime() {
        return this.time;
    }

    public Customer getEntity() {
        return this.cus;
    }

    /**
     *  Execution of event.
     *
     *  @param shop Shop reference.
     *  @param stats Stats reference.
     *  @return null.
     */
    public Event execute(Shop shop, Stats stats) {
        System.out.println(this);
        stats.addNumLeave();
        return null; //not added back into Simulator Queue
    }

    @Override
    public String toString() {
        return String.format("%.3f", this.time) + " " + this.cus + " leaves";
    }
}

