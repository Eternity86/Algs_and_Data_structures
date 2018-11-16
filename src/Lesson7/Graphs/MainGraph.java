package Lesson7.Graphs;

public class MainGraph {
    public static void main(String[] args) {
        int vertex = 10;
        Graph myGraph = new Graph(vertex);
        System.out.println(myGraph.getVertexCount());
        System.out.println(myGraph.getEdgeCount());
        myGraph.addEdge(0, 8);
        myGraph.addEdge(0, 9);
        myGraph.addEdge(8, 5);
        myGraph.addEdge(5, 9);
        myGraph.addEdge(9, 6);
        myGraph.addEdge(6, 7);
        myGraph.addEdge(6, 4);
        myGraph.addEdge(4, 1);
        myGraph.addEdge(4, 2);
        myGraph.addEdge(2, 3);
        System.out.println(myGraph.getEdgeCount());
        System.out.println(myGraph.adjList(0));
        BreadthFirstPaths bfs = new BreadthFirstPaths(myGraph, 0);
        System.out.println(bfs.pathTo(6));
        System.out.println(bfs.pathTo(1));
        System.out.println(bfs.distTo(7));
    }
}
