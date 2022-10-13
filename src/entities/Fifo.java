public class Fifo {

    private int cabeca, cauda, qtd_elementos;

    private int fila[];

    public Fifo(int tamanho) {

        this.fila = new int[tamanho];
        cauda = 0;
        cabeca = 0;
        qtd_elementos = 0;

    }

    public void enfileirar(int elemento) {

        this.fila[this.cauda] = elemento;

        if (this.cauda == this.fila.length - 1) {

            this.cauda = 0;

        } else {

            this.cauda += 1;
        }

        this.qtd_elementos++;

    }

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

    public boolean cheia() {

        if (this.qtd_elementos == this.fila.length) {

            return true;

        } else {

            return false;

        }
    }

    public boolean vazia() {

        if (this.qtd_elementos == 0) {

            return true;

        } else {

            return false;

        }
    }
}
