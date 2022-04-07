
package algraithms_project;

import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;

/**
 *
 * @author WEN 10
 */
abstract class MSTAlgorithim {

    Graph graph;
    ArrayList<Edge> MSTresultList = new ArrayList<>();
    int mst_cost;

    public MSTAlgorithim(Graph graph) {
        this.graph = graph;

    }

   public abstract void DisplayResultingMST();
    
}
