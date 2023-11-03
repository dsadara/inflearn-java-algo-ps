package _07_Recursive_Tree_Graph;

public class practice5 {
    Node root;
    public static void DFS(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.data + " ");  // 전위순회
            DFS(root.lt);
//            System.out.print(root.data + " ");    // 중위순회
            DFS(root.rt);
//            System.out.print(root.data + " ");    // 후위순회
        }
    }

    public static void main(String[] args) {
        practice5 tree = new practice5();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }
}
