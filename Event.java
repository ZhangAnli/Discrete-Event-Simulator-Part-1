package cs2030.simulator; 

import java.util.List;

/**
 * Immutable Event class with an event start time. 
 * It is associated with a customer and a list of servers.
 */
public abstract class Event {

    // Attributes 
    private final Customer customer; 
    private final List<Server> serverList; 
    private final double eventStartTime; 

    /**
     * Constructor method for the abstract Event class. 
     * Takes in a customer, a server list and a event start time.  
     * @param customer Customer 
     * @param serverList List of servers 
     * @param eventStartTime Event start time 
     */
    public Event(Customer customer, List<Server> serverList, double eventStartTime) { 
        this.customer = customer; 
        this.serverList = serverList; 
        this.eventStartTime = eventStartTime; 
    } 

    // Getters 
    public Customer getCustomer() {
        return this.customer; 
    }

    public List<Server> getServerList() {
        return this.serverList; 
    }

    public double getEventStartTime() { 
        return this.eventStartTime; 
    } 

    public abstract Event execute();
}