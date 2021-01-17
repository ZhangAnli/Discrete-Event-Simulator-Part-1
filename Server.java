package cs2030.simulator;

/**
 * Immutable Server class that is able to serve Customer class. 
 */
public class Server { 

    private final int identifier; 
    private final boolean isAvailable; 
    private final boolean hasWaitingCustomer; 
    private final double nextAvailableTime; 
    
    /**
     * Server constructor that takes in a server ID, availability status, 
     * waiting customer status and its next available time. 
     * @param identifier Server identifier 
     * @param isAvailable Server availability 
     * @param hasWaitingCustomer Server waiting customer
     * @param nextAvailableTime Server next available time 
     */
    public Server(int identifier, boolean isAvailable, 
            boolean hasWaitingCustomer, double nextAvailableTime) {
        this.identifier = identifier; 
        this.isAvailable = isAvailable; 
        this.hasWaitingCustomer = hasWaitingCustomer; 
        this.nextAvailableTime = nextAvailableTime; 
    } 

    // Getters 
    public int getId() { 
        return this.identifier; 
    } 

    public boolean getIsAvailable() { 
        return this.isAvailable; 
    } 

    public boolean getHasWaitingCustomer() { 
        return hasWaitingCustomer; 
    } 

    public double getNextAvailableTime() { 
        return nextAvailableTime; 
    } 

    @Override
    public String toString() { 
        if (isAvailable) { 
            return this.identifier + " is available"; 
        } else if (!hasWaitingCustomer) { 
            return this.identifier + " is busy; available at " + 
                    String.format("%.3f", this.nextAvailableTime); 
        } else { 
            return this.identifier + " is busy; waiting customer to be served at " + 
                    String.format("%.3f", this.nextAvailableTime);  
        } 
    } 
} 
