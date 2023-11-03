package _07_Recursive_Tree_Graph;

//그래프 최단거리 (BFS)
//6 9
//1 3
//1 4
//2 1
//2 5
//3 4
//4 5
//4 6
//6 2
//6 5

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class practice14 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] ch, dist;

    // dist 배열 사용
    public static void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(v);
        while(!Q.isEmpty()) {
            int cv = Q.poll();
            for (int nv : graph.get(cv)) {
                if (ch[nv] == 0) {
                    Q.offer(nv);
                    ch[nv] = 1;
                    dist[nv] = dist[cv] + 1;
                }
            }
        }
    }


    // 레벨 사용 -> 맞는지 잘 몰겠다
    public static void BFS2(int v) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(v);
        int l = 1;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int cv = Q.poll();
                for (int nv : graph.get(cv)) {
                    if (ch[nv] == 0) {
                        Q.offer(nv);
                        ch[nv] = 1;
                        dist[nv] = l;
                    }
                }
            }
            l++;
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);;
        n = kb.nextInt();
        m = kb.nextInt();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        ch= new int[n+1];
        dist = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        ch[1]=1;
        BFS2(1);

        for (int i = 1; i <= n; i++) {
            System.out.println(i + ": " + dist[i]);
        }
    }
}
