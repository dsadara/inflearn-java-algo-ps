package _07_recursive_tree_graph;

/**
 * 부분집합 구하기 - 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 부분집합을 모두 출력
 */
public class Practice6 {
    static int[] check;
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void DFS(int level) {
        if (level == n + 1) {
            sb.setLength(0);
            for (int i = 1; i <= n; i++) {
                if (check[i] == 1) {
                    sb.append(i);
                }
            }
            System.out.println(sb);
            return;
        } else {
            check[level] = 1;
            DFS(level + 1);
            check[level] = 0;
            DFS(level + 1);
        }
    }

    public static void main(String[] args) {
        n = 3;
        check = new int[n + 1];
        DFS(1);
    }
}
