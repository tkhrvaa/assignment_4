package com.company;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

public class WeightedGraph {

    private Map<Vertex , List<Edge>> graphMap;

//    private WeightedGraph(Map<Vertex, List<Edge> graphMap) {
//        this.graphMap = graphMap;
//    }

    WeightedGraph() {
        graphMap = new HashMap<>();
    }

    public Map<Vertex, List<Edge>> getGraphMap() {
        return graphMap;
    }

    public List<Edge> getVertexList(Vertex vertex) {
        return graphMap.get(vertex);
    }

    public void setGraphMap(Map<Vertex, List<Edge>> graphMap) {
        this.graphMap = graphMap;
    }

    public void addVertex(Vertex vertex) {
        graphMap.putIfAbsent(vertex , new ArrayList<>());
    }

    public void removeVertex(Vertex vertex) {
        graphMap.values()
                .stream()
                .map(e -> e.remove(vertex))
                .collect(Collectors.toList());
        graphMap.remove(vertex);
    }

    public void addEdge(Edge edge) {
        graphMap.get(edge.getSource()).add(new Edge(edge.getDest(), edge.getDest(), edge.getWeight()));
    }

    public void removeEdge(Edge edge) {
        graphMap.get(edge.getSource()).remove(edge.getDest());
        graphMap.get(edge.getDest()).remove(edge.getSource());
    }
    public boolean hasVertex(Vertex v) {
        return graphMap.containsKey(v);
    }

    public Edge getEdges(Vertex v) {
        if (!hasVertex(v)) return null;
        return graphMap.get(v).get(0);
    }

    public static class Builder {

        private WeightedGraph graph;
        private static WeightedGraph.Builder builder;

        private Builder() {
            graph = new WeightedGraph();
        }

        public static Builder getInstance() {
            if (builder == null) builder = new Builder();
            return builder;
        }

        public Builder setVertexes(Vertex... vertexes) {
            Arrays.stream(vertexes).forEach((vertex) -> graph.addVertex(vertex));
            return builder;
        }

        public Builder setEdges(Edge... edges) {
            Arrays.stream(edges).forEach((edge -> graph.addEdge(edge)));
            return builder;
        }

        public WeightedGraph build() {
            return graph;
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj != null) {
            if (obj.getClass() == this.getClass())
                equals = this.hashCode() == obj.hashCode();
        }
        return equals;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
