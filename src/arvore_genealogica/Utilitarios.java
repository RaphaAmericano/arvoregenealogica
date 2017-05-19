package arvore_genealogica;
import java.math.*;
//Importar o pacote de funções matérmaticas


public interface Utilitarios {
	public void fazerFilho(Object affair){
		int numeroRandomico;//atribuir um numero randomico de 0 a 10 a essa variavel usando uma variavel usando a função do pacote importado
		//int numeroPessoas = TestePessoa.todasPessoas; //Numero de pessoas
		numeroRandomico = (int) (Math.random() * 5 );
		if(numeroRandomico >= 5 ){
			Pessoa m1 = new Mulher();
		} else if(numeroRandomico < 5){
			Pessoa m1 = new Homem();
		};
		if(this.getSexo == 'M'){
			m1.setPai(this);
			m1.setMae(affair);
		} else if (this.getSexo == 'F'){
			m1.setMae(this);
			m1.setPai(affair);
		}
		
	}
}
