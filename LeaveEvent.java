package cs2030.simulator; 

import java.util.List; 

/** 
 * A leave event class that is created when the customer leaves 
 * as there are no available servers and waiting slots. 
 */
public class LeaveEvent extends Event { 
    
    /**
     * Constructor method for Leave Event that takes in a customer, 
     * a server List and a event start time.
     * @param customer Customer class 
     * @param serverList List of servers
     * @param eventStartTime Event start time 
     */
    LeaveEvent(Customer customer, List<Server> serverList, double eventStartTime) { 
        super(customer, serverList, customer.getArrivalTime()); 
    } 

    /**
     * Execute method that returns null as this is the last event. 
     * Does not change the state of any server in the server list. 
     * @return Event
     */
    @Override
    public Event execute() {
        return null; 
    } 

    @Override 
    public String toString() {
        return String.format("%.3f", super.getEventStartTime()) + 
                        " " + super.getCustomer().getId() + " leaves"; 
    }
} 