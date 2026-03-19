import org.w3c.dom.Node;

public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;
    private static class Node<E> {
        E value;
        Node<E> left, right;
        Node(E value) {this.value=value;}
    }
    public void insert(E value) {
        root = insertRecursive(root, value);
    }
    private Node<E> insertRecursive(Node<E> current, E value) {
        if (current == null) return new Node<>(value);
        if (value.compareTo(current.value) < 0)
            current.left = insertRecursive(current.left, value);
        else if (value.compareTo(current.value) > 0)
            current.right = insertRecursive(current.right, value);
        return current;
    }
    public E search(E value) {
        return searchRecursive(root, value);
    }
    private E searchRecursive(Node<E> current, E value) {
        if (current == null) return null;
        if (value.compareTo(current.value) == 0) return current.value;
        return value.compareTo(current.value) < 0 
            ? searchRecursive(current.left, value) 
            : searchRecursive(current.right, value);
        }
        public void inOrder() { 
        inOrderRecursive(root); 
        System.out.println();
        }
        private void inOrderRecursive(Node<E> node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.value + " ");
            inOrderRecursive(node.right);
        }
    }
}