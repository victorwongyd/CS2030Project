package cs2030.simulator;

/**
 *  Stats class takes account for the statistics of each simulation.
 */
public class Stats {
    private int numLeave;
    private int numServe;
    private double totalWaitTime;

    /**
     *  Creates stats class with 0 leave, serve and wait time.
     */
    public Stats() {
        this.numLeave = 0;
        this.numServe = 0;
        this.totalWaitTime = 0.0;
    }

    public int getNumLeave() {
        return this.numLeave;
    }

    public int getNumServe() {
        return this.numServe;
    }
    
    /**
     *  Calculates the average wait time of all Customers in the
     *  simulation.
     */
    public double getAvgWaitTime() {
        if (this.numServe > 0) {
            return this.totalWaitTime / this.numServe;
        } else {
            return this.totalWaitTime;
        }
    }

    public void addNumLeave() {
        this.numLeave++;
    }

    public void addNumServe() {
        this.numServe++;
    }

    public void addWaitTime(double time) {
        this.totalWaitTime = this.totalWaitTime + time;
    }
}

