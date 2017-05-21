package arvore_genealogica;

import java.util.ArrayList;
import java.util.List;


public class TestePessoa {
	public static List<Pessoa> todasPessoas = new ArrayList<Pessoa>();
	public static void main(String[] args) {
		/*
		Pessoa m1 = new Pessoa("Dona Florinda", 60,  null, null );
		Pessoa h1 = new Pessoa("Professor Girafales", 65, null, null);
		Pessoa h2 = new Pessoa("Quico", 10, m1, null);
		Pessoa h3 = new Pessoa("Seu Barriga", 68, null, null);
		Pessoa h4 = new Pessoa("Nhonho", 12, null, h3);
		Pessoa m2 = new Mulher();
		//Testes
		//Familia 1
		Pessoa th1 = new Pessoa("Jorge", 60, null, null);
		Pessoa tm1 = new Pessoa("Joana", 56, null, null);
		th1.casar(tm1);
		Pessoa th2 = new Pessoa("Paulo", 40, tm1, th1 );
		Pessoa tm2 = new Pessoa("Maria", 38, tm1, th1);
		Pessoa th3 = new Pessoa("Mario", 35, tm1, th1);
		//Familia 2
		Pessoa th4 = new Pessoa("Carlos", 62, null, null);
		Pessoa tm3 = new Pessoa("Joaquina", 58, null, null);
		th4.casar(tm3);
		Pessoa th5 = new Pessoa("Carlinhos", 45, tm3, th4);
		Pessoa tm4 = new Pessoa("Luiza", 40, tm3, th4);
		Pessoa tm5 = new Pessoa("Valesca", 38, tm3, th4);
		
		th2.casar(tm5);
		th5.casar(tm2);
		th3.casar(tm4);
		
		//Criancas
		Pessoa th6 = new Pessoa("Carlos Neto", 12, tm2, th5);
		Pessoa tm6 = new Pessoa("Fabiana", 8, tm2, th5);
		Pessoa th7 = new Pessoa("João Petro", 14, tm4, th3);
		//Teste IMC Mariazinha
		Pessoa tm7 = new Mulher();
		Pessoa th8 = new Homem();
		
		tm7.setNome("Mariazinha Linda");
		tm7.setAltura(180.00);
		tm7.setPeso(205.00);
		
		th7.verificarParentesco(th3);
		m1.casar(h1);
		m1.verificarEstadoCivil();
		//h1.divorciar(m1);
		
		//th1.listarFilhos();
		//tm7.calcularIMC();
		//System.out.println(todasPessoas.size());
		System.out.println(th8.getSexo());
		th8.fazerFilho();
		th8.listarFilhos();

		for(int i = 0; i < todasPessoas.size(); i++){
			System.out.println(todasPessoas.get(i).getNome());
		}
		*/
		
		// Árvore OFICIAL - Família Chaves

		// Criação de pessoas
		// Primeira Geração
		Pessoa donaNeves = new Mulher("Dona Neves", 99, null, null);
		Pessoa sirNeves = new Homem("Sir Neves", 100, null, null);		
		Pessoa donaMadruga = new Mulher("Dona Madruga", 80, null, null);
		Pessoa sirMadruga = new Homem("Sir Madruga", 85, null, null);
		// Segunda Geração
		Pessoa quicoPai = new Homem("Quico Pai", 55, donaNeves, sirNeves);
		Pessoa donaFlorinda = new Mulher("Dona Florinda", 41, null, null);
		Pessoa profGirafales = new Homem("Prof Girafales", 45, null, null);	
		Pessoa maeChiquinha = new Mulher("Mae da Chiquinha", 40, donaNeves, sirNeves);
		Pessoa seuMadruga = new Homem("Seu Madruga", 49, donaMadruga, sirMadruga);
		Pessoa bruxaDo71 = new Mulher("Bruxa do 71", 52, null, null);
		// Terceira Geração
		Pessoa quico = new Homem("Quico", 8, donaFlorinda, quicoPai);
		Pessoa kika = new Mulher("Kika", 15, donaFlorinda, quicoPai, 1.40, 100);
		Pessoa chiquinha = new Mulher("Chiquinha", 8, maeChiquinha, seuMadruga, 1.20, 35.5);
		Pessoa chaves = new Homem("Chaves", 8, bruxaDo71, seuMadruga);
		// Casamentos
		donaNeves.casar(sirNeves);
		donaMadruga.casar(sirMadruga);
		quicoPai.casar(donaFlorinda);
		quicoPai.divorciar(donaFlorinda);
		donaFlorinda.casar(profGirafales);
		maeChiquinha.casar(seuMadruga);
		maeChiquinha.divorciar(seuMadruga);
		seuMadruga.casar(bruxaDo71);


		// TESTES
		// Parentesco
		Object[][] testeParentesco = {
				{chaves, donaFlorinda, "Chaves e Dona Florinda não tem parentesco"},
				{quicoPai, quico, "Quico Pai é pai de Quico"},
				{donaFlorinda, quico, "Dona Florinda é mãe de Quico"},
				{profGirafales, donaFlorinda, "Prof Girafales é marido de Dona Florinda"},
				{donaFlorinda, profGirafales, "Dona Florinda é esposa de Prof Girafales"},
				{chaves, seuMadruga, "Chaves é filho de Seu Madruga"},
				{chiquinha, seuMadruga, "Chiquinha é filha de Seu Madruga"},
				{sirNeves, chiquinha, "Sir Neves é avô de Chiquinha"},
				{donaNeves, chiquinha, "Dona Neves é avó de Chiquinha"},
				{quicoPai, chiquinha, "Quico pai é tio de Chiquinha"},
				{maeChiquinha, quico, "Mãe da Chiquinha é tia de Quico"},
				{quico, maeChiquinha, "Quico é sobrinho de Mãe da Chiquinha"},
				{chiquinha, quicoPai, "Chiquinha é sobrinha de Quico Pai"},
				{chaves, null, "Erro - não é possível verificar parentesco com pessoa 'nula' (null)"},
				{chaves, chaves, "Erro - não é possível verificar parentesco de uma pessoa com ela mesma"},
				{chiquinha, chaves, "Chiquinha é meia-irmã de Chaves"}
				};
		System.out.println("--- Teste Parentesco ---");
		for(int i = 0; i<testeParentesco.length; i++ ){
			// Imprime o resultado esperado
			System.out.println("- Esperado:\n" + testeParentesco[i][2] + "\n- Resultado:");
			// Verifica parentesco entre pessoa 1 e pessoa 2
			Pessoa parente1 = (Pessoa)testeParentesco[i][0];
			Pessoa parente2 = (Pessoa)testeParentesco[i][1];
			parente1.verificarParentesco(parente2);
			System.out.println("");
		}
		System.out.println("--- Fim Teste Parentesco ---");
		
		// IMC
		Pessoa[] pessoasTesteIMC = {donaFlorinda, donaNeves, maeChiquinha, profGirafales};
		double[] alturasTesteIMC = {1.75, 1.45, 1.65, 2.10};
		double[] pesosTesteIMC = {66.6, 32.5, 80, 110};
		String[] resultadosTesteIMC = {"Dona Florinda: IMC = 21.74 - Peso normal", 
				"Dona Neves: IMC = 15.46 - Muito abaixo do peso", 
				"Mãe da Chiquinha: IMC = 29.38 - Acima do peso", 
				"Função inválida para homens"};
		Mulher mTeste;
		// Realiza os testes mapeados
		System.out.println("--- Teste Calcular IMC ---");
		for(int i = 0; i<pessoasTesteIMC.length; i++ ){
			// Imprime o resultado esperado
			System.out.println("- Esperado:\n" + resultadosTesteIMC[i] + "\n- Resultado:");
			// Calcula IMC
			if(pessoasTesteIMC[i] instanceof Mulher){
				mTeste = (Mulher) pessoasTesteIMC[i];
				mTeste.setAltura(alturasTesteIMC[i]);
				mTeste.setPeso(pesosTesteIMC[i]);
				mTeste.calcularIMC();				
			} else {
				System.out.println("Função inválida para homens");
			}
			System.out.println("");
		}
		System.out.println("--- Fim Teste Calcular IMC ---");


		
	}
}