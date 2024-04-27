package ProjetoFaculdade;

public class Main {
	public static void main(String[] args) {
		Banco banco = new Banco();
		
		Conta contaLoja1 = new Conta("Padaria Rei ",0);
		Conta contaLoja2 = new Conta("Pastelaria do seu ze ",0);
		
		Funcionario funcionarioLoja1 = new Funcionario(" Maria", contaLoja1, null);
		Funcionario funcionario2Loja1 = new Funcionario(" Freddy", contaLoja1, null);
		Funcionario funcionarioLoja2 = new Funcionario(" Mike", contaLoja2, null);
		Funcionario funcionario2Loja2 = new Funcionario(" William", contaLoja2, null);
		
		Loja loja1 = new Loja("Padaria Rei", contaLoja1, new Funcionario[]{funcionarioLoja1, funcionario2Loja1});
		Loja loja2 = new Loja("Pastelaria do seu ze", contaLoja1, new Funcionario[]{funcionarioLoja2, funcionario2Loja2});
		
		Conta contaFuncionario1 = new Conta("Maria - Salário ", 0);
        Conta InvestimentoFuncionario1 = new Conta("Maria - Investimento ", 0);

        Conta contaFuncionario2Loja1 = new Conta("Freddy - Salário ", 0);
        Conta InvestimentoFuncionario2Loja1 = new Conta("Freddy - Investimento ", 0);

        Conta contaFuncionario1Loja2 = new Conta("Mike - Salário ", 0);
        Conta InvestimentoFuncionario1Loja2 = new Conta("Mike - Investimento ", 0);

        Conta contaFuncionario2Loja2 = new Conta("William - Salário ", 0);
        Conta InvestimentoFuncionario2Loja2 = new Conta("William - Investimento ", 0);

        Conta contaCliente1 = new Conta("joão ", 1000);
        Cliente cliente1 = new Cliente("João ", contaCliente1, new Loja[]{loja1, loja2}, banco);

        Conta contaCliente2 = new Conta("Amanda ", 1000);
        Cliente cliente2 = new Cliente("Amanda ", contaCliente2, new Loja[]{loja1, loja2}, banco);

        Conta contaCliente3 = new Conta("Beatriz ", 1000);
        Cliente cliente3 = new Cliente("Beatriz ", contaCliente3, new Loja[]{loja1, loja2}, banco);

        Conta contaCliente4 = new Conta("Ricardo ", 1000);
        Cliente cliente4 = new Cliente("Ricardo ", contaCliente4, new Loja[]{loja1, loja2}, banco);

        Conta contaCliente5 = new Conta("Sofia ", 1000);
        Cliente cliente5 = new Cliente("Sofia ", contaCliente5, new Loja[]{loja1, loja2}, banco);
        
        Conta contaCliente6 = new Conta("Gabriel ", 1000);
        Cliente cliente6 = new Cliente("Gabriel ", contaCliente6, new Loja[]{loja1, loja2}, banco);

        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
        cliente6.start();

        try {
            cliente1.join();
            cliente2.join();
            cliente3.join();
            cliente4.join();
            cliente5.join();
            cliente6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loja1.salarioFuncionario();
        loja2.salarioFuncionario();

        Conta[] contas = {contaCliente1, contaCliente2, contaCliente3, contaCliente4, contaCliente5, contaFuncionario1, contaFuncionario2Loja1, contaFuncionario1Loja2, contaFuncionario2Loja2, InvestimentoFuncionario1, InvestimentoFuncionario2Loja1, InvestimentoFuncionario1Loja2, InvestimentoFuncionario2Loja2, contaLoja1, contaLoja2};
        banco.SaldosFinais(contas);
	}

}
