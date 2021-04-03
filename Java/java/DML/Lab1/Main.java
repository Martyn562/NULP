package DML.Lab1;

import java.util.*;

public class Main {

    public static long mst(List<Edge>[] edges, int[] pred) {
        int n = edges.length;
        Arrays.fill(pred, -1);
        boolean[] vis = new boolean[n];
        int[] prio = new int[n];
        Arrays.fill(prio, Integer.MAX_VALUE);
        prio[0] = 1;
        Queue<QItem> q = new PriorityQueue<QItem>();
        q.add(new QItem(0, 0));
        long res = 0;
        while (!q.isEmpty()) {
            QItem cur = q.poll();
            int u = cur.u;
            if (vis[u])
                continue;

            vis[u] = true;
            res += cur.prio;
            for (Edge e : edges[u]) {
                int v = e.t;
                if (!vis[v] && prio[v]>e.cost)
                {
                    prio[v] = e.cost;
                    pred[v] = u;
                    q.add(new QItem(prio[v], v));
                }
            }
        }
        return res;
    }

    static class Edge {
        int t, cost;

        public Edge(int t, int cost) {
            this.t = t;
            this.cost = cost;
        }
    }

    static class QItem implements Comparable<QItem> {
        int prio;
        int u;

        public QItem(int prio, int u) {
            this.prio = prio;
            this.u = u;
        }

        public int compareTo(QItem q) {
            return prio < q.prio ? -1 : prio > q.prio ? 1 : 0;
        }
    }

    // Usage example
    public static void main(String[] args) {
        int[][] cost = {{0, 3, 0, 0, 0, 34, 0, 80},
                {3, 0, 0, 1, 0, 0, 0, 68},
                {0, 0, 0, 0, 23, 0, 12, 0},
                {0, 1, 0, 0, 53, 0, 0, 39},
                {0, 0, 23, 53, 0, 0, 68, 14},
                {34, 0, 0, 0, 0, 0, 0, 25},
                {0, 0, 12, 0, 68, 0, 0, 99},
                {80, 68, 0, 39, 14, 25, 99, 0}};

        int n = cost.length;
        List<Edge>[] edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<Edge>();
            for (int j = 0; j < n; j++) {
                if (cost[i][j] != 0) {
                    edges[i].add(new Edge(j, cost[i][j]));
                }      }    }
        long res = mst(edges, new int[n]);System.out.println("\n");
        System.out.println("\nMinimum Weight Spanning Tree: ");
        System.out.println(res);
    }
}