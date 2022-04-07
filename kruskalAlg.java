package algraithms_project;

/**
 *
 * @author mada7
 */
import java.util.*;
import java.text.DateFormat;

public class kruskalAlg extends MSTAlgorithim {

    PriorityQueue<Edge> PriortQ = new PriorityQueue<>
            (Comparator.comparingInt(o -> o.weight));
    
    public kruskalAlg(Graph graph) {
        super(graph);
    }
    
    @Override
    public void DisplayResultingMST() {
        this.mst_cost = Find_MST();
        System.out.println("Cost of the minimum spanning tree in graph Krauskal : "+this.mst_cost);

    }
    
    public int Find_MST()
    {
        MSTresultList = new ArrayList<>();

        Add_To_PQ();

        Edge[] parent = new Edge[graph.verticies.length];
        for (int i = 0; i < graph.verticies.length; i++) {
            parent[i] = new Edge();
        }
        
        make_Set(parent);
        int index = 0;
        int cost = 0 ;
        while (index < graph.verticesNO - 1 && !PriortQ.isEmpty()) {
            Edge edge = PriortQ.remove();

            int source = Edge.Find_Parent(parent, edge.source.label);
            int target = Edge.Find_Parent(parent, edge.target.label);

            if (source != target) {
                MSTresultList.add(new Edge(edge.source, edge.target, edge.weight));                
                cost += edge.weight;
                index++;
                union(parent, source, target);
            }
        }
        return cost;
    }

    public void Add_To_PQ()
    {
        for(Vertex vertex : graph.verticies)
        {
            for(Edge edge : vertex.adjList)
            {
                PriortQ.add(edge);
            }
        }
    }
    
    public void make_Set(Edge[] parent) {
        for (int i = 0; i < parent.length; i++) {
            parent[i].source = new Vertex();
            parent[i].source.label = i;
        }
    }
    
    public void union(Edge[] parent, int source, int target) {
        int s_parent = Edge.Find_Parent(parent, source);
        int t_parent = Edge.Find_Parent(parent, target);
        //make source as parent of target
        parent[t_parent].source.label = s_parent;
    }

}
