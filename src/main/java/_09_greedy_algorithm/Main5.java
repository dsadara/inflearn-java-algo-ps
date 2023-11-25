package _09_greedy_algorithm;

//  다익스트라 알고리즘
//6 9
//1 2 12
//1 3 4
//2 1 2
//2 3 5
//2 5 5
//3 4 5
//4 2 2
//4 5 5
//6 4 5

import java.util.*;

class Edge implements Comparable<Edge> {
    int vex;
    int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "vex=" + vex +
                ", cost=" + cost +
                '}';
    }
}

public class Main5 {
    static int n;
    static int m;
    static int[] v;
    static int[] dist;

    public static int BFS(ArrayList<ArrayList<Edge>> graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        dist[1] = 0;
        v[1] = 1;
        for (Edge edge : graph.get(1)) {
            pq.offer(edge);
            dist[edge.vex] = edge.cost;
        }

        while (!pq.isEmpty()) {
            Edge min = pq.poll();
            pq.clear();
            for (Edge edge : graph.get(min.vex)) {
                if (v[edge.vex] == 1) continue;
                pq.offer(edge);
                dist[edge.vex] = Math.min(dist[edge.vex], dist[min.vex] + edge.cost);
                v[edge.vex] = 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        v = new int[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            int cost = in.nextInt();
            graph.get(from).add(new Edge(to, cost));
        }

        BFS(graph);

        for (int i = 1; i < dist.length; i++) {
            System.out.println(i + " : " + dist[i]);
        }
    }

    private static void printGraph(ArrayList<ArrayList<Edge>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print("vex:" + i + " ");
            for (Edge edge : graph.get(i)) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }
}
