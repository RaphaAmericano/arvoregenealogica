package arvore_genealogica;

import java.text.DecimalFormat;

public class Mulher extends Pessoa implements Humano, ControledePeso {
	
	// Caracteristicas exclusivas de Mulher
	protected double altura = 1.65;  //altura padr�o
	protected double peso = 65;     // peso padr�o
	
	// Construtores
	public Mulher(String nome, int idade, Pessoa mae, Pessoa pai){
		super(nome, idade, mae, pai, 'm');
	}
	public Mulher(String nome, int idade, Pessoa mae, Pessoa pai, double altura, double peso){
		super(nome, idade, mae, pai, 'm');
		this.setAltura(altura);
		this.setPeso(peso);
	}
	
	// Implementa o m�todo Calcular IMC
	public void calcularIMC(){
		double imc =  this.getPeso() / (this.getAltura() * this.getAltura());
		DecimalFormat df = new DecimalFormat("#.##");
		
		if(imc >= 40.00){
			System.out.println(this.nome + ": IMC = " + df.format(imc) + " - Obesidade 3(M�rbida)");
			return;
		}else if(imc >= 35.00){
			System.out.println(this.nome + ": IMC = " + df.format(imc) + " - Obesidade 2(Severa)");
			return;
		}else if(imc >= 30.00){
			System.out.println(this.nome + ": IMC = " + df.format(imc) + " - Obesidade 1");
			return;
		}else if(imc >= 25.00){
			System.out.println(this.nome + ": IMC = " + df.format(imc) + " - Acima do peso");
			return;
		}else if(imc >= 18.50){
			System.out.println(this.nome + ": IMC = " + df.format(imc) + " - Peso normal");
			return;
		}else if(imc >= 17){
			System.out.println(this.nome + ": IMC = " + df.format(imc) + " - Abaixo do peso");
			return;
		}else {
			System.out.println(this.nome + ": IMC = " + df.format(imc) + " - Muito abaixo do peso");
			return;
		}
		//Informa��es acima sobre tipos de obesidade foram retiradas da internet e n�o necessariamente foram verificadas
	}
	
	//M�todo para verificar Estado Civil
	//TODO: implementar na classe Pessoa
	
	// M�todos de acesso
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}

