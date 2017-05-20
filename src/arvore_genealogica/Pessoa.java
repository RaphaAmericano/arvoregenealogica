package arvore_genealogica;

import java.util.ArrayList;
import java.util.List;

//TODO tornar a classe Pessoa ABSTRATA para criarmos somente homens ou mulheres
public class Pessoa implements Utilitarios{
	
	protected double altura;
	protected double peso;
	
	protected String nome;
	protected int idade;
	protected char sexo;///Muda pra classe mulher
	protected Pessoa conjuge;
	protected Pessoa mae;
	protected Pessoa pai;
	
	protected List<Pessoa> exs = new ArrayList<Pessoa>();
	public Pessoa(){
		TestePessoa.todasPessoas.add(this);
	};
	//Construtor
	
	public Pessoa(String nome, int idade, Pessoa mae, Pessoa pai /*, char sexo*/) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.mae = mae;
		this.pai = pai;
		//this.sexo = sexo;
		//Adiciona a pessoa criada ao ArrayList
		TestePessoa.todasPessoas.add(this);
	}

	//Métodos
	//Métodos da interface
	public void fazerFilho(){};
	
	
	
	//Método Casar
	public void casar(Pessoa p){
		//Condicoções 
		//idade >= 16, não pode estar casado, não pode ser pai, mão, ele proprio ou pessoas esquisitas
		
		
		if(p == null){
			System.out.println("Não pode casar com null");
			return;
		}
		if(this == p){
			System.out.println("Não pode casar consigo mesmo!");
		}
		if(this.getIdade() < 16 || p.getIdade() < 16 ){
			System.out.println("Não pode casar com menos que 16!");
			return;
		}
		if(this.getConjuge() != null || p.getConjuge() != null){
			System.out.println("Não pode casar se já for casado!");
			return;
		}
		//Casamento
		this.setConjuge(p);
		p.setConjuge(this);
		System.out.println("Casou! TAM TAM TAM TAAAAAM! *** Pode beijar a noiva!");
	};
	//Divorciar
	public void divorciar(Pessoa p){
		if(p == null){
			System.out.println("Não pode divorciar de Null");
			return;
		}
		if(p.getConjuge() != this || this.getConjuge() != p){
			System.out.println("Não é o conjuge certo!");
			return;
		};
		p.getExs().add(this);
		p.setConjuge(null);
		this.getExs().add(p);
		this.setConjuge(null);
		System.out.println("*** "+p.getNome()+" tá na pista de novo!!");
		System.out.println("*** "+this.getNome()+" tá na pista de novo!!");
	};
	
	//Método para verificar Estado Civil
	public void verificarEstadoCivil(){};
	
	//Lista de casamentos
	public void listarCasamentos(){
		System.out.println("*** Casamentos da pessoa "+ this.getNome() + ":");
		if(this.getConjuge() != null ){
			System.out.println("- Atualmente casado(a) com " + this.getConjuge().getNome());
		}else {
			System.out.println("- Pessoa atualmente encalhada");
		}
		if(!this.getExs().isEmpty()){
			System.out.print("- Ex Casamentos:");
			for(Pessoa pessoa : exs){
				System.out.println("---"+ pessoa.getNome());
			}
		}
	};
	
	//Listar filhos
	public void listarFilhos(){
		for(Pessoa filho: TestePessoa.todasPessoas){
			if(filho.getMae() == this || filho.getPai() == this ){
				System.out.println( filho.getNome());
			}
		}
	};
	
	//Metodo de verificar parentesco
	public void verificarParentesco(Pessoa p){
		//verificações se p é null, this == p... blá blá
		if(p == null) {
			System.out.println("É null");
			return;
		}
		//Pai
		if(this == p.getPai() ){
			System.out.println("* "+ this.getNome()+ " é pai de " + p.getNome());
			return;
		}
		//Filho
		if(this.getPai() == p || this.getMae() == p ){
			System.out.println(this.getNome() + " é filho de "+ p.getNome() );
			return;
		}
		//Avô
		if((p.getPai() != null && this == p.getPai().getPai()) || (p.getMae() != null && this == p.getMae().getPai() ) ){
			System.out.println("* " + this.getNome() + " é avô de " + p.getNome());
			return;
		}
		//Irmão
		if(p.getPai() == this.getPai() || p.getMae() == this.getMae()){
			System.out.println(p.getIdade() + " é irmão de " + this.getNome());
			return;
		}
		//Meio irmão
		if((p.getPai() == this.getPai() && p.getMae() != this.getMae()) || (p.getMae() == this.getMae() && p.getPai() != this.getPai() ) ){
			System.out.println(p.getNome() + " é meio irmão de " + this.getNome());
			return;
		}
		//Tio 
		/*
		if((p.getPai() || p.getMae()) == (this.getPai().getPai() || this.getMae().getPai() || this.getPai().getMae() || this.getMae().getMae())){
			System.out.println(p.getNome() + " É Sobrinho de " this.getNome());
			return;
		}*/
		
		//Outros relacionamentos 
		// |
		// V
		/*
		public void listarFilhos(Pessoa p){
			for
		}
		*/
	};
	
	
	//Métodos de Acesso
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public Pessoa getConjuge() {
		return conjuge;
	}
	public void setConjuge(Pessoa conjuge) {
		this.conjuge = conjuge;
	}
	public Pessoa getMae() {
		return mae;
	}
	public void setMae(Pessoa mae) {
		this.mae = mae;
	}
	public Pessoa getPai() {
		return pai;
	}
	public void setPai(Pessoa pai) {
		this.pai = pai;
	}
	public List<Pessoa> getExs() {
		return exs;
	}
	public void setExs(List<Pessoa> exs) {
		this.exs = exs;
	}
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