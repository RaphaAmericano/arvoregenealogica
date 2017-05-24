package arvore_genealogica;


public interface Humano {
	public abstract void listarFilhos();
	public abstract void verificarParentesco(Pessoa p);
	public abstract void fazerFilho(String nomeMenino, String nomeMenina, Pessoa outraPessoa);
	public abstract String getNome();
	public abstract void setNome(String nome);
	public abstract int getIdade();
	public abstract void setIdade(int idade);
	public abstract char getSexo();
	public abstract void setSexo(char sexo);
	public abstract Pessoa getMae();
	public abstract void setMae(Pessoa mae);
	public abstract Pessoa getPai();
	public abstract void setPai(Pessoa pai);
}
