public class Produtor extends Thread {

	private Numero numero;

    public Produtor(Numero numero) {
       this.numero = numero; 
    }

	@Override
	public void run() {

			this.numero.produzir(this.getName(), 0);

	}

}
