package br.com.globo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arquivo {
	
	public List<String> preparaComando(){
		try {
			List<String> linhas = new ArrayList<String>();
			linhas = converter(lerArquivo());
			validarLinhas(linhas);
			return linhas;
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected static String lerArquivo() throws IOException{
		String linha = "";
		try {
			FileReader arq = new FileReader("input.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			linha = lerArq.readLine();
			arq.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException i) {
			i.printStackTrace();
		}
		return linha.trim().replace(" ," ,",").replace(", ", ",");
	}
	
	protected static List<String> converter(String linha) throws Exception{
		if(linha.trim() == null || linha.trim().isEmpty()){
			throw new Exception("**Erro - Linha vazia ou nula");
		}
		List<String> linhas = Arrays.asList(linha.replace("  ", " ").trim().split(","));
		return linhas;
	}
	
	protected static void validarLinhas(List<String> linhas) throws Exception{
			if(linhas.isEmpty() || linhas == null)
				throw new Exception("**Erro - Nenhum comando passado");
			else if(linhas.size() < 2)
				throw new Exception("**Erro - Linha 2 não foi preenchida");
			if (!validaPrimeiraLinha(linhas.get(0)))
				throw new Exception("**Erro - Linha 1 com formato incorreto");
			if (!validaSegundaLinha(linhas.get(1)))
				throw new Exception("**Erro - Linha 2 com formato incorreto");
			if (linhas.size() > 2) {
				for (int indice = 2 ; indice < linhas.size() ; indice ++) {
					if (linhas.get(indice).contains("T")) {//se a instrucao contem T eh o comando de teletransporte
						if (!validaLinhaTransferencia(linhas.get(indice))) 
							throw new Exception("**Erro - Linha " + (indice + 1) + " com formato incorreto");
					}
					else {
						if (!validaLinhaInstrucao(linhas.get(indice)))
							throw new Exception("**Erro - Linha " + (indice + 1) + " com formato incorreto");
					}
				}
			}
		}
	
	protected static boolean validaPrimeiraLinha(String linha) {
		return linha.matches("[0-9]+ [0-9]+");
	}
	
	protected static boolean validaSegundaLinha(String linha) {
		return linha.matches("[0-9]+ [0-9]+ [W|N|S|E]");
	}
	
	protected static boolean validaLinhaTransferencia(String linha) {
		return linha.matches("T [0-9]+ [0-9]+");
	}
	
	protected static boolean validaLinhaInstrucao(String linha) {
		return linha.matches("[L|R|M]+");
	}
}
