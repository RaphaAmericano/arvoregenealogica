package arvore_genealogica;

import java.util.List;

public interface Casamento {
	public abstract void casar(Pessoa p);
	public abstract void divorciar(Pessoa p);
	public abstract void verificarEstadoCivil();
	public abstract void listarCasamentos();
	public abstract  Pessoa getConjuge();
	public abstract void setConjuge(Pessoa conjuge);
	public abstract List<Pessoa> getExs();
	public abstract void setExs(List<Pessoa> exs);
}
