public class Numero {

	private Fifo fila;

	public Numero(Fifo fifo) {
		this.fila = fifo;
	}

	public synchronized void consumir(String idThread) {

		int elemento;

		while (true) {

			while (this.fila.vazia()) {

				try {

					this.wait();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			elemento = this.fila.desenfileirar();

			System.out.println("  Consumidor " + idThread + "\t consumiu: \t" + elemento);

			notify();
		}

	}

	public synchronized void produzir(String idThread, int valor) {

		int elemento = 0;

		while (true) {

			while (this.fila.cheia()) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			this.fila.enfileirar(elemento);

			System.out.println("Produtor " + idThread + "\t produziu: \t" + elemento);

			elemento++;

			notify();
		}
	}

}
