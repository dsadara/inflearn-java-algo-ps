package _08_dfs_bfs_practice;

import java.util.Scanner;

public class Practice1_Answer {
    static String isSame = "NO";
    static int n;
    static int total = 0;
    static Boolean flag = false;

    public static void DFS(int sum, int[] arr, int l) {
        if (flag) return;
        if (sum > total / 2)  return;
        if (l == n) {
            if ((total - sum) == (total / 2)) {
                flag = true;
                isSame = "YES";
            }
            return;
        } else {
            DFS(sum + arr[l], arr, l + 1);
            DFS(sum, arr, l + 1);
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            total += arr[i];
        }
        DFS(0, arr, 0);
        System.out.println(isSame);
    }
}
