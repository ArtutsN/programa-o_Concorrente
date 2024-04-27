package ProjetoFaculdade;

public class Loja {
	private String nome;
	private Conta conta;
	private Funcionario[] funcionario;
	private double caixa;
	
	public Loja(String nome, Conta conta, Funcionario[] funcionario) {
		this.nome = nome;
		this.conta = conta;
		this.funcionario = funcionario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Conta getConta() {
		return conta;
	}
	
	void salarioFuncionario() {
		synchronized(conta) {
			for(Funcionario funcionario : funcionario) {
				if(conta.getSaldo() >= Funcionario.getSalario()) {
					conta.subtrair(Funcionario.getSalario());
					System.out.println("Funcionario" + funcionario.getNome() +" recebeu " + Funcionario.getSalario());
				}else {
					System.out.println("Saldo insuficiente");
				}
			}
			caixa = 0;
		}
	}
}
