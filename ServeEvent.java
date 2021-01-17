package cs2030.simulator;

import java.util.List; 

/**
 * A serve event class that is created when the customer is being served.
 */
public class ServeEvent extends Event { 

    private final int serverId; 
    
    /**
     * Constructor method for a Serve Event. 
     * Takes in a customer, a server list, a event start time and a server ID. 
     * @param customer Customer class 
     * @param serverList List of servers
     * @param eventStartTime Event start time 
     * @param serverId Server Identification
     */
    ServeEvent(Customer customer, List<Server> serverList, 
            double eventStartTime, int serverId) { 
        super(customer, serverList, eventStartTime); 
        this.serverId = serverId; 
    } 

    /**
     * Execute method that updates the server's isServing status to true 
     * and returns the following Done Event. 
     * @return Event
     */
    @Override
    public Event execute() { 
        super.getServerList().set(serverId - 1, 
                new Server(serverId, false, false, 
                super.getEventStartTime() + 1.0)); 
        return new DoneEvent(super.getCustomer(), super.getServerList(), 
                super.getEventStartTime() + 1.0, serverId); 
    }

    @Override 
    public String toString() {
        return String.format("%.3f", super.getEventStartTime()) + " " + 
                super.getCustomer().getId() + " served by " + this.serverId; 
    } 
} 