package ProjetoFaculdade;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
	private Lock lock = new ReentrantLock();
	private double total = 0;
	
	public void transferencia(Conta origem, Conta destino, double valor) {
		lock.lock();
		try {
			if(origem.getSaldo() >= valor){
				origem.subtrair(valor);
				destino.adicionar(valor);
				total += valor;
				System.out.println("Transferência de " + valor + " da conta de " + origem.getTitular() + " para a conta de " + destino.getTitular());
			}else {
				System.out.println("Saldo insuficiente");
			}
		}finally {
			lock.unlock();
		}
	}
	
	public double getTotal() {
		return total;
	}
	
	public void SaldosFinais(Conta[] contas) {
		for(Conta conta : contas) {
			System.out.println("Conta de " + conta.getTitular() + conta.getSaldo());
		}
	}
}
