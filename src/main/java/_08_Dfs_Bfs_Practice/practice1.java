package _08_Dfs_Bfs_Practice;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 1. 합이 같은 부분집합(DFS : 아마존 인터뷰)
 * 설명
 *
 * N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
 *
 * 두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
 *
 * 둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
 *
 * 예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.
 *
 *
 * 입력
 * 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
 *
 * 두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.
 *
 *
 * 출력
 * 첫 번째 줄에 “YES" 또는 ”NO"를 출력한다.
 *
 *
 * 예시 입력 1
 *
 * 6
 * 1 3 5 6 7 10
 * 예시 출력 1
 *
 * YES
 */

public class practice1 {
    static int[] ch;
    static int[] arr;
    static int n;
    static Boolean isSame = false;

    public static void DFS(int level) {
        if (level == n + 1) {
            int sub1 = 0;
            int sub2 = 0;
            for (int i = 1; i < ch.length; i++) {
                if (ch[i] == 1) sub1 += arr[i];
                else sub2 += arr[i];
            }
            if (sub1 == sub2) isSame = true;
            return;
        } else {
            ch[level] = 1;
            DFS(level + 1);
            ch[level] = 0;
            DFS(level + 1);
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        ch = new int[n + 1];
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }
        DFS(1);
        if (isSame) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
