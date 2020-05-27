package cs2030.simulator;

/**
 *  SelfServer class that extends from Server class
 *  to represent a self-checkout counter.
 */
public class SelfServer extends Server implements Comparable<SelfServer> {
    private static int sQueue;
    private static int sSlot;

    /**
     *  Each SelfServer is created with a shared queue and slots.
     *
     *  @param slot Number of slots of a queue.
     *  @param numSServers Number of SelfServers required.
     */
    public SelfServer(int slot, int numSServers) {
        super(slot);
        SelfServer.sSlot = slot + numSServers;
        SelfServer.sQueue = SelfServer.sSlot;
    }

    @Override
    public int compareTo(SelfServer s) {
        if (this.getNextTime() > s.getNextTime()) {
            return 1;
        } else if (this.getNextTime() < s.getNextTime()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public int getSlot() {
        return SelfServer.sSlot;
    }

    @Override
    public int getQueue() {
        return SelfServer.sQueue;
    }

    @Override
    public void increaseSlot() {
        SelfServer.sSlot++;
    }

    @Override
    public void decreaseSlot() {
        SelfServer.sSlot--;
    }

    @Override
    public String toString() {
        return "self-check " + super.getID();
    }
}
