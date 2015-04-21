package HashDuplo;

public class Hash<T> {
	private int chave;
	private T objeto;
	private boolean deletado;
	
	public Hash(int parmChave, T parmObjeto){
		this.chave = parmChave;
		this.objeto = parmObjeto;
		this.deletado = false;
	}

	public boolean isDeletado() {
		return deletado;
	}

	public void setDeletado(boolean deletado) {
		this.deletado = deletado;
	}

	public int getChave() {
		return chave;
	}

	public T getObjeto() {
		return objeto;
	}
	
	

}
