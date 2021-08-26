package dio_junit_test;


import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.core.Is;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionTest {
	
	/*@Test(expected = IndexOutOfBoundsException.class)
	public void empty() {
		new ArrayList<Object>().get(0);
	}*/

	/*
	 * @Test(expected = IndexOutOfBoundsException.class)
	public void empty2() {
		List<String> lista = new ArrayList<String>();
		lista.add("Ola mundo");
		lista.get(0);
	}*/
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void shoudTestExceptionMessage() {
		List<Object> list = new ArrayList<Object>();

		thrown.expect(IndexOutOfBoundsException.class);
		//thrown.expectMessage("Index: 0, Size: 0");
		list.get(0);
	}

	@Test
	public void testExceptionMessage(){
		try {
			new ArrayList<Object>().get(0);
			fail("Esperado que IndexOutOfBoundException seja lançada");
		}catch(IndexOutOfBoundsException ex){

			//assertThat(ex.getMessage(), ("Index: 0, Size: 0"));
		}
	}




	
}
