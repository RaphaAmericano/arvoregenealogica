package arvore_genealogica;

public interface Humano {
	public abstract void fazerFilho(String nomeMenino, String nomeMenina, Pessoa mae, Pessoa pai);
	public abstract void listarFilhos();
	public abstract void casar(Pessoa p);
	public abstract void verificarEstadoCivil();
	public abstract void listarCasamentos();
	public abstract void verificarParentesco(Pessoa p);
}
