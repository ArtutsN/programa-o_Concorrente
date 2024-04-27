package ProjetoFaculdade;

public class Funcionario extends Thread {
	private String nome;
	private Conta salario;
	private Conta investimento;
	private static double Salario = 1400;
	
	public Funcionario(String nome, Conta salario, Conta investimento) {
		this.investimento = investimento;
		this.nome = nome;
		this.salario = salario;
	}
	
	public void run() {
		synchronized(salario) {
			salario.adicionar(Salario);
			double novoInvestimento = Salario * 0.2;
			investimento.adicionar(novoInvestimento);
			System.out.println(nome + " Recebeu" + Salario + " e investiu" + novoInvestimento + " na conta");
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public static double getSalario() {
		return Salario;
	}
}
