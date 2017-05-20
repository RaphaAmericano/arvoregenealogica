package arvore_genealogica;

import java.util.ArrayList;
import java.util.List;


public class TestePessoa {
	public static List<Pessoa> todasPessoas = new ArrayList<Pessoa>();
	public static void main(String[] args) {
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
		Pessoa th7 = new Pessoa("Jo�o Petro", 14, tm4, th3);
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
		
		// �rvore OFICIAL - Fam�lia Chaves
		
		// Primeira Gera��o
		Pessoa mDonaNeves = new Mulher("Dona Neves", 99, null, null);
		Pessoa hSirNeves = new Homem("Sir Neves", 100, null, null);		
		Pessoa mDonaMadruga = new Mulher("Dona Madruga", 80, null, null);
		Pessoa hSirMadruga = new Homem("Sir Madruga", 85, null, null);
		// Segunda Gera��o
		Pessoa hQuicoPai = new Homem("Quico Pai", 55, mDonaNeves, hSirNeves);
		Pessoa mDonaFlorinda = new Mulher("Dona Florinda", 41, null, null);
		Pessoa hProfessorGirafales = new Homem("ProfessorGirafales", 45, null, null);	
		Pessoa mMaeChiquinha = new Mulher("Mae da Chiquinha", 40, mDonaNeves, hSirNeves);
		Pessoa hSeuMadruga = new Homem("Seu Madruga", 49, mDonaMadruga, hSirMadruga);
		Pessoa mBruxaDo71 = new Mulher("Bruxa do 71", 52, null, null);
		// Terceira Gera��o
		Pessoa hQuico = new Homem("Quico", 8, mDonaFlorinda, hQuicoPai);
		Pessoa mKika = new Mulher("Kika", 15, mDonaFlorinda, hQuicoPai);
		Pessoa mChiquinha = new Mulher("Chiquinha", 8, mMaeChiquinha, hSeuMadruga);
		Pessoa hChaves = new Homem("Chaves", 8, mBruxaDo71, hSeuMadruga);
		
		

	}
}