package arvore_genealogica;
import java.math.*;

public class Homem extends Pessoa {
	//protected char sexo = 'm';
	public Homem(){
		this.setSexo('M');
	};
	
	public void fazerFilho(){
		//Gera um número randomicamente
		int numeroRandomico = (int) (Math.random() * 10 );
		
		//Usa o numero para definir o sexo do filho
		if(numeroRandomico >= 5 ){
			System.out.println(numeroRandomico + " Mulher");
			Pessoa np = new Mulher();
		} else if(numeroRandomico < 5){
			System.out.println(numeroRandomico + " Homem");
			Pessoa np = new Mulher();
		};
		
		//np.setPai(this);
		//np.setMae(affair);
	};

}