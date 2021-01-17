package cs2030.simulator; 

import java.util.List; 

/**
 * A wait event class when the customer has to wait for a server as it is serving someone. 
 */
public class WaitEvent extends Event { 

    private final int serverId; 

    /**
     * Constructor method for Wait Event. 
     * @param customer One customer 
     * @param serverList List of servers 
     * @param eventStartTime Event start time
     * @param serverId Server identifier
     */
    WaitEvent(Customer customer, List<Server> serverList, 
            double eventStartTime, int serverId) { 
        super(customer, serverList, eventStartTime); 
        this.serverId = serverId; 
    } 

    /**
     * Execute method that updates the server's hasWaitingCustomer status to true.  
     * Returns the following Serve Event.
     * @return Event
     */
    @Override
    public Event execute() { 
        double serverAvailableTime = 
                super.getServerList().get(serverId - 1).getNextAvailableTime(); 
        super.getServerList().set(serverId - 1, 
                new Server(serverId, false, true, serverAvailableTime)); 
        return new ServeEvent(super.getCustomer(), super.getServerList(), 
                serverAvailableTime, serverId); 
    } 

    // Getter
    public double getWaitingTime() { 
        return super.getServerList().get(serverId - 1).getNextAvailableTime() - 
                super.getEventStartTime(); 
    }

    @Override 
    public String toString() {
        return String.format("%.3f", super.getEventStartTime()) + 
                " " + super.getCustomer().getId() + 
                " waits to be served by " + serverId; 
    } 
} 
