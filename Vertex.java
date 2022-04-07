
package algraithms_project;

import java.util.LinkedList;
import java.text.DateFormat;

/**
 *
 * @author WEN 10
 */
public class Vertex {

    public boolean isVisited = false;

    int label;

    // TODO: confirm with doctor
    Vertex parent = this;

    LinkedList<Edge> adjList = new LinkedList<>();

    Vertex(int label) {

        this.label = label;

    }
    public Vertex() {
       this.adjList= new LinkedList<Edge>();
      
      
       }

  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.label;
        return hash;
    }

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
        final Vertex other = (Vertex) obj;
        if (this.label != other.label) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vertex{" + "label=" + label + '}';
    }

}
