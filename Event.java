package cs2030.simulator;

/**
 * Abstract parent Event class that represents an Event.
 */
public abstract class Event {
    protected double time; 

    abstract Entity getEntity();

    abstract double getTime();

    abstract Event execute(Shop shop, Stats stats);
}
