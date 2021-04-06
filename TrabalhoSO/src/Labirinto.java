import java.util.Random;

public class Labirinto {
	
	private int tamanhoLab;
	
	private int qtdParedes;
	
	public String[][] labirinto;
	
	private RatoLab rato;
	
	public Labirinto(int tamanhoLab, int qtdParedes) {
		this.tamanhoLab = tamanhoLab;
		this.qtdParedes = qtdParedes;
		this.construirNovoLabirinto();
	}
	
	// Construir o labirinto
	public void construirNovoLabirinto() {
		labirinto = new String[this.tamanhoLab][this.tamanhoLab];
		for (int i = 0; i < this.tamanhoLab; i++) {
			for (int j = 0; j < this.tamanhoLab; j++) {
				this.labirinto[i][j] = " ";
			}
		}
		
		int aux = qtdParedes;
		while(aux != 0) {
			Random random = new Random();
			int numero = random.nextInt(tamanhoLab);
			while(numero == 0) {
				 numero = random.nextInt(tamanhoLab);
			}
			
			int numero2 = random.nextInt(tamanhoLab);
			while(numero2 == 0) {
				 numero2 = random.nextInt(tamanhoLab);
			}
			
			this.labirinto[numero][numero2] = "P";
			
			// System.out.println(numero + " " + numero2);
			
			aux--;
		}
		this.labirinto[0][0] = "Q";
	}
	
	public void exibirLabirinto() {
		atualizarPosicaoRato();
		for (int i = 0; i < tamanhoLab; i++) {
			for (int j = 0; j < tamanhoLab; j++) {
				if (labirinto[i][j].equals(" R ")) {
					System.out.print("|" + labirinto[i][j] + "|");
				} else {
					System.out.print("| " + labirinto[i][j] + " |");
				}
				
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	private void atualizarPosicaoRato() {
		if (this.rato != null) {
			PosicaoXY posAgente = this.rato.getPosicao();
			labirinto[posAgente.getPosX()][posAgente.getPosY()] = " R ";
		}
	}

	public int getTamanhoLabirinto() {
		
		return this.tamanhoLab;
	}

	public String retornarValorPosicaoLabirinto(PosicaoXY posicao) {
		return this.labirinto[posicao.getPosX()][posicao.getPosY()];
	}

	public void setRato(RatoLab rato) {
		this.rato = rato;
	}

	public void limpar() {
		PosicaoXY posicao = this.rato.getPosicao();
		labirinto[posicao.getPosX()][posicao.getPosY()] = "*";
	}
	
	
}
