package _09_Greedy_Algorithm;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main5_answer {
    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dist;

    public static int solution(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        dist[v] = 0;

        while(!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (dist[now] < nowCost) continue;
            for (Edge edge : graph.get(now)) {
                int newCost = nowCost + edge.cost;
                if (dist[edge.vex] > newCost) {
                    dist[edge.vex] = newCost;
                    pq.add(new Edge(edge.vex, newCost));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            int c = sc.nextInt();
            graph.get(f).add(new Edge(t, c));
        }

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        solution(1);

        for (int i = 1; i < dist.length; i++) {
            System.out.println(i + ": " + dist[i]);
        }
    }
}
