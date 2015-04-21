package Fila;

import FPrioridade.FilaPrioridade;

public class App {

	/**
	 * @param args
	 * @throws FilaVaziaException 
	 */
	public static void main(String[] args) throws FilaVaziaException {
		// TODO Auto-generated method stub
		FilaEncadeada<Integer> fila1 = new FilaEncadeada<Integer>();
		FilaEncadeada<Integer> fila2 = new FilaEncadeada<Integer>();
		FilaEncadeada<Integer> fila3 = new FilaEncadeada<Integer>();
		
		fila1.Enfileirar(1);
		fila1.Enfileirar(2);
		fila1.Enfileirar(3);
		fila1.Enfileirar(4);
		fila1.Enfileirar(5);
		
		System.out.println("Fila 1 "+fila1.toString());
	
		fila2.Enfileirar(6);
		fila2.Enfileirar(7);
		fila2.Enfileirar(8);
		fila2.Enfileirar(9);
		
		System.out.println("Fila 2 "+fila2.toString());
		
		fila3.Enfileirar(10);
		fila3.Enfileirar(11);
		fila3.Enfileirar(12);
		fila3.Enfileirar(13);
		fila3.Enfileirar(14);
		
		System.out.println("Fila 3 "+fila3.toString());
		
		System.out.print("Ordem de Atendimento: ["+fila1.Remover()+",");
		System.out.print(fila1.Remover()+",");
		System.out.print(fila1.Remover()+",");
		System.out.print(fila1.Remover()+",");
		System.out.print(fila1.Remover()+",");
		if(fila1.estaVazia()){
			while(!fila2.estaVazia()){
			int cont = 0;
			while(cont !=2) {
				System.out.print(fila2.Remover()+",");
				cont++;
			}
			System.out.print(fila3.Remover()+",");
			}
			
			if (fila2.estaVazia()) {
				
				while(!fila3.estaVazia()){
				System.out.print(fila3.Remover()+",");
				}
			} else if(fila3.estaVazia()){
					System.out.print(fila3.Remover()+",");
				}
			}
		System.out.print("]");
	}
			
			
		
		
		
		
	
	
	
		
		
		

	}


