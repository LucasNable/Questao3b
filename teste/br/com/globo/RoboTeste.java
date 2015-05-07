package br.com.globo;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RoboTeste {
	
	//teste move
	@Test
	public void moveTesteNorte(){
		Robo r = new Robo(Direcao.NORTE, 10, 10, 2, 5);
		r.move(r);
		assertTrue(r.getPosicaoY() == 6);
	}

	@Test
	public void moveTesteNorteMax(){
		Robo r = new Robo(Direcao.NORTE, 3, 3, 2, 2);
		r.move(r);
		r.move(r);
		r.move(r);
		assertTrue(r.getPosicaoY() == 3);
	}
	

	@Test
	public void moveTesteSul(){
		Robo r = new Robo(Direcao.SUL, 10, 10, 2, 3);
		r.move(r);
		assertTrue(r.getPosicaoY() == 2);
	}
	
	@Test
	public void moveTesteSulNegativo(){
		Robo r = new Robo(Direcao.SUL, 10, 10, 2, 3);
		r.move(r);
		r.move(r);
		r.move(r);
		r.move(r);
		r.move(r);
		assertTrue(r.getPosicaoY() == 1);
	}
	
	@Test
	public void moveTesteOeste(){
		Robo r = new Robo(Direcao.OESTE, 10, 10, 4, 3);
		r.move(r);
		assertTrue(r.getPosicaoX() == 3);
	}
	
	
	@Test
	public void moveTesteOesteNegativo(){
		Robo r = new Robo(Direcao.OESTE, 10, 10, 2, 3);
		r.move(r);
		r.move(r);
		r.move(r);
		r.move(r);
		r.move(r);
		assertTrue(r.getPosicaoX() == 1);
	}
	
	@Test
	public void moveTesteLeste(){
		Robo r = new Robo(Direcao.LESTE, 10, 10, 4, 3);
		r.move(r);
		assertTrue(r.getPosicaoX() == 5);
	}
	
	@Test
	public void moveTesteLesteMax(){
		Robo r = new Robo(Direcao.LESTE, 6, 6, 4, 3);
		r.move(r);
		r.move(r);
		r.move(r);
		r.move(r);
		assertTrue(r.getPosicaoX() == 6);
	}
	//fim do teste move
	
	//teste teletransporte
	@Test
	public void teletransporteTeste(){
		Robo r = new Robo(Direcao.LESTE, 10, 10, 4, 3);
		r.teletransporte("5", "5", r);
		assertTrue(r.getPosicaoX() == 5 && r.getPosicaoY() == 5);
	}
	
	@Test
	public void teletransporteTesteMax(){
		Robo r = new Robo(Direcao.LESTE, 4, 4, 2, 2);
		r.teletransporte("5", "5", r);
		assertTrue(r.getPosicaoX() == 2 && r.getPosicaoY() == 2);
	}
	
	@Test
	public void teletransporteTesteNeg(){
		Robo r = new Robo(Direcao.LESTE, 4, 4, 2, 2);
		r.teletransporte("-5", "-5", r);
		assertTrue(r.getPosicaoX() == 2 && r.getPosicaoY() == 2);
	}
	//fim do teste teletransporte

	//teste comandos
	@Test
	public void validaComandosTestEixoX() {		
		try {
			Robo r = new Robo();
			List<String> lista = new ArrayList<String>();
			lista.addAll(Arrays.asList("10 10","2 5 N"));
			Robo.comandos(lista);
			assertTrue(r.getEixoXTamanho() == 10);
		} 
		catch (Exception e) { }			
	}
	
	@Test
	public void validaComandosTestEixoY() {		
		try {
			Robo r = new Robo();
			List<String> lista = new ArrayList<String>();
			lista.addAll(Arrays.asList("10 10","2 5 N"));
			Robo.comandos(lista);
			assertTrue(r.getEixoYTamanho() == 10);
		} 
		catch (Exception e) { }			
	}
	
	@Test
	public void validaComandosTestPosicaoX() {		
		try {
			Robo r = new Robo();
			List<String> lista = new ArrayList<String>();
			lista.addAll(Arrays.asList("10 10","2 5 N"));
			Robo.comandos(lista);
			assertTrue(r.getPosicaoX() == 2);
		} 
		catch (Exception e) { }			
	}
	
	@Test
	public void validaComandosTestPosicaoY() {		
		try {
			Robo r = new Robo();
			List<String> lista = new ArrayList<String>();
			lista.addAll(Arrays.asList("10 10","2 5 N"));
			Robo.comandos(lista);
			assertTrue(r.getPosicaoY() == 5);
		} 
		catch (Exception e) { }			
	}
	
	@Test
	public void validaComandosTestDirecao() {		
		try {
			Robo r = new Robo();
			List<String> lista = new ArrayList<String>();
			lista.addAll(Arrays.asList("10 10","2 5 N"));
			Robo.comandos(lista);
			assertTrue(r.getDirecao().getSentido() == "N");
		} 
		catch (Exception e) { }			
	}
	//fim do teste comandos
}
