package _07_recursive_tree_graph;

import java.util.Scanner;

/**
 * 팩토리얼 - 재귀사용
 */

public class Practice3 {

    public int DFS(int n) {
        if (n == 1) return 1;
        return n * DFS(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Practice3 practice = new Practice3();
        System.out.println(practice.DFS(n));
    }

}
