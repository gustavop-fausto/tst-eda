import java.util.NoSuchElementException;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
   
    public boolean isEmpty() {
        return this.head == null;
    }

    public void addFirst(int valor) {
        Node newNode = new Node(valor);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }

        size++;
    }

    public void addLast(int valor) {
        Node newNode = new Node(valor);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }

        size++;
    }

    // adiciona um valor na posição passada como parâmetro
    public void add(int index, int valor) {
        verificaIndex(index);

        if (index == 0) {
            addFirst(valor);
            return;
        }

        if (index == this.size) {
            addLast(valor);
            return;
        }

        Node newNode = new Node(valor);
        Node aux = this.head;

        for (int i = 0; i < index - 1; i++) 
            aux = aux.next;

        newNode.next = aux.next;
        newNode.prev = aux;
        aux.next.prev = newNode;
        aux.next = newNode;

        this.size++;
    }

    public int getFirst() {
        return this.head.v;
    }

    public int getLast() {
        return this.tail.v;
    }

    // retorna o elemento na posição  passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        verificaIndex(index);

        Node aux = this.head;
        for (int i = 0; i < index; i++) 
           aux = aux.next; 

        return aux.v;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (isEmpty()) 
            throw new NoSuchElementException("LinkedList vazia.");

        Node nodeRemoved = this.head;

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }

        this.size--;

        return nodeRemoved.v;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() {
        if (isEmpty()) 
            throw new NoSuchElementException("LinkedList vazia.");

        Node nodeRemoved = this.tail;

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        this.size--;

        return nodeRemoved.v;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public int remove(int index) {
        verificaIndex(index);

        if (index == 0) 
            return removeFirst();

        if (this.size - 1 == index) 
            return removeLast();

        Node aux = this.head;
        for (int i = 0; i < index; i++) 
            aux = aux.next;

        aux.next.prev = aux.prev;
        aux.prev.next = aux.next;
        this.size--;

        return aux.v;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {
        Node aux = this.head;

        int i = 0;
        while (i < this.size && aux.v != value) {
            aux = aux.next;
            i++;
        }

        if (i < this.size) {
            remove(i);
            return true;
        }

        return false;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        if (isEmpty()) 
            return -1;

        Node aux = this.head;

        int i = 0;
        while (i < this.size && aux.v != value) {
            aux = aux.next;
            i++;
        }

        return i < this.size ? i : -1;
    }

    public boolean contain(int v) {
        Node aux = this.head;

        for (int i = 0; i < this.size; i++) {
            if (aux.v == v) 
                return true;
            aux = aux.next;
        }

        return false;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        Node aux = this.tail;

        for (int i = this.size - 1; i >= 0; i--) {
            if (aux.v == valor) 
                return i;
            aux = aux.prev;
        }

        return -1;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        if (isEmpty()) return "";

        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.v + ", ";
            aux = aux.next;
        }
        return out.substring(0, out.length() - 2);
    }
    
    public int size() {
        return this.size;
    }

    private boolean verificaIndex(int index) {
        if (index < 0 || index > this.size)
            throw new IndexOutOfBoundsException("Índice inválido.");
        return true;
    }
}

class Node {
    int v;
    Node prev;
    Node next;

    Node(int v) {
        this.v = v;
    }
}
