import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class BST {

    private Node root;
    private int size;
    
    public boolean isEmpty() {
        return this.root == null;
    }

    public void addRecursivo(int element) {
        if (isEmpty())
            this.root = new Node(element);
        else 
            addRecursivo(this.root, element);

        this.size++;
    }

    private void addRecursivo(Node aux, int element) {
        if (element < aux.value) {
            if (aux.left == null) {
                Node newNode = new Node(element);
                aux.left = newNode;
                newNode.parent = aux;
                return;
            }

            addRecursivo(aux.left, element);
        }

        if (element > aux.value) {
            if (aux.right == null) {
                Node newNode = new Node(element);
                aux.right = newNode;
                newNode.parent = aux;
                return;
            }

            addRecursivo(aux.right, element);
        }
    }
    
    public ArrayList<Integer> search(int element) {
        return search(this.root, element);
    }

    private ArrayList<Integer> search(Node aux, int element) {
        ArrayList<Integer> path = new ArrayList<>();

        boolean achou = false;
        while (aux != null && !achou) {
            if (aux.value == element) 
                achou = true;

            if (aux.value > element) {
                path.add(aux.value);
                aux = aux.left;
            } else {
                path.add(aux.value);
                aux = aux.right;
            }
        }
        return path;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();

        int[] values = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int value = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < values.length; i++) 
            bst.addRecursivo(values[i]);

        System.out.println(bst.search(value));
    }
}


class Node {
    int value;
    Node left;
    Node right;
    Node parent;
    
    Node(int v) {
        this.value = v;
    }

    @Override
    public String toString() {
        return "" + value + "";
    }
}
