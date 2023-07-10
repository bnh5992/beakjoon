import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        public static String preOrder = "";
        public static String midOrder = "";
        public static String backOrder = "";
        String root;
        Node left, right;

        public Node(String root, Node left, Node right) {
            this.root = root;
            this.left = left;
        }

        public void addLeft(Node node) {
            left = node;
        }

        public void addRight(Node node) {
            right = node;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String root = st.nextToken();
        String right = st.nextToken();
        String left = st.nextToken();
        Node node = new Node(root, null, null);
        addTree(right, node, root, false);
        addTree(left, node, root, false);

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            root = st.nextToken();
            right = st.nextToken();
            left = st.nextToken();
            try {
                if(right.equals(".") && !left.equals(".")){
                    addTree(right, node, root, false);
                    addTree(left, node, root, true);
                }
                else{
                    addTree(right, node, root, false);
                    addTree(left, node, root, false);
                }

            } catch (Exception e) {

            }
        }
        preOrder(node);
        midOrder(node);
        backOrder(node);
        System.out.println(node.preOrder);
        System.out.println(node.midOrder);
        System.out.println(node.backOrder);

    }

    public static void addTree(String root, Node node, String target, boolean isEmpty) {
        if (node.root.equals(target)) {
            if (node.left == null && !root.equals(".")) {
                if (!isEmpty) {
                    node.addLeft(new Node(root, null, null));
                } else {
                    node.addRight(new Node(root, null, null));
                }
                return;
            } else {
                isEmpty = true;
            }
            if (node.right == null && !root.equals(".")) {
                node.addRight(new Node(root, null, null));
                return;
            }
        }
        if (node.left != null) {
            addTree(root, node.left, target, isEmpty);
        }
        if (node.right != null) {
            addTree(root, node.right, target, isEmpty);

        }
    }

    public static void preOrder(Node node) {
        boolean isFind = false;
        if (node.left != null) {
            node.preOrder += node.root;
            isFind = true;
            preOrder(node.left);
        }

        if (node.right != null) {
            if (!isFind) node.preOrder += node.root;
            preOrder(node.right);
        }

        if (node.left == null && node.right == null) {
            node.preOrder += node.root;
        }
    }

    public static void midOrder(Node node) {
        boolean isFind = false;
        if (node.left == null && node.right == null) {
            node.midOrder += node.root;
        }
        if (node.left != null) {
            midOrder(node.left);
            node.midOrder += node.root;
            isFind = true;
        }

        if (node.right != null) {
            if (!isFind) node.midOrder += node.root;
            midOrder(node.right);
        }
    }

    public static void backOrder(Node node){
        if(node.left != null){
            backOrder(node.left);
            if(node.right == null){
                node.backOrder += node.root;
            }
        }
        if (node.left == null && node.right == null) {
            node.backOrder += node.root;
            return;
        }
        if(node.right != null){
            backOrder(node.right);
            node.backOrder += node.root;
        }
    }
}