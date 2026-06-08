public class ArrayList {
    private final int CAPACIDADE_DEFAULT = 20;
    private int[] array;
    private int tamanho;

    public ArrayList() {
        this.array = new int[CAPACIDADE_DEFAULT];
    }

    public ArrayList(int capacidadeInicial) {
        this.array = new int[capacidadeInicial];
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public void addFirst(int valor) {
        add(0, valor);
    }

    public void addLast(int valor) {
        add(this.tamanho, valor);
    }

    // adiciona um valor no índice passado como parâmetro
    public void add(int index, int valor) {
        if (index < 0 || index > this.tamanho) 
            throw new IndexOutOfBoundsException("Índice inválido");

        assegureCapacidade(this.tamanho + 1);
        shiftParaDireita(index);

        this.array[index] = valor;
        this.tamanho++;
    }

    public int getFirst() {
        if (this.tamanho == 0) 
            throw new IllegalArgumentException("ArrayList vazio.");

        return this.array[0];
    }

    public int getLast() {
        if (this.tamanho == 0) 
            throw new IllegalArgumentException("ArrayList vazio.");

        return this.array[this.tamanho - 1];
    }

    // retorna o elemento no índice passado como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if (index > this.tamanho - 1) 
            throw new IndexOutOfBoundsException("Índice inválido.");

        return this.array[index];
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (this.tamanho == 0)
            throw new IllegalArgumentException("ArrayList vazio.");

        int firstValue = this.array[0];
        remove(0);
        return firstValue;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() { 
        if (this.tamanho == 0) 
            throw new IllegalArgumentException("ArrayList vazio.");

        int lastValue = this.array[this.tamanho - 1];
        remove(this.tamanho - 1);
        return lastValue;
    }

    // remove o valor no índice passado como parâmetro. 
    // lançar exceção se o índice não for válido.
    public void remove(int index) {
        if (index < 0 || index > this.tamanho) 
            throw new IllegalArgumentException("Índice Inválido.");

        shiftParaEsquerda(index);
        this.tamanho--;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada.
    public void removeByValue(int value) {
        int i = 0;
        while (this.array[i] != value && i < this.tamanho) 
            i++;  

        if (i != this.tamanho) 
            remove(i);
    }

    // retorna o índice da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        for (int i = 0; i < this.tamanho; i++) 
            if (this.array[i] == value) 
                return i;

        return -1;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        for (int i = this.tamanho - 1; i >= 0; i--) 
            if (this.array[i] == valor) 
                return i;

        return -1;
    }
    // deve retornar uma string representando a lista. 
    public String toString() {
        String out = "";
        for (int i = 0; i < this.tamanho; i++) 
            out += this.array[i] + " ";

        return out.trim();
    }
    
    public int size() {
        return this.tamanho;
    }

    private void assegureCapacidade(int capacidadePretendida) {
        if (capacidadePretendida > this.array.length) 
            resize(Math.max(this.array.length * 2, capacidadePretendida));
    }

    // você vai precisar desse método quando tentar adicionar e a fila já estiver cheia
    private void resize(int novaCapacidade) {
        int[] novoArray = new int[novaCapacidade];
        for (int i = 0; i < this.array.length; i++) 
            novoArray[i] = this.array[i];

        this.array = novoArray;
    }

    private void shiftParaDireita(int index) {
        for (int i = this.tamanho; i > index; i--) 
            this.array[i] = this.array[i - 1];
    }

    private void shiftParaEsquerda(int index) {
        for (int i = index; i < this.tamanho - 1; i++)
            this.array[i] = this.array[i + 1];
    }
}
