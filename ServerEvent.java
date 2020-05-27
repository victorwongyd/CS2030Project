package cs2030.simulator;

/**
 *  Abstract parent ServerEvent class that extends from abstract Event
 *  class to represent a Server Event.
 */
public abstract class ServerEvent extends Event {
    protected Server server;

    abstract Server getEntity();
}
