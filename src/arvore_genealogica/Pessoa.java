package arvore_genealogica;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa{
	
	protected String nome;
	protected int idade;
	protected char sexo;///Muda pra classe mulher
	protected Pessoa conjuge;
	protected Pessoa mae;
	protected Pessoa pai;
	protected List<Pessoa> exs = new ArrayList<Pessoa>();
	
	public Pessoa(){
		TestePessoa.todasPessoas.add(this);
	}
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

	public void fazerFilho(String nomeMenino, String nomeMenina, Pessoa mae, Pessoa pai){
		Pessoa np;
		int numeroRandomico = (int)(Math.random() * 2) + 1;
		if(numeroRandomico == 1 ){
			np = new Mulher(nomeMenina, 0, mae, pai);
			System.out.println("Parabéns! É uma menina e o nome dela é " + np.getNome());
		} else if(numeroRandomico == 2){
			np = new Homem(nomeMenino, 0, mae, pai);
			System.out.println("Parabéns! É um menino e o nome dele é " + np.getNome());
		}
		
	}
	public void listarFilhos(){
		for(Pessoa filho: TestePessoa.todasPessoas){
			if(filho.getMae() == this || filho.getPai() == this ){
				System.out.println( filho.getNome());
			}
		}
	}
	
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
	}
	
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
	}
	
	public void verificarEstadoCivil(){
		String married;
		String single;
		String divorced;
		if(this instanceof Mulher){
			married = " é casada";
			single = " é solteira";
			divorced = " é divorciada";
		}else{
			married = " é casado";
			single = " é solteiro";
			divorced = " é divorciado";
		}
		
		if(this.getConjuge() != null ){
			System.out.print(this.getNome() + married);
		}
		else if( this.getConjuge() == null && this.getExs().isEmpty() ){
			System.out.print(this.getNome() + single);
		}
		else{
			System.out.print(this.getNome() + divorced);
		}
	}
	
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
	}
	
	
	public void verificarParentesco(Pessoa p){
		//verificações básicas - se p é null, this == p, ... 
		if(p == null) {
			System.out.println("Erro - não é possível verificar parentesco com pessoa 'nula' (null)");
			return;
		}
		if(p == this) {
			System.out.println("Erro - não é possível verificar parentesco de uma pessoa com ela mesma");
			return;
		}
		//Pai
		if(p.getPai() != null && this == p.getPai()){
			System.out.println(this.getNome()+ " é pai de " + p.getNome());
			return;
		}
		//Mãe
		if(p.getMae() != null && this == p.getMae()){
			System.out.println(this.getNome()+ " é mãe de " + p.getNome());
			return;
		}
		//Marido e Esposa
		if(p.getConjuge() != null && this == p.getConjuge()){
			if(this instanceof Homem){
				System.out.println(this.getNome()+ " é marido de " + p.getNome());
				return;
			} else {
				System.out.println(this.getNome()+ " é esposa de " + p.getNome());
				return;
			}
		}
		//Filho
		if( (this.getPai() != null && this.getPai() == p) || (this.getMae() != null && this.getMae() == p) ){
			if(this instanceof Homem){
				System.out.println(this.getNome() + " é filho de "+ p.getNome() );
				return;
			} else {
				System.out.println(this.getNome() + " é filha de "+ p.getNome() );
				return;
			}
		}
		//Avô
		if((p.getPai() != null && p.getPai().getPai() != null && this == p.getPai().getPai()) || 
				(p.getMae() != null && p.getMae().getPai() != null && this == p.getMae().getPai() ) ){
			System.out.println(this.getNome() + " é avô de " + p.getNome());
			return;
		}
		//Avó
		if((p.getPai() != null && p.getPai().getMae() != null && this == p.getPai().getMae()) || 
				(p.getMae() != null && p.getMae().getMae() != null && this == p.getMae().getMae() ) ){
			System.out.println(this.getNome() + " é avó de " + p.getNome());
			return;
		}
		//Irmão
		if( ((this.getPai() != null && p.getPai() != null) && this.getPai() == p.getPai()) && 
				(this.getMae() != null && p.getMae() != null) && this.getMae() == p.getMae()) {
			if(this instanceof Homem){
				System.out.println(this.getNome() + " é irmão de " + p.getNome());
				return;
			} else {
				System.out.println(this.getNome() + " é irmã de " + p.getNome());
				return;
			}
		}
		//Meio-irmão
		if( ((this.getPai() != null && p.getPai() != null) && this.getPai() == p.getPai()) || 
				(this.getMae() != null && p.getMae() != null) && this.getMae() == p.getMae()) {
			if(this instanceof Homem){
				System.out.println(this.getNome() + " é meio-irmão de " + p.getNome());
				return;
			} else {
				System.out.println(this.getNome() + " é meia-irmã de " + p.getNome());
				return;
			}
		}
		// Tio(a)
		if( (this.getPai() != null && p.getPai() != null && p.getPai().getPai() != null && 
				this.getPai() == p.getPai().getPai() ) ||
				(this.getPai() != null && p.getMae() != null && p.getMae().getPai() != null && 
				this.getPai() == p.getMae().getPai() ) ||
				(this.getMae() != null && p.getPai() != null && p.getPai().getMae() != null && 
				this.getMae() == p.getPai().getMae() ) ||
				(this.getMae() != null && p.getMae() != null && p.getMae().getMae() != null && 
				this.getMae() == p.getMae().getMae() )) {
			if (this instanceof Homem) {
				System.out.println(this.getNome() + " é tio de " + p.getNome());
				return;
			} else {
				System.out.println(this.getNome() + " é tia de " + p.getNome());
				return;
			}			
		}
		// Sobrinho(a)
		if( (p.getPai() != null && this.getPai() != null && this.getPai().getPai() != null && 
				p.getPai() == this.getPai().getPai() ) ||
				(p.getPai() != null && this.getMae() != null && this.getMae().getPai() != null && 
				p.getPai() == this.getMae().getPai() ) ||
				(p.getMae() != null && this.getPai() != null && this.getPai().getMae() != null && 
				p.getMae() == this.getPai().getMae() ) ||
				(p.getMae() != null && this.getMae() != null && this.getMae().getMae() != null && 
				p.getMae() == this.getMae().getMae() )) {
			if (this instanceof Homem) {
				System.out.println(this.getNome() + " é sobrinho de " + p.getNome());
				return;
			} else {
				System.out.println(this.getNome() + " é sobrinha de " + p.getNome());
				return;
			}
		}
		//Outros relacionamentos 
		// |
		// V
		//Se não houver parentesco
		System.out.println(this.getNome() + " e " + p.getNome() +  " não têm parentesco");
	}

	
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

}