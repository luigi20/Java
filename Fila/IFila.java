package Fila;

public interface IFila<T> {
	public void Enfileirar(T objeto) throws FilaVetorPreenchidaException;
	public T Remover() throws FilaVaziaException;
	public T getInicio();
	public T getFim();
	//Implementar um toString que ir� pegar o primeiro
	//elemento da fila at� o �ltimo
	//A impress�o dever� ser da seguinte maneira
	//Ex: [5,3,2]
	public String toString();
	public void limpar();
	public boolean contem(T objeto);
}