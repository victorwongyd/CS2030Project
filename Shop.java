package cs2030.simulator;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

/**
 *  Shop contains all the servers.
 */
public class Shop {
    private ArrayList<Server> servers;
    private ArrayList<SelfServer> sServers;
    private RandomGenerator rg;
    private double probRest;

    /**
     *  Constructor creates the Servers and contains the RandomGenerator.
     *
     *  @param numServers Number of Servers required.
     *  @param numSlots Number of slots a Server has.
     *  @param rg RandomGenerator reference.
    */
    public Shop(int numServers, int numSServers, int numSlots, 
            RandomGenerator rg, double probRest) {
        this.servers = new ArrayList<Server>();
        this.sServers = new ArrayList<SelfServer>();
        this.rg = rg;
        this.probRest = probRest;
        
        for (int i = numServers; i > 0; i--) {  //Human Servers
            servers.add(new Server(numSlots));
        }

        for (int i = numSServers; i > 0; i--) {
            SelfServer ss = new SelfServer(numSlots, numSServers);
            servers.add(ss);
            sServers.add(ss);
        }
    }

    /**
     *  Finding a server that is available in the Shop.
     * 
     *  @param greedy Whether the Customer is greedy.
     *  @return The unique ID of server if there is a server available, else 0.
     */
    public int findServer(boolean greedy) {
        for (Server s : servers) {
            if (!s.getState()) {
                return s.getID();
            }
        }

        if (greedy) {
            Server se = servers.get(0);
            for (Server server : servers) {
                if (server.getSlot() > se.getSlot()) {
                    se = server;
                }
            }
            if (se.getSlot() > 0) {
                return se.getID();
            } else {
                return 0;
            }
        }

        for (Server s : servers) {
            if (s.getSlot() > 0) { //Server with available slot
                return s.getID();
            }
        }
        return 0;
    }

    /**
     *  Finding the SelfServer that has the smallest next timing.
     */
    public SelfServer getNextAvailSServer() {
        Collections.sort(this.sServers);
        return sServers.get(0);
    }

    public double getServeTime() {
        return this.rg.genServiceTime();
    }

    public boolean goingRest() {
        return this.rg.genRandomRest() < this.probRest;
    }

    public double getRestPeriod() {
        return this.rg.genRestPeriod();
    }

    /**
     *  Find Server with the unique Server ID.
     *
     *  @param serverID Unique Server ID.
     *  @return Required Server reference.
     */
    public Server getServer(int serverID) {
        for (Server s: servers) {
            if (s.getID() == serverID) {
                return s;
            }
        }
        return null;
    }
}






