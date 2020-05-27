package cs2030.simulator;

import java.util.PriorityQueue;

/**
 *  Simulator generates and carries out the simulation.
 */
public class Simulator {
    private Shop shop;
    private RandomGenerator rg;
    private Stats stats;
    private PriorityQueue<Event> pqE;

    /**
     *  Constructor to create simulator.
     *
     *  @param seed Seed of RandomGenerator.
     *  @param numServers Number of Servers required.
     *  @param numSlots Number of slots a Server has.
     *  @param numCus Number of Customers required.
     *  @param aRate Arrival Rate of Customers.
     *  @param sRate Service Rate of Servers.
     *  @param rRate Resting Rate of Servers.
     *  @param probRest Probability of Server resting.
     */
    public Simulator(int seed, int numServers, int numSServers, int numSlots, int numCus, 
            double aRate, double sRate, double rRate, double probRest, double probGreedy) {
        this.rg = new RandomGenerator(seed, aRate, sRate, rRate);
        this.shop = new Shop(numServers, numSServers, numSlots, this.rg, probRest);
        this.pqE = new PriorityQueue<>(new EventComparator());
        this.stats = new Stats();
        double time = 0;

        for (int i = numCus; i > 0; i--) { //Creating Customer PriorityQueue
            pqE.add(new EventArrive(time, this.rg.genCustomerType() < probGreedy));
            time = time + this.rg.genInterArrivalTime();
        }
    }

    /**
     *  Run the simulation. Goes through the Priority Queue and pushes each event.
     *  If there is a new event that needs to be created, it will be added back to
     *  the Priority Queue.
     *  Required Statistics will be printed out at the end.
     */
    public void sim() {
        while (!pqE.isEmpty()) {
            Event eve = pqE.poll();
            eve = eve.execute(shop, stats);

            if (eve != null) {
                pqE.add(eve);
            }
        }
        System.out.println("[" + String.format("%.3f", stats.getAvgWaitTime()) + " "
                + stats.getNumServe() + " " + stats.getNumLeave() + "]");
    }
}
