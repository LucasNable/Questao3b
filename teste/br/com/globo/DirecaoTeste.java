package br.com.globo;


import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DirecaoTeste {

	@Test
	public void direcaoBuscarPorSentidoTest() {
		assertNull(Direcao.buscaPorSentido(""));	
		assertNull(Direcao.buscaPorSentido(null));
		assertNull(Direcao.buscaPorSentido("1"));
		assertNull(Direcao.buscaPorSentido("h"));
		assertTrue(Direcao.buscaPorSentido("W").equals(Direcao.OESTE));
		assertTrue(Direcao.buscaPorSentido("S").equals(Direcao.SUL));
		assertTrue(Direcao.buscaPorSentido("N").equals(Direcao.NORTE));
		assertTrue(Direcao.buscaPorSentido("E").equals(Direcao.LESTE));
	}
	
	@Test
	public void direcaoGetSentidoTest() {
		assertTrue(Direcao.LESTE.getSentido().equals("E"));
		assertTrue(Direcao.NORTE.getSentido().equals("N"));
		assertTrue(Direcao.SUL.getSentido().equals("S"));
		assertTrue(Direcao.OESTE.getSentido().equals("W"));
	}
	
	
	//movimento para esquerda
	@Test
	public void esquerdaTesteN(){
		assertTrue(Direcao.NORTE.movimentoL().getSentido() == "W");
	}
	
	@Test
	public void esquerdaTesteW(){
		assertTrue(Direcao.OESTE.movimentoL().getSentido() == "S");
	}
	
	@Test
	public void esquerdaTesteS(){
		assertTrue(Direcao.SUL.movimentoL().getSentido() == "E");
	}
	
	@Test
	public void esquerdaTesteE(){
		assertTrue(Direcao.LESTE.movimentoL().getSentido() == "N");
	}
	//fim do teste de movimento para esquerda
	
	//movimento para direita
	@Test
	public void direitaTesteN(){
		assertTrue(Direcao.NORTE.movimentoR().getSentido() == "E");
	}
	@Test
	public void direitaTesteE(){
		assertTrue(Direcao.LESTE.movimentoR().getSentido() == "S");
	}
	@Test
	public void direitaTesteS(){
		assertTrue(Direcao.SUL.movimentoR().getSentido() == "W");
	}
	@Test
	public void direitaTesteW(){
		assertTrue(Direcao.OESTE.movimentoR().getSentido() == "N");
	}
	//fim do teste de movimento para direita
}
