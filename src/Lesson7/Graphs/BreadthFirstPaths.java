package Lesson7.Graphs;

import java.util.LinkedList;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private int source;
    private static final int INF = Integer.MAX_VALUE;

    public BreadthFirstPaths(Graph g, int source) {
        this.source = source;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int[g.getVertexCount()];
        distTo = new int[g.getVertexCount()];

        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = INF;
        }
        bfs(g, source);
    }

    private void bfs(Graph g, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;
        distTo[source] = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w:
                    g.adjList(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    distTo[w] = distTo[vertex] + 1;
                    queue.addLast(w);
                }
            }
        }
    }

    private boolean hasPathTo(int destination) {
        return marked[destination];
    }

    public LinkedList<Integer> pathTo(int destination) {
        if (!hasPathTo(destination)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();

        int vertex = destination;

        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

    public int distTo(int destination) {
        return distTo[destination];
    }

}