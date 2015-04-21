package Fila;

public interface IFila<T> {
	public void Enfileirar(T objeto) throws FilaVetorPreenchidaException;
	public T Remover() throws FilaVaziaException;
	public T getInicio();
	public T getFim();
	//Implementar um toString que irá pegar o primeiro
	//elemento da fila até o último
	//A impressão deverá ser da seguinte maneira
	//Ex: [5,3,2]
	public String toString();
	public void limpar();
	public boolean contem(T objeto);
}