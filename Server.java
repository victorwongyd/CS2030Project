package cs2030.simulator;

/**
 *  Server class that represents a server.
 */
public class Server extends Entity {
    protected double nextTime;
    private int queue;
    private int slot;
    private final int id;
    private static int count = 1; //Counter
    private boolean state; //true if busy, false if  available

    /**
     *  Each Server is created with a unique ID.
     *
     *  @param slot Number of slots of a queue.
     */
    public Server(int slot) {
        this.nextTime = 0;
        this.slot = slot + 1;
        this.queue = this.slot;
        this.id = count;
        this.state = false;
        Server.count++;
    }

    public int getID() {
        return this.id;
    }

    public double getNextTime() {
        return this.nextTime;
    }

    public void setNextTime(double time) {
        this.nextTime = time;
    }

    public void setState(boolean bool) {
        this.state = bool;
    }
    
    public boolean getState() {
        return this.state;
    }

    public int getSlot() {
        return this.slot;
    }

    public int getQueue() {
        return this.queue;
    }

    public void increaseSlot() {
        this.slot++;
    }

    public void decreaseSlot() {
        this.slot--;
    }

    @Override
    public String toString() {
        return "server " + this.id;
    }
}





