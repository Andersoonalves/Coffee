package br.ufpb.dce.aps.coffee;



import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MachineTest {

	@Test
	public void loadAndUnloadCoins() {
		Machine machine = new Machine();
		machine.loadCoins(0, 10, 10, 5, 5, 0);
		int[] num = machine.unloadCoins();
		Assert.assertEquals(0, num[0]);
		Assert.assertEquals(10, num[1]);
		Assert.assertEquals(10, num[2]);
		Assert.assertEquals(5, num[3]);
		Assert.assertEquals(5, num[4]);
		Assert.assertEquals(0, num[5]);
	}
	
	
}
