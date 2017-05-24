package arvore_genealogica;

public interface Casamento {
	public abstract void casar(Pessoa p);
	public abstract void divorciar(Pessoa p);
	public abstract void verificarEstadoCivil();
	public abstract void listarCasamentos();

}
