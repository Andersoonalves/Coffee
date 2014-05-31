package br.ufpb.dce.aps.coffee;

public class Machine {
	
	private int[] coins = new int[6];

	public void loadCoins(int numPenny, int numNickel, int numDime,
			int numQuarter, int numHalfDollar, int numDollar) {
		
		coins[0] = numPenny;
		coins[1] = numNickel;
		coins[2] = numDime;
		coins[3] = numQuarter;
		coins[4] = numHalfDollar;
		coins[5] = numDollar;
	}

	public int[] unloadCoins() {
		return coins;
	}

	public void insertCoin(Coin coin) {
		switch (coin) {
		case penny:
			coins[0]++;
			break;
		case nickel:
			coins[1]++;
			break;
		case dime:
			coins[2]++;
			break;
		case quarter:
			coins[3]++;
			break;
		case halfDollar:
			coins[4]++;
			break;
		case dollar:
			coins[5]++;
			break;
		}
	}
	
	

}
