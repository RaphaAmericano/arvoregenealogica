package arvore_genealogica;
import java.math.*;

public class Homem extends Pessoa {
	//protected char sexo = 'm';
	public Homem(String nome, int idade, Pessoa mae, Pessoa pai){
		super(nome, idade, mae, pai);
		this.setSexo('M');
	};
	
	public void fazerFilho(){
		//Gera um número randomicamente
		int numeroRandomico = (int) (Math.random() * 10 );
		Pessoa np;
		//Usa o numero para definir o sexo do filho
		if(numeroRandomico >= 5 ){
			np = new Mulher();
			np.setNome("Joana");
			System.out.println(numeroRandomico + " Mulher " + np.getNome());
		} else if(numeroRandomico < 5){
			np = new Homem();
			np.setNome("Marcos");
			System.out.println(numeroRandomico + " Homem " + np.getNome());
		};
		
		//np.setPai(this);
		//np.setMae(affair);
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