package p2parking.client;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class MainTest {
	
	@Test
	public void testGetNombre() {
		String[] temp = {"0.0.0.0", "8080"};
		assertTrue(Main.main(temp));
	}
}