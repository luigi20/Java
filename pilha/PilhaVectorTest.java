package Pilha;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PilhaVectorTest {


	private PilhaVector<Integer> pilha;
	
	@Before
	public void Iniciar() {
		pilha = new PilhaVector<Integer>(5);
	} 
	
	@Test
	public void TestaTamanho() {
		pilha.empilhe(10);
		pilha.empilhe(20);
		pilha.empilhe(30);
		
		assertEquals(3, pilha.size());
		
	}
	
	@Test
	public void TestaEmpilha() {
		pilha.empilhe(10);
		pilha.empilhe(30);
		pilha.empilhe(20);
		pilha.empilhe(40);
		
		assertEquals("[10,30,20,40]",pilha.toString());
		
	}
	
	@Test
	public void TestaDesempilha() throws PilhaVaziaException {
		pilha.empilhe(10);
		pilha.empilhe(30);
		pilha.empilhe(20);
		pilha.empilhe(40);
		pilha.desempilhe();
		
		assertEquals("[10,30,20]",pilha.toString());
		
	}
	
	@Test
	public void TestaDesempilha2() throws PilhaVaziaException {
		pilha.empilhe(10);
		pilha.empilhe(30);
		pilha.empilhe(20);
		pilha.empilhe(40);
		pilha.desempilhe();
		pilha.desempilhe();
		pilha.desempilhe();
		pilha.desempilhe();
		
		assertEquals("[]",pilha.toString());
		
	}
	
	@Test
	public void TestaContem() {
		pilha.empilhe(10);
		pilha.empilhe(30);
		pilha.empilhe(40);
		assertEquals(true,pilha.contem(30));
	}
	
	@Test
	public void TestaContem2() {
		pilha.empilhe(10);
		pilha.empilhe(30);
		pilha.empilhe(40);
		assertEquals(true,pilha.contem(40));
	}
	
	@Test
	public void TestaNaoContem() throws PilhaVaziaException {
		pilha.empilhe(10);
		pilha.empilhe(30);
		pilha.empilhe(40);
		pilha.desempilhe();
		assertEquals(false,pilha.contem(40));
	}
	
	@Test(expected = PilhaVaziaException.class)
	public void TestaDesempilhaVazia() throws PilhaVaziaException {
		pilha.desempilhe();
	}
	
	@Test
	public void TestaPilhaCheia() {
		pilha.empilhe(10);
		pilha.empilhe(50);
		pilha.empilhe(30);
		pilha.empilhe(40);
		pilha.empilhe(80);
		pilha.empilhe(5);
		assertEquals("[10,50,30,40,80,5]",pilha.toString());
		
	}

}
