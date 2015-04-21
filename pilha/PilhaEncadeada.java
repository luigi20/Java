package Pilha;







public class PilhaEncadeada<T> implements IPilha<T>{

	private NoSimpEnc<T> inicio;
	private NoSimpEnc<T> fim;
	private NoSimpEnc<T> topo;
	private int cont;
	
	

	@Override //OK
	public int size() {
		return this.cont;
	}

	@Override //OK
	public boolean estaVazia() {
		if (inicio == null) {
			return true;
		}else {
			return false;
		} 
	}
	
	public void InserirInicio(T elemento) {
		
		NoSimpEnc<T> novo = new NoSimpEnc<T>(elemento);
		if (this.inicio == null) {
			this.inicio = this.fim = novo;
		} else {
			
			novo.setProximo(inicio);
			this.inicio = novo;
			
		}
		this.cont++;
		}
	@Override //OK
	public void empilhe(T elemento) {
		if (this.cont == 0) {
			this.InserirInicio(elemento);
		} else {
			NoSimpEnc<T> novo = new NoSimpEnc<T>(elemento);
			this.fim.setProximo(novo);
			this.fim = novo;
			this.cont++;
		}
	
	}

	public void RemoverInicio() {
		
		
		
		if (this.cont == 0) {
			
			throw new IllegalArgumentException("Não há nenhum elemento na lista");
			
		}
		this.inicio = this.inicio.getProximo();
		this.cont--;
		
	}
	
	@Override //OK
	public T desempilhe() throws PilhaVaziaException{
		
		T aux = null;
		if (estaVazia()) {
			
			throw new PilhaVaziaException();
		} else {
			if (this.cont == 1) {
				
				this.RemoverInicio();
			
		} else {
			if (this.inicio != null) {
				
				NoSimpEnc<T> atual = this.inicio;
				
				while(atual.getProximo().getProximo() != null) {
					
					atual = atual.getProximo();
					
					
				}
				aux = atual.getProximo().getElemento();
				atual.setProximo(null);
				this.fim = atual;
				this.cont--;
				
			}
			
		}
			
		}
		return aux;
	}

	public T getTopo() throws PilhaVaziaException {
		
		if (estaVazia() == false) {
		
			return  topo.getElemento();
			
		} else {
			
			throw new PilhaVaziaException();
		}
	}
	
	@Override //OK
	public boolean contem(T elemento) {
		NoSimpEnc<T> atual = this.inicio;
		boolean achou = false;
		while (atual != null) {
			if (atual.getElemento().equals(elemento)) {
				achou = true;
			}
			atual = atual.getProximo();
		}
		return achou;
	}

	public String toString() {
		  // Verificando se a Lista está vazia
		  if(this.size() == 0){
		    return "[]";
		  }
		  
		  StringBuilder builder = new StringBuilder("[");
		  NoSimpEnc<T> atual = inicio;

		  // Percorrendo até o penúltimo elemento.
		  for (int i = 0; i < this.size() -1; i++) {
		    builder.append(atual.getElemento());
		    builder.append(",");
		    atual = atual.getProximo();
		  }

		  // último elemento
		  builder.append(atual.getElemento());
		  builder.append("]");
		  
		  return builder.toString();
		}
}