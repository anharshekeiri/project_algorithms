
package algraithms_project;

import java.util.Objects;
import java.text.DateFormat;

public class Edge {

    int weight;
    Vertex source;
    Vertex target;

    Vertex parent;
   

    public Edge() {
    }

    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
       
        this.parent = source;
     
    }
    //find root if lable equle the job is done if not do the recrsion 
    public static int Find_Parent(Edge[] parent, int vertex) {
        if (parent[vertex].source.label == vertex) {
            return vertex;
        }
        return Find_Parent(parent, parent[vertex].source.label);
    }


    @Override
    public String toString() {
        return source + "-" + target + ": w =" + weight;
    }

 
//change the equle to do the right comparimg if we need 
    @Override
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge other = (Edge) obj;
        if (!Objects.equals(this.source, other.source)) {
            return false;
        }
        if (!Objects.equals(this.target, other.target)) {
            return false;
        }
        return true;
    }

}
