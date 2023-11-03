package _08_Dfs_Bfs_Practice;

import java.util.Scanner;

/**
 * 7. 조합의 경우수(메모이제이션)
 * 설명
 *
 * Image1.jpg로 계산합니다.
 *
 * 하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
 *
 * Image1.jpg
 *
 *
 * 입력
 * 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
 *
 *
 * 출력
 * 첫째 줄에 조합수를 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * 5 3
 *
 * 예시 출력 1
 *
 * 10
 *
 * 예시 입력 2
 *
 * 33 19
 *
 * 예시 출력 2
 *
 * 818809200
 */

public class practice7_combi_num {
    static int n;
    static int r;
    static int[][] combi;

    public static int DFS(int n, int r) {
        if (combi[n][r] != 0) {
            return combi[n][r];
        }
        if (n == r || r == 0) {
           return 1;
        } else {
            combi[n-1][r-1] = DFS(n - 1, r - 1);
            combi[n-1][r] = DFS(n-1, r);
            return combi[n-1][r-1] + combi[n-1][r];
        }
    }

    public static int DFS2(int n, int r) {
        if (combi[n][r] > 0) return combi[n][r];
        if (n == r || r == 0) return 1;
        else return combi[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        r = in.nextInt();
        combi = new int[n + 1][n + 1];
        System.out.println(DFS2(n, r));
    }
}
