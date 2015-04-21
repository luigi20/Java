package Fila;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FilaEncadeadaTest {

private FilaEncadeada<Integer> fila;
	
	@Before
	public void Iniciar() {
		fila = new FilaEncadeada<Integer>();
	} 
	
	@Test
	public void TestaTamanho() {
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(20);
		
		assertEquals(3, fila.size());
		
	}
	
	@Test
	public void TestaEnfileirar() {
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(20);
		fila.Enfileirar(40);
		
		assertEquals("[10,30,20,40]",fila.toString());
		
	}
	
	@Test
	public void TestaRemover() throws FilaVaziaException {
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(20);
		fila.Enfileirar(40);
		fila.Remover();
		
		assertEquals("[30,20,40]",fila.toString());
		
	}
	
	@Test
	public void TestaRemover2() throws FilaVaziaException {
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(20);
		fila.Enfileirar(40);
		fila.Remover();
		fila.Remover();
		fila.Remover();
		fila.Remover();
		
		assertEquals("[]",fila.toString());
		
	}
	
	@Test(expected = FilaVaziaException.class)
	public void TestaFilaVazia() throws FilaVaziaException {
		fila.Remover();
	}
	
	@Test
	public void TestaContem() {
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(40);
		assertEquals(true,fila.contem(30));
	}
	
	@Test
	public void TestaContem2() {
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(40);
		assertEquals(true,fila.contem(10));
	}
	
	@Test
	public void TestaNaoContem() throws FilaVaziaException {
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(40);
		fila.Remover();
		assertEquals(false,fila.contem(10));
	}
	
	
	

}
