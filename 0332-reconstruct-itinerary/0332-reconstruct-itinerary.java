import java.util.*;

class Solution {
    // Map to store graph: airport -> list of destinations (priority queue for sorting)
    private HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
    // List to store the final itinerary (built in reverse)
    private List<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // 1. Build the adjacency list
        for (List<String> ticket : tickets) {
            adj.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            adj.get(ticket.get(0)).add(ticket.get(1));
        }
        
        // 2. Start DFS from JFK
        dfs("JFK");
        
        // The list is built in reverse, so we return it as is if using LinkedList
        return itinerary;
    }

    private void dfs(String airport) {
        // While there are still destinations to visit from the current airport
        while (adj.containsKey(airport) && !adj.get(airport).isEmpty()) {
            String nextAirport = adj.get(airport).poll();
            dfs(nextAirport);
        }
        // 3. Add the current airport to the itinerary list in post-order
        // Using addFirst to build the list in the correct order directly
        ((LinkedList<String>) itinerary).addFirst(airport); 
    }
}
