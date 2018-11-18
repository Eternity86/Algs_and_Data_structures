package Lesson7.Graphs;

import java.util.LinkedList;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DepthFirstPaths(Graph g, int source) {
        this.source = source;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int[g.getVertexCount()];
        dfs(g, source);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w:
                g.adjList(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    public boolean hasPathTo(int dest) {
        return marked[dest];
    }

    public LinkedList<Integer> pathTo(int dest) {
        if (!hasPathTo(dest)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();

        int vertex = dest;

        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

}