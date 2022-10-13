public class App {
	public static void main(String[] args) throws InterruptedException {

		Fifo fifo = new Fifo(3);
		Numero num = new Numero(fifo);
		Produtor producer = new Produtor(num);
		Consumidor consumer = new Consumidor(num);

		producer.start();
		consumer.start();

	}
}
