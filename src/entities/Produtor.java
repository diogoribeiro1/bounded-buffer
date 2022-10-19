public class Produtor extends Thread {

	private Numero numero;

	public Produtor(Numero numero) {
		this.numero = numero;
	}
	
	// O metodo Run sobreposto da classe Thread, ele roda quando o metodo start() chama

	@Override
	public void run() {
		
		// atributo Numero executa o metodo produzir passando como parametro o nome thread (Thread - 0)

		this.numero.produzir(this.getName());

	}

}
