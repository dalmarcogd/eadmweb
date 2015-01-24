package br.com.eadm.ui;

import java.util.ArrayList;

import javax.swing.text.MaskFormatter;

public class GeraCPF {
	private ArrayList<Integer> listAleatoria = new ArrayList<Integer>();
	private ArrayList<Integer> listNumMultiplicados =  null;
		
	private String gera() {
		geraListAleatoria();
		geraListNumMultiplicados(10);
		geraNumVerificador();
		geraListNumMultiplicados(11);
		geraNumVerificador();
		return formatCPF();
	}

	
	// gera lista aleatoria
	private void geraListAleatoria(){
		for (int i = 0; i < 9; i++) {
			listAleatoria.add(gerarNumeroAleatorio());
		}
	}
	
	//gera numeros aleatorios
	private int gerarNumeroAleatorio(){
		int numero = (int) (Math.random() * 10);
		
		return numero;
	}
	
	//gerar lista final
	private void geraListNumMultiplicados(int numMultiplicador){
		listNumMultiplicados = new ArrayList<Integer>();
		
		for (Integer num : listAleatoria) {
			listNumMultiplicados.add(num * numMultiplicador);
			numMultiplicador--;
		}
	}
	
	// gera primeiro digito verificador
	private void geraNumVerificador(){
		Integer total = 0;
		for (Integer integer : listNumMultiplicados) {
			total += integer;
		}
		
		Integer div = total % 11;
		
		if (div < 2) {
			listAleatoria.add(0);
		}else{
			listAleatoria.add(11 - div);
		}
	}
	
	private String formatCPF() {
		String texto = "";
		String cpf = "";
		
		for (Integer integer : listAleatoria) {
			texto += integer;
		}
		
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			mask.setValueContainsLiteralCharacters(false);
			cpf = mask.valueToString(texto);
			
		} catch (Exception e) {
			System.out.println("CPF inválido.");
		}
		
		return cpf;
	}
	
	public String getCPF(){
		return gera();
	}

}

