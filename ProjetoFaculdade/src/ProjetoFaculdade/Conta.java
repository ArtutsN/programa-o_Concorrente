package ProjetoFaculdade;

public class Conta {
	private String titular;
	private  double saldo;
	
	public Conta(String titular, double saldo) {
		this.titular = titular;
		this.saldo = saldo;
	}
	
	public void adicionar(double valor) {
		saldo += valor;
	}
	
	public void subtrair(double valor) {
		saldo -= valor;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public double getSaldo() {
		return saldo;
	}
}
