import java.util.Scanner;
import cs2030.simulator.Simulator;

/**
 *  Main class to drive the input and output.
 */
public class Main {
    
    /**
     *  Contains all the calls of the discrete event simulator.
     *
     *  @params args required arguments.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seed = sc.nextInt();
        int numServers = sc.nextInt();
        int numSServers = sc.nextInt();
        int numSlots = sc.nextInt();
        int numCus = sc.nextInt();
        double arate = sc.nextDouble();
        double srate = sc.nextDouble();
        double rrate = sc.nextDouble();
        double probRest = sc.nextDouble();
        double probGreedy = sc.nextDouble();

        Simulator sim = new Simulator(seed, numServers, numSServers, 
                numSlots, numCus, arate, srate, rrate, probRest, probGreedy);
        
        sim.sim();
    }
}

