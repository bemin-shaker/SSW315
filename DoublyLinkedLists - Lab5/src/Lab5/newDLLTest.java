package Lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class newDLLTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		MyImplDLL<Integer> dll = new MyImplDLL<Integer>();
	    assertTrue(dll.isEmpty());
	    assertEquals(0, dll.getSize());
	
	}
	
	@Test
	public void insertTest() {
		MyImplDLL<Integer> dll0 = new MyImplDLL<Integer>();
	    int num = 5;
	    dll0.insert(num);
	    assertFalse(dll0.isEmpty());
	    assertEquals(1, dll0.getSize());
	}

}
