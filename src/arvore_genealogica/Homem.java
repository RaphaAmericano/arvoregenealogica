package arvore_genealogica;
import java.math.*;

public class Homem extends Pessoa {
	//protected char sexo = 'm';
	public Homem(String nome, int idade, Pessoa mae, Pessoa pai){
		super(nome, idade, mae, pai);
		this.setSexo('M');
	}
	
}