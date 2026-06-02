package data_structures;

public class Pilha {
    private int[] pilha;
    private int topo;

    public Pilha(int capacidade) {
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo + 1 == this.pilha.length;
    }

    public void push(int valor) {
        if (isFull()) 
            throw new RuntimeException("Pilha está cheia!");

        this.pilha[++this.topo] = valor;
    }

    public int pop() {
        if (isEmpty()) 
            throw new RuntimeException("Pilha já está vazia.");

        return this.pilha[this.topo--];
    }

    public int top() {
        if (isEmpty()) 
            throw new RuntimeException("Pilha já está vazia.");

        return this.pilha[this.topo];
    }

    public String toString() {
        Pilha pilhaAux = new Pilha(this.pilha.length);

        String out = "";
        int topoReal = this.topo;

        while (this.topo >= 0) 
            pilhaAux.push(pop());

        while (this.topo < topoReal) {
            int value = pilhaAux.pop();
            push(value);

            out += !(this.topo == topoReal) ? value + ", " : value;
        }

        return out; 
    }
    
    public int indexOf(int valor) {
        Pilha pilhaAux = new Pilha(this.pilha.length);

        int topoReal = this.topo;

        while (this.topo >= 0 && this.pilha[this.topo] != valor) 
            pilhaAux.push(pop());

        int indexOf = this.topo;

        while (this.topo < topoReal) 
            push(pilhaAux.pop());

        return indexOf;
    }

    public int size() {
        return this.topo + 1;
    }
}
