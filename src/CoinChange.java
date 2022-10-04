/**
 * 322. Coin Change
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        return minCoins(coins, amount, new int[amount]);
    }

    private int minCoins(int[] coins, int amount, int[] mem) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (mem[amount - 1] != 0) return mem[amount-1];

        int result = amount + 1;
        for (int coin : coins) {
            int num = minCoins(coins, amount - coin, mem);
            if (num >= 0 && num + 1 < result)
            result = num+1;
        }

        mem[amount-1] = result == amount + 1 ? -1 : result;
        return mem[amount-1];
    }
}