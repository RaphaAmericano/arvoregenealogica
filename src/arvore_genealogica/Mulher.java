package arvore_genealogica;
import java.math.*;

public class Mulher extends Pessoa {
	
	public Mulher(){
		this.setSexo('F');
	}
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
	public void calcularIMC(){
		double imc =  this.peso / this.altura;
		
		if(imc > 40.00){
			System.out.println("Obesidade 3(Mórbida)");
			return;
		}else if(imc > 35.00 && imc < 39.99){
			System.out.println("Obesidade 2(Severa)");
			return;
		}else if(imc > 30.00 && imc < 34.99){
			System.out.println("Obesidade 1");
			return;
		}else if(imc > 25.00 && imc < 29.99){
			System.out.println("Acima do peso");
			return;
		}else if(imc > 18.50 && imc < 24.99){
			System.out.println("Peso normal");
			return;
		}else if(imc > 17 && imc < 18.49){
			System.out.println("Abaixo do peso");
			return;
		}else if(imc < 17.00){
			System.out.println("Muito abaixo do peso");
			return;
		}
		//Informações acima sobre tipos de obesidade foram retiradas da internet e não necessariamente foram verificadas
	};
}

