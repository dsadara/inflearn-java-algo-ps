package _07_recursive_tree_graph;

/**
 * 재귀함수로 1에서 n 까지 숫자 출력하기
 */

public class Practice1 {
    public static void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
        return;
    }

    public static void main(String[] args) {
        DFS(10);
    }
}
