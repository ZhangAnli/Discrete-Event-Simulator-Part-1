package cs2030.simulator; 

import java.util.List; 

/**
 * An arrival event class first created when the customer arrives at the server. 
 */
public class ArriveEvent extends Event { 

    /**
     * Constructor method that takes in a customer and a server list. 
     * @param customer Customer 
     * @param serverList List of servers 
     */
    public ArriveEvent(Customer customer, List<Server> serverList) {  
        super(customer, serverList, customer.getArrivalTime()); 
    } 

    /**
     * Execute method that returns the next event for the customer. 
     * @return Event 
     */
    @Override
    public Event execute() { 

        // Serve
        for (int i = 0; i < super.getServerList().size(); i++) { 
            if (super.getServerList().get(i).getIsAvailable()) { 
                return new ServeEvent(super.getCustomer(), 
                        super.getServerList(), 
                        super.getEventStartTime(), i + 1);         
            } 
        }    
        
        // Wait 
        for (int i = 0; i < super.getServerList().size(); i++) { 
            if (!getServerList().get(i).getHasWaitingCustomer()) { 
                return new WaitEvent(super.getCustomer(), 
                        super.getServerList(), 
                        super.getEventStartTime(), i + 1);
            } 
        }

        // Leave 
        return new LeaveEvent(super.getCustomer(), 
                super.getServerList(), 
                super.getEventStartTime()); 
    } 

    @Override 
    public String toString() {
        return String.format("%.3f", super.getEventStartTime()) + 
                " " + super.getCustomer().getId() + " arrives";  
    } 
} 
