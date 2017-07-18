package TestNGClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 {
	@Test
	public void testWO(){
		Assert.assertTrue(false);
		System.out.println("WO is working as UNexpected");
	}
}
