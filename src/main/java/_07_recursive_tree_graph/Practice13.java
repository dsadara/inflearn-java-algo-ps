package _07_recursive_tree_graph;

//  경로탐색 DFS (인접리스트)
//  입력예제
//  5 9
//  1 2
//  1 3
//  1 4
//  2 1
//  2 3
//  2 5
//  3 4
//  4 2
//  4 5
//

import java.util.ArrayList;
import java.util.Scanner;

public class Practice13 {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] ch;

    public static void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (Integer nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
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
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        ch[1]=1;
        DFS(1);
        System.out.println(answer);
    }
}
