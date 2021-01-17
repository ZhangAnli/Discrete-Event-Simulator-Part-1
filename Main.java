import cs2030.simulator.Customer;
import cs2030.simulator.Server;
import cs2030.simulator.Event;
import cs2030.simulator.EventComparator; 
import cs2030.simulator.ArriveEvent; 
import cs2030.simulator.DoneEvent; 
import cs2030.simulator.LeaveEvent; 
import cs2030.simulator.ServeEvent; 
import cs2030.simulator.WaitEvent; 
import java.util.Scanner;
import java.util.ArrayList; 
import java.util.PriorityQueue;

/** 
 * A discrete event simulator program. 
 */
public class Main {
    /**
     * Reads input from System.in to create customers and start event simulation.
     * @param args Not required 
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Initialise servers and customers 
        int numOfServers = sc.nextInt();
        ArrayList<Server> servers = new ArrayList<Server>(); 
        for (int i = 0; i < numOfServers; i++) { 
            servers.add(new Server(i + 1, true, false, 0)); 
        } 

        ArrayList<Customer> queue = new ArrayList<Customer>(); 
        int counter = 1; 
        while (sc.hasNextDouble()) {
            double arrivalTime = sc.nextDouble();
            queue.add(new Customer(counter, arrivalTime));  
            counter++; 
        }
        Customer[] custArr = queue.toArray(new Customer[counter]); 

        // Statistic counters 
        double totalWaitingTime = 0; 
        int customersServed = 0; 
        int customersLeft = 0; 

        // Set up priority queue 
        PriorityQueue<Event> out = new PriorityQueue<Event>(counter, 
                new EventComparator()); 

        // Add events to priority queue - Simulate 
        for (int i = 0; i < counter - 1; i++) { 
            out.add(new ArriveEvent(custArr[i], servers)); 
        } 

        while (!out.isEmpty()) { 

            Event event = out.poll(); 
            System.out.println(event); 

            if (event instanceof ArriveEvent || event instanceof ServeEvent) { 
                Event next = event.execute(); 
                out.add(next); 
            } else if (event instanceof DoneEvent) { 
                customersServed++;
                event.execute(); 
            } else if (event instanceof LeaveEvent) { 
                customersLeft++; 
            } else if (event instanceof WaitEvent) { 
                totalWaitingTime += ((WaitEvent)event).getWaitingTime();  
                Event next = event.execute(); 
                out.add(next); 
            } 
        }

        // Average Waiting Time 
        double averageWaitingTime = 0; 

        if (totalWaitingTime != 0) { 
            averageWaitingTime = (double) totalWaitingTime / customersServed; 
        } 

        // Print
        System.out.println("[" + String.format("%.3f", averageWaitingTime) + 
                " " + customersServed + " " + customersLeft + "]"); 
    } 
}