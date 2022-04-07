package algraithms_project;

import java.util.Random;
import java.text.DateFormat;

/**
 *
 * @author WEN 10
 */
public class Graph {

    int verticesNO;
    int edgeNO;
    Vertex[] verticies;
    boolean isDigraph;

    Graph(int edgeNO, int verticesNO, boolean isDigraph) {
        this.edgeNO = edgeNO;
        this.verticesNO = verticesNO;
        this.isDigraph = isDigraph;

        this.verticies = new Vertex[verticesNO];
        for (int i = 0; i < verticesNO; i++) {

            verticies[i] = new Vertex(i);
        }
     
      
    }

    public void makeGraph() {
        Random random = new Random();

        for (int i = 0; i < verticesNO - 1; i++) {
            int w = random.nextInt(20) + 1;
            addEdge(verticies[i], verticies[i + 1], w);
        }

        int remainingEdges = edgeNO - verticesNO - 1;

        for (int i = 0; i < remainingEdges; i++) {
            // select random source vertex and random target vertex

            Vertex source = verticies[random.nextInt(verticesNO)];
            Vertex target = verticies[random.nextInt(verticesNO)];
            // create random weight
            int weight = random.nextInt(20) + 1;
            // make sure the source and target are not equal AND they do not exist 
            if ((source == target) || checkIfEdgeExists(source, target)) {
                // decrement the counter to try again a different combination
                i--;

            } else {
                addEdge(source, target, weight);
            }

        }

    }

    public void addEdge(Vertex source, Vertex target, int w) {
        Edge edge = new Edge(source, target, w);
        source.adjList.add(edge);

        // in the case of undirected graph, add the edge to target as well
        if (!isDigraph) {
            edge = new Edge(target, source, w);
            target.adjList.add(edge);
        }

    }

    private boolean checkIfEdgeExists(Vertex source, Vertex target) {
        //cheak if the edge between target and source its exsist or not 
//نشيك على ادج موجود بين سورس و تارغت و سوينا بس تشيك وحده لانو هوا فوق لازم يضيف اول ادج ف لو مافي الاول يعني مافي ثاني   
        for (Edge edge : source.adjList) {
            if (edge.target == target) {
                return true;
            }
        }

        return false;

    }

    public void printGraph() {
        String graphType = isDigraph ? "Directed" : "Undirected";
        System.out.println(graphType + "Graph with " + verticesNO + " verticies and " + edgeNO + " edges");
        for (Vertex v : verticies) {
            for (Edge e : v.adjList) {
                System.out.println(e.source.label + "->" + e.target.label + "(w=" + e.weight + ")");
            }
        }
    }
}
