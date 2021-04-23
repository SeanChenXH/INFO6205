package Assignment8;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

    public LinkedList<Node> nodes;

    public Graph() {
        nodes = new LinkedList<Node>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

}
