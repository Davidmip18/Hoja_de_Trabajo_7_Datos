class TreeNode<E> {
    E data;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTree<E extends Comparable<E>> {
    private TreeNode<E> root;

    public BinaryTree() {
        root = null;
    }

    // Método para insertar
    public void insert(E data) {
        root = insertRec(root, data);
    }

    private TreeNode<E> insertRec(TreeNode<E> root, E data) {
        if (root == null) {
            root = new TreeNode<>(data);
            return root;
        }
        if (data.compareTo(root.data) < 0)
            root.left = insertRec(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = insertRec(root.right, data);
        return root;
    }

    // Método para buscar
    public E search(E data) {
        return searchRec(root, data);
    }

    private E searchRec(TreeNode<E> root, E data) {
        if (root == null || root.data.compareTo(data) == 0)
            return root != null ? root.data : null;
        if (root.data.compareTo(data) < 0)
            return searchRec(root.right, data);
        return searchRec(root.left, data);
    }

    // Recorrido In-Order
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(TreeNode<E> root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }
}
