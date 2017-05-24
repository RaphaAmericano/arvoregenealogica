package arvore_genealogica;


public interface ControledePeso {
	public abstract void calcularIMC();
	public abstract double getAltura();
	public abstract void setAltura(double altura);
	public abstract double getPeso();
	public abstract void setPeso(double peso);
}