
public class RatoLab {
	// Movimentar para 4 direções (Cima, baixo, esquerda, direita)
	// Referencia do Labiririnto 
	
	private Labirinto labirinto;
	private MovimentoRatoLab movimento;
	
	private PosicaoXY posXY;
	
	private int pilhaMovimentos;
	
	private int aux;

	public RatoLab(Labirinto labirinto) {
		this.labirinto = labirinto;
		labirinto.setRato(this);
		this.posXY = new PosicaoXY();
		this.movimento = MovimentoRatoLab.CIMA;
	}
	
	public void movimentar() {
		if (this.pilhaMovimentos >= 4) {
			return;
		}
		PosicaoXY proximoMovimento = retornarMovimento();
		String valor = this.labirinto.retornarValorPosicaoLabirinto(proximoMovimento);
		
		if (valor.equals("*") || valor.equals(" R ") || valor.equals("P")) {
			proximoMovimento();
			aumentarPilha();
			movimentar();
		} else {
			if(valor.equals("Q")) {
				//System.out.println("O rato acabou!");
				aux = 1;
			}else {
				this.labirinto.limpar();
				this.posXY = proximoMovimento;
			}
		}
	}
	
	private void aumentarPilha() {
		this.pilhaMovimentos++;
	}

	private void proximoMovimento() {
		switch(this.movimento) {
			case CIMA:
				this.movimento = MovimentoRatoLab.BAIXO;
				break;
			case BAIXO:
				this.movimento = MovimentoRatoLab.ESQUERDA;
				break;
			case ESQUERDA:
				this.movimento = MovimentoRatoLab.DIREITA;
				break;
			case DIREITA:
				this.movimento = MovimentoRatoLab.CIMA;
				break;
		}
	}

	public PosicaoXY retornarMovimento() {
		int retornoPosX = this.posXY.getPosX();
		int retornoPosY = this.posXY.getPosY();
		switch(movimento) {
			case CIMA:
				if (retornoPosX > 0) {
					retornoPosX -= 1;
				}
				break;
			case BAIXO:
				if (retornoPosX < this.labirinto.getTamanhoLabirinto() - 1) {
					retornoPosX += 1;
				}
				break;
			case ESQUERDA:
				if (retornoPosY > 0) {
					retornoPosY -= 1;
				}
				break;
			case DIREITA:
				if (retornoPosY < this.labirinto.getTamanhoLabirinto() - 1) {
					retornoPosY += 1;
				}
				break;
		}
		return new PosicaoXY(retornoPosX, retornoPosY);
	}

	public PosicaoXY getPosicao() {
		return this.posXY;
	}

	public boolean isAindaLimpando() {
		if(pilhaMovimentos < 4 && aux != 1) {
			return true;
		}
		return false;
	}

	public void zerarPilha() {
		this.pilhaMovimentos = 0;
	}

	public void setPosicao(PosicaoXY posicaoXY) {
		this.posXY = posicaoXY;
		
	}
}
