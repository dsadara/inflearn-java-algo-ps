package _10_dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    static int[] coin;
    static int n;
    static int m;
    static int[] dy;

    public static int solution() {
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j - coin[i]] + 1, dy[j]);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        m = sc.nextInt();
        dy = new int[m+1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        System.out.println(solution());
    }
}
