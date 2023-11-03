package _07_Recursive_Tree_Graph;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 피보나치 재귀 - 일반버전, 메모이제이션
 */
public class practice4 {
    public static int DFS(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }
        return DFS(n - 2) + DFS(n - 1);
    }

    static int[] fibo;
    public static int DFS_Memoization(int n) {
        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else
            return fibo[n] = DFS_Memoization(n - 2) + DFS_Memoization(n - 1);
    }

    public static int DFS_Memoization_fast(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }
        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else
            return fibo[n] = DFS_Memoization_fast(n - 2) + DFS_Memoization_fast(n - 1);
    }

    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        int n = 45;

        // 일반
        watch.start();
        for (int i = 1; i <= n; i++) {
            System.out.print(DFS(i) + " ");
        }
        watch.stop();
        System.out.println("\nTime Elapsed: " + watch.getTime());

        // 메모이제이션
        watch.reset();
        watch.start();
        fibo = new int[n + 1];
        DFS_Memoization(n);
        for (int i = 1; i < fibo.length; i++) {
            System.out.print(fibo[i] + " ");
        }
        watch.stop();
        System.out.println("\nTime Elapsed: " + watch.getTime());

        // 메모이제이션 개선
        watch.reset();
        watch.start();
        fibo = new int[n + 1];
        DFS_Memoization_fast(n);
        for (int i = 1; i < fibo.length; i++) {
            System.out.print(fibo[i] + " ");
        }
        watch.stop();
        System.out.println("\nTime Elapsed: " + watch.getTime());
    }
}
