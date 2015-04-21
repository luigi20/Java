package Pilha;





import java.lang.reflect.Array;
import java.util.Arrays;

public class PilhaVector<T extends Comparable<T>> implements IPilha<T> {
		

	private int topo;
	private T[] pilha;
	
	public PilhaVector(Class<T> c, int pTamanho) {
		
		this.topo = -1;
		this.pilha = (T[])Array.newInstance(c, pTamanho);
	}
	
	
	
	public PilhaVector ordenarPilha(PilhaVector p) throws PilhaVaziaException {
		
		PilhaVector pilhaAux = new PilhaVector(Integer.class,pilha.length * 2);
		PilhaVector pilha3 = new PilhaVector(Integer.class,pilha.length * 2);
		int cont = 0;
		
		int indiceElemento = 1;
		int indiceAnterior = indiceElemento - 1;
	
		pilhaAux.empilhe(pilha);
		pilhaAux.empilhe(p);
		
		
		for (int i = 0; i < this.topo - 1; i++) {
			for (int j = 1; j < this.topo - i; j++) {
				if (pilhaAux.getTopo().compareTo(topo-j) == -1) {
					
					pilha3.empilhe(pilhaAux.desempilhe());
				}
			}
		}
		return pilha3;
	}
	@Override
	public void empilhe(T objeto){
		
		
			
		if (estaVazia()) {
				
			this.topo = 0;
			pilha[this.topo] = objeto;
			
		} else if (this.topo <= pilha.length)  {
				
			this.topo++;
				pilha[this.topo] = objeto;
						
						
						
			}
		
		}
		
	  
	@Override
	public T desempilhe() throws PilhaVaziaException{
		
		T aux;
		if (estaVazia()) {
			
			throw new PilhaVaziaException();
		
		} else {
			
				 aux = pilha[topo];
				 pilha[topo] = null ;
				 this.topo--;	
				 return aux;
			}
			
	}
	
	@Override
	public T getTopo() throws PilhaVaziaException{
		
		if (this.size() == 0) {
			
			throw new PilhaVaziaException();
		} else {
			
			return pilha[topo];
		}
	
	//Implementar um toString que ir‡ pegar o primeiro
	//elemento da pilha atŽ o œltimo
	//A impress‹o dever‡ ser da seguinte maneira
	//Ex: [5,3,2]
	}
	
	@Override
	public String toString(){
		if (this.topo== 0){
			return "[]";
		}
		String variavelString = "[";
		for (int i = 0; i <= this.topo; i++) {
			if (i == 0) {
				variavelString = variavelString + pilha[i];
			} else {
				variavelString = variavelString + "," + pilha[i];
			}
			
		}
		variavelString = variavelString + "]";
		return variavelString;
	}
	//Tamanho da pilha
	@Override
	public int size() {
		return this.topo;
	}
	@Override
	public boolean estaVazia() {
		
		boolean vazio = false;
		if (this.topo == -1) {
			 
			 vazio = true;
			 
		}
		return vazio;
	}
	@Override
	public boolean contem(T objeto) {
		
		boolean conter = false;
		for (int i = 0; i <= this.topo; i++) {
			
			if (pilha[i] == objeto) {
				
				conter = true;
			}
			
		}
		return conter;
	
	}
}
