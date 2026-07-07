import java.util.ArrayList;

public class BST {

    private Node root;
    private int size;
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
        this.size += 1;
        if (isEmpty())
            this.root = new Node(element);
        else {
            
            Node aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
    }

    /**
     * Implementação recursiva da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
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

    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * recursiva clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node search(int element) {
        return search(this.root, element);
    }

    private Node search(Node aux, int element) {
        if (aux == null)
            return null;

        if (element == aux.value) 
            return aux;

        if (element < aux.value)
            return search(aux.left, element);

        return search(aux.right, element);
    }

    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }

    public Node min() {
        if (isEmpty())
            return null;
        return min(this.root);
    }

    private Node min(Node aux) {
        if (aux.left != null)
            return min(aux.left);
        return aux;
    }

    public Node max() {
        if (isEmpty())
            return null;
        return max(this.root);
    }

    private Node max(Node aux) {
        if (aux.right != null)
            return max(aux.right);
        return aux;
    }

    public Node sucessor(int element) {
        Node aux = search(element);

        if (aux == null) 
            return null;

        if (aux.right != null) 
            return min(aux.right);

        return sucessor(aux, aux.parent);
    }

    private Node sucessor(Node node, Node parent) {
        if (parent == this.root && parent.value < node.value)
            return null;

        if (parent.value < node.value) 
            return sucessor(parent, parent.parent);

        return parent;
    }

    public Node predecessor(int element) {
        Node aux = search(element);

        if (aux == null) 
            return null;

        if (aux.left != null) 
            return max(aux.left);

        return predecessor(aux, aux.parent);
    }

    private Node predecessor(Node node, Node parent) {
        if (parent == this.root && parent.value > node.value)
            return null;

        if (parent.value > node.value) 
            return predecessor(parent, parent.parent);

        return parent;
    }
    
    /**
     * Retorna a altura da árvore.
     */
    public int height() {
        return height(this.root);
    }

    private int height(Node node) {
        if (node == null) 
            return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public void remove(int element) {
        remove(search(element));
    }

    private void remove(Node node) {
        if (node == null) return;

        if (node.right == null && node.left == null) {
            removeLeaf(node);
            return;
        }

        if (hasOnlyLeftChild(node)) {
            removeLeftChild(node);
            return;
        }

        if (hasOnlyRightChild(node)) {
            removeRightChild(node);
            return;
        }

        if (node.left != null && node.right != null) {
            Node aux = sucessor(node.value);
            node.value = aux.value;
            remove(aux);
        }
    }

    private void removeLeaf(Node node) {
        if (node == this.root) {
            this.root = null;
            return;
        }

        if (node.value < node.parent.value) {
            node.parent.left = null; 
        } else {
            node.parent.right = null;
        }
    }

    private void removeLeftChild(Node node) {
        if (node == this.root) {
            this.root = node.left;
            this.root.parent = null;
            return;
        }

        node.left.parent = node.parent;
        if (node.value < node.parent.value) {
            node.parent.left = node.left;
        } else {
            node.parent.right = node.left;
        }
    }

    private void removeRightChild(Node node) {
        if (node == this.root) {
            this.root = node.right;
            this.root.parent = null;
            return;
        }

        node.right.parent = node.parent;
        if (node.value > node.parent.value) {
            node.parent.right = node.right;
        } else {
            node.parent.left = node.right;
        }
    }

    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }

    private boolean hasOnlyLeftChild(Node node) {
        if (node.right == null && node.left != null)
            return true;
        return false;
    }

    private boolean hasOnlyRightChild(Node node) {
        if (node.right != null && node.left == null)
            return true;
        return false;
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
