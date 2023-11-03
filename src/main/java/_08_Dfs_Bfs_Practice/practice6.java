package _08_Dfs_Bfs_Practice;

//순열 구하기
//
//입력예제 1
//3 2
//3 6 9
//
//출력예제 1
//3 6
//3 9
//6 3
//6 9
//9 3
//9 6

import java.util.Scanner;

public class practice6 {
    static int[] pm;
    static int[] arr;
    static int[] ch;
    static int n, m;

    public static void DFS(int l) {
        if (l == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[l] = arr[i];
                    DFS(l+1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        pm = new int[m];
        arr = new int[n];
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        DFS(0);
    }
}
