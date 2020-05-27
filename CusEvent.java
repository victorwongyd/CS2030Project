package cs2030.simulator;

/**
 *  Abstract parent CusEvent class that extends from abstract Event class
 *  to represent an Customer Event.
 * 
 */
public abstract class CusEvent extends Event {
    protected Customer cus;

    abstract Customer getEntity();
}

