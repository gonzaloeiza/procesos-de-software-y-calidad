package p2parking.client;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import p2parking.testCategories.UnitTest;

@Category(UnitTest.class)
public class MainTest {
	
	@Before
	public void antes() {
		new Main();
	}
	
	@Test
	public void testBien() {
		String[] temp = {"0.0.0.0", "8080"};
		assertTrue(Main.main(temp));
	}
	@Test
	public void testMal() {
		assertFalse(Main.main(null));
	}
}