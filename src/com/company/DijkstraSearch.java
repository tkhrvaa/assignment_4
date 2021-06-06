package com.company;
import java.lang.String;
import java.util.*;

public class DijkstraSearch<V> extends Search {
    private Set<Vertex> unsettledNodes;
    private Map<Vertex, Double> distances;
    private WeightedGraph graph;

    public DijkstraSearch(WeightedGraph graph, Vertex source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;
        dijkstra();
    }

    public void dijkstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (unsettledNodes.size() > 0) {
            Vertex node =  getVertexWithMinimumWeight(unsettledNodes);
            marked.add(node);
            unsettledNodes.remove(node);
            for (Edge target : graph.getVertexList(node)) {
                if (getShortestDistance(target.getDest()) > getShortestDistance(node)
                        + getDistance(node, target.getDest())) {
                    distances.put(target.getDest(), getShortestDistance(node)
                            + getDistance(node, target.getDest()));
                    edgeTo.put(target.getDest(), node);
                    unsettledNodes.add(target.getDest());
                }
            }
        }
    }

    private double getDistance(Vertex node, Vertex target) {
        for (Object dest : (List)graph.getEdges(node)) {
            Edge edge = (Edge)dest;
            if (edge.getDest().equals(target))
                return edge.getWeight();
        }

        throw new RuntimeException("Not found!");
    }

    private Vertex getVertexWithMinimumWeight(Set<Vertex> vertices) {
        Vertex minimum = null;
        for (Vertex vertex : vertices) {
            if (minimum == null)
                minimum = vertex;
            else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum))
                    minimum = vertex;
            }
        }
        return minimum;
    }

    private double getShortestDistance(Vertex destination) {
        Double d = distances.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }
}
