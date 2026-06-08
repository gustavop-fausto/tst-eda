package fila_com_array;

import java.util.Scanner;

public class FilaComArray {
    private int[] fila;
    private int head;
    private int tail;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tamanho = Integer.parseInt(sc.nextLine());
        FilaComArray fila = new FilaComArray(tamanho);

        String[] entrada = sc.nextLine().split(" ");

        while (!entrada[0].equals("end")) {
            switch (entrada[0].toLowerCase()) {
                case "element" -> fila.element();
                case "print" -> fila.print();
                case "add" -> fila.add(Integer.parseInt(entrada[1]));
                case "remove" -> fila.remove();
                default -> System.out.println("Inválido");
            }

            entrada = sc.nextLine().split(" ");
        }
    }

    public FilaComArray(int tamanho) {
        this.fila = new int[tamanho];
        this.head = -1;
        this.tail = -1;
    }

    public void element() {
        System.out.println(this.fila[this.head]);
    }

    public void print() {
        if (this.head == -1 && this.tail == -1) {
            System.out.println("empty");
            return;
        }

        String out = "";
        for (int i = this.tail; i < this.head; i++) 
            out += this.fila[i] + " ";

        System.out.println(out.trim());
    }

    private void add(int value) {
        if (this.tail == this.fila.length) {
            System.out.println("full");
            return;
        }

        if (this.head == -1) 
            this.head++;

        this.fila[++this.tail] = value;
    }

    private void remove() {
        if (this.tail == -1 && this.head == -1) {
            System.out.println("empty");
            return;
        }

        this.head++;
    }
}
