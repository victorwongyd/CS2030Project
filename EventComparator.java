package cs2030.simulator;

import java.util.Comparator;

/**
 *  Allows us to compare between Event type objects.
 */
public class EventComparator implements Comparator<Event> {

    /**
    * Compares two Event objects based on their time. If time is the same,
    * respective Customer ID is compared.
    * @param e1 First Event object argument
    * @param e2 Second Event object argument
    */
    public int compare(Event e1, Event e2) { 
        if (e1.getTime() < e2.getTime()) {
            return -1;
        } else if (e1.getTime() == e2.getTime()) {
            return e1.getEntity().getID() - e2.getEntity().getID();
        } else {
            return 1;
        }
    }
}

