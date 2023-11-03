package _07_Recursive_Tree_Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Tree 말단노드까지의 까장 짧은 경로(DFS)
 */

public class practice10 {
    Node root;

    public int BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node node = q.poll();
                if (node.lt == null && node.rt == null) return level;
                if (node.lt != null) q.offer(node.lt);
                if (node.rt != null) q.offer(node.rt);
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        practice10 tree = new practice10();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(tree.root));
    }
}
