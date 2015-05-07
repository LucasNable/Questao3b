package br.com.globo;

public enum Direcao {
	
	NORTE("N", 0),
	LESTE("E", 1),
	SUL("S", 2),
	OESTE("W", 3);
		
	private String sentido;
	private int codigo;
	
	private Direcao(String sentido, int codigo) {
		this.sentido = sentido;
		this.codigo = codigo;
	}

	public static Direcao buscaPorSentido(String sentido){
		if(sentido == null || sentido.trim().isEmpty())
			return null;

		for (Direcao direcao : Direcao.values()) {
			if (direcao.sentido.equals(sentido))
				return direcao;
		}
		return null;
	}
	
	private static Direcao buscaPorCodigo(Integer codigo){
		if(codigo == null)
			return null;
		for (Direcao direcao : Direcao.values()) {
			if (direcao.codigo == codigo.intValue())
				return direcao;
		}
		return null;
	}
	
	//movimento para esquerda, - 1, se o valor ficar negativo eh pq a direcao atual e N
	public Direcao movimentoL() {
		int novoCodigo = this.codigo - 1;
		if(novoCodigo == -1)
			novoCodigo = 3;
		return buscaPorCodigo(novoCodigo);
	}
	//movimento para direita, + 1, se o valor ultrapassar 3 eh pq a direcao atual e W
	public Direcao movimentoR() {
		int novoCodigo = this.codigo + 1;
		if(novoCodigo == 4)
			novoCodigo = 0;
		return buscaPorCodigo(novoCodigo);
	}
	
	public String getSentido() {
		return sentido;
	}
}
