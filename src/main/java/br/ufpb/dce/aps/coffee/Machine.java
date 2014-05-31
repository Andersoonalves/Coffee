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
	

}
