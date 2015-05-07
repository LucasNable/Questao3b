package br.com.globo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArquivoTeste {
	//teste das linhas do arquivo
	@Test
	public void arquivoValidaTestFalha() {
		List<String> lista = new ArrayList<String>();
		lista.add("teste");			
		try {
			Arquivo.validarLinhas(lista);
			fail("Preparou arquivo com formato invalido.");
		} 
		catch (Exception e) { }			
		assertTrue(true);
	}

	@Test
	public void arquivoValidaTest() {
		List<String> lista = new ArrayList<String>();
		lista.addAll(Arrays.asList("10 10","2 5 N","LLRRMMMRLRMMM","T 1 3","LLRRMMRMMRMMM"));			
		try {
			Arquivo.validarLinhas(lista);
			assertTrue(true);
		} 
		catch (Exception e){
			assertTrue(false);
		}			
		
	}
	
	@Test
	public void arquivoValidaLinha1Test() {
		List<String> lista = new ArrayList<String>();
		lista.addAll(Arrays.asList("10 e","2 5 N","LLRRMMMRLRMMM","T 1 3","LLRRMMRMMRMMM"));			
		try {
			Arquivo.validarLinhas(lista);
			fail("linha 1 invalida");
		} 
		catch (Exception e) {
			assertTrue(true);
		}			
	}
	
	@Test
	public void arquivoValidaLinha2Test() {
		List<String> lista = new ArrayList<String>();
		lista.addAll(Arrays.asList("10 10","2 N","LLRRMMMRLRMMM","T 1 3","LLRRMMRMMRMMM"));			
		try {
			Arquivo.validarLinhas(lista);
			fail("linha 2 invalida");
		} 
		catch (Exception e) {
			assertTrue(true);
		}			
	}
	
	@Test
	public void arquivoValidaLinha3Test() {
		List<String> lista = new ArrayList<String>();
		lista.addAll(Arrays.asList("10 10","2 5 N","LLRRMM7RLRMMM","T 1 3","LLRRMMRMMRMMM"));			
		try {
			Arquivo.validarLinhas(lista);
			fail("linha 3 invalida");
		} 
		catch (Exception e) {
			assertTrue(true);
		}			
	}
	
	@Test
	public void arquivoValidaLinha4Test() {
		List<String> lista = new ArrayList<String>();
		lista.addAll(Arrays.asList("10 10","2 5 N","LLRRMMMRLRMMM","S 1 3","LLRRMMRMMRMMM"));			
		try {
			Arquivo.validarLinhas(lista);
			fail("linha 4 invalida");
		} 
		catch (Exception e) {
			assertTrue(true);
		}			
	}
	
//fim dos testes das linhas do arquivo
	
	@Test
	public void validaPrimeiraLinhaTest() {		
		try {
			assertFalse(Arquivo.validaPrimeiraLinha("6"));
			assertTrue(Arquivo.validaPrimeiraLinha("8 8"));
		} 
		catch (Exception e) { }			
	}
	
	@Test
	public void validaSegundaLinhaTest() {		
		try {
			assertFalse(Arquivo.validaSegundaLinha("N N"));
			assertTrue(Arquivo.validaSegundaLinha("1 4 N"));
		} 
		catch (Exception e) { }			
	}
	
	@Test
	public void validaLinhaTeletransporteTest() {		
		try {
			assertFalse(Arquivo.validaLinhaTransferencia("T 1 5 "));
			assertTrue(Arquivo.validaLinhaTransferencia("T 3 4"));
		} 
		catch (Exception e) { }			
	}
	
	@Test
	public void validaLinhaInstrucaoTest() {		
		try {
			assertFalse(Arquivo.validaLinhaInstrucao("LLRR MLRLRMMM"));
			assertTrue(Arquivo.validaLinhaInstrucao("LRMRLR"));
		} 
		catch (Exception e) { }			
	}
	
}
