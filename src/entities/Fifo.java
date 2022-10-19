public class Fifo {

    private int cabeca, cauda, qtd_elementos;

    private int fila[];

    public Fifo(int tamanho) {

        this.fila = new int[tamanho];
        cauda = 0;
        cabeca = 0;
        qtd_elementos = 0;

    }

    // Metodo que adiciona o elemento no buffer(fila)
    // Fifo (first in first out)
    public void enfileirar(int elemento) {

        // coloca na cauda o elemento passado na class Numero
        this.fila[this.cauda] = elemento;

        // verifica se a fila ta no ultimo valor
        if (this.cauda == this.fila.length - 1) {

            // se estiver no ultimo valor 
            // renicia, colocando o valor 0
            this.cauda = 0;

        } else {

            // senao ela vai pro prox valor da fila
            this.cauda += 1;
        }

        this.qtd_elementos++;

    }

    // mesma logica do enfileirar
    public int desenfileirar() {

        int valor = this.fila[this.cabeca];

        if (this.cabeca == this.fila.length - 1) {

            this.cabeca = 0;

        } else {

            this.cabeca += 1;

        }

        this.qtd_elementos--;

        return valor;
    }

    // metodo que verifica se a fila ta cheia
    public boolean cheia() {
        
        // se a qtd de elementos produzidos for igual o tamanho da fila
        if (this.qtd_elementos == this.fila.length) {

            return true;

        } else {

            return false;

        }
    }

    // metodo que verifica se a fila ta vazia
    public boolean vazia() {

        // se a qtd de elementos for igual a 0 = fila ta vazia
        if (this.qtd_elementos == 0) {

            return true;

        } else {

            return false;

        }
    }
}
