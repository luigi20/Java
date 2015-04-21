package HashDuplo;

public class vetorHashDuplo<T> implements IHashDuplo<T> {

	private int cont;
	private Hash[] vetorHashDuplo;
	
	public vetorHashDuplo (int cont) {
		
		vetorHashDuplo = new Hash[cont];
		this.cont = 0;
	}
	
	@Override
	public void clear() {
		for (int i = 0; i < vetorHashDuplo.length; i++) {
			vetorHashDuplo[i] = null;
		}
		this.cont = 0;
	}

	public boolean estavazio(){
		return this.cont == 0;
	}

	@Override
	public boolean add(T obj) {
		
		//if (!contains(obj)) {
			this.verificaCarga();
			/*if (this.tamanho == this.hashDuplo.length) {
				redimensionar(this.tamanho * 2);
			}*/
			int chave = obj.hashCode();
			Hash novoHash = new Hash(chave, obj);
			int indice = funcHash(chave);
			if ((vetorHashDuplo[indice] == null || vetorHashDuplo[indice].isDeletado()) && !this.contains((T) novoHash)) {
				vetorHashDuplo[indice] = novoHash;
				this.cont++;
				return true;
			} 
			int i = 1;
			indice = (i * funcHash2(chave)) ;
			indice = indice % vetorHashDuplo.length;
			while (vetorHashDuplo[indice] != null && !this.contains((T) novoHash) ) {
				if (vetorHashDuplo[indice].isDeletado()){
					break;
				}
				i++;
				indice += (i * funcHash2(chave));
				indice = indice % vetorHashDuplo.length;
			}
			vetorHashDuplo[indice] = novoHash;
			this.cont++;
			return true;
		//}
		//return false;
	}
	
	public int retornaIndiceElemento(T elemento){
		int chave = elemento.hashCode();
		int indice = funcHash(chave);
		if (vetorHashDuplo[indice] == null || this.cont == 0) {
			return -1;
		}
		int i = 1;
		//indice += i * funcHash2(chave);
		while (vetorHashDuplo[indice] != null) {
			if (vetorHashDuplo[indice].getObjeto().equals(elemento) && !vetorHashDuplo[indice].isDeletado()) {
				return indice;
			}
			indice += (i * funcHash2(chave));
			indice = indice % vetorHashDuplo.length;
			i++;
		}
		return -1;
	}

	@Override
	public boolean remove(T obj) {
		//if (contains(obj)) {
		int indice = retornaIndiceElemento(obj);
		if (indice == -1) {
			return false;
		} 
		vetorHashDuplo[indice].setDeletado(true);
		this.cont--;
		return true;
		//}
	}

	@Override
	public boolean contains(T obj) {
		int chave = obj.hashCode();
		int indice = funcHash(chave);
		if (vetorHashDuplo[indice] == null) {
			return false;
		}
		int i = 1;
		while (vetorHashDuplo[indice] != null) {
			if (vetorHashDuplo[indice].getObjeto().equals(obj) && !vetorHashDuplo[indice].isDeletado()) {
				return true;
			}
			i++;
			indice += (i * funcHash2(chave));
			indice = indice % vetorHashDuplo.length;
		}
		return false;
	}

	@Override
	public int funcHash(int chave) {
		return (chave %vetorHashDuplo.length);
	}
	
	public int funcHash2(int chave) {
		return (1 + (chave % (vetorHashDuplo.length - 1)));
	}
	
	private void verificaCarga(){
		int capacidade = vetorHashDuplo.length;
		double carga = (double)(this.cont / capacidade);
		if (carga > 0.75){
			redimensionar(capacidade * 2);
		}
	}
	
	public int size() {
		return this.cont;
	}
	
	private void redimensionar(int novoTamanho) {
		Hash[] vetorAuxiliar =  new Hash[vetorHashDuplo.length];
		for (int i = 0; i < vetorHashDuplo.length; i++) {
			vetorAuxiliar[i] = vetorHashDuplo[i];
		}
		vetorHashDuplo = new Hash[novoTamanho];
		this.cont = 0;
		for (int i = 0; i < vetorAuxiliar.length; i++) {
			if (vetorAuxiliar[i] != null && !vetorAuxiliar[i].isDeletado()){
				add((T) vetorAuxiliar[i].getObjeto());
			}
		}
	}
	
	@Override
	public String toString(){
		if (estavazio()) {
			return "[]";
		}
		String stringRetorno = "[";
		T elemento;
		for (int i = 0; i < vetorHashDuplo.length; i++) {
			
			if (vetorHashDuplo[i] == null) {
				elemento = (T) "-";
			} else if (vetorHashDuplo[i].isDeletado()) {
				elemento = (T) "D";
			} else {
				elemento = (T) vetorHashDuplo[i].getObjeto();
			}
			
			if (i == 0) {
				stringRetorno += " " + elemento;
			} else {
				stringRetorno += ", " + elemento;
			}
			
		}
		stringRetorno += "]";
		return stringRetorno;
	}
}