package br.com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.dao.UserDAO;
import junit.framework.TestCase;
/**
 * @author VBA
 *
 */
public class LoginTest extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		System.out.println("Iniciando LoginTest...");
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.println("Finalizando LoginTest...");
	}

	/**
	* M�todo testLogin - Respons�vel por realizar testes de login.
	*
	*/
	@Test
	public void testLogin() {
		UserDAO dao = new UserDAO();
		
		assertEquals("Usu�rio autenticado com sucesso! ", false,
				dao.validate("admin", "admin"));
	 }
}
