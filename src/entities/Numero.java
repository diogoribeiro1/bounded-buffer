public class Numero {

	// Atributos

	private Fifo fila;

	private int qtd_repeticoes;

	public Numero(Fifo fifo, int qtd_repeticoes) {
		this.fila = fifo;
		this.qtd_repeticoes = qtd_repeticoes;
	}

	// Obs: Os metodos produzir e consumir poderiam estar na classe produtor e consumidor respectivamente

	// Metodo onde tem a area de risco, pois compartilha mesmo buffer que o produzir
	// (metodo)
	// Ele roda de forma sicrona com o produzir
	public synchronized void consumir(String idThread) {

		int elemento;

		while (true) { // roda em loop ifinito

			while (this.fila.vazia()) { // enquanto a fila ta vazia ele espera

				try {

					this.wait(); // faz um break na metodo (deixa o metodo esperando ate receber um notify)

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			elemento = this.fila.desenfileirar(); // atributo fila chama o metd desenfileirar
			// elemento = eh o numero removido da fila(Buffer)

			System.out.println("  Consumidor " + idThread + "\t consumiu: \t" + elemento);

			// notifica o wait() da outra thread para ele poder continuar
			notify();
		}

	}

	public synchronized void produzir(String idThread) {

		int elemento = 0;
		int cont = 0;

		while (cont != this.qtd_repeticoes) { // faz a contagem de repeticoes 

			while (this.fila.cheia()) { // verifica se a fila ta cheia
				try {

					this.wait(); // se a fila tiver cheia ele fica esperando

				} catch (InterruptedException e) {
				}
			}

			this.fila.enfileirar(elemento); // ele passa o elemento que deve ser colocado no buffer

			System.out.println("Produtor " + idThread + "\t produziu: \t" + elemento);

			elemento++;
			cont++;

			notify();

		}
	}

}
