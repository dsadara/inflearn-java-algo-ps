package _08_dfs_bfs_practice;
/*
중복순열

입력예제 1
3 2
출력예제 1
1 1
1 2
1 3
2 1
2 2
2 3
3 1
*/

import java.util.Scanner;

public class Practice4 {
    static int[] pm;
    static int n, m;

    public static void DFS(int l) {
        if (l == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm[l] = i;
                DFS(l + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        pm = new int[m];
        DFS(0);
    }
}
