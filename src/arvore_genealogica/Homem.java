package arvore_genealogica;
import java.math.*;

public class Homem extends Pessoa {
	//protected char sexo = 'm';
	public Homem(String nome, int idade, Pessoa mae, Pessoa pai){
		super(nome, idade, mae, pai);
		this.setSexo('M');
	};
	
	public void verificarEstadoCivil(){
		if(this.getConjuge() != null ){
			System.out.print(this.getNome() + " é casado");
		}
		else if( this.getConjuge() == null && this.getExs().isEmpty() ){
			System.out.print(this.getNome() + " é solteiro");
		}
		else{
			System.out.print(this.getNome() + " é divorciado");
		}
	};
}