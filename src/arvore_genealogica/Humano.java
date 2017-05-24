package arvore_genealogica;

public interface Humano {
	public abstract void fazerFilho(String nomeMenino, String nomeMenina, Pessoa outraPessoa);
	public abstract void listarFilhos();
	public abstract void verificarParentesco(Pessoa p);
}
