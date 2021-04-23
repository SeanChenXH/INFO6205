package Assignment8;

import java.util.*;

public class FindShortestPaths {

    public static void main(String[] args) {
        //Test 1
        Graph graph = new Graph();
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");

        node1.addEdge(node2, 7);
        node1.addEdge(node3, 9);
        node1.addEdge(node6, 14);

        node2.addEdge(node1, 7);
        node2.addEdge(node3, 10);
        node2.addEdge(node4, 15);

        node3.addEdge(node1, 9);
        node3.addEdge(node2, 10);
        node3.addEdge(node4, 11);
        node3.addEdge(node6, 2);

        node4.addEdge(node2, 15);
        node4.addEdge(node3, 11);
        node4.addEdge(node5, 6);

        node5.addEdge(node4, 6);
        node5.addEdge(node6, 9);

        node6.addEdge(node1, 14);
        node6.addEdge(node3, 2);
        node6.addEdge(node5, 9);

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);
        graph.addNode(node5);
        graph.addNode(node6);

        findShortestPaths(graph, node1);

    }

    public static void findShortestPaths(Graph graph, Node source) {

        //Check if the source vertex is existed
        if (!graph.nodes.contains(source)) {
            System.out.println("No Such Source Node Existed");
            return;
        }

        //Using a map to store the Shortest Path Distance
        HashMap<Node, Integer> distances = new HashMap<>();
        //Using a set to check if it is visited
        HashSet<Node> visited = new HashSet<>();

        //Initializing the distance
        for (Node node : graph.nodes) {
            if (node == source) {
                distances.put(node, 0);
            } else {
                distances.put(node, Integer.MAX_VALUE);
            }
        }

        Node currentNode = source;
        visited.add(currentNode);

        while (currentNode != null) {
            //Get the edges of current node
            LinkedList<Edge> neighborsNodes = currentNode.listEdges;

            //Update the reachable node's shortest path distance
            for (Edge edge : neighborsNodes) {
                Integer curEdgeDis = distances.get(currentNode) + edge.weight;
                Integer preEdgeDis = distances.get(edge.edgeNode);
                if (curEdgeDis < preEdgeDis) {
                    distances.put(edge.edgeNode, curEdgeDis);
                }
            }
            currentNode = getSmallestNode(distances, visited);
            visited.add(currentNode);
        }

        for (Node node : distances.keySet()) {
            System.out.println("Source Node(" + source.name + ") --> Node(" + node.name + ") distance: " + distances.get(node));
        }
    }

    public static Node getSmallestNode(HashMap<Node, Integer> distances, HashSet<Node> visited) {
        Node currentNode = null;

        for (Node node : distances.keySet()) {
            if (visited.contains(node)) {
                continue;
            } else {
                if (currentNode == null) {
                    currentNode = node;
                } else {
                    if (distances.get(currentNode) > distances.get(node)) {
                        currentNode = node;
                    }
                }
            }
        }

        return currentNode;
    }
}
