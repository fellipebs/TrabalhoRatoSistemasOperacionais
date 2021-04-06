import java.util.Scanner;
import java.lang.*;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// R - Rato
		// Q - Queijo
		// P - Parede
		// * - Lugares aonde o Rato passou
		// " " - Lugares aonde o Rato não passou
		
		//Trabalhando com threads, usuário escolhera o numero
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite o número de ratos:");
		int i = ler.nextInt();
		
		System.out.println("Digite o tamanho do labirinto:");
		int tamanhoLabirinto = ler.nextInt();
		
		System.out.println("Digite a quantidade de paredes do labirinto:");
		int paredes = ler.nextInt();
		
		
		Labirinto labirinto = new Labirinto(tamanhoLabirinto,paredes);	
		labirinto.construirNovoLabirinto();
		labirinto.exibirLabirinto();
		
		RatosThreads run = new RatosThreads();
		run.labirinto = labirinto;
		run.tamanhoLabirinto = tamanhoLabirinto;
		
		
		int aux = 1;
		run.NumeroThread = aux;
		while(aux <= i) {
			Thread.sleep(40);
			run.NumeroThread = aux;
			Thread t1 = new Thread(run);
			t1.start();
			aux++;
		}
		
	}

	
}

class RatosThreads implements Runnable {
	public int NumeroThread;
	Labirinto labirinto;
	int tamanhoLabirinto;
	Auxiliar a = new Auxiliar();
	
	public void run() {
		int rato = NumeroThread;
		a.metodo(labirinto, tamanhoLabirinto, rato);
		System.exit(0);
	}
}

