public class Fila {
    private int[] fila;
    private int head;
    private int tail;
    private int size;

    public Fila(int capacidade) {
        this.fila = new int[capacidade];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == -1 && this.tail == -1;
    }

    public boolean isFull() {
        return this.size == this.fila.length;
    }

    public void addLast(int valor) {
        if (isFull())
            throw new RuntimeException("Fila está cheia!");

        if (isEmpty()) 
            this.head = 0;

        this.tail = (this.tail + 1) % this.fila.length;
        this.fila[this.tail] = valor;
        this.size++;
    }

    public int removeFirst() {
        if (isEmpty()) 
            throw new RuntimeException("Fila vazia!");

        int headValue = this.fila[this.head];

        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.fila.length;
        }

        this.size--;

        return headValue;
    }

    public int getFirst() {
        return this.fila[this.head];
    }

    public int getLast() {
        return this.fila[this.tail];
    }

    public String toString() {
        String out = "";
        
        for (int i = 0; i < this.size; i++) {
            int idx = (this.head + i) % this.fila.length;

            out += i != size - 1 ? fila[idx] + ", " : fila[idx];
        }

        return out; 
    }
    
    public int indexOf(int valor) {
        int i = 0;
        int j = (this.head + i) % this.fila.length;

        while (i < size() && this.fila[j] != valor) 
            j = (this.head + ++i) % this.fila.length;

        return i == this.size ? -1 : i;
    }

    public int lastIndexOf(int valor) {
        int i = this.size() - 1;
        int j = (this.head + i) % this.fila.length;

        while (i >= 0 && this.fila[j] != valor) 
            j = (this.head + --i) % this.fila.length;

        return i == -1 ? -1 : i;
    }
    
    public int size() {
        return this.size;
    }
}
