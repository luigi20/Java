package Fila;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FilaVetorTest {

	private FilaVetor<Integer> fila;
	
	@Before
	public void Iniciar() {
		fila = new FilaVetor<Integer>(Integer.class, 5);
	} 
	
	@Test
	public void TestaTamanho() throws FilaVetorPreenchidaException {
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(20);
		
		assertEquals(3, fila.size());
		
	}
	
	@Test
	public void TestaEnfileirar() throws FilaVetorPreenchidaException {
		
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(20);
		fila.Enfileirar(40);
		
		assertEquals("[10,30,20,40]",fila.toString());
		
	}
	
	
	@Test
	public void TestaRemover() throws FilaVaziaException, FilaVetorPreenchidaException {
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(20);
		fila.Enfileirar(40);
		fila.Remover();
		
		assertEquals("[30,20,40]",fila.toString());
		
	}
	
	@Test
	public void TestaRemover2() throws FilaVaziaException, FilaVetorPreenchidaException {
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
	
	@Test
	public void TestaVetorCircular() throws FilaVaziaException, FilaVetorPreenchidaException {
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(20);
		fila.Enfileirar(40);
		
		fila.Remover();
		fila.Enfileirar(50);
		fila.Enfileirar(60);
			
		assertEquals("[30,20,40,50,60]",fila.toString());
		
	}
	
	@Test
	public void TestaVetorCircular2() throws FilaVaziaException, FilaVetorPreenchidaException {
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(20);
		fila.Enfileirar(40);
		fila.Remover();
		fila.Remover();
		fila.Enfileirar(50);
		fila.Enfileirar(60);
		fila.Enfileirar(70);
		
		assertEquals("[20,40,50,60,70]",fila.toString());
		
	}
	
	
	@Test(expected = FilaVaziaException.class)
	public void TestaFilaVazia() throws FilaVaziaException {
		fila.Remover();
	}
	
	@Test(expected = FilaVetorPreenchidaException.class)
	public void TestaFilaCheia() throws FilaVetorPreenchidaException, FilaVaziaException {
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(20);
		fila.Enfileirar(40);
		fila.Remover();
		fila.Remover();
		fila.Enfileirar(50);
		fila.Enfileirar(60);
		fila.Enfileirar(70);
		fila.Enfileirar(90);
	}
	
	
	@Test
	public void TestaContem() throws FilaVetorPreenchidaException {
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(40);
		assertEquals(true,fila.contem(30));
	}
	
	
	@Test
	public void TestaContem2() throws FilaVetorPreenchidaException {
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(40);
		assertEquals(true,fila.contem(10));
	}
	
	@Test
	public void TestaContem3() throws FilaVetorPreenchidaException {
		fila.Enfileirar(10);
		assertEquals(true,fila.contem(10));
	}
	
	@Test
	public void TestaNaoContem() throws FilaVaziaException, FilaVetorPreenchidaException {
		fila.Enfileirar(10);
		fila.Enfileirar(30);
		fila.Enfileirar(40);
		fila.Remover();
		assertEquals(false,fila.contem(10));
	}
	
	@Test
	public void TestaNaoContem2() throws FilaVaziaException, FilaVetorPreenchidaException {
		fila.Enfileirar(10);
		fila.Remover();
		assertEquals(false,fila.contem(10));
	}
	
	
	

}
