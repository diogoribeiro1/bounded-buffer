public class Consumidor extends Thread {

    private Numero numero;

    public Consumidor(Numero numero) {
       this.numero = numero; 
    }

    @Override
    public void run() {

            this.numero.consumir(this.getName());
    }

}
