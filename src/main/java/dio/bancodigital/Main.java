package dio.bancodigital;

public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		cc.depositar(200);
		cc.transferir(20, poupanca);
                cc.sacar(50);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
