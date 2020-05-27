package cs2030.simulator;

/**
 * Customer class that represents a customer.
 */

public class Customer extends Entity {
    private final int id;
    private static int count = 1;
    private boolean greedy;

    /**
     *  Each Customer is created with a unique id.
     */
    public Customer(boolean greedy) {
        this.id = count;
        Customer.count++;
        this.greedy = greedy;
    }

    public int getID() {
        return this.id;
    }

    @Override
    public String toString() {
        if (greedy) {
            return String.valueOf(this.id) + "(greedy)";
        } else {
            return String.valueOf(this.id);
        }
    }
}

