package arvore_genealogica;

import java.util.ArrayList;
import java.util.List;


public class TestePessoa {
	//public static List<Pessoa> todasPessoas = new ArrayList<Pessoa>();
	public static void main(String[] args) {
		
		// �rvore OFICIAL - Fam�lia Chaves

		// Cria��o de pessoas
		// Primeira Gera��o
		Pessoa donaNeves = new Mulher("Dona Neves", 99, null, null);
		Pessoa sirNeves = new Homem("Sir Neves", 100, null, null);		
		Pessoa donaMadruga = new Mulher("Dona Madruga", 80, null, null);
		Pessoa sirMadruga = new Homem("Sir Madruga", 85, null, null);
		// Segunda Gera��o
		Pessoa quicoPai = new Homem("Quico Pai", 55, donaNeves, sirNeves);
		Pessoa donaFlorinda = new Mulher("Dona Florinda", 41, null, null);
		Pessoa profGirafales = new Homem("Prof Girafales", 45, null, null);	
		Pessoa maeChiquinha = new Mulher("Mae da Chiquinha", 40, donaNeves, sirNeves);
		Pessoa seuMadruga = new Homem("Seu Madruga", 49, donaMadruga, sirMadruga);
		Pessoa bruxaDo71 = new Mulher("Bruxa do 71", 52, null, null);
		// Terceira Gera��o
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
				{chaves, donaFlorinda, "Chaves e Dona Florinda n�o tem parentesco"},
				{quicoPai, quico, "Quico Pai � pai de Quico"},
				{donaFlorinda, quico, "Dona Florinda � m�e de Quico"},
				{profGirafales, donaFlorinda, "Prof Girafales � marido de Dona Florinda"},
				{donaFlorinda, profGirafales, "Dona Florinda � esposa de Prof Girafales"},
				{chaves, seuMadruga, "Chaves � filho de Seu Madruga"},
				{chiquinha, seuMadruga, "Chiquinha � filha de Seu Madruga"},
				{sirNeves, chiquinha, "Sir Neves � av� de Chiquinha"},
				{donaNeves, chiquinha, "Dona Neves � av� de Chiquinha"},
				{quicoPai, chiquinha, "Quico pai � tio de Chiquinha"},
				{maeChiquinha, quico, "M�e da Chiquinha � tia de Quico"},
				{quico, maeChiquinha, "Quico � sobrinho de M�e da Chiquinha"},
				{chiquinha, quicoPai, "Chiquinha � sobrinha de Quico Pai"},
				{chaves, null, "Erro - n�o � poss�vel verificar parentesco com pessoa 'nula' (null)"},
				{chaves, chaves, "Erro - n�o � poss�vel verificar parentesco de uma pessoa com ela mesma"},
				{chiquinha, chaves, "Chiquinha � meia-irm� de Chaves"},
				{chiquinha, donaNeves, "Chiquinha � neta de Dona Neves"},
				{quico, sirNeves, "Quico � neto de Sir Neves"}
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
		System.out.println("--- Fim Teste Parentesco ---\n");
		
		// IMC
		Pessoa[] pessoasTesteIMC = {donaFlorinda, donaNeves, maeChiquinha, profGirafales};
		double[] alturasTesteIMC = {1.75, 1.45, 1.65, 2.10};
		double[] pesosTesteIMC = {66.6, 32.5, 80, 110};
		String[] resultadosTesteIMC = {"Dona Florinda: IMC = 21.74 - Peso normal", 
				"Dona Neves: IMC = 15.46 - Muito abaixo do peso", 
				"M�e da Chiquinha: IMC = 29.38 - Acima do peso", 
				"Fun��o inv�lida para homens"};
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
				System.out.println("Fun��o inv�lida para homens");
			}
			System.out.println("");
		}
		System.out.println("--- Fim Teste Calcular IMC ---\n");

		// Fazer filho
		System.out.println("--- Teste Fazer filhos ---");
		Pessoa p2 = new Homem("Jo�o", 20, null, null);
		Pessoa p1 = new Mulher("Maria", 20, null, null);
		p1.fazerFilho("Joao", "Joana", null);
		p1.fazerFilho("Joao", "Joana", p1);
		p1.fazerFilho("Joao", "Joana", p2);
		p1.fazerFilho("Joao", "Joana", p2);
		p1.fazerFilho("Joao", "Joana", p2);
		System.out.println("--- Fim Teste Fazer filhos ---\n");

		// Listar filhos
		System.out.println("--- Teste Listar filhos ---");
		p1.listarFilhos();
		p2.listarFilhos();
		donaNeves.listarFilhos();
		System.out.println("--- Fim Teste Listar filhos ---\n");

		System.out.println("--- Teste Estado Civil ---");
		p2.verificarEstadoCivil();
		System.out.println("--- Fim Teste Estado Civil ---\n");
		
		System.out.println("--- Teste Listar Todas Pessoas ---");
		Pessoa.listarTodasPessoas();
		System.out.println("--- Fim Listar Todas Pessoas ---\n");
		
	}
}