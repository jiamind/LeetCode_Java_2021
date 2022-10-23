import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 133. Clone Graph
 */
public class CloneGraph {
    public class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // Queue for the to-be-processed node in the original graph
        // Each original node in the queue should have a copy in the map (see below)
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        // Set for processed node values
        // processed means the node was copied and connected to its neighbors
        Set<Integer> visited = new HashSet<>();

        Node result = new Node(node.val);
        // Map to locate the copied node by its value
        Map<Integer,Node> map = new HashMap<>();
        map.put(result.val, result);

        while(!queue.isEmpty()) {
            // Get the node to be processed
            Node originNode = queue.poll();

            // If the node is already processed, skip it
            if (visited.contains(originNode.val)) continue;

            // Get the copied node from the map. It should already exist
            Node copyNode = map.get(originNode.val);

            // Mark the value of the node as visited
            // Since we copied it and going to connect it to its neighbors below
            visited.add(copyNode.val);

            // Iterate through the neighors of the original node
            for (Node neighbor : originNode.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    // The neighbor node was never copied. 
                    // So create a copy and put it into the map
                    // Then add the copied neighbor to the current copied node
                    Node copyNeighbor = new Node(neighbor.val);
                    map.put(neighbor.val, copyNeighbor);
                    copyNode.neighbors.add(copyNeighbor);
                } else {
                    // The neighbor node was copied before
                    // Get the copied node from the map
                    // Then add the copied neighbor to the current copied node
                    Node copyNeighbor = map.get(neighbor.val);
                    copyNode.neighbors.add(copyNeighbor);
                }

                // Add this neighbor into the queue to be processed
                queue.add(neighbor);
            }
        }

        return result;
    }
}
