package Fila;

import Pilha.NoSimpEnc;



public class FilaEncadeada<T> implements IFila<T> {
	
	
	private NoSimpEnc<T> fim;
	private int cont;
	
	public FilaEncadeada MesmoElementos(FilaEncadeada fila) {
		
		NoSimpEnc<T> atual = this.fim;
		FilaEncadeada retorno = null;
		NoSimpEnc<T> parametro = (NoSimpEnc<T>) fila.getInicio();
		
		while (atual != null) {
			
			while (fila != null) {
				if(atual.getElemento().equals(parametro)) {
					retorno.Enfileirar(parametro);
					
				}
				parametro = parametro.getProximo();
			}
			atual = atual.getProximo();
			parametro = (NoSimpEnc<T>) fila.getInicio();
		}
		return retorno;
	}
	
	public boolean estaVazia() {
		
		boolean vazio = false;
		if (this.cont == 0) {
			 
			 vazio = true;
			 
		}
		return vazio;
	}
	
	@Override
	public void Enfileirar(T objeto) {

		NoSimpEnc<T> novoNo = new NoSimpEnc<T>(objeto);
		if(cont == 0) {
			
			this.fim = novoNo;
			this.fim.setProximo(novoNo);
		
		} else {
					
					novoNo.setProximo(this.fim.getProximo());
					this.fim.setProximo(novoNo);
					this.fim = novoNo;
					
		       }
		  
		  this.cont++;
	    }

	@Override
	public T Remover() throws FilaVaziaException {
		
		if (this.cont == 0) {
			throw new FilaVaziaException();
		}
		T inicioAntigo = this.getInicio();
		this.fim.setProximo(this.fim.getProximo().getProximo());
		this.cont--;
		return inicioAntigo;
	}

	@Override
	public T getInicio() {
		// TODO Auto-generated method stub
		return this.fim.getProximo().getElemento();
	}

	@Override
	public T getFim() {
		// TODO Auto-generated method stub
		return this.fim.getElemento();
	}

	@Override
	public void limpar() {
		// TODO Auto-generated method stub
		this.cont = 0;
		this.fim = null;
	}

	@Override
	public boolean contem(T objeto) {
		
		NoSimpEnc<T> aux = this.fim.getProximo();
		for (int i = 0; i < this.cont; i++) {
			if (aux.getElemento().equals(objeto)){
				return true;
			} 
			aux = aux.getProximo();
		}
		return false;
	
	}

	public String toString() {
		  // Verificando se a Lista está vazia
		  if(this.cont == 0){
		    return "[]";
		  }
		  
		  StringBuilder builder = new StringBuilder("[");
		  NoSimpEnc<T> atual = this.fim.getProximo();

		  // Percorrendo até o penúltimo elemento.
		  for (int i = 0; i < this.cont -1; i++) {
		    builder.append(atual.getElemento());
		    builder.append(",");
		    atual = atual.getProximo();
		  }

		  // último elemento
		  builder.append(atual.getElemento());
		  builder.append("]");
		  
		  return builder.toString();
		}	
	public int size() {
		return this.cont;
	}
}
