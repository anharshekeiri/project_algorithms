package algraithms_project;
import java.text.DateFormat;

import java.util.*;

public class MHPrimAlg extends MSTAlgorithim {

    public MHPrimAlg(Graph graph) {
        super(graph);
    }

    public void DisplayResultingMST() {
        this.mst_cost = Find_MST();
        System.out.println("Cost of the minimum spanning tree in graph MHPrime : " + this.mst_cost);
    }

    public int Find_MST() {
        double StartTime = System.currentTimeMillis();
        boolean[] inHeap = new boolean[graph.verticesNO];
        ResultSet[] resultMST = new ResultSet[graph.verticesNO];
        int[] key = new int[graph.verticesNO];

        //create heapNode for all the vertices
        HeapNode[] heapNodes = new HeapNode[graph.verticesNO];
        for (int i = 0; i < graph.verticesNO; i++) {
            heapNodes[i] = new HeapNode();
            heapNodes[i].vertex = graph.verticies[i];
            heapNodes[i].vertex.label = graph.verticies[i].label;
            heapNodes[i].key = Integer.MAX_VALUE;
            resultMST[i] = new ResultSet();
            resultMST[i].parent.label = -1;
            inHeap[i] = true;
            key[i] = Integer.MAX_VALUE;
        }

        //decrease the key for the first index 
        heapNodes[0].key = 0;

        //add all the vertices to the MinHeap 
        minHeap minHeap = new minHeap(graph.verticesNO);
        //add all the vertices to priority queue 
        for (int i = 0; i < graph.verticesNO; i++) {
            minHeap.insert(heapNodes[i]);
        }

        //while minHeap is not empty 
        while (!minHeap.isEmpty()) {
            //extract the min 
            HeapNode extractedNode = minHeap.extractMin();

            //extracted vertex 
            int extractedVertex = extractedNode.vertex.label;
            inHeap[extractedVertex] = false;

            LinkedList< Edge> list = extractedNode.vertex.adjList;
            for (int i = 0; i < list.size(); i++) {

                Edge edge = list.get(i);

                if (inHeap[edge.target.label]) {
                    int destination = edge.target.label;
                    int newKey = edge.weight;
                    //check if updated key < existing key, if yes, update it
                    if (key[destination] > newKey) {
                        decreaseKey(minHeap, newKey, destination);
                        //update the parent node for destination 
                        resultMST[destination].parent.label = extractedVertex;
                        resultMST[destination].weight = newKey;
                        key[destination] = newKey;

                    }
                }
            }
        }
        double EndTime = System.currentTimeMillis();
        //print the total time consumed by the algorithm 
        System.out.println("Total runtime of Prim's Algorithm " + (EndTime - StartTime) + " ms.");

        int total_min_weight = 0;
        for (int i = 1; i < graph.verticesNO; i++) {
//     
            total_min_weight += resultMST[i].weight;
        }
        return total_min_weight;

    }

    public void decreaseKey(minHeap minHeap, int newKey, int vertex) {
        //get the index which key's needs a decrease; 
        int index = minHeap.indexes[vertex];

        //get the node and update its value 
        HeapNode node = minHeap.mH[index];
        node.key = newKey;
        minHeap.percolateUp(index);
    }

}
