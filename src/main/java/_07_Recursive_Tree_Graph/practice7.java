package _07_Recursive_Tree_Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 이진트리 순회 - BFS
 */
public class practice7 {
    Node root;
    public void BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            System.out.print(level + ": ");
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) q.offer(cur.lt);
                if (cur.rt != null) q.offer(cur.rt);

            }
            level++;
            System.out.println();
        }
        return;
    }
    public static void main(String[] args) {
        practice7 tree = new practice7();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
