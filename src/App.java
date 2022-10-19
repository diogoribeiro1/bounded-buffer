public class App {
	public static void main(String[] args) throws InterruptedException {

		// Declaracoes de objetos
		
		// Passando o tamanho da fila(BUFFER) pelo construtor
		Fifo fifo = new Fifo(3);

		// Passando buffer e a qtd de repeticoes
		Numero num = new Numero(fifo, 3991);

		// Passando o obj Numero na classe produtor
		Produtor producer = new Produtor(num);

		// Passando o obj Numero na classe consumer
		Consumidor consumer = new Consumidor(num);

		// Start vai rodar o thread (tarefa)
		// Produtor
		// Consumidor
		producer.start();
		consumer.start();

		// O Join manda o (public static void main) abdicar das threads
		// producer.join();
		// consumer.join();
	}

}
