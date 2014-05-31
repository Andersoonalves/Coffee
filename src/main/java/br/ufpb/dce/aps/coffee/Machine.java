package br.ufpb.dce.aps.coffee;

public class Machine {

	private int[] coins = new int[6];
	private int current;

	public void loadCoins(int numPenny, int numNickel, int numDime,
			int numQuarter, int numHalfDollar, int numDollar) {

		coins[0] += numPenny;
		coins[1] += numNickel;
		coins[2] += numDime;
		coins[3] += numQuarter;
		coins[4] += numHalfDollar;
		coins[5] += numDollar;
	}

	public int[] unloadCoins() {
		return coins;
	}

	public void insertCoin(Coin coin) {
		current += coin.getValue();
		int i = 0;
		for (Coin c : Coin.values()) {
			if (c.equals(coin)) {
				coins[i]++;
			}
			i++;
		}
	}

	public int[] select(Drink drink) {

		int[] arrayChange = new int[6];
		int change = current - 35;

		int i = 5;
		for (Coin c : Coin.reverse()) {
			while (change >= c.getValue() && coins[i] > 0) {
				change -= c.getValue();
				coins[i]--;
				arrayChange[i]++;
			}
			i--;
		}
		
		if (change > 0) {
			loadCoins(arrayChange[0], arrayChange[1], arrayChange[2],
					arrayChange[3], arrayChange[4], arrayChange[5]);
			throw new RuntimeException("Unavailable change for: " + (current - 35));
		}

		return arrayChange;
	}

}
