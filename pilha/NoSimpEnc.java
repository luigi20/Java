package Pilha;



public class NoSimpEnc<T> {

	private T elemento;
	private NoSimpEnc<T> proximo;
	
	
	public T getElemento() {
		return elemento;
	}

	public NoSimpEnc<T> getProximo() {
		return proximo;
	}

	
	public NoSimpEnc(T objeto) {
		this.elemento = objeto;		
	}
	
	public NoSimpEnc(T objeto, NoSimpEnc<T> proximo) {
		this.elemento = objeto;
		this.proximo = proximo;
	}

	public void setProximo(NoSimpEnc<T> proximo) {
		this.proximo = proximo;
	}
}