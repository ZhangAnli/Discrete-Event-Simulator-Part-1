package cs2030.simulator; 

import java.util.List; 

/**
 * A Done Event class that is created when  server finish serving customer. 
 */
public class DoneEvent extends Event { 

    private final int serverId; 
    
    /**
     * Constructor method for Done Event that takes in a customer, 
     * a server list, a event start time and a server ID.
     * @param customer Customer 
     * @param serverList List of servers 
     * @param eventStartTime Event Start Time 
     * @param serverId Server identifier  
     */
    DoneEvent(Customer customer, List<Server>  serverList, 
            double eventStartTime, int serverId) {         
        super(customer, serverList, eventStartTime); 
        this.serverId = serverId; 
    }

    /**
     * Execute method that returns null as this is the last event. 
     * Updates the server isAvailable status to true. 
     * @return null
     */
    @Override
    public Event execute() {
        super.getServerList().set(this.serverId - 1, 
                new Server(serverId, true, false, super.getEventStartTime()));  
        return null; 
    }

    @Override 
    public String toString() {
        return String.format("%.3f", super.getEventStartTime()) + 
                " " + super.getCustomer().getId() + 
                " done serving by " + serverId;  
    } 
} 
