package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jindalh on 1/4/17.
 */
public class dijkstra {
    public static void dijkstra(int graph[][], int src, int V) throws Exception {
        int dist[][] = new int[V][V];

        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[src][src] = 0;

        // while all nodes are settled
        Set<Integer> settled = new HashSet<>();
        while (settled.size() < V) {

            int minD = Integer.MAX_VALUE;
            int vertex = -1;
            // find node with min dist from src
            for (int i = 0; i < V; ++i) {
                if (!settled.contains(i) && dist[src][i] < minD) {
                    minD = dist[src][i];
                    vertex = i;
                }
            }

            if (vertex == -1) throw new Exception();

            settled.add(vertex);

            // update distance matrix
            for (int i = 0; i < V; ++i) {
                if (dist[src][vertex] + graph[vertex][i] < dist[src][i]) {
                    dist[src][i] = dist[src][vertex] + graph[vertex][i];
                }
            }
        }

        for (int i=0; i<V; ++i) {
            System.out.print(dist[src][i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        int V = 3;
        int graph[][] = {
                {0, 1, 43},
                {1, 0, 6},
                {43, 6, 0}
        };
        dijkstra(graph, 0, V);
    }
}
