package arvore_genealogica;

public class Homem extends Pessoa {

	public Homem(String nome, int idade, Pessoa mae, Pessoa pai){
		super(nome, idade, mae, pai, 'M');
	}
	
}