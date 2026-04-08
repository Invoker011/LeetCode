package Fractional_Knapsack;
import java.util.*;
public class Solution {

    static class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public double fractionalKnapsack(int[] value, int[] weight, int W) {
        int n = value.length;

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(value[i], weight[i]);
        }

        // Sort by value/weight ratio in descending order
        Arrays.sort(items, (a, b) -> {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1);
        });

        double totalValue = 0.0;

        for (Item item : items) {
            if (W >= item.weight) {
                totalValue += item.value;
                W -= item.weight;
            } else {
                totalValue += ((double) item.value / item.weight) * W;
                break;
            }
        }

        return totalValue;
    }
}
    

