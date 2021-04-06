import java.util.Random;

public class Auxiliar {
	public void metodo(Labirinto labirinto, int tamanhoLabirinto, int numrato) {
		 RatoLab rato = new RatoLab(labirinto); // Objeto do tipo Labirinto - Rato
		 //Randomizando posições do rato
		 
		 	Random random = new Random();
		 	
			int numero = random.nextInt(tamanhoLabirinto);
			while(numero == 0) {
				 numero = random.nextInt(tamanhoLabirinto);
			}
			
			int numero2 = random.nextInt(tamanhoLabirinto);
			while(numero2 == 0) {
				 numero2 = random.nextInt(tamanhoLabirinto);
			}
			
			
			while(labirinto.labirinto[numero][numero2].equals("P")) {
				
				numero = random.nextInt(tamanhoLabirinto);
				while(numero == 0) {
					 numero = random.nextInt(tamanhoLabirinto);
				}
				
				numero2 = random.nextInt(tamanhoLabirinto);
				while(numero2 == 0) {
					 numero2 = random.nextInt(tamanhoLabirinto);
				}
				
			}

		 rato.setPosicao(new PosicaoXY(numero,numero2)); // Escolhendo a posicao inicial do ratinho
		 

		 while(rato.isAindaLimpando()) {
			rato.zerarPilha();
			rato.movimentar(); 
			labirinto.exibirLabirinto();
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 System.out.println("O rato de numero: "+ numrato + " acabou!");
	}
}
