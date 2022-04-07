
package algraithms_project;
import java.sql.*;
import java.util.*;
import java.text.DateFormat;
/**
 *
 * @author WEN 10
 */
public class PQPrimAlg extends MSTAlgorithim {
    
    public PQPrimAlg(Graph graph) {
        super(graph);
    }
     
    @Override
    public void DisplayResultingMST() {
        this.mst_cost = Find_MST();
        System.out.println("Cost of the minimum spanning tree in graph PQ : "+this.mst_cost);

    }
    
    public int Find_MST()
    {
        int mst_cost = 0;
         // Comparator lambda function that enables the priority queue to store the nodes
        // based on the cost in the ascending order.
        Comparator<Edge> NodeComparator = (obj1, obj2) -> {
            return obj1.weight - obj2.weight;
        };

        // Priority queue stores the object node-cost into the queue with 
        // the smallest cost node at the top.
        PriorityQueue<Edge> pq = new PriorityQueue<>(NodeComparator);

        // The cost of the source node to itself is 0
        pq.add(new Edge(null, graph.verticies[0], 0));
        boolean isFirst = true;
        while (!pq.isEmpty()) 
        {
            // Select the item <node, cost> with minimum cost
            Edge item = pq.peek();
            pq.remove();

            int node = item.target.label;
            int cost = item.weight;

            // If the node is node not yet added to the minimum spanning tree, add it and increment the cost.
            if ( !graph.verticies[node].isVisited ) {
                if(!isFirst)
                {
                    MSTresultList.add(item);
                }
                mst_cost += cost;
                graph.verticies[node].isVisited = true;

                // Iterate through all the nodes adjacent to the node taken out of priority queue.
                // Push only those nodes (node, cost) that are not yet present in the minumum spanning tree.
                for(int i = 0 ; i < graph.verticies[node].adjList.size() ; i++)
                {
                    Edge pair_edge = graph.verticies[node].adjList.get(i);
                    int adj_node = pair_edge.target.label;
                    if (graph.verticies[adj_node].isVisited == false) {
                         pq.add(pair_edge);
                     }
                }
            }
            isFirst = false;
        }
        return mst_cost;
    }
}