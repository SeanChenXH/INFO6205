package Assignment8;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    public String name;
    public LinkedList<Edge> listEdges = new LinkedList<Edge>();

    public Node(String name) {
        this.name = name;
    }

    public void addEdge(Node edgeNode, int weight) {

        for (Edge edge : listEdges) {
            if (edge.edgeNode == edgeNode) {
                return;
            }
        }
        Edge edge = new Edge(edgeNode, weight);
        listEdges.add(edge);
    }
}
