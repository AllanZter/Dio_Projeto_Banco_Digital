package dio.bancodigital;


public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	private int agencia;
	private int numero;
	private double saldo;
	private Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
          if(valor <= saldo){
            saldo -= valor; 
              System.out.println("Saque de: R$ " + valor + " realizado com sucesso");
          }
          else{
              System.out.println("Saldo insulficiente");
          }            
	}

	@Override
	public void depositar(double valor) {
	    if(valor <= 0){
                System.out.println("Depósito deve ser maior que zero.");
            }else{
              saldo += valor;  
            }
            
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
	    if(valor <= saldo){
              this.sacar(valor);
	      contaDestino.depositar(valor);
              System.out.println("Transferencia realizada com sucesso");
            }
            else{
              System.out.println("Saldo insulficiente");
            }
            
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo Atual: %.2f", this.saldo));
	}
}