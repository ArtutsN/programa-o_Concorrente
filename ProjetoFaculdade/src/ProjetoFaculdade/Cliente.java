package ProjetoFaculdade;

import java.util.List;

public class Cliente extends Thread{
	private Banco banco;
	private Conta conta;
	private Loja[] loja;
	private String nome;
	
	
	public Cliente(String nome,Conta conta, Loja[] loja, Banco banco) {
		this.banco = banco;
		this.conta = conta;
		this.loja = loja;
		this.nome = nome;
	}

	public void run() {
		while(conta.getSaldo() > 0) {
			Loja lojaEscolhida = loja[(int)(Math.random() * loja.length)];
			double valor = Math.random() < 0.5 ? 100 : 200;
			
			synchronized(lojaEscolhida) {
				if(conta.getSaldo() >= valor) {
					banco.transferencia(conta, lojaEscolhida.getConta(), valor);
					System.out.println(nome + " realizou uma compra de " + valor +" na loja " + lojaEscolhida.getNome());
				}else {
					System.out.println("Saldo insuficiente");
					break;
				}
			}
			
			try {
				Thread.sleep(100);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public String getNome() {
		return nome;
	}
}