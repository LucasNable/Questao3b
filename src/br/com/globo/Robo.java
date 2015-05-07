package br.com.globo;

import java.util.List;

public class Robo {
	
	private Direcao direcao;
	private Integer eixoXTamanho;
	private Integer eixoYTamanho;
	private Integer posicaoX;
	private Integer posicaoY;
	
	public Robo(Direcao direcao, Integer eixoXTamanho, 
			Integer eixoYTamanho, Integer posicaoX,
			Integer posicaoY) {
		super();
		this.direcao = direcao;
		this.eixoXTamanho = eixoXTamanho;
		this.eixoYTamanho = eixoYTamanho;
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
	}
	
	public Robo(){}

	public static void main(String[] args){
		try {
			Arquivo a = new Arquivo();
			comandos(a.preparaComando());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void comandos(List<String> linhas){
		Robo r = new Robo(Direcao.buscaPorSentido(linhas.get(1).split(" ")[2]),  Integer.parseInt(linhas.get(0).split(" ")[0]),
				Integer.parseInt(linhas.get(0).split(" ")[1]), Integer.parseInt(linhas.get(1).split(" ")[0]),
				Integer.parseInt(linhas.get(1).split(" ")[1]));
		
		for (int indice = 2 ; indice < linhas.size() ; indice ++) {
			if (linhas.get(indice).contains("T")) {
				r.teletransporte(linhas.get(indice).split(" ")[1], linhas.get(indice).split(" ")[2], r);
			}
			else {
				for (int i = 0 ; i < linhas.get(indice).length() ; i ++) {
					switch(linhas.get(indice).substring(i, i+1)){
						case "L":
							r.direcao = r.direcao.movimentoL();
							break;
						case "R":
							r.direcao = r.direcao.movimentoR();
							break;
						case "M":
							r.move(r);
							break;
						default:
							break;
					}
				}
			}
		}
		System.out.println("na posição "+r.posicaoX.toString() +"," + r.posicaoY.toString() +" virado para " + r.direcao);
	}
	
	
	protected void move(Robo r){
		switch (r.direcao) {
		case NORTE:
			if(r.posicaoY + 1 > 1 && r.posicaoY + 1 <= r.eixoYTamanho)
				r.posicaoY = r.posicaoY + 1;
			break;
		case OESTE:
			if(r.posicaoX - 1 >= 1)
				r.posicaoX = r.posicaoX - 1;
			break;
		case SUL:
			if(r.posicaoY - 1 >= 1)
				r.posicaoY = r.posicaoY - 1;
			break;
		case LESTE:
			if(r.posicaoX + 1 > 1 && r.posicaoX + 1 <= r.eixoXTamanho)
				r.posicaoX = r.posicaoX + 1;
			break;
		default:
			break;
		}
	}
	
	protected void teletransporte(String x, String y, Robo r){
		Integer teleX = Integer.parseInt(x);
		Integer teleY = Integer.parseInt(y);
		if((teleX > 0 && teleX <= r.eixoXTamanho) && (teleY > 0 && teleY <= r.eixoYTamanho)){
			r.posicaoX = teleX;
			r.posicaoY = teleY;
		}
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public Integer getEixoXTamanho() {
		return eixoXTamanho;
	}

	public void setEixoXTamanho(Integer eixoXTamanho) {
		this.eixoXTamanho = eixoXTamanho;
	}

	public Integer getEixoYTamanho() {
		return eixoYTamanho;
	}

	public void setEixoYTamanho(Integer eixoYTamanho) {
		this.eixoYTamanho = eixoYTamanho;
	}

	public Integer getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(Integer posicaoX) {
		this.posicaoX = posicaoX;
	}

	public Integer getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(Integer posicaoY) {
		this.posicaoY = posicaoY;
	}
	
	
}
