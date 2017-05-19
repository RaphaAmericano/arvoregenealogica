package arvore_genealogica;
import java.math.*;

public class Homem extends Pessoa {
	//protected char sexo = 'm';
	public Homem(){
		this.setSexo('M');
	};
	/*
	public void fazerFilho(Object affair){
		int numeroRandomico;
		numeroRandomico = (int) (Math.random() * 5 );
		if(numeroRandomico >= 5 ){
			Pessoa m1 = new Mulher();
		} else if(numeroRandomico < 5){
			Pessoa m1 = new Homem();
		};
		m1.setPai(this);
		m1.setMae(affair);
	};
	*/
	
	public Homem(){
		this.setSexo('M');
	};
}