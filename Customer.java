package cs2030.simulator; 

/**
 * Immutable Customer class that can be served by Server class. 
 */
public class Customer { 

    private final int id; 
    private final double arrivalTime; 

    /**
     * Constructor method for customer that takes in customer ID and customer arrival time. 
     * @param id Customer identifier 
     * @param arrivalTime Customer arrival time 
     */
    public Customer(int id, double arrivalTime) { 
        this.id = id; 
        this.arrivalTime = arrivalTime; 
    } 

    // Getters 
    public int getId() { 
        return this.id; 
    } 

    public double getArrivalTime() { 
        return this.arrivalTime; 
    } 

    public String toString() { 
        return this.id + " arrives at " + this.arrivalTime; 
    } 
} 