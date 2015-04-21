package Fila;

import java.lang.reflect.Array;

public class FilaVetor<T> implements IFila<T> {

	private int fim;
	private int inicio;
	private int cont;
	private T[] vetorFila;
	
	public FilaVetor(Class<Integer> c, int ptamanho) {
		vetorFila = (T[])Array.newInstance(c, ptamanho);
		cont = 0;
		inicio = 0;
		fim = 0;
		
	}	
	@Override
	public void Enfileirar(T objeto) throws FilaVetorPreenchidaException {
		
		if (cont == 0) {
			this.inicio = 0;
			this.fim = 0;
			vetorFila[this.inicio] = objeto;
			
			this.cont++;
		
		} else if (this.cont < vetorFila.length) {
			
					fim = (fim + 1) % vetorFila.length;
					vetorFila[fim] = objeto;
					this.cont++;
		} else if ( (fim + 1) % vetorFila.length == this.inicio) {
			
			throw new FilaVetorPreenchidaException();
		} 
		
	}
		
	
		
		
	@Override
	public T Remover() throws FilaVaziaException{
		
		T aux;
		if (this.cont == 0) {
			
			throw new FilaVaziaException();
		} else {
			
				aux = vetorFila[this.inicio];
				vetorFila[this.inicio] = null;
				this.inicio++;
				this.cont--;
		}
		return aux;
	}
	
	@Override
	public T getInicio(){
		
			return vetorFila[this.inicio];
	}
	
	@Override
	public T getFim(){
		return vetorFila[this.fim];
	}
	//Implementar um toString que ir‡ pegar o primeiro
	//elemento da fila atŽ o œltimo
	//A impress‹o dever‡ ser da seguinte maneira
	//Ex: [5,3,2]
	@Override
	public String toString() {
		if (this.cont == 0){
			return "[]";
		}
		String stringRetorno = "[";
		int indice = inicio;
		for (int i = 0; i < this.cont; i++) {
			if (indice == inicio){
				stringRetorno = stringRetorno + vetorFila[indice];
			}else{
				stringRetorno = stringRetorno + "," + vetorFila[indice];
			}
			if ((indice + 1) == vetorFila.length) {
				indice = 0;
			} else {
				indice++;
			}
		}
		stringRetorno = stringRetorno + "]";
		return stringRetorno;
	}
	
	@Override
	public void limpar() {
			
		for (int i = 0; i < vetorFila.length; i++ ) {
			
			vetorFila[i] = null;
			this.cont = 0;
		}	
		
	}
	
	@Override
	public boolean contem(T objeto) {
		
		T contem;
		boolean achou = false;
		for(int i = 0 ; i < vetorFila.length; i++ ) {
			
			contem = vetorFila[i];
			if ( vetorFila[i] == objeto) {
				
				achou = true;
			}
		}
		return achou;
	}
	public int size() {
		return this.cont;
	}
}
