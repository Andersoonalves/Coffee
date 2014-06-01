package br.ufpb.dce.aps.coffee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MachineTest {

	private Machine machine;

	@Before
	public void init() {
		machine = new Machine();

	}

	@Test
	public void loadAndUnloadCoins() {
		machine.loadCoins(0, 10, 10, 5, 5, 0);
		int[] num = machine.unloadCoins();
		verifyCoins(num, 0, 10, 10, 5, 5, 0);
	}

	@Test
	public void insertCoinsBelowMinimumValue() {
		machine.insertCoin(Coin.quarter);
		int[] num = machine.unloadCoins();
		verifyCoins(num, 0, 0, 0, 1, 0, 0);
	}

	private void verifyCoins(int[] num, int numPenny, int numNickel,
			int numDime, int numQuarter, int numHalfDollar, int numDollar) {
		Assert.assertEquals(numPenny, num[0]);
		Assert.assertEquals(numNickel, num[1]);
		Assert.assertEquals(numDime, num[2]);
		Assert.assertEquals(numQuarter, num[3]);
		Assert.assertEquals(numHalfDollar, num[4]);
		Assert.assertEquals(numDollar, num[5]);
	}
	
	@Test
	public void insertCoinsAndSelectCoffee() {
		machine.loadCoins(0, 10, 10, 5, 5, 0);
		machine.insertCoin(Coin.quarter);
		machine.insertCoin(Coin.quarter);
		
		int[] change = machine.select(Drink.BLACK);
		verifyCoins(change, 0, 1, 1, 0, 0, 0);
		
		int[] num = machine.unloadCoins();
		verifyCoins(num, 0, 9, 9, 7, 5, 0);
	}
	
	@Test
	public void insertCoinsAndSelectCoffeeWithoutChange() {
		machine.insertCoin(Coin.quarter);
		machine.insertCoin(Coin.dime);
		
		int[] change = machine.select(Drink.BLACK);
		verifyCoins(change, 0, 0, 0, 0, 0, 0);
		int[] num = machine.unloadCoins();
		verifyCoins(num, 0, 0, 1, 1, 0, 0);
	}
	
	@Test
	public void insertCoinsAndCancel(){
		machine.loadCoins(0, 10, 10, 5, 5, 0);
		machine.insertCoin(Coin.quarter);
		machine.insertCoin(Coin.dime);
		int[] cancel = machine.cancelRequest();
		verifyCoins(cancel, 0, 0, 1, 1, 0, 0);
		int[] num = machine.unloadCoins();
		verifyCoins(num, 0, 10, 10, 5, 5, 0);
	}
	
}
