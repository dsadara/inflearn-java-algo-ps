package _08_dfs_bfs_practice;

import java.util.Scanner;

/**
 * 조합 구하기
 */
public class Practice9_Combi {
    static int[] combi;
    static int N, M;

    public static void DFS(int L, int S) {
        if (L == M) {
            for (int x : combi) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = S; i <= N; i++) {
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        combi = new int[M];
        DFS(0, 1);
    }
}
