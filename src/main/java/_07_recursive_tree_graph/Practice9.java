package _07_recursive_tree_graph;

/**
 * Tree 말단노드까지의 까장 짧은 경로(DFS)
 */
public class Practice9 {
    Node root;

    public int DFS(int level, Node node) {
        if (node.lt == null && node.rt == null) {
            return level;
        }
        else {
            return Math.min(DFS(level + 1, node.lt), DFS(level + 1, node.rt));
        }
    }

    public static void main(String[] args) {
        Practice9 tree = new Practice9();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.DFS(0, tree.root));
    }
}
