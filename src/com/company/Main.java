package com.company;

public class Main {

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        Vertex source1 = new Vertex("Almaty");
        Vertex dest1 = new Vertex("Astana");
        Edge edge = new Edge(source1, dest1, 2.1);
        graph.addEdge(edge);
        Vertex source2 = new Vertex("Almaty");
        Vertex dest2 = new Vertex("Shymkent");
        edge = new Edge(source2, dest2, 7.2);
        graph.addEdge(edge);
        Vertex source3 = new Vertex("Shymkent");
        Vertex dest3 = new Vertex("Astana");
        edge = new Edge(source3, dest3, 3.9);
        graph.addEdge(edge);
        Vertex source4 = new Vertex("Astana");
        Vertex dest4 = new Vertex("Kostanay");
        edge = new Edge(source4, dest4, 7.2);
        graph.addEdge(edge);
        Vertex source5 = new Vertex("Almaty");
        Vertex dest5 = new Vertex("Shymkent");
        edge = new Edge(source5, dest5, 5.4);
        graph.addEdge(edge);
        Vertex expSource = new Vertex("Almaty");
        System.out.println("Dijkstra:");
        Search djk = new DijkstraSearch(graph, expSource);
        Vertex key = new Vertex("Kyzylorda");
        outputPath(djk, key);
    }
    public static void outputPath(Search search, Vertex key) {
        for (Vertex v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
    }
}
